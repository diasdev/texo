package com.texo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class State {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "CODE")
    private long code;

    @Column(name = "NAME")
    private long name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getName() {
        return name;
    }

    public void setName(long name) {
        this.name = name;
    }
}
