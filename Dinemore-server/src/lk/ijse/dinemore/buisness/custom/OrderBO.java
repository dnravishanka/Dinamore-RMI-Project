/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.buisness.custom;

import java.util.List;
import lk.ijse.dinemore.buisness.SuperBO;
import lk.ijse.dinemore.dto.OrderDTO;

/**
 *
 * @author Nadun
 */
public interface OrderBO extends SuperBO{

    
     public boolean addOrder(OrderDTO customerDTO) throws  Exception;
    
    public boolean updateOrder(OrderDTO customerDTO) throws  Exception;
    
//    public boolean deleteCustomer(String cid) throws Exception;
    
    public List<OrderDTO> getAllOrders() throws Exception;
    
//    public OrderDTO searchCustomer(String cid) throws Exception;
}
