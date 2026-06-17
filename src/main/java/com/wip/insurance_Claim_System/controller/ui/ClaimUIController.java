package com.wip.insurance_Claim_System.controller.ui;

import com.wip.insurance_Claim_System.dto.ClaimDto;
import com.wip.insurance_Claim_System.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/claim")
public class ClaimUIController {

    @Autowired
    private ClaimService claimService;

    // SHOW ALL CLAIMS
    @GetMapping("/list")
    public String showClaims(Model model) {

        List<ClaimDto> claims = claimService.getAllClaims();

        model.addAttribute("claims", claims);

        return "claim-list";
    }

    // SHOW CREATE FORM
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("claim", new ClaimDto());

        return "claim-form";
    }

    // SAVE CLAIM
    @PostMapping("/save")
    public String saveClaim(@ModelAttribute ClaimDto claimDto) {

        claimService.saveClaim(claimDto);

        return "redirect:/ui/claim/list";
    }

    // DELETE CLAIM
    @GetMapping("/delete/{id}")
    public String deleteClaim(@PathVariable Long id) {

        claimService.deleteClaim(id);

        return "redirect:/ui/claim/list";
    }
}