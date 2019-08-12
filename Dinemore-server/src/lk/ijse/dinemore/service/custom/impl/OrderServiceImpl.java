/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom.impl;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.service.custom.OrderService;
import lk.ijse.dinemore.buisness.BOFactory;
import lk.ijse.dinemore.buisness.custom.OrderBO;

import lk.ijse.dinemore.observer.Observer;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.reservation.impl.ReservationImpl;


/**
 *
 * @author Nadun
 */
public class OrderServiceImpl extends UnicastRemoteObject implements OrderService,Subject {
 private OrderBO customerBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();
    private static ReservationImpl<OrderService> cusResBook = new ReservationImpl<>();

    public OrderServiceImpl() throws Exception{
        customerBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);
    }
    
    @Override
    public boolean addOrder(OrderDTO customerDTO) throws Exception {
        boolean addCustomer = customerBO.addOrder(customerDTO);
        notifyObservers();
        return addCustomer;
    }

//    @Override
//    public boolean deleteOrder(String cid) throws Exception {
//        boolean deleteCustomer = customerBO.deleteOrder(cid);
//        notifyObservers();
//        return deleteCustomer;
//    }

    @Override
    public boolean updateOrder(OrderDTO customerDTO) throws Exception {
        boolean updateCustomer = customerBO.updateOrder(customerDTO);
        notifyObservers();
        return updateCustomer;
    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        return customerBO.getAllOrders();
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(()->{
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        return cusResBook.reserve(id, this);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return cusResBook.relese(id);
    }

//    @Override
//    public CustomerDTO searchCustomer(String cid) throws Exception {
//        return customerBO.searchCustomer(cid);
//    }
    
}
