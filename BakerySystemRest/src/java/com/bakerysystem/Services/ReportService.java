/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bakerysystem.Services;

import java.util.ArrayList;

/**
 *
 * @author Andrew
 */
public interface ReportService {
    

    public ArrayList<String> getPlaced();
    public ArrayList<String> getOutStanding();
    public ArrayList<String> getDelivered();
    
    
}
