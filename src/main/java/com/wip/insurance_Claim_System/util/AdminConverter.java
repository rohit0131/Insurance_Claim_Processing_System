package com.wip.insurance_Claim_System.util;

import com.wip.insurance_Claim_System.dto.AdminDto;
import com.wip.insurance_Claim_System.entity.Admin;

public class AdminConverter {

    public static AdminDto toDto(Admin admin) {

        AdminDto dto = new AdminDto();

        dto.setAdminId(admin.getAdminId());
        dto.setAdminName(admin.getAdminName());
        dto.setEmail(admin.getEmail());
        dto.setRole(admin.getRole());

        return dto;
    }

    public static Admin toEntity(AdminDto dto) {

        Admin admin = new Admin();

        admin.setAdminName(dto.getAdminName());
        admin.setEmail(dto.getEmail());
        admin.setRole(dto.getRole());

        return admin;
    }
}