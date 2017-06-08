package ru.arkadiy.ubanktest.model.data;

import java.util.Date;

/**
 * Created by arkadiy.zakharov on 08.06.2017.
 */

public class Item {

    private String title;
    private Date date;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
