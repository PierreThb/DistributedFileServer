/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Pierre
 */
public class RMIFileServer {

    public static void main(String[] args) {
        try {
            String host = "localhost";
            String port = "1099";
            FileServerImpl fsi = new FileServerImpl();
            if (args.length == 1) {
                host = args[0];
            } else if (args.length == 2) {
                host = args[0];
                port = args[1];
            }
            Naming.rebind("rmi://" + host + ":" + port + "/FileServer", fsi);
            System.out.println("Server" + host + " is running on port " + port);
        } catch (RemoteException | MalformedURLException e) {
            System.out.println("Trouble : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
