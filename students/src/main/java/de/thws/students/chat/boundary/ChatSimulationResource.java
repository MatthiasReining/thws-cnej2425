package de.thws.students.chat.boundary;

import de.thws.students.chat.control.NewChatUser;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("chat-simulation")
public class ChatSimulationResource {

    @Inject
    @NewChatUser
    Event<String> event;

    @GET
    @Path("{username}")
    public String simulateChat(@PathParam("username") String username) {
        System.out.println("simulateChat started " + username);

        event.fireAsync(username);
        return "Chat simulation started";
    }
}
