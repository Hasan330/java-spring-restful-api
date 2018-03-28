package com.hasan;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name= "consumption")
public class FuelConsumption {

    @Id
    @Column(name= "id")
    @GeneratedValue(generator = "incrementator")
    @GenericGenerator(name = "incrementator", strategy = "increment" )
    private int id;

    @Column(name= "cost")
    private int        cost;

    private Calendar   refuelDate;
    private Long       initialMillage;
    private double     litresFilled;
    private int        proposedDistance;
    private int        actualDistance;

    @Column(name = "CAR_ID")
    private int carId;

    @OneToMany
    @JoinColumn(name = "REFILL_ID", referencedColumnName = "id")
    private List<LongDistance> longDistances = new ArrayList<>();


    public FuelConsumption(Calendar refuelDate, Long initialMillage, int cost, double litresFilled, int proposedDistance, int actualDistance) {
        this.refuelDate        = refuelDate;
        this.initialMillage    = initialMillage;
        this.cost              = cost;
        this.litresFilled      = litresFilled;
        this.proposedDistance  = proposedDistance;
        this.actualDistance    = actualDistance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Calendar getRefuelDate() {
        return refuelDate;
    }

    public Long getInitialMillage() {
        return initialMillage;
    }

    public int getId() {
        return id;
    }

    public int getCost() {
        return cost;
    }

    public double getLitresFilled() {
        return litresFilled;
    }

    public int getProposedDistance() {
        return proposedDistance;
    }

    public int getActualDistance() {
        return actualDistance;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public List<LongDistance> getLongDistances() {
        return longDistances;
    }

    public void setLongDistances(List<LongDistance> longDistances) {
        this.longDistances = longDistances;
    }

    public void addLongDistance(LongDistance longDistance){
        this.longDistances.add(longDistance);

    }
}