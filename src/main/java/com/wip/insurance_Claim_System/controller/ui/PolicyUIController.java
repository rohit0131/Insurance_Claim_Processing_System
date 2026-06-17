package com.wip.insurance_Claim_System.controller.ui;

import com.wip.insurance_Claim_System.dto.PolicyDto;
import com.wip.insurance_Claim_System.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/policy")
public class PolicyUIController {

    @Autowired
    private PolicyService policyService;

    // SHOW ALL POLICIES
    @GetMapping("/list")
    public String showPolicies(Model model) {

        List<PolicyDto> policies = policyService.getAllPolicies();

        model.addAttribute("policies", policies);

        return "policy-list";
    }

    // SHOW CREATE FORM
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("policy", new PolicyDto());

        return "policy-form";
    }

    // SAVE POLICY FROM FORM
    @PostMapping("/save")
    public String savePolicy(@ModelAttribute PolicyDto policyDto) {

        policyService.savePolicy(policyDto);

        return "redirect:/ui/policy/list";
    }

    // DELETE POLICY
    @GetMapping("/delete/{id}")
    public String deletePolicy(@PathVariable Long id) {

        policyService.deletePolicy(id);

        return "redirect:/ui/policy/list";
    }
}