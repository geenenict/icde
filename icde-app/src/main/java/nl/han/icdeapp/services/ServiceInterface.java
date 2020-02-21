package nl.han.icdeapp.services;
import java.util.List;
import java.util.Optional;

public interface ServiceInterface<T> {

	public List<T> findAll();
	public Optional<T> findById(long Id);
	public T add(T t);
	public void update(T t);
	public void delete(long id);
	
}
