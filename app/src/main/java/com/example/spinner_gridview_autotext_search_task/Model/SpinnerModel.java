package com.example.spinner_gridview_autotext_search_task.Model;

public class SpinnerModel
{
    int image;
    String countryName;

    public SpinnerModel(int image, String countryName) {
        this.image = image;
        this.countryName = countryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
