package com.example.lifepharmacy.ModelResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class CreatePresRequest {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("mobile_number")
    @Expose
    private String mobileNumber;
    @SerializedName("flat_number")
    @Expose
    private String flatNumber;
    @SerializedName("building")
    @Expose
    private String building;
    @SerializedName("street_address")
    @Expose
    private String streetAddress;
    @SerializedName("emirates_id_back")
    @Expose
    private String emiratesIdBack;
    @SerializedName("emirates_id_front")
    @Expose
    private String emiratesIdFront;
    @SerializedName("insurance_card_back")
    @Expose
    private String insuranceCardBack;
    @SerializedName("insurance_card_front")
    @Expose
    private String insuranceCardFront;
    @SerializedName("notes")
    @Expose
    private String notes;
    @SerializedName("prescription")
    @Expose
    private List<String> prescription = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreatePresRequest() {
    }

    /**
     *
     * @param notes
     * @param streetAddress
     * @param prescription
     * @param mobileNumber
     * @param flatNumber
     * @param emiratesIdFront
     * @param name
     * @param building
     * @param emiratesIdBack
     * @param insuranceCardBack
     * @param insuranceCardFront
     */
    public CreatePresRequest(String name, String mobileNumber, String flatNumber, String building, String streetAddress, String emiratesIdBack, String emiratesIdFront, String insuranceCardBack, String insuranceCardFront, String notes, List<String> prescription) {
        super();
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.flatNumber = flatNumber;
        this.building = building;
        this.streetAddress = streetAddress;
        this.emiratesIdBack = emiratesIdBack;
        this.emiratesIdFront = emiratesIdFront;
        this.insuranceCardBack = insuranceCardBack;
        this.insuranceCardFront = insuranceCardFront;
        this.notes = notes;
        this.prescription = prescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getEmiratesIdBack() {
        return emiratesIdBack;
    }

    public void setEmiratesIdBack(String emiratesIdBack) {
        this.emiratesIdBack = emiratesIdBack;
    }

    public String getEmiratesIdFront() {
        return emiratesIdFront;
    }

    public void setEmiratesIdFront(String emiratesIdFront) {
        this.emiratesIdFront = emiratesIdFront;
    }

    public String getInsuranceCardBack() {
        return insuranceCardBack;
    }

    public void setInsuranceCardBack(String insuranceCardBack) {
        this.insuranceCardBack = insuranceCardBack;
    }

    public String getInsuranceCardFront() {
        return insuranceCardFront;
    }

    public void setInsuranceCardFront(String insuranceCardFront) {
        this.insuranceCardFront = insuranceCardFront;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public List<String> getPrescription() {
        return prescription;
    }

    public void setPrescription(List<String> prescription) {
        this.prescription = prescription;
    }

}