package org.example.data;
import java.time.LocalDate;
import java.time.LocalTime;

public class Winner {
    private String msisdn;
    private LocalDate date;
    private LocalTime time;


    public Winner() {
    }

    public Winner(String msisdn, LocalDate date, LocalTime time) {
        this.msisdn = msisdn;
        this.date = date;
        this.time = time;
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
