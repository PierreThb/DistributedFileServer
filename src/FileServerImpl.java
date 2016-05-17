/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implement the FileServer interface and override all interface's fucntions
 * 
 * @author Pierre
 */
public class FileServerImpl extends UnicastRemoteObject implements FileServer {

    public FileServerImpl() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<File> getFiles(String currentPath) throws RemoteException {
        File folder = new File("files/" + currentPath); /* get the folder */
        File[] listOfFiles = folder.listFiles(); /* get all files of the folder */
        ArrayList<File> files = new ArrayList<>();

        int i = 0;
        /* 
        Add all files in the ArrayList
        */
        for (File file : listOfFiles) {
            files.add(i, file);
            i++;
        }
        return files;
    }

    @Override
    public void deleteFile(String filename) throws RemoteException {
        String[] parts = filename.split("[\\\\]");
        int size = parts.length;
        File file = null;
        /*
        Get the file
        */
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
            System.out.println("Can not delete a directory, you only can delete a file ! \n");
        } else if (file.delete()) {
            System.out.println("File deleted !\n");
        } else {
            System.out.println("Problem, file not deleted !\n");
        }
    }

    @Override
    public ArrayList<String> openReadFile(String filename) throws RemoteException {
        ArrayList<String> records = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) { /* read the file content */
                String line;
                while ((line = reader.readLine()) != null) {
                    records.add(line); /* add each line of the buffer inoto the ArrayList */
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
        return "Hello from the server, welcome " + name;
    }

    @Override
    public void createFile(String filename, String parent, boolean isDir) throws RemoteException {
        if (isDir) {
            File file = new File("files/" + parent + "/" + filename); /* new Directory */
            if (file.mkdir()) { /* create the Directory */
                System.out.println("Directory created!\n");
            } else {
                System.out.println("Problem, directory not created !\n");
            }
        } else if (parent.equals("")) {
            File file = new File("files/" + filename); /* new Directory */
            try {
                if (file.createNewFile()) { /* create Directory */
                    System.out.println("Directory created !\n");
                } else {
                    System.out.println("Problem directory not created !\n");
                }
            } catch (IOException ex) {
                Logger.getLogger(FileServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            File file = new File("files/" + parent + "/" + filename); /* new File */
            try {
                if (file.createNewFile()) { /* create File */
                    System.out.println("File created ! \n");
                } else {
                    System.out.println("Problem, file not created ! \n");
                }
            } catch (IOException ex) {
                Logger.getLogger(FileServerImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void renameFile(String filename, String newName) throws RemoteException {
        String[] parts = filename.split("[\\\\]");
        int size = parts.length;
        File oldFile = null;
        File newFile = null;
        /*
        Get the old file name and the new file name
        */
        switch (size) {
            case 2:
                oldFile = new File("files/" + parts[size - 1]);
                newFile = new File("files/" + newName);
                break;
            case 3:
                oldFile = new File("files/" + parts[size - 2] + "/" + parts[size - 1]);
                newFile = new File("files/" + parts[size - 2] + "/" + newName);
                break;
            case 4:
                oldFile = new File("files/" + parts[size - 3] + "/" + parts[size - 2] + "/" + parts[size - 1]);
                newFile = new File("files/" + parts[size - 3] + "/" + parts[size - 2] + "/" + newName);
                break;
            default:
                break;
        }
        if (oldFile.renameTo(newFile)) { /* rename the file */
            System.out.println("File renamed !\n");
        } else {
            System.out.println("Problem, file not renamed !\n");
        }
    }

    @Override
    public boolean isFile(String filename) throws RemoteException {
        String[] parts = filename.split("[\\\\]");
        int size = parts.length;
        File file = null;
        /*
        Get the file
        */
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
        return file.isFile();
    }
}
