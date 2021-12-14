package com.minticCicloIV.registerMicroservice.controller;

import com.minticCicloIV.registerMicroservice.exception.NoEmailException;
import com.minticCicloIV.registerMicroservice.exception.NotFoundCustomerException;
import com.minticCicloIV.registerMicroservice.exception.NotValidValueException;

import com.minticCicloIV.registerMicroservice.model.Customer;
import com.minticCicloIV.registerMicroservice.repository.CustomerRepository;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/custom/{username}/")//trae todas las solicitudes de una empresa (username)
    List<Customer> getCustomerS(@PathVariable String username){

        List<Customer> customers = customerRepository.findByUsername(username);
        if (customers.size() <= 0){
            throw new NotFoundCustomerException("no se encontraron solicitudes para: "+ username);
        }
        return customers;
    }

    @GetMapping("/custom/{username}/{correo}/")//trae las solicitudes correspondientes a un mismo correo
    Customer getCustomer(@PathVariable String correo,@PathVariable String username){
        List<Customer> customers =customerRepository.findByCorreo(correo);
        System.out.println(customers.size());
        Customer customersEmail=null;
        if(customers.size() <= 0){
            throw new NotFoundCustomerException("no se encontró ninguna peticion asociada al correo " + correo);
        }
        for (Customer customerr : customers){
            if(customerr.getUsername().equals(username)){
                customersEmail = customerr;
            }
        }
        if(customersEmail==null){
            throw new NotFoundCustomerException("no se encontró ninguna peticion asociada al correo" + correo);
        }

        return  customersEmail;
    }

    @PostMapping("/custom/create/")
    Customer saveNewCustomer(@RequestBody Customer customer) {
        Integer reCount = 0;

        if (customer.isCasapropia()){reCount+=10;}else reCount += 5;
        if (customer.isHomejob()){reCount+=20;}else reCount += 10;
        if (customer.isCuidador()) reCount += 15;
        if (customer.getSalario()<1.5) reCount += 5;
        if (customer.getSalario()>1.5 && customer.getSalario()<3) reCount += 15;
        if (customer.getSalario()>=3 ) reCount += 20;
        if (customer.getNumMascotas()==1){reCount += 10;}
        if (customer.getNumMascotas()>=1){reCount += 15;}

        if (reCount<=50) customer.setRecomendado(false); else customer.setRecomendado(true);


        if(!(customer.getCorreo().contains("@"))){
            throw new NoEmailException("email no válido");
        }
        if(customer.getSalario()<0){
            throw new NotValidValueException("valor no válido");
        }
        if(customer.getNumMascotas()<0){
            throw new NotValidValueException("número de mascotas no válido");
        }



        Customer customers =customerRepository.findById(customer.getId_()).orElse(null);
        if(!(customers == null)){
            throw new NotFoundCustomerException("ya tiene una solicitud existente");//agregar excepción
        }
        return customerRepository.save(customer);
    }

    @DeleteMapping("/custom/delete/{username}/{correo}/")//corregir  delete validando correo y username
     String deleteCustomer(@PathVariable String correo, @PathVariable String username){
        Customer customer = customerRepository.findById((username+correo)).orElse(null);
        if(customer==null){
            throw new NotFoundCustomerException("No existe este formulario");
        }
        customerRepository.deleteById(username+correo);

         return "Borrado exitoso";
    }
    @GetMapping("/")
    String messageRoot(){
        return "Bienvenido";
    }
}
