package loja.prova.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import loja.prova.model.Tag;

public interface TagRepository  extends JpaRepository<Tag, Long>{

}
