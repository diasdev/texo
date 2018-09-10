package com.texo.entity;

import javax.persistence.*;

@Entity(name = "city")
public class City {

    @Id
    @Column(name = "ibge_id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "capital")
    private boolean capital;

    @ManyToOne(optional = false)
    @JoinColumn(name="uf_code")
    private State state;

    @Column(name = "latitude", precision = 8, scale = 6, columnDefinition="DECIMAL(8,6)")
    private double latitude;

    @Column(name = "longitude", precision = 9, scale = 6, columnDefinition="DECIMAL(9,6)")
    private double longitude;

    @Column(name = "name_no_diacritics")
    private String nameWithoutDiacritics;

    @Column(name = "alternative_names")
    private String alternativeNames;

    @Column(name = "microregion")
    private String microregion;

    @Column(name = "mesoregion")
    private String mesoregion;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(boolean capital) {
        this.capital = capital;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNameWithoutDiacritics() {
        return nameWithoutDiacritics;
    }

    public void setNameWithoutDiacritics(String nameWithoutDiacritics) {
        this.nameWithoutDiacritics = nameWithoutDiacritics;
    }

    public String getAlternativeNames() {
        return alternativeNames;
    }

    public void setAlternativeNames(String alternativeNames) {
        this.alternativeNames = alternativeNames;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }
}
