package com.amirahmed.eschoola.Models;

public class SonItem {

    String sonPic;
    String sonName;
    String sonBirthDate;
    String sonGender;
    String sonStage;
    String sonLevel;
    String sonLastSchool;

    public SonItem() {
    }

    public SonItem(String sonName) {
        this.sonName = sonName;
    }

    public String getSonName() {
        return sonName;
    }

    public String getSonPic() {
        return sonPic;
    }

    public void setSonPic(String sonPic) {
        this.sonPic = sonPic;
    }

    public void setSonName(String sonName) {
        this.sonName = sonName;
    }

    public String getSonBirthDate() {
        return sonBirthDate;
    }

    public void setSonBirthDate(String sonBirthDate) {
        this.sonBirthDate = sonBirthDate;
    }

    public String getSonGender() {
        return sonGender;
    }

    public void setSonGender(String sonGender) {
        this.sonGender = sonGender;
    }

    public String getSonStage() {
        return sonStage;
    }

    public void setSonStage(String sonStage) {
        this.sonStage = sonStage;
    }

    public String getSonLevel() {
        return sonLevel;
    }

    public void setSonLevel(String sonLevel) {
        this.sonLevel = sonLevel;
    }

    public String getSonLastSchool() {
        return sonLastSchool;
    }

    public void setSonLastSchool(String sonLastSchool) {
        this.sonLastSchool = sonLastSchool;
    }
}
