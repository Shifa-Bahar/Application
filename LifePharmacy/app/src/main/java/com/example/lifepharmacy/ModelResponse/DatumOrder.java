package com.example.lifepharmacy.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class DatumOrder {

    @SerializedName("order_number")
    @Expose
    private String orderNumber;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("status_label")
    @Expose
    private String statusLabel;

    /**
     * No args constructor for use in serialization
     */
    public DatumOrder() {
    }

    /**
     * @param orderNumber
     * @param statusLabel
     * @param status
     */
    public DatumOrder(String orderNumber, Integer status, String statusLabel) {
        super();
        this.orderNumber = orderNumber;
        this.status = status;
        this.statusLabel = statusLabel;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

}
