package ru.porabote.springbootrestauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class FileModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String filename;

    private String hash;

    private long size;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getSize(long size) {
        return this.size;
    }

    public void setFilename(String name) {
        this.filename = name;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String email) {
        this.hash = email;
    }

}
