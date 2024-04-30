package com.riwi.vacants.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.vacants.service.interfaces.iCompanyService;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(path = "/company")
@AllArgsConstructor
public class CompanyController {
    @Autowired
    private final iCompanyService companyService;

    @GetMapping
    public ResponseEntity<Page<CompanyResponse>>getall(      
         @RequestParam(defaultValue = "1") int Page,
            @RequestParam(defaultValue = "3") int size) {
        return ResponseEntity.ok(this.companyService.getAll(Page - 1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CompanyResponse>get(
            @PathVariable String id) {
        return ResponseEntity.ok(this.companyService.getById(id));
         }
    

    @PostMapping
    public ResponseEntity<CompanyResponse>insert(
            @RequestBody CompanyRequest company){
                return ResponseEntity.ok(this.companyService.create(company));
        }

}