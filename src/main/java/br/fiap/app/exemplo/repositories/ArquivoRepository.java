package br.fiap.app.exemplo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fiap.app.exemplo.models.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

}
