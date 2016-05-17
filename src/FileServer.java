/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * This class represente interface for the remote FileServer
 * 
 * @author Pierre
 */
public interface FileServer extends Remote {

    /*
    Function to for when the a client is connect to the same adress as the server 
    */
    public String helloClient(String name) throws RemoteException;

    /*
    Fuction which return an ArrayList of File
    */
    public ArrayList<File> getFiles(String currentPath) throws RemoteException;

    /*
    Function which delete a File
    */
    public void deleteFile(String filename) throws RemoteException;

    /*
    Function which create a File or a Directory
    */
    public void createFile(String filename, String parent, boolean isDir) throws RemoteException;

    /*
    Function which return a ArrayList of String containing the contents of a File
    */
    public ArrayList<String> openReadFile(String filename) throws RemoteException;

    /*
    Function which rename a File
    */
    public void renameFile(String filename, String newName) throws RemoteException;

    /*
    Function which return if filename is a File or false if it's a Directory
    */
    public boolean isFile(String filename) throws RemoteException;
}
