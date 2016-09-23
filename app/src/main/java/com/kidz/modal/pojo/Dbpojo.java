package com.kidz.modal.pojo;

public class Dbpojo {
     
    //private variables
    String videoid;
    String titile;

     
    // Empty constructor
    public Dbpojo(){
         
    }
    // constructor


    public Dbpojo(String videoid, String titile) {
        this.videoid = videoid;
        this.titile = titile;
    }

    public String getVideoid() {
        return videoid;
    }

    public void setVideoid(String videoid) {
        this.videoid = videoid;
    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }
}