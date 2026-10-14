package post.formulario.controllers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import post.formulario.Formulario;

@Controller
public class FormularioController {
    @GetMapping("/formulario")
    public String mostrarFormulario(){
        return "formulario";
    }

    @PostMapping("/procesar")
    @ResponseBody
    public String procesarFormulario(@ModelAttribute Formulario formulario) {
        if (formulario.getApellidos().isEmpty()){
            formulario.setApellidos("");
        }

        if (formulario.getContraseña().isEmpty()){
            int intPassword = (int) (Math.random() * 1000000);
            String newPassword = String.format("%06d", intPassword);
            formulario.setContraseña(newPassword);

        }


        return "Formulario recibido. Nombre: " + formulario.getNombre()
                + ", contraseña: " + formulario.getContraseña();
    }

}
