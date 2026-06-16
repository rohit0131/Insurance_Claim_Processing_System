package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.AdminDto;

import java.util.List;

public interface AdminService {

    void saveAdmin(AdminDto adminDto);

    AdminDto getAdminById(Long adminId);

    List<AdminDto> getAllAdmins();

   List< AdminDto> updateAdmin( AdminDto adminDto);

   List< AdminDto>  deleteAdmin(Long adminId);
}
