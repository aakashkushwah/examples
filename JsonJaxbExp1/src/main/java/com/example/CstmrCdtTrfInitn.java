
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PmtInf"
})
public class CstmrCdtTrfInitn {

    @JsonProperty("PmtInf")
    private PmtInf pmtInf;

    @JsonProperty("PmtInf")
    public PmtInf getPmtInf() {
        return pmtInf;
    }

    @JsonProperty("PmtInf")
    public void setPmtInf(PmtInf pmtInf) {
        this.pmtInf = pmtInf;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pmtInf", pmtInf).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pmtInf).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CstmrCdtTrfInitn) == false) {
            return false;
        }
        CstmrCdtTrfInitn rhs = ((CstmrCdtTrfInitn) other);
        return new EqualsBuilder().append(pmtInf, rhs.pmtInf).isEquals();
    }

}
