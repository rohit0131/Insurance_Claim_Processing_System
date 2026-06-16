package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.CustomerCreateDto;
import com.wip.insurance_Claim_System.dto.CustomerDto;
import com.wip.insurance_Claim_System.dto.CustomerLoginDto;

import java.util.List;

public interface CustomerService {

    void saveCustomer(CustomerCreateDto customerCreateDto);

    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> getAllCustomers();

   List <CustomerDto> updateCustomer( CustomerDto customerDto);

   List <CustomerDto>  deleteCustomer(Long customerId);
   CustomerDto login(CustomerLoginDto customerLoginDto);
}