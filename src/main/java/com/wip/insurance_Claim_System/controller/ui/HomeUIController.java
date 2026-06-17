package com.wip.insurance_Claim_System.controller.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wip.insurance_Claim_System.service.ClaimService;
import com.wip.insurance_Claim_System.service.CustomerService;
import com.wip.insurance_Claim_System.service.PolicyService;

@Controller
	@RequestMapping("/ui")
	public class HomeUIController {

	    @Autowired
	    private CustomerService customerService;

	    @Autowired
	    private PolicyService policyService;

	    @Autowired
	    private ClaimService claimService;

	    @GetMapping("/home")
	    public String home(Model model) {

	        model.addAttribute("customerCount", customerService.getAllCustomers().size());
	        model.addAttribute("policyCount", policyService.getAllPolicies().size());
	        model.addAttribute("claimCount", claimService.getAllClaims().size());

	        return "index";
	    }
	}


