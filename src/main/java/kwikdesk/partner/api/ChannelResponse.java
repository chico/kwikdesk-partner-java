/* Copyright (c) 2014 Chico Charlesworth, MIT License */
package kwikdesk.partner.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ChannelResponse implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer error;

  private List<ChannelResult> results = new ArrayList<ChannelResult>();

  public Integer getError() {
    return error;
  }

  public void setError(Integer error) {
    this.error = error;
  }

  public List<ChannelResult> getResults() {
    return results;
  }

  public void setResults(List<ChannelResult> results) {
    this.results = results;
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
