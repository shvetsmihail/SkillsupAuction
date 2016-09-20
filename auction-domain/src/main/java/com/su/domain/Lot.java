package com.su.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Lot {
    private Item item;
    private User owner;
    private BigDecimal startPrice;
    private Date datePlaced;
    private Date dateEnd;
    private User buyer;
    private BigDecimal currentPrice;

    public Lot(Item item, User owner, BigDecimal startPrice) {
        this.item = item;
        this.owner = owner;
        this.startPrice = startPrice;
        this.datePlaced = new Date();
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public BigDecimal getStartPrice() {
        return startPrice;
    }

    public void setStartPrice(BigDecimal startPrice) {
        this.startPrice = startPrice;
    }

    public Date getDatePlaced() {
        return datePlaced;
    }

    public void setDatePlaced(Date datePlaced) {
        this.datePlaced = datePlaced;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(BigDecimal currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return  "item: " + item +
                ", owner: " + owner +
                ", startPrice: " + startPrice;
    }
}
