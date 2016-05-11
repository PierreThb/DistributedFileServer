/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.List;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Pierre
 */
public interface FileServer extends Remote {

    public String helloClient(String name) throws RemoteException;

    public ArrayList<File> getFiles(String currentPath) throws RemoteException;

    public void deleteFile(String filename) throws RemoteException;

    public void createFile(String filename, String parent, boolean isDir) throws RemoteException;

    public ArrayList<String> openReadFile(String filename) throws RemoteException;

    public void renameFile(String filename, String newName) throws RemoteException;

    public boolean isFile(String filename) throws RemoteException;
}
