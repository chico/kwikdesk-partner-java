/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner.api;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class TimeResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer error;

  private String iso;
  
  private String timezone;
  
  private Long unixTimestamp;

  public Integer getError() {
    return error;
  }

  public void setError(Integer error) {
    this.error = error;
  }

  public String getIso() {
    return iso;
  }

  public void setIso(String iso) {
    this.iso = iso;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public Long getUnixTimestamp() {
    return unixTimestamp;
  }

  public void setUnixTimestamp(Long unixTimestamp) {
    this.unixTimestamp = unixTimestamp;
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
