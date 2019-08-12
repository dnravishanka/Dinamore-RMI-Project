/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinemore.buisness.custom.OrderBO;
import lk.ijse.dinemore.dto.OrderDTO;
import lk.ijse.dinemore.entity.Orders;
import lk.ijse.dinemore.repository.RepositoryFactory;
import lk.ijse.dinemore.repository.custom.OrderRepository;
import lk.ijse.dinemore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Nadun
 */
public class OrderBOimpl implements OrderBO{

  private OrderRepository customerRepository;

    public OrderBOimpl() {
        customerRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERS);
    }

    @Override
    public boolean addOrder(OrderDTO customerDTO) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSesstion(session);
            session.beginTransaction();
            Orders customer = new Orders(
                customerDTO.getOid(),
                customerDTO.getName(),
                customerDTO.getTele(),
                customerDTO.getQty(),
                    customerDTO.getStatus()
            );
            boolean result = customerRepository.save(customer);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean updateOrder(OrderDTO customerDTO) throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSesstion(session);
            session.beginTransaction();
            Orders customer = new Orders(
                     customerDTO.getOid(),
                customerDTO.getName(),
                customerDTO.getTele(),
                customerDTO.getQty(),
                    customerDTO.getStatus()
            );
            boolean result = customerRepository.update(customer);
            session.getTransaction().commit();
            return result;
        }
    }

//    @Override
//    public boolean deleteCustomer(String cid) throws Exception {
//        try(Session session = HibernateUtil.getSessionFactory().openSession()){
//            customerRepository.setSesstion(session);
//            session.beginTransaction();
//            Orders customer = customerRepository.findByID(cid);
//            boolean result = false;
//            if (customer !=null) {
//                result = customerRepository.delete(customer);
//            }
//            session.getTransaction().commit();
//            return result;
//        }
//    }

    @Override
    public List<OrderDTO> getAllOrders() throws Exception {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            customerRepository.setSesstion(session);
            session.beginTransaction();
            List<Orders> customers = customerRepository.findAll();
            session.getTransaction().commit();
            if (customers != null) {
                System.out.println("Not Null");
                List<OrderDTO> alCustomrs=new ArrayList<>();
                for (Orders custome : customers) {
                    OrderDTO customerDTO = new OrderDTO(
                            custome.getOrderID(),
                            custome.getCustName(),
                            custome.getTp(),
                            custome.getQty(),
                            custome.getStat()
                    );
                    
                    System.out.println("Hello :"+custome.getOrderID());
                    alCustomrs.add(customerDTO);
                }
                return alCustomrs;
            }else{
                return null;
            }
        }
    }

//    @Override
//    public OrderDTO searchCustomer(String cid) throws Exception {
//        Customer customer = customerRepository.findByID(cid);
//        return new OrderDTO(
//        customer.getId(),
//        customer.getName(),
//        customer.getAddress(),
//        customer.getSalary());
////        return null;
//    }

    
}
