package nl.han.icdeapp.repositories;
import nl.han.icdeapp.models.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvlRepository extends JpaRepository<Evl, Long> {

}