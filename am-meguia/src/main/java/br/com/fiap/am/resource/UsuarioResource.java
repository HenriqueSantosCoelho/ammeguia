package br.com.fiap.am.resource;

import br.com.fiap.am.model.Usuario;
import br.com.fiap.am.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestController
@RequestMapping("usuario")
public class UsuarioResource {
    @Autowired
    private UsuarioRepository rep;



    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario cadastrar(@RequestBody Usuario usuario){
        LocalDate a = LocalDate.now();
        usuario.setData(a);
        return rep.save(usuario);
    }


}
