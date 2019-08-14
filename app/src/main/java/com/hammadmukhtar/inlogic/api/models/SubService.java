package com.hammadmukhtar.inlogic.api.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubService {
    @Expose
    @SerializedName("image_url")
    private String imageUrl;
    @Expose
    @SerializedName("language_id")
    private int languageId;
    @Expose
    @SerializedName("service_id")
    private int serviceId;
    @Expose
    @SerializedName("name")
    private String name;
    @Expose
    @SerializedName("name_ar")
    private String nameAr;
    @Expose
    @SerializedName("name_en")
    private String nameEn;
    @Expose
    @SerializedName("is_active")
    private int isActive;
    @Expose
    @SerializedName("parent_id")
    private int parentId;
    @Expose
    @SerializedName("image")
    private String image;
    @Expose
    @SerializedName("id")
    private int id;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
