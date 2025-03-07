package com.example.qrcodegenerator.config;

import com.example.qrcodegenerator.showing.Showing;
import com.example.qrcodegenerator.showing.ShowingRepository;
import com.example.qrcodegenerator.ticket.Ticket;
import com.example.qrcodegenerator.ticket.TicketRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;


@Component
public class InitData implements CommandLineRunner {


    private TicketRepository ticketRepository;
    private ShowingRepository showingRepository;

    public InitData(TicketRepository ticketRepository, ShowingRepository showingRepository){
        this.ticketRepository = ticketRepository;
        this.showingRepository = showingRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Showing showing1 = new Showing();
        showing1.setDate(Date.valueOf("2021-12-12"));
        showing1.setTime(java.sql.Time.valueOf("12:00:00"));
        showingRepository.save(showing1);


        Ticket ticket1 = new Ticket();
        ticket1.setPhoneNumber(12345678);
        ticket1.setShowing(showing1);
        ticketRepository.save(ticket1);
    }
}
