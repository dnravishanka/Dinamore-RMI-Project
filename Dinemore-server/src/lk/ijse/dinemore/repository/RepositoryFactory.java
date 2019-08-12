/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinemore.repository;

import lk.ijse.dinemore.repository.custom.impl.OrderRepositoryImpl;

/**
 *
 * @author Nadun
 */
public class RepositoryFactory {
    public enum RepositoryTypes{
        CUSTOMER,ITEM,ORDERS,ORDERDETAILS
    }
    
    public static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }
    
    public static RepositoryFactory getInstance(){
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }
    
    public SuperRepository getRepository(RepositoryTypes repositoryTypes){
        
       switch(repositoryTypes){
           case ORDERS :
               return new OrderRepositoryImpl();
//           case ITEM :
//               return new ItemRepositoryImpl();
           default:
               return null;
       }
    }
}
