/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.movierental;

/**
 *
 * @author in-rahul.khandelwal
 */
public class TextStatement {
    
    public String display(String customerName, Rentals rentals) {
        String result = "Rental Record for " + customerName + "\n";
        
        for (Rental each : rentals) {
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t"
                    + String.valueOf(each.amount()) + "\n";
        }

        //add footer lines result
        result += "Amount owed is " + String.valueOf(rentals.totalAmount()) + "\n";
        result += "You earned " + String.valueOf(rentals.frequentRenterPoints())
                + " frequent renter points";
        return result;
    }
    
}
