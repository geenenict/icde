package nl.han.icdeapp.services;

import nl.han.icdeapp.models.*;
import nl.han.icdeapp.repositories.*;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemesterService implements ServiceInterface<Semester> {

	@Autowired
	private SemesterRepository SemesterRepository;
	
	
	@Override
	public List<Semester> findAll() {
		return (List<Semester>) SemesterRepository.findAll();
	}
	
	@Override
	public Optional<Semester> findById(long Id) {
		return SemesterRepository.findById(Id);
	}

	@Override
	public Semester add(Semester semester) {
		return SemesterRepository.save(semester);
	}
	
	@Override
	public void update(Semester semester) {
		SemesterRepository.save(semester);
	}
	
	@Override
	public void delete(long Id) {
		SemesterRepository.deleteById(Id);
	}

}
