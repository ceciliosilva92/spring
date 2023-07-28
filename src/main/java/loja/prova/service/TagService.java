package loja.prova.service;

import java.util.List;

import loja.prova.model.Tag;

public interface TagService {

	List<Tag> findAll();
	Tag findById(Long Id);
	Tag save(Tag tag);
}
