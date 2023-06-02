package tw.niq.example.repository.scm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.niq.example.entity.scm.ActionLog;

@Repository
public interface ActionLogRepository extends JpaRepository<ActionLog, Long> {

}
