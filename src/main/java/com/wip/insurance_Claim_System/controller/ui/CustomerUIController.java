package com.wip.insurance_Claim_System.controller.ui;

import com.wip.insurance_Claim_System.dto.CustomerCreateDto;
import com.wip.insurance_Claim_System.dto.CustomerDto;
import com.wip.insurance_Claim_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/customer")
public class CustomerUIController {

    @Autowired
    private CustomerService customerService;

    // LIST CUSTOMERS
    @GetMapping("/list")
    public String listCustomers(Model model) {

        List<CustomerDto> customers = customerService.getAllCustomers();

        model.addAttribute("customers", customers);

        return "customer-list";
    }

    // SHOW ADD FORM
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("customer", new CustomerCreateDto());

        return "customer-form";
    }

    // SAVE CUSTOMER
    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute CustomerCreateDto customerCreateDto) {

        customerService.saveCustomer(customerCreateDto);

        return "redirect:/ui/customer/list";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editCustomer(@PathVariable Long id, Model model) {

        CustomerDto customer = customerService.getCustomerById(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    // DELETE CUSTOMER
    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable Long id) {

        customerService.deleteCustomer(id);

        return "redirect:/ui/customer/list";
    }
}