/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner.api;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.google.gson.annotations.SerializedName;

public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  public static final Integer DEFAULT_DELETE = new Long(TimeUnit.MINUTES.convert(1, TimeUnit.DAYS)).intValue();

  private String content;

  private Integer delete = DEFAULT_DELETE;
  
  @SerializedName("private")
  private Boolean secure = true; 

  public Message(String content) {
    this.content = content;
  }

  public Message(String content, Integer delete) {
    this.content = content;
    this.delete = delete;
  }
  
  public Message(String content, Integer delete, Boolean secure) {
    this.content = content;
    this.delete = delete;
    this.secure = secure;
  }

  public String getContent() {
    return content;
  }

  public Integer getDelete() {
    return delete;
  }
  
  public Boolean getSecure() {
    return secure;
  }

  @Override
  public boolean equals(Object obj) {
      return EqualsBuilder.reflectionEquals(this, obj);
  }

  @Override
  public int hashCode() {
      return HashCodeBuilder.reflectionHashCode(this);
  }

}
