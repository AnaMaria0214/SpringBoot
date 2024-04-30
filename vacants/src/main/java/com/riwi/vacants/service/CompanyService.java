package com.riwi.vacants.service;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.vacants.repositories.CompanyRepositoy;
import com.riwi.vacants.service.interfaces.iCompanyService;
import com.riwi.vacants.Entities.Company;
import com.riwi.vacants.Entities.Vacant;
import com.riwi.vacants.utils.dto.request.CompanyRequest;
import com.riwi.vacants.utils.dto.response.CompanyResponse;
import com.riwi.vacants.utils.dto.response.VacantToCompanyResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CompanyService implements iCompanyService{


    @Autowired
    private final CompanyRepositoy companyRepositoy;
    @Override
    public Page<CompanyResponse> getAll(int Page, int size) {
        if(Page<0)
        Page=0;
        PageRequest pagination = PageRequest.of(Page ,size);
        return this.companyRepositoy.findAll(pagination).map(Company -> this.entityToResponse(Company));
    }

    @Override
    public CompanyResponse create(CompanyRequest request) {
        Company company = this.requestToEntity(request, new Company());
        return this.entityToResponse(this.companyRepositoy.save(company));
    }

    @Override
    public CompanyResponse update(String id, CompanyRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CompanyResponse getById(String id) {
        Company company = this.find(id);
        return this.entityToResponse(company);
   
    }
    
    private CompanyResponse entityToResponse(Company entity) {
        CompanyResponse response = new CompanyResponse();
        /*BeanUtils no permite hacer una copia de una clase a otra 
         * en este caso toda la entiedad de tipo company sera copiada con toda la informacion
         * requerida pro la variable tipo companyResponse
         */
        BeanUtils.copyProperties(entity, response);

        response.setVacants(entity.getVacants().stream().map(this::vacantToResponse).collect(Collectors.toList()));
        return response;
    }
     
    private VacantToCompanyResponse vacantToResponse(Vacant entity) {
        VacantToCompanyResponse response = new VacantToCompanyResponse();

        BeanUtils.copyProperties(entity, response);

        return response;
    }

    private Company requestToEntity(CompanyRequest entity, Company company) {
        company.setContact(entity.getContact());
        company.setLocation(entity.getLocation());
        company.setName(entity.getName());
        company.setVacants(new ArrayList<>());
        return company;
    }

    private Company find(String id) {
        return this.companyRepositoy.findById(id).orElseThrow();
    }

}
