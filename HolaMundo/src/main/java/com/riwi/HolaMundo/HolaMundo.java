package com.riwi.HolaMundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*Indica que esta clase es un controlador*/
@Controller
/* Crea la ruta base del controlador */
@RequestMapping("/controller")
public class HolaMundo {

    /*GetMapping crea una ruta especifica para el metodo */
@GetMapping("/holamundo")
/*Response body nos permite responder en el navegador */
@ResponseBody
    public String mostrarMensaje (){
        return "Hola Mundo";
    }

    @GetMapping("/sumadenumeros")
    @ResponseBody
    public String sumaDeNumeros(){
        int num1 = 2;
        int num2 = 2;
        int suma = num1 + num2;
        return String.valueOf(suma);
    }
    
}
