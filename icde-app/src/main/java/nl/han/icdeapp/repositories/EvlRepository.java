package nl.han.icdeapp.repositories;
import nl.han.icdeapp.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring

@Repository
public interface EvlRepository extends JpaRepository<Evl, Long> {

}