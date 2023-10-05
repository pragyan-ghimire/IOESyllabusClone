package com.pragyan.ioesyllabusapp;



public class ItemStructure {
    int imgId;
    String title;
    String description;
   public ItemStructure(int imgId,String title,String description){
       this.imgId=imgId;
       this.title=title;
       this.description=description;
   }

    public int getImgId() {
        return imgId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
