package nl.han.icdeapp.services;

import nl.han.icdeapp.models.*;
import nl.han.icdeapp.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvlService implements ServiceInterface<Evl> {

	@Autowired
	private EvlRepository EvlRepository;
	
	
	@Override
	public List<Evl> findAll() {
		return (List<Evl>) EvlRepository.findAll();
	}
	
	@Override
	public Optional<Evl> findById(long Id) {
		return EvlRepository.findById(Id);
	}

	@Override
	public Evl add(Evl evl) {
		return EvlRepository.save(evl);
	}
	
	@Override
	public void update(Evl evl) {
		EvlRepository.save(evl);
	}
	
	@Override
	public void delete(long Id) {
		EvlRepository.deleteById(Id);
	}

}
