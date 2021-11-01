package com.example.lifepharmacy.ModelResponse.MyOrder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class MyOrderResponse {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DatumOrder> data = null;


    public MyOrderResponse() {
    }

    /**
     *
     * @param data
     * @param success
     * @param message
     */
    public MyOrderResponse(Boolean success, String message, List<DatumOrder> data) {
        super();
        this.success = success;
        this.message = message;
        this.data = data;
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

    public List<DatumOrder> getData() {
        return data;
    }

    public void setData(List<DatumOrder> data) {
        this.data = data;
    }

}
