package com.riwi.primeraweb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.repository.CoderRepository;

/*
 * Indica que esta clase será un servicio
 */
@Service
public class CoderService {
    /*
     * Autowired le indica a spring Boot que esto es una inyección de dependencias
     */
    @Autowired
    private CoderRepository objCoderRepository;

    /**
     * Servicio para listar todos los coders
     */
    public List<Coder> findAll(int page, int size) {
        return this.objCoderRepository.findAll();
    }

    public Page<Coder> findAllPaginate(int page , int size){
        if (page<0){
            page=0;
        }
        //crear paginacion
        Pageable objPage=PageRequest.of(page, size);
        return this.objCoderRepository.findAll(objPage);
    }


    public Coder create(Coder objCoder) {
        return this.objCoderRepository.save(objCoder);
    }


    // metodo para eliminar un coder por id (deleteByid)
    public void delete(long id) {
        // llamar al repository
        this.objCoderRepository.deleteById(id);
    }

    //metodo para obtener por id
    public Coder findById(Long id) {
        return this.objCoderRepository.findById(id).orElse(null);
    }
    //metodo para actualizar un coder
    public Coder update(Long id, Coder coder){
        //buscar el coder por id
        Coder objCoderDB = this.findById(id);
        //verificamos que si exista
        if (objCoderDB == null) return null;

        //actualizar el coder viejo
        objCoderDB = coder;
        //el metodo save verifica si el objeto tiene valor en la llave primaria , sobreescribe los valores
        //de lo contrario crea un nuevo coder
        return this.objCoderRepository.save(objCoderDB);
    }
}
