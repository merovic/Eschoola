package com.amirahmed.eschoola.Models;

public class ReservationItem {

    String number;
    String date;
    String status;

    String schoolLogo;
    String schoolName;

    String kidGender;
    String kidName;
    String kidLevel;

    String payment;
    String transportation;

    String totalAmount;
    String discountAmount;
    String paidAmount;


    Boolean additinalDiscount;
    Boolean uniform;
    Boolean books;

    public ReservationItem() {
    }



    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSchoolLogo() {
        return schoolLogo;
    }

    public void setSchoolLogo(String schoolLogo) {
        this.schoolLogo = schoolLogo;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getKidGender() {
        return kidGender;
    }

    public void setKidGender(String kidGender) {
        this.kidGender = kidGender;
    }

    public String getKidName() {
        return kidName;
    }

    public void setKidName(String kidName) {
        this.kidName = kidName;
    }

    public String getKidLevel() {
        return kidLevel;
    }

    public void setKidLevel(String kidLevel) {
        this.kidLevel = kidLevel;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTransportation() {
        return transportation;
    }

    public void setTransportation(String transportation) {
        this.transportation = transportation;
    }

    public Boolean getAdditinalDiscount() {
        return additinalDiscount;
    }

    public void setAdditinalDiscount(Boolean additinalDiscount) {
        this.additinalDiscount = additinalDiscount;
    }

    public Boolean getUniform() {
        return uniform;
    }

    public void setUniform(Boolean uniform) {
        this.uniform = uniform;
    }

    public Boolean getBooks() {
        return books;
    }

    public void setBooks(Boolean books) {
        this.books = books;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(String paidAmount) {
        this.paidAmount = paidAmount;
    }
}
