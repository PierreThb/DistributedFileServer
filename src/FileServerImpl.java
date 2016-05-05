/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierre
 */
public class FileServerImpl extends UnicastRemoteObject implements FileServer {

    public FileServerImpl() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<String> getFiles(String basDir) throws RemoteException {
        File folder = new File("files/"+basDir);
        File[] listOfFiles = folder.listFiles();
        ArrayList<String> strings = new ArrayList<>();
        
        int i = 0;
        for(File file : listOfFiles){
            System.out.println("pass here");
            if(file.isFile()){
                strings.add(i, file.toString());
                i++;
            }
        }
        
        return strings;
    }

    @Override
    public void createFile(String filename, boolean isDir) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteFile(String filename) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> openReadFile(String filename) throws RemoteException {
        ArrayList<String> records = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    records.add(line);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileServerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return records;
    }

    @Override
    public String helloClient(String name) throws RemoteException {
        return "Here is the server, welcome " + name;
    }

    @Override
    public void openFile(String filename) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
