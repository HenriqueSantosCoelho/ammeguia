package br.com.fiap.am.resource;

import br.com.fiap.am.model.Problema;
import br.com.fiap.am.model.TipoProblema;
import br.com.fiap.am.repository.ProblemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "problema",method = RequestMethod.OPTIONS)
public class ProblemaResource {
    @Autowired
    private ProblemaRepository rep;

    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Problema cadastrar(@RequestBody Problema problema){
        LocalDate a = LocalDate.now();
        problema.setData(a);
        return rep.save(problema);
    }

    @CrossOrigin
    @GetMapping("listar")
    public List<Problema> listar(){
        return rep.findAll();
    }

    @CrossOrigin
    @GetMapping("buscarPorTipo")
    public List<Problema> buscarPorTipo(TipoProblema tipo){
        return rep.findAllByTipo(tipo);
    }
}
