package com.example.qrcodegenerator.ticket;


import com.example.qrcodegenerator.showing.Showing;
import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long phoneNumber;

    //many tickets to one showing
    @ManyToOne
    @JoinColumn(name = "showingId", referencedColumnName = "id")
    private Showing showing;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Showing getShowing() {
        return showing;
    }
    public void setShowing(Showing showing) {
        this.showing = showing;
    }

}
