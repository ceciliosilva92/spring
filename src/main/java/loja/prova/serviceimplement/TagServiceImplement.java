package loja.prova.serviceimplement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import loja.prova.model.Tag;
import loja.prova.repository.TagRepository;
import loja.prova.service.TagService;

public class TagServiceImplement implements TagService{

	@Autowired
	TagRepository tagRepository;
	
	public List<Tag> findAll() {
		// TODO Auto-generated method stub
		return tagRepository.findAll();
	}

	
	public Tag findById(Long Id) {
		// TODO Auto-generated method stub
		return tagRepository.findById(Id).get();
	}

	
	public Tag save(Tag tag) {
		// TODO Auto-generated method stub
		return tagRepository.save(tag);
	}

}
