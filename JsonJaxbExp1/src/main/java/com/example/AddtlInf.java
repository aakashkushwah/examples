
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "BizInf"
})
public class AddtlInf {

    @JsonProperty("BizInf")
    private BizInf bizInf;

    @JsonProperty("BizInf")
    public BizInf getBizInf() {
        return bizInf;
    }

    @JsonProperty("BizInf")
    public void setBizInf(BizInf bizInf) {
        this.bizInf = bizInf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("bizInf", bizInf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bizInf).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AddtlInf) == false) {
            return false;
        }
        AddtlInf rhs = ((AddtlInf) other);
        return new EqualsBuilder().append(bizInf, rhs.bizInf).isEquals();
    }

}
