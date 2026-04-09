package com.example.khaija.Models;

public class PizzaRecipie {

    int img;
    String name, price, description;

    public PizzaRecipie(int img, String name, String price, String description) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
//    int pic;
//    String text;
//
//    public PizzaRecipie(int pic, String text) {
//        this.pic = pic;
//        this.text = text;
//    }
//
//    public int getPic() {
//        return pic;
//    }
//
//    public void setPic(int pic) {
//        this.pic = pic;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }

