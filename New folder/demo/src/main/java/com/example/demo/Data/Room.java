package com.example.demo.Data;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name= "name")
    private String name;

    @Column(name= "max_count")
    private int max_count;

    @Column(name= "rent_per_day")
    private float rent_per_day;

    @Column(name= "image_urls")
    private String image_urls;

    @Column(name= "type")
    private String type;

    @Column(name= "description")
    private String description;

    @Column(name = "checkin_date")
    private LocalDate checkinDate;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMax_count() {
        return max_count;
    }

    public void setMax_count(int max_count) {
        this.max_count = max_count;
    }

    public float getRent_per_day() {
        return rent_per_day;
    }

    public void setRent_per_day(float rent_per_day) {
        this.rent_per_day = rent_per_day;
    }

    public String getImage_urls() {
        return image_urls;
    }

    public void setImage_urls(String image_urls) {
        this.image_urls = image_urls;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }
}

