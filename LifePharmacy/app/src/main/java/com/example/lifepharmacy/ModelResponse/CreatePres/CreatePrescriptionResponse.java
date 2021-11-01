package com.example.lifepharmacy.ModelResponse.CreatePres;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CreatePrescriptionResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("DatumPres")
    @Expose
    private com.example.lifepharmacy.ModelResponse.CreatePres.DatumPres DatumPres;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreatePrescriptionResponse() {
    }

    /**
     *
     * @param DatumPres
     * @param success
     * @param message
     */
    public CreatePrescriptionResponse(Boolean success, String message, DatumPres DatumPres) {
        super();
        this.success = success;
        this.message = message;
        this.DatumPres = DatumPres;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DatumPres getDatumPres() {
        return DatumPres;
    }

    public void setDatumPres(DatumPres DatumPres) {
        this.DatumPres = DatumPres;
    }

}


