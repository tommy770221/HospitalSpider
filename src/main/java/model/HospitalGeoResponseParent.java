package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Tommy on 2017/6/4.
 */
public class HospitalGeoResponseParent {

    @JsonProperty("model.HospitalGeoData")
    HospitalGeoResponse hospitalGeoResponse;

    public HospitalGeoResponse getHospitalGeoResponse() {
        return hospitalGeoResponse;
    }

    public void setHospitalGeoResponse(HospitalGeoResponse hospitalGeoResponse) {
        this.hospitalGeoResponse = hospitalGeoResponse;
    }
}
