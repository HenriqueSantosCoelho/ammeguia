package br.com.fiap.am.resource;


import br.com.fiap.am.model.Pedido;
import br.com.fiap.am.model.Produto;
import br.com.fiap.am.repository.PedidoRepository;
import br.com.fiap.am.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="pedido",method = RequestMethod.OPTIONS)
public class PedidoResource {

    @Autowired
    private PedidoRepository rep;

    @Autowired
    private ProdutoRepository prod;

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
    @CrossOrigin
    @GetMapping("dataentre")
    public List<Pedido> total(@RequestParam LocalDate start,@RequestParam LocalDate end){
        return rep.findByDataBetween(start,end);
    }
    @CrossOrigin
    @GetMapping("totalentre")
    public double totalEntreDatas(@RequestParam LocalDate start,@RequestParam LocalDate end){
        return rep.sumByDataBetween(start,end);
    }


    @PostMapping("cadastrar")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido cadastrar(@RequestBody Pedido pedido){
        LocalDate a = LocalDate.now();
        Produto p =  prod.findByCodigo(pedido.getProduto().getCodigo());
        pedido.setProduto(p);
        pedido.setTotal((pedido.getQuantidade()*p.getValor())+pedido.getFrete());
        pedido.setData(a);
        return rep.save(pedido);
    }
}
