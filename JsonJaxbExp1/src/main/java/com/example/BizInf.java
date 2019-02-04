
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ChanlCd"
})
public class BizInf {

    @JsonProperty("ChanlCd")
    private String chanlCd;

    @JsonProperty("ChanlCd")
    public String getChanlCd() {
        return chanlCd;
    }

    @JsonProperty("ChanlCd")
    public void setChanlCd(String chanlCd) {
        this.chanlCd = chanlCd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("chanlCd", chanlCd).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(chanlCd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BizInf) == false) {
            return false;
        }
        BizInf rhs = ((BizInf) other);
        return new EqualsBuilder().append(chanlCd, rhs.chanlCd).isEquals();
    }

}
