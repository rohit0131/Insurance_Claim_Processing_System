package com.wip.insurance_Claim_System.controller.ui;

import com.wip.insurance_Claim_System.dto.ClaimStatusDto;
import com.wip.insurance_Claim_System.service.ClaimStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/status")
public class ClaimStatusUIController {

    @Autowired
    private ClaimStatusService claimStatusService;

    // LIST STATUS
    @GetMapping("/list")
    public String listStatus(Model model) {

        List<ClaimStatusDto> list = claimStatusService.getAllClaimStatus();

        model.addAttribute("statuses", list);

        return "status-list";
    }

    // SHOW CREATE FORM
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("status", new ClaimStatusDto());

        return "status-form";
    }

    // SAVE STATUS
    @PostMapping("/save")
    public String saveStatus(@ModelAttribute ClaimStatusDto dto) {

        claimStatusService.saveClaimStatus(dto);

        return "redirect:/ui/status/list";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editStatus(@PathVariable Long id, Model model) {

        ClaimStatusDto dto = claimStatusService.getClaimStatusById(id);

        model.addAttribute("status", dto);

        return "status-form";
    }

    // DELETE STATUS
    @GetMapping("/delete/{id}")
    public String deleteStatus(@PathVariable Long id) {

        claimStatusService.deleteClaimStatus(id);

        return "redirect:/ui/status/list";
    }
}