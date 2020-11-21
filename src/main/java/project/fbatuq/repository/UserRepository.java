package project.fbatuq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fbatuq.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
