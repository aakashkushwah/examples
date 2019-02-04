
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "LclInstrm"
})
public class PmtTpInf {

    @JsonProperty("LclInstrm")
    private LclInstrm lclInstrm;

    @JsonProperty("LclInstrm")
    public LclInstrm getLclInstrm() {
        return lclInstrm;
    }

    @JsonProperty("LclInstrm")
    public void setLclInstrm(LclInstrm lclInstrm) {
        this.lclInstrm = lclInstrm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("lclInstrm", lclInstrm).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(lclInstrm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PmtTpInf) == false) {
            return false;
        }
        PmtTpInf rhs = ((PmtTpInf) other);
        return new EqualsBuilder().append(lclInstrm, rhs.lclInstrm).isEquals();
    }

}
