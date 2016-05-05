/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

<<<<<<< HEAD
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
=======
>>>>>>> 5b58ba539e6d12417fe7e43b9db94df9053353cd
import java.util.Map;

/**
 *
 * @author Pierre
 */
public interface FileServer extends java.rmi.Remote {

<<<<<<< Updated upstream:src/FileServer.java
    public String helloClient(String name) throws RemoteException;
    
<<<<<<< HEAD
    public ArrayList<String> getFiles(String baseDir) throws RemoteException;
=======
    public Map getFiles(String basDir) throws RemoteException;
=======
    public Map getFiles(String baseDir) throws java.rmi.RemoteException;
>>>>>>> Stashed changes:src/distributedfileserver/FileServer.java

    public Map getFiles(String baseDir, boolean upper) throws java.rmi.RemoteException;
>>>>>>> 5b58ba539e6d12417fe7e43b9db94df9053353cd

    public void createFile(String filename, boolean isDir) throws java.rmi.RemoteException;

<<<<<<< HEAD
    public void deleteFile(String filename) throws RemoteException;
    
    public ArrayList<String> openReadFile(String filename) throws RemoteException;
=======
    public void deleteFile(String filename) throws java.rmi.RemoteException;

    public void openFile(String filename) throws java.rmi.RemoteException;
>>>>>>> 5b58ba539e6d12417fe7e43b9db94df9053353cd
}
