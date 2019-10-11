package br.com.fiap.am.repository;

import br.com.fiap.am.model.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SugestaoRepository extends JpaRepository<Sugestao,Integer> {
}
