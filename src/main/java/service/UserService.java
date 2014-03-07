package service;

import data.FileRepository;
import data.UserRepository;
import model.Document;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 07/03/14
 * Time: 09:20
 * To change this template use File | Settings | File Templates.
 */

@Path("/userService")
public class UserService {

    static UserRepository ur = new UserRepository();
    static FileRepository fr = new FileRepository();

    @POST
    @Path("/registerUser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registerNewUser(User user) {
        ur.RegisterNewUser(user);
        System.out.println("user has been registered");
    }

    /*
    generate the hashcode of document which has been uploaded.
     */
    public String generateHashCode(Document doc) {
        return doc.toString();
    }

    public boolean examineHashcode(Document doc, String hashcode) {
        return generateHashCode(doc).equals(hashcode);
    }

    public boolean examineSignature() {
        return true;
    }

    public User getUserInfo(User user) {
        return ur.findUserByEmail(user.getUserEmailAddress());
    }

    @POST
    @Path("/authenticateUser")
    @Consumes("application/json")
    public Response authenticateUser(User user, File file, String Hashcode) {
        String resultStr = null;

            if (getUserInfo(user) == null) {
               resultStr += "user does not exist ";
                registerNewUser(user);
                resultStr += "user has been registered";
            }

        return Response.status(201).entity(resultStr).build();
    }

    public Response authenticateFile(Document doc){
        String resultStr = null;

        if (examineHashcode(doc, doc.getDocumentHashCode()) == false) {
            resultStr += "hashcode does not match ";
        }

        return Response.status(201).entity(resultStr).build();
    }

    @POST
    @Path("/getDocumentInfo")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response getDocumentInfo(Document doc) {
        Document document = fr.getFileInfo(doc.getReceiverName(), doc.getFileName());
        if(document == null){
            return  Response.status(201).entity("null").build();
        }
         else{
            return Response.status(201).entity(document.toString()).build();
        }

    }


    public String generateSignature(User user){
        return user.toString();
    }


    @POST
    @Path("/generateSignature")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response provideSignature(User user) {
         String returnStr = null;
        if (ur.findUserByEmail(user.getUserEmailAddress()) == null) {
              returnStr =  generateSignature(user);
        }

       return   Response.status(201).entity(returnStr).build();

    }


}
