package de.thws.students.chat.control;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class ChatStudentLinkController {

    public void isChatUserAlsoAStudent(@Observes @NewChatUser String username) {
        System.out.println("isChatUserAlsoAStudent -> ??? " + username);

    }
}
