package com.riwi.vacants.utils.dto.response;

import com.riwi.vacants.utils.enums.statusVacant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacantsResponse {
    private Long id;
    private String name;
    private String description;
    private statusVacant status;
    private CompanyToVacantResponse company;
    
}
