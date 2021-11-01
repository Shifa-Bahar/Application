package com.example.lifepharmacy.ModelResponse.CreatePres;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class DatumPres {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("emirates_id_front")
    @Expose
    private String emiratesIdFront;
    @SerializedName("emirates_id_back")
    @Expose
    private String emiratesIdBack;
    @SerializedName("insurance_card_front")
    @Expose
    private String insuranceCardFront;
    @SerializedName("insurance_card_back")
    @Expose
    private String insuranceCardBack;
    @SerializedName("prescription")
    @Expose
    private List<String> prescription = null;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("address_id")
    @Expose
    private Integer addressId;
    @SerializedName("items")
    @Expose
    private List<Object> items = null;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("status_label")
    @Expose
    private String statusLabel;

    /**
     * No args constructor for use in serialization
     */
    public DatumPres() {
    }

    /**
     * @param notes
     * @param userId
     * @param statusLabel
     * @param addressId
     * @param createdAt
     * @param prescription
     * @param emiratesIdFront
     * @param id
     * @param items
     * @param emiratesIdBack
     * @param insuranceCardBack
     * @param insuranceCardFront
     * @param status
     * @param updatedAt
     */
    public DatumPres(Integer userId, String emiratesIdFront, String emiratesIdBack, String insuranceCardFront, String insuranceCardBack, List<String> prescription, String notes, Integer status, Integer addressId, List<Object> items, String updatedAt, String createdAt, Integer id, String statusLabel) {
        super();
        this.userId = userId;
        this.emiratesIdFront = emiratesIdFront;
        this.emiratesIdBack = emiratesIdBack;
        this.insuranceCardFront = insuranceCardFront;
        this.insuranceCardBack = insuranceCardBack;
        this.prescription = prescription;
        this.notes = notes;
        this.status = status;
        this.addressId = addressId;
        this.items = items;
        this.updatedAt = updatedAt;
        this.createdAt = createdAt;
        this.id = id;
        this.statusLabel = statusLabel;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmiratesIdFront() {
        return emiratesIdFront;
    }

    public void setEmiratesIdFront(String emiratesIdFront) {
        this.emiratesIdFront = emiratesIdFront;
    }

    public String getEmiratesIdBack() {
        return emiratesIdBack;
    }

    public void setEmiratesIdBack(String emiratesIdBack) {
        this.emiratesIdBack = emiratesIdBack;
    }

    public String getInsuranceCardFront() {
        return insuranceCardFront;
    }

    public void setInsuranceCardFront(String insuranceCardFront) {
        this.insuranceCardFront = insuranceCardFront;
    }

    public String getInsuranceCardBack() {
        return insuranceCardBack;
    }

    public void setInsuranceCardBack(String insuranceCardBack) {
        this.insuranceCardBack = insuranceCardBack;
    }

    public List<String> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<String> prescription) {
        this.prescription = prescription;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

}
