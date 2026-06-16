package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.CustomerDto;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> getAllCustomers();

   List <CustomerDto> updateCustomer( CustomerDto customerDto);

   List <CustomerDto>  deleteCustomer(Long customerId);
}