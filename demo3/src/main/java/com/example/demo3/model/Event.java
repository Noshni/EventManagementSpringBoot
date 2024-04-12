package com.example.demo3.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Event {
    @Id
    private int eventId;
    private String eventPlace;
    private String eventName;
    private String eventDesigns;
    private String eventMember;
    private String eventDetailId;
    private double eventPrice;
    private String eventDiscount;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDesigns() {
        return eventDesigns;
    }

    public void setEventDesigns(String eventDesigns) {
        this.eventDesigns = eventDesigns;
    }

    public String getEventMember() {
        return eventMember;
    }

    public void setEventMember(String eventMember) {
        this.eventMember = eventMember;
    }

    public String getEventDetailId() {
        return eventDetailId;
    }

    public void setEventDetailId(String eventDetailId) {
        this.eventDetailId = eventDetailId;
    }

    public double getEventPrice() {
        return eventPrice;
    }

    public void setEventPrice(double eventPrice) {
        this.eventPrice = eventPrice;
    }

    public String getEventDiscount() {
        return eventDiscount;
    }

    public void setEventDiscount(String eventDiscount) {
        this.eventDiscount = eventDiscount;
    }

    public Event(int eventId, String eventPlace, String eventName, String eventDesigns, String eventMember,
            String eventDetailId, double eventPrice, String eventDiscount) {
        this.eventId = eventId;
        this.eventPlace = eventPlace;
        this.eventName = eventName;
        this.eventDesigns = eventDesigns;
        this.eventMember = eventMember;
        this.eventDetailId = eventDetailId;
        this.eventPrice = eventPrice;
        this.eventDiscount = eventDiscount;
    }

    public Event() {
    }

    @OneToOne
    @JsonBackReference
    private Login login;

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
