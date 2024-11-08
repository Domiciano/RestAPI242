package com.example.intregradorapi.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String natID;
    private String name;

    public String getNatID() {
        return natID;
    }

    public void setNatID(String natID) {
        this.natID = natID;
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<TestInfo> testInfos;

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

    public List<TestInfo> getTestInfos() {
        return testInfos;
    }

    public void setTestInfos(List<TestInfo> testInfos) {
        this.testInfos = testInfos;
    }
}
