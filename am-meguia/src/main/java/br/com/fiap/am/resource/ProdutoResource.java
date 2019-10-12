package br.com.fiap.am.resource;

import br.com.fiap.am.model.Produto;
import br.com.fiap.am.repository.ProblemaRepository;
import br.com.fiap.am.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="produto",method = RequestMethod.OPTIONS)
public class ProdutoResource {
    @Autowired
    private ProdutoRepository rep;

    @CrossOrigin
    @GetMapping("listar")
    public List<Produto> listar(){
        return rep.findAll();
    }

    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Produto cadastrar(@RequestBody Produto produto){
        return rep.save(produto);
    }
}
