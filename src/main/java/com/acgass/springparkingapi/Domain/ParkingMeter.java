package com.acgass.springparkingapi.domain;

import java.io.Serializable;

public class ParkingMeter implements Serializable {
    private String locaiton;
    private long meterId;
    private String timeRemaining;
    private boolean isOpen;
    private String moneyPaid;

    public ParkingMeter (String lcation, long meterId, String timeRemaining, String moneyPaid){
        this.locaiton = lcation;
        this.meterId = meterId;
        this.timeRemaining = timeRemaining;
        this.moneyPaid = moneyPaid;
    }

    public String getLocaiton() {
        return locaiton;
    }

    public void setLocaiton(String locaiton) {
        this.locaiton = locaiton;
    }

    public long getMeterId() {
        return meterId;
    }

    public void setMeterId(long meterId) {
        this.meterId = meterId;
    }

    public String getTimeRemaining() {
        return timeRemaining;
    }

    public void setTimeRemaining(String timeRemaining) {
        this.timeRemaining = timeRemaining;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public String getMoneyPaid() {
        return moneyPaid;
    }

    public void setMoneyPaid(String moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public updateTime(String amountPaid){
        // TODO: implement once util class is flushed out
        return timeRemaining;
    }
}