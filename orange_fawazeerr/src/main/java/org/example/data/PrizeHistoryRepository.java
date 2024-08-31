
package org.example.data;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface PrizeHistoryRepository extends CrudRepository<PrizeHistory, String> {
    @Query("SELECT * FROM PrizeHistory ORDER BY prizeid DESC LIMIT 1")
    public List<PrizeHistory> getLastPerson();


    @Modifying
    @Query("INSERT INTO PrizeHistory (capacity, msisdn, date, time) VALUES (:capacity, :msisdn, :date, :time)")
    public void addawinnerPrizeH(Integer capacity, String msisdn, LocalDate date, LocalTime time);
    // custom query
}

