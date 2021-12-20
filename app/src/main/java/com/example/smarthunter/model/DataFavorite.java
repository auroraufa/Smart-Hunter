package com.example.smarthunter.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataFavorite{

    @SerializedName("favorite")
    private List<FavoriteItem> favorite;

    public void setFavorite(List<FavoriteItem> favorite){
        this.favorite = favorite;
    }

    public List<FavoriteItem> getFavorite(){
        return favorite;
    }
}