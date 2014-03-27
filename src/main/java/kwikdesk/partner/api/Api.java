/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner.api;

import static java.lang.String.format;
import static kwikdesk.partner.KwikDesk.environment;
import static kwikdesk.partner.utils.JsonUtils.fromJson;
import static kwikdesk.partner.utils.JsonUtils.toJson;

import java.util.HashMap;
import java.util.Map;

import kwikdesk.partner.http.HttpClient;
import kwikdesk.partner.utils.Utils;

public class Api {

  public interface ApiPath {
    public static final String TOKEN = format("%s/token", environment.getApiBase());
    public static final String SEARCH = format("%s/search", environment.getApiBase());
    public static final String MESSAGES = format("%s/messages", environment.getApiBase());
  }
  
  public interface ApiHeader {
    public static final String APPNAME = "X-AppName";
    public static final String TOKEN = "X-API-Token";
  }

  protected HttpClient httpClient = HttpClient.DEFAULT;

  public Api() {
  }
  
  public TokenResponse token(String appName) {
    appName = (appName != null) ? appName : "";
    return fromJson(httpClient.post(ApiPath.TOKEN, headers(ApiHeader.APPNAME, appName), null), TokenResponse.class);
  }

  public SearchResponse search(String token, String q) {
    return fromJson(httpClient.get(format("%s?q=%s", ApiPath.SEARCH, Utils.encode(q)), headers(ApiHeader.TOKEN, token)), SearchResponse.class);
  }

  public MessageResponse message(String token, Message message) {
    return fromJson(httpClient.post(ApiPath.MESSAGES, headers(ApiHeader.TOKEN, token), toJson(message)), MessageResponse.class);
  }
  
  protected Map<String, String> headers(String name, String value, String[]... nameValuePairs) {
    Map<String, String> headers = new HashMap<String, String>();
    headers.put(name, value);
    for(String[] nvp: nameValuePairs) {
      if (nvp.length != 2) {
        throw new IllegalArgumentException("Invalid name value pair");
      }
      headers.put(nvp[0], nvp[1]);
    }
    return headers;
  }

  protected void setHttpClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

}
