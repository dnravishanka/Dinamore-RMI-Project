/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.controller;
import java.util.List;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.observer.Subject;
import lk.ijse.dinemore.proxy.ProxyHandler;
import lk.ijse.dinemore.service.ServiceFactory;
import lk.ijse.dinemore.service.custom.OrderService;
import lk.ijse.dinemore.service.custom.OrderService;
/**
 *
 * @author Nadun
 */
public class ManageOrderController {
     public static boolean addOrder(OrderDTO cdto) throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return customerService.addOrder(cdto);
    }
    
//    public static OrderDTO searchCustomer(String cid) throws Exception{
//        OrderService customerService = (OrderService) ProxyHandler.getInstance()
//                .getService(ServiceFactory.ServiceType.ORDERS);
//        return customerService.searchCustomer(cid);
//    }
    
//    public static boolean removeCustomer(String cid) throws Exception{
//        OrderService customerService = (OrderService) ProxyHandler.getInstance()
//                        .getService(ServiceFactory.ServiceType.ORDERS);
//        return customerService.deleteCustomer(cid);
//    }
    
    public static boolean updateCustomer(OrderDTO cdto) throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDERS);
        return customerService.updateOrder(cdto);
    }
    
    public static List<OrderDTO> getAllOrders() throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDERS);
        return customerService.getAllOrders();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
    }
    
    public static boolean reserveCustomer(String customerID) throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return customerService.reserve(customerID);
    }
    
    public static boolean releaseCustomer(String customerID) throws Exception{
        OrderService customerService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return customerService.release(customerID);
    }
}
