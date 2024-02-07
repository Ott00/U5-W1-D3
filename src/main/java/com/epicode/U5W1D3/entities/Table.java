package com.epicode.U5W1D3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Table {
    private int numTable;
    private int numMaxCoperti;
    private boolean isFree;
    private double seatPrice;

    public void print() {
        System.out.println("Numero tavolo: " + numTable);
        System.out.println("Numero massimo coperti: " + numMaxCoperti);
        System.out.println("Occupato/libero: " + (this.isFree ? "Libero" : "Occupato"));
    }

}
