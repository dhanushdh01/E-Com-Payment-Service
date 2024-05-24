package dev.dhanush.PaymentService.Util;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class SchedulingDemo {

    @Scheduled(cron = "*/5 * * * * *") // <second> <minute> <hour> <day of month> <month> <day of week>
    public void printTimeAndDetails(){
        System.out.println("Hello World " + LocalDateTime.now());
    }
}