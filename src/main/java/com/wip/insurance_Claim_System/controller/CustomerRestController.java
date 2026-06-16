package com.wip.insurance_Claim_System.controller;

import com.wip.insurance_Claim_System.dto.CustomerDto;
import com.wip.insurance_Claim_System.service.CustomerService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;


    // ADD CUSTOMER
    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDto customerDto) {

        customerService.saveCustomer(customerDto);

        return new ResponseEntity<>(
                "Customer " + customerDto.getName() + " created successfully",
                HttpStatus.OK
        );
    }

    // LIST ALL CUSTOMERS
    @GetMapping("/listAllCustomer")
    public ResponseEntity<List<CustomerDto>> listAllCustomers() {

        List<CustomerDto> customerList = customerService.getAllCustomers();

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    // GET CUSTOMER BY ID
    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {

        CustomerDto customer = customerService.getCustomerById(id);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    // UPDATE CUSTOMER
    @PutMapping("/updateCustomer")
    public ResponseEntity<List<CustomerDto>> updateCustomer(
            @Valid @RequestBody CustomerDto customerDto) {

        List<CustomerDto> customerList = customerService.updateCustomer(customerDto);

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    // DELETE CUSTOMER
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<List<CustomerDto>> deleteCustomer(@PathVariable Long id) {

        List<CustomerDto> customerList = customerService.deleteCustomer(id);

        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

//    // SEARCH CUSTOMER BY EMAIL
//    @GetMapping("/getCustomerByEmail/{email}")
//    public ResponseEntity<CustomerDto> searchByEmail(@PathVariable String email) {
//
//        CustomerDto customer = customerService.searchByEmail(email);
//
//        return new ResponseEntity<>(customer, HttpStatus.OK);
//    }
}