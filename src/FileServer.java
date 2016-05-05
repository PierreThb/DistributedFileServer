/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Pierre
 */
public interface FileServer extends Remote{

    public String helloClient(String name) throws RemoteException;
    
    public ArrayList<String> getFiles(String baseDir) throws RemoteException;

    public void createFile(String filename, boolean isDir) throws RemoteException;

    public void deleteFile(String filename) throws RemoteException;
    
    public ArrayList<String> openReadFile(String filename) throws RemoteException;
}
