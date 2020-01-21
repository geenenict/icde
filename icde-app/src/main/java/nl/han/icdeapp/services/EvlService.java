package nl.han.icdeapp.services;
import java.util.List;
import java.util.Optional;

import nl.han.icdeapp.models.*;

public interface EvlService {

	public List<Evl> findAll();
	public Optional<Evl> findById(long Id);
	public Evl add(Evl evl);
	public void update(Evl evl);
	public void delete(long Id);
	
}
