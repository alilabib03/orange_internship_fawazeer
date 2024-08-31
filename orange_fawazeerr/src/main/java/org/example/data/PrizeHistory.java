
package org.example.data;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrizeHistory {
    @Id Integer prizeid;
    private Integer capacity;
    private String msisdn;
    private LocalDate date;
    private LocalTime time;


    public PrizeHistory() {
    }

    public PrizeHistory(Integer capacity, String msisdn, LocalDate date, Integer prizeid, LocalTime time ) {

        this.capacity = capacity;
        this.msisdn = msisdn;
        this.date = date;
        this.time = time;
        this.prizeid = prizeid;
    }


    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }


    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }
}
