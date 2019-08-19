/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movierental;

import java.util.ArrayList;

/**
 *
 * @author in-rahul.khandelwal
 */
public class Rentals extends ArrayList<Rental> {
    
    public double totalAmount() {
        double totalAmount = 0;
        
        for (Rental each : this) {
            totalAmount += each.amount();
        }
        
        return totalAmount;
    }
    
    public int frequentRenterPoints() {
        int frequentRenterPoints = 0;
        
        for (Rental each : this) {
            frequentRenterPoints += each.getFrequentRenterPoints();
        }
        
        return frequentRenterPoints;
    }
}
