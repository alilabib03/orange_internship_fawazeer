
package org.example.data;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface WinnerRepository extends CrudRepository<Winner, String> {

    @Modifying
    @Query("INSERT INTO winner (msisdn, date, time) VALUES (:msisdn, :date, :time)")
    public void addawinner(String msisdn, LocalDate date, LocalTime time);


    @Query("SELECT * FROM winner WHERE msisdn = :msisdn ")
    public List<Winner> checkWinnerpresent(String msisdn);


    @Modifying
    @Query("UPDATE winner SET date = :date , time = :time WHERE msisdn = :msisdn")
    public void updateawinner(String msisdn, LocalDate date, LocalTime time);


    //custom query
}
