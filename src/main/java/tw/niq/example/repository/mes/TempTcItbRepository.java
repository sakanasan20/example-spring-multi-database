package tw.niq.example.repository.mes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tw.niq.example.entity.mes.TempTcItb;

@Repository
public interface TempTcItbRepository extends JpaRepository<TempTcItb, String> {

}
