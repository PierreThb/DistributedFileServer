/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedfileserver;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Pierre
 */
public class RMIFileServer {

    public static void main(String[] args) {
        try {
            String host = "localhost";
            if (args.length == 1) {
                host = args[0];
            }
            Naming.rebind("//" + host + "/FileServer", (Remote) new FileServerImpl());
        } catch (RemoteException | MalformedURLException e) {

        }
    }
}
