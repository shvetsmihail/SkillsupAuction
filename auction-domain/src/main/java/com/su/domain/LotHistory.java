package com.su.domain;

import java.math.BigDecimal;

public class LotHistory {
    private Lot lot;
    private User user;
    private BigDecimal price;

    public LotHistory(Lot lot, User user, BigDecimal price) {
        this.lot = lot;
        this.user = user;
        this.price = price;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "lot: " + lot.getItem().getTitle() +
                ", user: " + user +
                ", price: " + price;
    }
}
