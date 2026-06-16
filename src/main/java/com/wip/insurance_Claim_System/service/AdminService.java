package com.wip.insurance_Claim_System.service;

import com.wip.insurance_Claim_System.dto.AdminCreateDto;
import com.wip.insurance_Claim_System.dto.AdminDto;
import com.wip.insurance_Claim_System.dto.AdminLoginDto;
import com.wip.insurance_Claim_System.util.AdminConverter;

import java.util.List;

public interface AdminService {

    void saveAdmin(AdminCreateDto adminCreateDto);

    AdminDto getAdminById(Long adminId);

    List<AdminDto> getAllAdmins();

   List< AdminDto> updateAdmin( AdminDto adminDto);

   List< AdminDto>  deleteAdmin(Long adminId);
   
   AdminDto login(AdminLoginDto asAdminLoginDto);

}
