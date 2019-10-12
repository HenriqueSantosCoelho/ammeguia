package br.com.fiap.am.resource;


import br.com.fiap.am.model.Pedido;
import br.com.fiap.am.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @CrossOrigin
    @GetMapping("total")
    public Double total(){
        return rep.sumTotal();
    }
    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido cadastrar(@RequestBody Pedido pedido){
        LocalDate a = LocalDate.now();
        pedido.setTotal((pedido.getQuantidade()*pedido.getProduto().getValor())+pedido.getFrete());
        pedido.setData(a);
        return rep.save(pedido);
    }
}
