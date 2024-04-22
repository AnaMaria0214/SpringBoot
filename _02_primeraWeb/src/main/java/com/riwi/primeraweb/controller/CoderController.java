package com.riwi.primeraweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.riwi.primeraweb.entity.Coder;
import com.riwi.primeraweb.services.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {
    @Autowired
    private CoderService objCoderService;

    /**
     * Metodo para motrar la vista y enviarle la lista coders
     */
    @GetMapping
    public String showViewGetAll(Model objModel, @RequestParam(defaultValue = "1")
    int page, @RequestParam (defaultValue = "2") int size) {
        // LLamo el servicio y guardo la lista de coders
        Page<Coder> list = this.objCoderService.findAllPaginate(page-1,size);
        objModel.addAttribute("coderList", list); // Llave- valor
        objModel.addAttribute("currentPage", page); // Llave- valor
        objModel.addAttribute("totalPage", list.getTotalPages()); // Llave- valor
        // Se debe retornar el nombre exacto de la vista html
        return "viewCoder";

    }

    @GetMapping("/form")
    public String showViewForm(Model model){
        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/create-coder");
        return "viewForm";
    }

       /**
     * Método para recibir todos la información del formulario
     * 
     * @ModelAttribute lo utilizamos para recibir información de la vista
     */
    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute Coder objCoder) {
        this.objCoderService.create(objCoder);
        return "redirect:/";
    }

    // crear un controlador para eliminar recibira como parametro el id por URL
    @GetMapping("/delete/{id}")
    // pathVariable funciona para obtener el valor de una variable en la URL 
    // solo si esde tipo path (ejemplo: /delete/10 ) donde 10 es u numero dinamico
    public String deleteCoder(@PathVariable Long id){
        this.objCoderService.delete(id);
        // redireccionar a la lista de coders
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String updateCoder(@PathVariable Long id,Model model){
        Coder objCoder = this.objCoderService.findById(id);
        model.addAttribute("coder",objCoder);
        model.addAttribute("action","/edit/"+id);
        return "viewForm";
    }
    @PostMapping("/edit/{id}")
    public String updateCoder (@PathVariable Long id, @ModelAttribute Coder objCoder){
        this.objCoderService.update(id,objCoder);
        return "redirect:/";
    }
}
