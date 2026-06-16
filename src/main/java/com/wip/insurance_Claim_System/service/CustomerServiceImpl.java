package com.wip.insurance_Claim_System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.insurance_Claim_System.dto.CustomerCreateDto;
import com.wip.insurance_Claim_System.dto.CustomerDto;
import com.wip.insurance_Claim_System.dto.CustomerLoginDto;
import com.wip.insurance_Claim_System.entity.Customer;
import com.wip.insurance_Claim_System.exception.ResourceNotFoundException;
import com.wip.insurance_Claim_System.repository.CustomerRepository;
import com.wip.insurance_Claim_System.util.CustomerConverter;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void saveCustomer(CustomerCreateDto customerCreateDto) {
        Customer customer = CustomerConverter.toEntity(customerCreateDto);
        customerRepository.save(customer);
        System.out.println("Customer Created...");
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(CustomerConverter::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "customerId", id));

        return CustomerConverter.toDto(customer);
    }

    @Override
    public List<CustomerDto> updateCustomer(CustomerDto customerDto) {

        Customer customer = customerRepository.findById(customerDto.getCustomerId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Customer", "customerId", customerDto.getCustomerId()));

        // update fields
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPhone(customerDto.getPhone());
        customer.setAddress(customerDto.getAddress());

        customerRepository.save(customer);

        return getAllCustomers();
    }

    @Override
    public List<CustomerDto> deleteCustomer(Long id) {
        customerRepository.deleteById(id);
        return getAllCustomers();
    }

	@Override
	public CustomerDto login(CustomerLoginDto customerLoginDto) {
		   Customer customer = customerRepository.findByEmail(customerLoginDto.getEmail())
		            .orElseThrow(() -> new RuntimeException("Invalid Email"));

		    if (!customer.getPassword().equals(customerLoginDto.getPassword())) {
		        throw new RuntimeException("Invalid Password");
		    }

		    return CustomerConverter.toDto(customer);
		
	}
    
    

//    @Override
//    public CustomerDto searchByEmail(String email) {
//        Customer customer = customerRepository.findByEmail(email)
//                .orElseThrow(() -> new CustomerNotFoundException("Customer", "email", email));
//
//        return CustomerConverter.toDto(customer);
//    }
}