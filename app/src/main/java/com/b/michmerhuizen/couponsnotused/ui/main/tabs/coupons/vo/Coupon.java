package com.b.michmerhuizen.couponsnotused.ui.main.tabs.coupons.vo;

public class Coupon {
    public static final Coupon ADD_COUPON = new Coupon("","Add a coupon","Add a coupon");
     public final String item_number;
     public final String content;
     public final String details;

    public Coupon(String item_number, String content, String details) {
        this.item_number = item_number;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}
