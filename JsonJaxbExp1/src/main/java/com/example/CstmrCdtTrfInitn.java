
package com.example;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "GrpHdr",
    "PmtInf",
    "SplmtryData"
})
public class CstmrCdtTrfInitn {

    @JsonProperty("GrpHdr")
    private GrpHdr grpHdr;
    @JsonProperty("PmtInf")
    private PmtInf pmtInf;
    @JsonProperty("SplmtryData")
    private List<SplmtryDatum> splmtryData = null;

    @JsonProperty("GrpHdr")
    public GrpHdr getGrpHdr() {
        return grpHdr;
    }

    @JsonProperty("GrpHdr")
    public void setGrpHdr(GrpHdr grpHdr) {
        this.grpHdr = grpHdr;
    }

    @JsonProperty("PmtInf")
    public PmtInf getPmtInf() {
        return pmtInf;
    }

    @JsonProperty("PmtInf")
    public void setPmtInf(PmtInf pmtInf) {
        this.pmtInf = pmtInf;
    }

    @JsonProperty("SplmtryData")
    public List<SplmtryDatum> getSplmtryData() {
        return splmtryData;
    }

    @JsonProperty("SplmtryData")
    public void setSplmtryData(List<SplmtryDatum> splmtryData) {
        this.splmtryData = splmtryData;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("grpHdr", grpHdr).append("pmtInf", pmtInf).append("splmtryData", splmtryData).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pmtInf).append(grpHdr).append(splmtryData).toHashCode();
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
        return new EqualsBuilder().append(pmtInf, rhs.pmtInf).append(grpHdr, rhs.grpHdr).append(splmtryData, rhs.splmtryData).isEquals();
    }

}
