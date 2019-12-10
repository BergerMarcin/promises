package honestit.akwilina.promises.domain.repositories;

import honestit.akwilina.promises.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByName(String name);
}
