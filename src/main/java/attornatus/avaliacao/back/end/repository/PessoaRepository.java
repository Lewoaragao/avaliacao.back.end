package attornatus.avaliacao.back.end.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import attornatus.avaliacao.back.end.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
}
