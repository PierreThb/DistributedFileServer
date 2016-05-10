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
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public ArrayList<File> getFiles(String currentPath) throws RemoteException {
        File folder = new File("files/" + currentPath);
        File[] listOfFiles = folder.listFiles();
        ArrayList<File> strings = new ArrayList<>();

        int i = 0;
        for (File file : listOfFiles) {
            strings.add(i, file);
            i++;
        }
        return strings;
    }

    @Override
    public void deleteFile(String filename) throws RemoteException {
        String[] parts = filename.split("[\\\\]");
        int size = parts.length;
        File file = null;
        switch (size) {
            case 2:
                file = new File("files/" + parts[size - 1]);
                break;
            case 3:
                file = new File("files/" + parts[size - 2] + "/" + parts[size - 1]);
                break;
            case 4:
                file = new File("files/" + parts[size - 3] + "/" + parts[size - 2] + "/" + parts[size - 1]);
                break;
            default:
                break;
        }

        if (file.isDirectory()) {
            System.out.println("Can not delete a directory, you only can delete a file");
        } else if (file.delete()) {
            System.out.println("File deleted !");
        } else {
            System.out.println("Problem, file not deleted !");
        }
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
    public void createFile(String filename, String parent, boolean isDir) throws RemoteException {
        if (isDir) {
            File file = new File("files/" + parent + "/" + filename);
            if (file.mkdir()) {
                System.out.println("Directory is created!");
            } else {
                System.out.println("Directory already exists.");
            }
        } else if (parent.equals("")) {
            File file = new File("files/" + filename);
            try {
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException ex) {
                Logger.getLogger(FileServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            File file = new File("files/" + parent + "/" + filename);
            try {
                if (file.createNewFile()) {
                    System.out.println("File is created!");
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException ex) {
                Logger.getLogger(FileServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public boolean isFile(String filename, String parent) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
