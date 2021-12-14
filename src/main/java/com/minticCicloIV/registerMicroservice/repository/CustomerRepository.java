package com.minticCicloIV.registerMicroservice.repository;
import com.minticCicloIV.registerMicroservice.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository  extends MongoRepository<Customer,String>{

    List<Customer> findByUsername(String username);
    List<Customer> findByCorreo(String correo);

}
