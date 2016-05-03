/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedfileserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pierre
 */
public class Client {
    
    public void getFileServerImpl() throws RemoteException, MalformedURLException, NotBoundException{
        String servername = "//localhost/FileServer";
        
        FileServerImpl serverImpl = (FileServerImpl) Naming.lookup(servername);
    }
}
