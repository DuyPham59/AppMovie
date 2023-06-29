package com.example.appmovie;

public class Film {
    private int resourceId;
    private  String name;

    public Film(int resourceId , String name){
        this.resourceId = resourceId;
        this.name = name;
    }
    public int getResourceId(){
        return  resourceId;
    }
    public void setResourceId(){
        this.resourceId = resourceId;
    }
    public String getName(){
        return name;
    }
    public void setName(){
        this.name = name;
    }
}
