package com.example.hearthstonemvvm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResultsPojo {

    @SerializedName("Basic")
    @Expose
    public List<CardPojo> basic = null;

}
