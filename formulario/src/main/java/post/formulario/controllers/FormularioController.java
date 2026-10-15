package post.formulario.controllers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import post.formulario.Formulario;
import post.formulario.Login;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormularioController {
    Map<String , String> lista = new HashMap<>();

    @GetMapping("/registro")
    public String mostrarFormulario(){
        return "formulario";
    }

    @GetMapping("/login")
    public String mostrarLogin(){ return "login";}


    @PostMapping("/procesar")
    @ResponseBody
    public String procesarFormulario(@ModelAttribute Formulario formulario) {
        boolean passwdEmpty = false;
        if (formulario.getApellidos().isEmpty()){
            formulario.setApellidos("");
        }

        if (formulario.getContraseña().isEmpty()){
            int intPassword = (int) (Math.random() * 1000000);
            String newPassword = String.format("%06d", intPassword);
            formulario.setContraseña(newPassword);
            passwdEmpty = true;
        }

        // Asegurarse de que nombre o email no esten vacíos
        if (formulario.getNombre().isEmpty() || formulario.getEmail().isEmpty()){
            return "Correo o email no validos";
        }

        // Agregar al map tanto el nombre como el email con el valor de contraseña
        lista.put(formulario.getNombre(), formulario.getContraseña());
        lista.put(formulario.getEmail(), formulario.getContraseña());

        String mensaje = "Formulario recibido. Nombre: " + formulario.getNombre()
                + ", email: " + formulario.getEmail();

        if (passwdEmpty){
            mensaje += " Contraseña generada automaticamente: " + formulario.getContraseña();
        }

        return mensaje;
    }

    @PostMapping("/login")
    @ResponseBody
    public String procesarLogin(@ModelAttribute Login login){
        if (!lista.containsKey(login.getNombre())){
            return "Usuario Inexistente";
        }
        if (!lista.get(login.getNombre()).equals(login.getContraseña())){
            return "Contraseña Incorrecta";
        }

        return "Usuario Existente y Contraseña Correcta";
    }

}
