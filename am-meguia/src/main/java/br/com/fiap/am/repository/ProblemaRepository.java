package br.com.fiap.am.repository;

import br.com.fiap.am.model.Problema;
import br.com.fiap.am.model.TipoProblema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemaRepository extends JpaRepository<Problema,Integer> {

    List<Problema> findAllByTipo(TipoProblema tipo);
}
