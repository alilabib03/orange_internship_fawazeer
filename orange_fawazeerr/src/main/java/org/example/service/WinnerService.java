
package org.example.service;

import org.example.data.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class WinnerService {

    private final WinnerRepository winnerRepository;
    private final PrizeHistoryRepository prizehistoryRepository;
    public WinnerService(WinnerRepository winnerRepository, PrizeHistoryRepository prizehistoryRepository ) {
        this.winnerRepository = winnerRepository;
        this.prizehistoryRepository = prizehistoryRepository;
    }

    public String getAllWinners(String msisdn) {

        //winnerRepository.addawinner(msisdn);
        List<Winner> mywinner = winnerRepository.checkWinnerpresent(msisdn);
        if(mywinner.isEmpty()){
            // first time for this winner to play fawazeer
            int m = checkforAmountofPrizes(msisdn);
            System.out.println("hey");
            if(m==1){
                System.out.println("hey 2");
                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();
                winnerRepository.addawinner(msisdn,currentDate, currentTime);
                return "you are granted the first gift successfully";


            }
            else if(m==2){
                LocalDate currentDate = LocalDate.now();
                LocalTime currentTime = LocalTime.now();
                winnerRepository.addawinner(msisdn,currentDate, currentTime);
                return "you are granted the second gift successfully";
            }
            else{
                return "Sorry, no gifts available";

            }
        }
        else{
            for (int i = 0; i < mywinner.size(); i++) {
                LocalDate currentDate = LocalDate.now();
                int dayOfMonth = currentDate.getDayOfMonth();
                LocalTime currentTime = LocalTime.now();
                Winner winner = mywinner.get(i);
                LocalDate dateforWinner = winner.getDate();
                int dayOfMonthWinner = dateforWinner.getDayOfMonth();
                if(dayOfMonth>dayOfMonthWinner){
                    int m = checkforAmountofPrizes(msisdn);
                    if (m==1){

                        winnerRepository.updateawinner(msisdn,currentDate, currentTime);
                        return "you are granted the first gift successfully";

                    }
                    else if(m==2){
                        winnerRepository.updateawinner(msisdn,currentDate, currentTime);
                        return "you are granted the second gift successfully";
                    }
                    else{
                        return "Sorry, no gifts available";
                    }

                }
                else{
                    return "Sorry, you were already granted today";
                }
            }
        }
        return "ay haga";

        //return (List<Winner>) winnerRepository.findAll(); // adjust this
    }
    public int checkforAmountofPrizes(String msisdn){
        System.out.println("arrived here");
        List<PrizeHistory> lastpersonGranted = prizehistoryRepository.getLastPerson();
        if(lastpersonGranted.isEmpty()){
            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            prizehistoryRepository.addawinnerPrizeH(1,msisdn,currentDate,currentTime);
            return 1;
        }
        for (int i = 0; i < lastpersonGranted.size(); i++) {
            PrizeHistory prizeHistory = lastpersonGranted.get(i);

            LocalDate currentDate = LocalDate.now();
            LocalTime currentTime = LocalTime.now();
            int dayOfMonth = currentDate.getDayOfMonth();
            LocalDate dateforLastPerson = prizeHistory.getDate();
            int dayOfMonthLastPerson = dateforLastPerson.getDayOfMonth();
            if(dayOfMonthLastPerson<dayOfMonth){
                prizehistoryRepository.addawinnerPrizeH(1,msisdn,currentDate,currentTime);
                return 1;
            }
            else{
                int thecapacity = prizeHistory.getCapacity();
                if(thecapacity>3 && thecapacity<7){
                    int newcapacity = thecapacity + 1;
                    prizehistoryRepository.addawinnerPrizeH(newcapacity,msisdn,currentDate,currentTime);
                    return 2;
                    //return 99;
                }
                else if(thecapacity>=7){
                    return 99;
                }
                else{
                    int newcapacity = thecapacity + 1;
                    prizehistoryRepository.addawinnerPrizeH(newcapacity,msisdn,currentDate,currentTime);
                    return 1;
                }
            }
            //System.out.println(prizeHistory);
        }

        return 0;
    }

    // Add methods
}

