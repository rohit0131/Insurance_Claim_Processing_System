package com.wip.insurance_Claim_System.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wip.insurance_Claim_System.dto.AdminDto;
import com.wip.insurance_Claim_System.entity.Admin;
import com.wip.insurance_Claim_System.exception.ResourceNotFoundException;
import com.wip.insurance_Claim_System.repository.AdminRepository;
import com.wip.insurance_Claim_System.util.AdminConverter;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // CREATE ADMIN
    @Override
    public void saveAdmin(AdminDto adminDto) {

        Admin admin = AdminConverter.toEntity(adminDto);
        adminRepository.save(admin);

        System.out.println("Admin Created...");
    }

    // GET ALL ADMINS
    @Override
    public List<AdminDto> getAllAdmins() {

        List<Admin> admins = adminRepository.findAll();

        return admins.stream()
                .map(AdminConverter::toDto)
                .collect(Collectors.toList());
    }

    // GET ADMIN BY ID
    @Override
    public AdminDto getAdminById(Long id) {

        Admin admin = adminRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Admin", "adminId", id));

        return AdminConverter.toDto(admin);
    }

    // UPDATE ADMIN
    @Override
    public List<AdminDto> updateAdmin(AdminDto adminDto) {

        Admin admin = adminRepository.findById(adminDto.getAdminId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Admin", "adminId", adminDto.getAdminId()));

        admin.setAdminName(adminDto.getAdminName());
        admin.setEmail(adminDto.getEmail());
        admin.setRole(adminDto.getRole());

        adminRepository.save(admin);

        return getAllAdmins();
    }

    // DELETE ADMIN
    @Override
    public List<AdminDto> deleteAdmin(Long id) {

        adminRepository.deleteById(id);

        return getAllAdmins();
    }
}