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
public class HtmlStatement {
    
    public String display(String customerName, Rentals rentals) {
        String result = "<h1>Rental Record for <b>" + customerName + "</b></h1><br/>";
        
        for (Rental each : rentals) {
            //show figures for this rental
            result += " " + each.getMovie().getTitle() + " "
                    + String.valueOf(each.amount()) + "<br/>";
        }

        //add footer lines result
        result += "Amount owed is <b>" + String.valueOf(rentals.totalAmount()) + "</b><br/>";
        result += "You earned <b>" + String.valueOf(rentals.frequentRenterPoints())
                + "</b> frequent renter points";
        return result;
    }
    
}
