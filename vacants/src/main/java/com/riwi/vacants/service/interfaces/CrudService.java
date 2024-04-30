package com.riwi.vacants.service.interfaces;

import org.springframework.data.domain.Page;


public interface CrudService <RQ,RS,ID> {
    Page<RS> getAll(int Page, int size);
    
    RS create(RQ request);

    RS update(ID id, RQ request);

    void delete(ID id);

    RS getById(ID id);
}
