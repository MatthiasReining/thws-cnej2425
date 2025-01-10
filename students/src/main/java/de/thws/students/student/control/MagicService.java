package de.thws.students.student.control;

import de.thws.students.logdata.entity.LogData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;

@ApplicationScoped
public class MagicService {

    @PersistenceContext
    EntityManager em;

    public void failedMagic() {

        LogData logData = new LogData("Magic failed");
        throw new RuntimeException("Magic failed");

    }

    @Transactional(value = TxType.REQUIRES_NEW)
    public void magicIsWonderful() {

        LogData logData = new LogData("Magic is Wonderful");
        em.persist(logData);

    }
}
