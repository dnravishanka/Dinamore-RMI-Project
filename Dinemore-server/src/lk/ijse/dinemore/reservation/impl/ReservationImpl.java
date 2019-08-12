/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.reservation.impl;

import java.util.HashMap;
import java.util.Map;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author Nadun
 */
public class ReservationImpl<T extends SuperService>{
    private Map<Object,T> resBook=new HashMap<>();
    
    public boolean reserve(Object key,T service){
        if (resBook.containsKey(key)) {
            if (resBook.get(key) == service) {
                return true;
            } else {
                return false;
            }
        } else {
            resBook.put(key, service);
            return true;
        }
    }
    
    public boolean relese(Object key){
        if (resBook.containsKey(key)) {
            resBook.remove(key);
            return true;
        } else {
            return false;
        }
    }
}
