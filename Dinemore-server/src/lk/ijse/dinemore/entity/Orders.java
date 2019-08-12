/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Nadun
 */
@Entity
public class Orders {
    @Id
    private String orderID;
    private String custName;
    private String tp;
    private int Qty;
    private String stat;

    public Orders() {
    }

    public Orders(String orderID, String custName, String tp, int Qty, String stat) {
        this.orderID = orderID;
        this.custName = custName;
        this.tp = tp;
        this.Qty = Qty;
        this.stat = stat;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
    
    
}
