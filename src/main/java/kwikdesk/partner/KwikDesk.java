/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner;

import kwikdesk.partner.api.Api;

/**
 * KwikDesk is the main interface to the KwikDesk Partner API.<p>
 *
 */
public class KwikDesk {

  public final static String VERSION = "1.0.0";

  public final static Api api = new Api();

  public interface ApiBase {
    public static final String PRODUCTION = "https://platform.kwikdesk.com";
  }
  
  public enum Environment {
    PRODUCTION("https://platform.kwikdesk.com");
    
    private final String apiBase;       

    private Environment(String apiBase) {
        this.apiBase = apiBase;
    }

    public String getApiBase(){
       return apiBase;
    }
  };
  
  public static Environment environment = Environment.PRODUCTION;

  protected KwikDesk() {}
  
}
