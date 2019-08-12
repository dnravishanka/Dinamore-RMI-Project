/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.dto;

/**
 *
 * @author Nadun
 */
public class OrderDTO extends SuperDTO{
    private String oid;
    private String name;
    private String tele;
    private int qty;
    private String status;

    public OrderDTO() {
    }

    public OrderDTO(String oid, String name, String tele, int qty, String status) {
        this.oid = oid;
        this.name = name;
        this.tele = tele;
        this.qty = qty;
        this.status = status;
    }

   

    

    

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
