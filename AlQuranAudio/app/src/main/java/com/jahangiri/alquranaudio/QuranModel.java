package com.jahangiri.alquranaudio;

public class QuranModel {

    private int ImageId;
    private String quranParaNo;
    private String quranParaName;

    public QuranModel(int imageId, String quranParaNo, String quranParaName) {
        this.ImageId = imageId;
        this.quranParaNo = quranParaNo;
        this.quranParaName = quranParaName;
    }

    //Alt+insert is the shortcut key for the getter and setter but first you should have to declare variable


    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    public String getQuranParaNo() {
        return quranParaNo;
    }

    public void setQuranParaNo(String quranParaNo) {
        this.quranParaNo = quranParaNo;
    }

    public String getQuranParaName() {
        return quranParaName;
    }

    public void setQuranParaName(String quranParaName) {
        this.quranParaName = quranParaName;
    }
}