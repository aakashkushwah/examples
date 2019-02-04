
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "CstmrCdtTrfInitn"
})
public class Document {

    @JsonProperty("CstmrCdtTrfInitn")
    private CstmrCdtTrfInitn cstmrCdtTrfInitn;

    @JsonProperty("CstmrCdtTrfInitn")
    public CstmrCdtTrfInitn getCstmrCdtTrfInitn() {
        return cstmrCdtTrfInitn;
    }

    @JsonProperty("CstmrCdtTrfInitn")
    public void setCstmrCdtTrfInitn(CstmrCdtTrfInitn cstmrCdtTrfInitn) {
        this.cstmrCdtTrfInitn = cstmrCdtTrfInitn;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cstmrCdtTrfInitn", cstmrCdtTrfInitn).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cstmrCdtTrfInitn).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Document) == false) {
            return false;
        }
        Document rhs = ((Document) other);
        return new EqualsBuilder().append(cstmrCdtTrfInitn, rhs.cstmrCdtTrfInitn).isEquals();
    }

}
