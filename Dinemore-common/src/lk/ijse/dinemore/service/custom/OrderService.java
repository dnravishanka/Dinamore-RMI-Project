/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.service.custom;

import java.util.List;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.service.SuperService;

/**
 *
 * @author Nadun
 */
public interface OrderService extends SuperService{
     public boolean addOrder(OrderDTO customerDTO) throws Exception;
    
//    public boolean deleteCustomer(String cid) throws Exception;
    
//    public OrderDTO searchCustomer(String cid) throws Exception;
    
    public boolean updateOrder(OrderDTO customerDTO) throws Exception;
    
    public List<OrderDTO> getAllOrders() throws Exception;
}
