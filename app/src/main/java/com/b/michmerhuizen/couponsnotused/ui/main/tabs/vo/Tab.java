package com.b.michmerhuizen.couponsnotused.ui.main.tabs.vo;

public class Tab {
    public static final Tab ADD_ME = new Tab("Add a Tab");
    private String title;
    public Tab(String title){
        this.title = title;
    }

    public CharSequence getTitle() {
        return title;
    }
}
