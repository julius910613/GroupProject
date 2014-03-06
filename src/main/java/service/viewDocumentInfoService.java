package service;

import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 06/03/14
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */

@Path("/json/metallica")
public class viewDocumentInfoService {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserInJSON() {

        User u1 = new User();
        u1.setUserEmailAddress("abc");
        u1.setUserName("aa");
        return u1;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUserInJSON(User user) {

        String result = "User saved : " + user;
        return Response.status(201).entity(result).build();

    }
}
