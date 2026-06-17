package com.wip.insurance_Claim_System.controller.ui;

import com.wip.insurance_Claim_System.dto.ApprovalDto;
import com.wip.insurance_Claim_System.service.ApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/approval")
public class ApprovalUIController {

    @Autowired
    private ApprovalService approvalService;

    // LIST APPROVALS
    @GetMapping("/list")
    public String listApprovals(Model model) {

        List<ApprovalDto> approvals = approvalService.getAllApprovals();

        model.addAttribute("approvals", approvals);

        return "approval-list";
    }

    // SHOW CREATE FORM
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("approval", new ApprovalDto());

        return "approval-form";
    }

    // SAVE APPROVAL (APPROVE CLAIM)
    @PostMapping("/save")
    public String saveApproval(@ModelAttribute ApprovalDto approvalDto) {

        approvalService.saveApproval(approvalDto);

        return "redirect:/ui/approval/list";
    }

    // EDIT FORM
    @GetMapping("/edit/{id}")
    public String editApproval(@PathVariable Long id, Model model) {

        ApprovalDto dto = approvalService.getApprovalById(id);

        model.addAttribute("approval", dto);

        return "approval-form";
    }
}