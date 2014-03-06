package data;


import model.User;
import dataset.DocumentData;
import model.Document;
import model.User;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 06/03/14
 * Time: 10:36
 * To change this template use Document | Settings | Document Templates.
 */
public class FileRepository {
   static DocumentData fd = new DocumentData();

    public Document getFileInfo(User user, String filename){


        Document file = fd.getFileInfo(user.getUserEmailAddress()+filename) ;
        return file;
    }

    public void addFileInfo(User user, Document file){

        fd.addFileInfo(user.getUserEmailAddress() + file.getFileName(),file );
    }

}
