package com.wip.insurance_Claim_System.util;

import com.wip.insurance_Claim_System.dto.CustomerDto;
import com.wip.insurance_Claim_System.entity.Customer;


public class CustomerConverter {

    public static CustomerDto toDto(Customer customer) {

        CustomerDto dto = new CustomerDto();
        dto.setCustomerId(customer.getCustomerId());
        dto.setName(customer.getName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setAddress(customer.getAddress());

        return dto;
    }

    public static Customer toEntity(CustomerDto dto) {

        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setEmail(dto.getEmail());
        customer.setPhone(dto.getPhone());
        customer.setAddress(dto.getAddress());

        return customer;
    }
}