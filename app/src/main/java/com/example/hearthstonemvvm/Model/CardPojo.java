package com.example.hearthstonemvvm.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CardPojo {

    @SerializedName("cardId")
    @Expose
    public String cardId;
    @SerializedName("dbfId")
    @Expose
    public String dbfId;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("cardSet")
    @Expose
    public String cardSet;
    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("health")
    @Expose
    public Integer health;
    @SerializedName("playerClass")
    @Expose
    public String playerClass;
    @SerializedName("img")
    @Expose
    public String img;
    @SerializedName("imgGold")
    @Expose
    public String imgGold;
    @SerializedName("locale")
    @Expose
    public String locale;
    @SerializedName("text")
    @Expose
    public String text;
    @SerializedName("mechanics")
    @Expose
    public List<MechanicPojo> mechanics = null;
    @SerializedName("cost")
    @Expose
    public Integer cost;
    @SerializedName("attack")
    @Expose
    public Integer attack;
    @SerializedName("elite")
    @Expose
    public Boolean elite;
    @SerializedName("race")
    @Expose
    public String race;
    @SerializedName("rarity")
    @Expose
    public String rarity;
    @SerializedName("flavor")
    @Expose
    public String flavor;
    @SerializedName("artist")
    @Expose
    public String artist;
    @SerializedName("collectible")
    @Expose
    public Boolean collectible;
    @SerializedName("howToGet")
    @Expose
    public String howToGet;
    @SerializedName("howToGetGold")
    @Expose
    public String howToGetGold;
    @SerializedName("durability")
    @Expose
    public Integer durability;

}
