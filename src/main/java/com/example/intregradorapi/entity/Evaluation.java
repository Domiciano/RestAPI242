package com.example.intregradorapi.entity;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "evaluation")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Type(JsonBinaryType.class)  // Usa el tipo JSONB de hibernate-types
    @Column(columnDefinition = "jsonb")
    private Readings readings;


    @OneToOne
    @JoinColumn(name = "testinfoID")
    private TestInfo testInfo ;

    public TestInfo getTestInfo() {
        return testInfo;
    }

    public void setTestInfo(TestInfo testInfo) {
        this.testInfo = testInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
    }
}
