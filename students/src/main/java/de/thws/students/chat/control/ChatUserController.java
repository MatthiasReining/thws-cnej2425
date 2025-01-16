package de.thws.students.chat.control;

import de.thws.students.logdata.entity.LogData;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.ObservesAsync;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ChatUserController {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void newChatUser(@ObservesAsync @NewChatUser String username) {
        System.out.println("CHATUserController -> Chat User " + username + " joined");

        LogData logData = new LogData();
        logData.message = "Chat User " + username + " joined";
        em.persist(logData);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("ChatUserController -> Chat User " + username + "  done");
    }
}
