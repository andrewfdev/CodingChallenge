package com.codewithandrew.ShareTradingFunctions;

import java.util.Date;

public class SharePrice {
    private Date sellTime;
    private int price;

    public Date getSellTime() {
        return sellTime;
    }

    public void setSellTime(Date sellTime) {
        this.sellTime = sellTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public SharePrice(Date sellTime, int price) {
        this.sellTime = sellTime;
        this.price = price;
    }
}
