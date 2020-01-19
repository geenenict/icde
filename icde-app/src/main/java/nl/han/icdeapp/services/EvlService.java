package nl.han.icdeapp.services;

import nl.han.icdeapp.models.*;
import nl.han.icdeapp.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvlService {

	
	// https://medium.com/stackavenue/why-to-use-service-layer-in-spring-mvc-5f4fc52643c0
	// https://medium.com/@gustavo.ponce.ch/spring-boot-jquery-datatables-a2e816e2b5e9
	// https://stackoverflow.com/questions/33004831/spring-mvc-thymeleaf-rest
	// http://forum.thymeleaf.org/Rest-with-Thymeleaf-td4028635.html
	
	@Autowired
	private EvlRepository EvlRepository;
	
	
	public List<Evl> getAll() {
		return (List<Evl>) EvlRepository.findAll();
	}
	
	public Optional<Evl> getOne(Long Id) {
		return EvlRepository.findById(Id);
	}

	public void addNew(Evl evl) {
		EvlRepository.save(evl);
	}
	
	public void update(Evl evl) {
		EvlRepository.save(evl);
	}
	
	public void delete(Long Id) {
		EvlRepository.deleteById(Id);
	}
	
}
