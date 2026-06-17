package com.wip.insurance_Claim_System.controller.ui;

import com.wip.insurance_Claim_System.dto.AdminCreateDto;
import com.wip.insurance_Claim_System.dto.AdminDto;
import com.wip.insurance_Claim_System.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ui/admin")
public class AdminUIController {

    @Autowired
    private AdminService adminService;

    // LIST ADMINS
    @GetMapping("/list")
    public String listAdmins(Model model) {

        List<AdminDto> admins = adminService.getAllAdmins();

        model.addAttribute("admins", admins);

        return "admin-list";
    }

    // SHOW CREATE FORM
    @GetMapping("/create")
    public String showCreateForm(Model model) {

        model.addAttribute("admin", new AdminCreateDto());

        return "admin-form";
    }

    // SAVE ADMIN
    @PostMapping("/save")
    public String saveAdmin(@ModelAttribute AdminCreateDto adminCreateDto) {

        adminService.saveAdmin(adminCreateDto);

        return "redirect:/ui/admin/list";
    }

    // EDIT ADMIN
    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model) {

        AdminDto admin = adminService.getAdminById(id);

        model.addAttribute("admin", admin);

        return "admin-form";
    }

    // DELETE ADMIN
    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {

        adminService.deleteAdmin(id);

        return "redirect:/ui/admin/list";
    }
}