package com.example.sofitconsultancytask.ModelClasses;

public class ImagesModel {
    int imageId;
    String description;

    public ImagesModel(int imageId, String description) {
        this.imageId = imageId;
        this.description = description;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
