/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pierre
 */
public class Client {
    String name;

    public Client(String name) {
        this.name = name;
    }
    
    public void getFileServerImpl(String server, String port) {

        String servername = "rmi://" + server + ":" + port + "/FileServer";

        try {

            FileServer serverImpl = (FileServer) Naming.lookup(servername);
            String str = serverImpl.helloClient(name);
            System.out.println(str);

        } catch (NotBoundException | MalformedURLException | RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        Client client = new Client("pierre");
        client.getFileServerImpl("localhost", "1099");
    }
}
