/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner.api;

import static java.lang.String.format;
import static kwikdesk.partner.TestUtils.readFromRawResourceFile;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Map;

import kwikdesk.partner.api.Api.ApiHeader;
import kwikdesk.partner.http.HttpClient;
import kwikdesk.partner.utils.JsonUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class ApiTest {

  private Api api = new Api();

  @Mock private HttpClient mockHttpClient;
  
  private final String appName = "my-app";
  
  private final String token = "secret-token";
  
  private final Map<String, String> appNameHeader = api.headers(ApiHeader.APPNAME, appName);
  
  private final Map<String, String> tokenHeader = api.headers(ApiHeader.TOKEN, token);

  @Before
  public void setUp() {
    initMocks(this);
    api.setHttpClient(mockHttpClient);
  }
  
  @Test
  public void testToken() {
    when(mockHttpClient.post(Api.ApiPath.TOKEN, appNameHeader, null)).thenReturn(readFromRawResourceFile("/token_response.json"));
    TokenResponse response = api.token(appName);
    verify(mockHttpClient, times(1)).post(Api.ApiPath.TOKEN, appNameHeader, null);
    assertEquals(response.getError().intValue(), 0);
    assertEquals(response.getToken(), token);
  }

  @Test
  public void testSearch() {
    String q = "test";
    String url = format("%s?q=%s", Api.ApiPath.SEARCH, q);
    when(mockHttpClient.get(url, tokenHeader)).thenReturn(readFromRawResourceFile("/search_response.json"));
    SearchResponse response = api.search(token, q);
    verify(mockHttpClient, times(1)).get(url, tokenHeader);
    assertEquals(response.getError().intValue(), 0);
    assertEquals(response.getResults().size(), 1);
    assertEquals(response.getResults().get(0).getContent(), "The message that contains the search #term");
  }

  @Test
  public void testMessage() {
    Message message = new Message("test");
    String messageJSON = JsonUtils.toJson(message);
    when(mockHttpClient.post(Api.ApiPath.MESSAGES, tokenHeader, messageJSON)).thenReturn(readFromRawResourceFile("/message_response.json"));
    MessageResponse response = api.message(token, message);
    verify(mockHttpClient, times(1)).post(Api.ApiPath.MESSAGES, tokenHeader, messageJSON);
    assertEquals(response.getError().intValue(), 0);
  }

}
