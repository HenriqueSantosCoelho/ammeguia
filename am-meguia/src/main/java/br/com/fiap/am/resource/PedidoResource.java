package br.com.fiap.am.resource;


import br.com.fiap.am.model.Pedido;
import br.com.fiap.am.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="pedido",method = RequestMethod.OPTIONS)
public class PedidoResource {

    @Autowired
    private PedidoRepository rep;

    @CrossOrigin
    @GetMapping("listar")
    public List<Pedido> listar(){
        return rep.findAll();
    }

    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido cadastrar(@RequestBody Pedido pedido){
        return rep.save(pedido);
    }
}
