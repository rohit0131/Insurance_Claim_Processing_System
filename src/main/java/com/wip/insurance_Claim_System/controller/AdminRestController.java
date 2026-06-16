package com.wip.insurance_Claim_System.controller;

import com.wip.insurance_Claim_System.dto.AdminCreateDto;
import com.wip.insurance_Claim_System.dto.AdminDto;
import com.wip.insurance_Claim_System.dto.AdminLoginDto;
import com.wip.insurance_Claim_System.service.AdminService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public ResponseEntity<AdminDto> login(
            @RequestBody AdminLoginDto loginDto) {

        return ResponseEntity.ok(adminService.login(loginDto));
    }
    // ADD ADMIN
    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAdmin(@Valid @RequestBody AdminCreateDto adminCreateDto) {

        adminService.saveAdmin(adminCreateDto);

        return new ResponseEntity<>(
                "Admin " + adminCreateDto.getAdminName() + " created successfully",
                HttpStatus.OK
        );
    }

    // LIST ALL ADMINS
    @GetMapping("/listAllAdmin")
    public ResponseEntity<List<AdminDto>> listAllAdmins() {

        List<AdminDto> adminList = adminService.getAllAdmins();

        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    // GET ADMIN BY ID
    @GetMapping("/getAdmin/{id}")
    public ResponseEntity<AdminDto> getAdmin(@PathVariable Long id) {

        AdminDto admin = adminService.getAdminById(id);

        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    // UPDATE ADMIN
    @PutMapping("/updateAdmin")
    public ResponseEntity<List<AdminDto>> updateAdmin(
            @Valid @RequestBody AdminDto adminDto) {

        List<AdminDto> adminList = adminService.updateAdmin(adminDto);

        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }

    // DELETE ADMIN
    @DeleteMapping("/deleteAdmin/{id}")
    public ResponseEntity<List<AdminDto>> deleteAdmin(@PathVariable Long id) {

        List<AdminDto> adminList = adminService.deleteAdmin(id);

        return new ResponseEntity<>(adminList, HttpStatus.OK);
    }
}