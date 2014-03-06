package dataset;

import model.Document;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: cmdadmin
 * Date: 06/03/14
 * Time: 09:17
 * To change this template use Document | Settings | Document Templates.
 */
public class DocumentData {
    HashMap<String, Document>fileMap = new  HashMap<String,Document>();

    public DocumentData(){
        Document f1 = new Document();
        f1.setFileName("a");
        f1.setSenderName("1");
        f1.setReceiverName("2");
        fileMap.put(f1.getReceiverName() + f1.getFileName(), f1);
        Document f2 = new Document();
        f2.setFileName("b");
        f2.setSenderName("2");
        f2.setReceiverName("3");
        fileMap.put(f2.getReceiverName() + f2.getFileName(), f1);
        Document f3 = new Document();
        f3.setFileName("b");
        f3.setSenderName("3");
        f3.setReceiverName("1");
        fileMap.put(f3.getReceiverName() + f3.getFileName(), f1);

    }


    public Document getFileInfo(String filename){
        Document file = fileMap.get(filename);
        return file;
    }

    public void addFileInfo(String filename, Document file){
        fileMap.put(filename, file);
    }

    public void removeFileInfo(String filename){
        fileMap.remove(filename);
    }

}
