package br.com.fiap.am.resource;

import br.com.fiap.am.model.Sugestao;
import br.com.fiap.am.repository.SugestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "sugestao",method = RequestMethod.OPTIONS)
public class SugestaoResource {
    @Autowired
    private SugestaoRepository rep;

    @CrossOrigin
    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Sugestao cadastrar(@RequestBody Sugestao sugestao){
        return rep.save(sugestao);
    }
}
