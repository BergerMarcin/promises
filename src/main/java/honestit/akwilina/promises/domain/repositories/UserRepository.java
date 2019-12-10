package honestit.akwilina.promises.domain.repositories;

import honestit.akwilina.promises.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

}
