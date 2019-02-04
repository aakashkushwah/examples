
package com.example;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Nm"
})
public class InitgPty {

    @JsonProperty("Nm")
    private String nm;

    @JsonProperty("Nm")
    public String getNm() {
        return nm;
    }

    @JsonProperty("Nm")
    public void setNm(String nm) {
        this.nm = nm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("nm", nm).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(nm).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InitgPty) == false) {
            return false;
        }
        InitgPty rhs = ((InitgPty) other);
        return new EqualsBuilder().append(nm, rhs.nm).isEquals();
    }

}
