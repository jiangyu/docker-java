package com.github.dockerjava.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DeviceRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("Driver")
    private String driver = "";

    @JsonProperty("Count")
    private Integer count = 0;

    @JsonProperty("DeviceIDs")
    private List<String> devicesIDs = new ArrayList<>();

    @JsonProperty("Capabilities")
    private List<String> capabilities = Arrays.asList("gpu");

    public DeviceRequest() {
    }

    public DeviceRequest(List<String> devicesIDs) {
        this.devicesIDs = devicesIDs;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof DeviceRequest) {
            DeviceRequest other = (DeviceRequest) obj;
            return new EqualsBuilder().append(getDevicesIDs(), other.getDevicesIDs()).isEquals();
        } else {
            return super.equals(obj);
        }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getDevicesIDs()).toHashCode();
    }

    public String getDriver() {
        return driver;
    }

    public Integer getCount() {
        return count;
    }

    public List<String> getDevicesIDs() {
        return devicesIDs;
    }

    public List<String> getCapabilities() {
        return capabilities;
    }
}
