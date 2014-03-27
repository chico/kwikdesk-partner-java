/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RealApiTest {

  private Api api = new Api();

  private final String appName = "test-app";
  
  @Test
  public void testToken() {
    TokenResponse response = api.token(appName);
    assertEquals(response.getError().intValue(), 0);
    assertTrue(response.getToken() != null);
    System.out.println(response.getToken());
  }

  @Test
  public void testSearch() {
    SearchResponse response = api.search(api.token(appName).getToken(), "kwikdesk");    
    assertEquals(response.getError().intValue(), 0);
    assertTrue(response.getResults().size() >= 0);
  }

  @Test
  public void testMessage() {
    Message message = new Message("This is the message I want to post #kwikdesk");
    MessageResponse response = api.message(api.token(appName).getToken(), message);
    assertEquals(response.getError().intValue(), 0); 
  }

}
