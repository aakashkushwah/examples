
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Dt"
})
public class ReqdExctnDt {

    @JsonProperty("Dt")
    private String dt;

    @JsonProperty("Dt")
    public String getDt() {
        return dt;
    }

    @JsonProperty("Dt")
    public void setDt(String dt) {
        this.dt = dt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("dt", dt).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(dt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReqdExctnDt) == false) {
            return false;
        }
        ReqdExctnDt rhs = ((ReqdExctnDt) other);
        return new EqualsBuilder().append(dt, rhs.dt).isEquals();
    }

}
