package com.app.falkenfoods.Required;

public class Foods {
    private String fname, fdescriptiopn, fprice, fimage, fcategory, fdid, date, time;

    public Foods() {

    }

    public Foods(String fname, String fdescriptiopn, String fprice, String fimage, String fcategory, String fdid, String date, String time) {
        this.fname = fname;
        this.fdescriptiopn = fdescriptiopn;
        this.fprice = fprice;
        this.fimage = fimage;
        this.fcategory = fcategory;
        this.fdid = fdid;
        this.date = date;
        this.time = time;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFdescriptiopn() {
        return fdescriptiopn;
    }

    public void setFdescriptiopn(String fdescriptiopn) {
        this.fdescriptiopn = fdescriptiopn;
    }

    public String getFprice() {
        return fprice;
    }

    public void setFprice(String fprice) {
        this.fprice = fprice;
    }

    public String getFimage() {
        return fimage;
    }

    public void setFimage(String fimage) {
        this.fimage = fimage;
    }

    public String getFcategory() {
        return fcategory;
    }

    public void setFcategory(String fcategory) {
        this.fcategory = fcategory;
    }

    public String getFdid() {
        return fdid;
    }

    public void setFdid(String fdid) {
        this.fdid = fdid;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
