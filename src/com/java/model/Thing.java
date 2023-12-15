package com.java.model;

public class Thing {
    private Integer id;

    private String name;

    private Integer thingtypeId;

    private Integer thingtype2Id;
    private Pages page;
    private ThingType thingtype;
    private ThingType2 thingtype2;
    private String img;
    private int num;
    private String color;
    private String size;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Pages getPage() {
        return page;
    }

    public void setPage(Pages page) {
        this.page = page;
    }

    public ThingType getThingtype() {
        return thingtype;
    }

    public void setThingtype(ThingType thingtype) {
        this.thingtype = thingtype;
    }

    public ThingType2 getThingtype2() {
        return thingtype2;
    }

    public void setThingtype2(ThingType2 thingtype2) {
        this.thingtype2 = thingtype2;
    }

    private Integer shopId;

    private Integer price;

    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getThingtypeId() {
        return thingtypeId;
    }

    public void setThingtypeId(Integer thingtypeId) {
        this.thingtypeId = thingtypeId;
    }

    public Integer getThingtype2Id() {
        return thingtype2Id;
    }

    public void setThingtype2Id(Integer thingtype2Id) {
        this.thingtype2Id = thingtype2Id;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}