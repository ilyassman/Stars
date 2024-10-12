package com.example.tp4.beans;

public class Star {
    private int id;
    private static int comp=0;
    private String name;
    private String img;
    private float star;
    private boolean gender;
    public Star(String name, String img, float star,boolean gender) {
        this.id = ++comp;
        this.name = name;
        this.img = img;
        this.star = star;
        this.gender=gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static void setComp(int comp) {
        Star.comp = comp;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setStar(float star) {
        this.star = star;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public static int getComp() {
        return comp;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public float getStar() {
        return star;
    }

    public boolean isGender() {
        return gender;
    }
}
