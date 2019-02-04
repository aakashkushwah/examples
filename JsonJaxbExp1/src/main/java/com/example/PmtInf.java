
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "PmtInfId",
    "PmtMtd",
    "PmtTpInf",
    "ReqdExctnDt",
    "InstrForDbtrAgt"
})
public class PmtInf {

    @JsonProperty("PmtInfId")
    private String pmtInfId;
    @JsonProperty("PmtMtd")
    private String pmtMtd;
    @JsonProperty("PmtTpInf")
    private PmtTpInf pmtTpInf;
    @JsonProperty("ReqdExctnDt")
    private ReqdExctnDt reqdExctnDt;
    @JsonProperty("InstrForDbtrAgt")
    private String instrForDbtrAgt;

    @JsonProperty("PmtInfId")
    public String getPmtInfId() {
        return pmtInfId;
    }

    @JsonProperty("PmtInfId")
    public void setPmtInfId(String pmtInfId) {
        this.pmtInfId = pmtInfId;
    }

    @JsonProperty("PmtMtd")
    public String getPmtMtd() {
        return pmtMtd;
    }

    @JsonProperty("PmtMtd")
    public void setPmtMtd(String pmtMtd) {
        this.pmtMtd = pmtMtd;
    }

    @JsonProperty("PmtTpInf")
    public PmtTpInf getPmtTpInf() {
        return pmtTpInf;
    }

    @JsonProperty("PmtTpInf")
    public void setPmtTpInf(PmtTpInf pmtTpInf) {
        this.pmtTpInf = pmtTpInf;
    }

    @JsonProperty("ReqdExctnDt")
    public ReqdExctnDt getReqdExctnDt() {
        return reqdExctnDt;
    }

    @JsonProperty("ReqdExctnDt")
    public void setReqdExctnDt(ReqdExctnDt reqdExctnDt) {
        this.reqdExctnDt = reqdExctnDt;
    }

    @JsonProperty("InstrForDbtrAgt")
    public String getInstrForDbtrAgt() {
        return instrForDbtrAgt;
    }

    @JsonProperty("InstrForDbtrAgt")
    public void setInstrForDbtrAgt(String instrForDbtrAgt) {
        this.instrForDbtrAgt = instrForDbtrAgt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("pmtInfId", pmtInfId).append("pmtMtd", pmtMtd).append("pmtTpInf", pmtTpInf).append("reqdExctnDt", reqdExctnDt).append("instrForDbtrAgt", instrForDbtrAgt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pmtInfId).append(reqdExctnDt).append(instrForDbtrAgt).append(pmtTpInf).append(pmtMtd).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PmtInf) == false) {
            return false;
        }
        PmtInf rhs = ((PmtInf) other);
        return new EqualsBuilder().append(pmtInfId, rhs.pmtInfId).append(reqdExctnDt, rhs.reqdExctnDt).append(instrForDbtrAgt, rhs.instrForDbtrAgt).append(pmtTpInf, rhs.pmtTpInf).append(pmtMtd, rhs.pmtMtd).isEquals();
    }

}
