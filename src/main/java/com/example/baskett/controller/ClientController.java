package com.example.baskett.controller;

import com.example.baskett.model.Client;
import com.example.baskett.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RequestMapping(path="/client", produces="application/json")
@CrossOrigin(origins="*")
@RequiredArgsConstructor
@RestController
public class ClientController {
    private final ClientService clientService;

    private String auntificationCode(){
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        String date = String.valueOf(localDate.getYear())
                + String.valueOf(localDate.getMonthValue())
                + String.valueOf(localDate.getDayOfMonth())
                + String.valueOf(localTime.getHour())
                + String.valueOf(localTime.getMinute())
                + String.valueOf((int) localTime.getSecond());
        return date;
    }

    private String randomId(){
        String id = String.valueOf((int) (Math.random() *((899)+1))+100);
        return id;
    }

    @PostMapping (path = "/get-auntification")
    public String getAuntification(){
        Client client = new Client();
        String auntification = auntificationCode() + randomId();
        client.setAuntification(auntification);
        clientService.saveClient(client);
        return auntification + " id - " + String.valueOf(client.toString());

    }

    @DeleteMapping(path = "/deleteauntification/{id}")
    public String deleteAccount(@PathVariable Long id){
        clientService.deleteID(id);

        return "Delete - ";
    }
    @DeleteMapping(path = "/delete/{count}")
    public String deleteAccount(@PathVariable("count") String count){
        clientService.deleteClient(count);
        return "Delete - " + count;
    }



}






















