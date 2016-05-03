/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedfileserver;

import java.rmi.RemoteException;
import java.util.Map;

/**
 *
 * @author Pierre
 */
public interface FileServer {

    public Map getFiles(String basDir) throws RemoteException;

    public Map getFiles(String baseDir, boolean upper) throws RemoteException;

    public void createFile(String filename, boolean isDir) throws RemoteException;

    public void deleteFile(String filename) throws RemoteException;
}