package project.fbatuq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.fbatuq.model.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
