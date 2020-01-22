package nl.han.icdeapp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

public interface BaseRestControllerInterface<T> {

	public List<T> findAll();
	public Optional<T> findById(long Id);
	public Object add(T t);
	public ResponseEntity<Object> update(T t, long id);
	public void delete(long id);
	
}