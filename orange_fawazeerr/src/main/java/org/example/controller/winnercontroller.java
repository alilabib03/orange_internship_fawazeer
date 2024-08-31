package org.example.controller;


import com.example.fawazyr.service.WinnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/winners")
public class winnercontroller {
    @Autowired
    private final WinnerService winnerService;

    public winnercontroller(WinnerService winnerService) {
        this.winnerService = winnerService;
    }
    @GetMapping
    public String getAllWinners(@RequestParam String msisdn) {
        return winnerService.getAllWinners(msisdn); //adjust this
    }

}

