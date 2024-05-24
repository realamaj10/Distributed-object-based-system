package Main;

import RMI_Connection.Eletronic_Shop_Connect;
import RMI_Connection.Eletronic_Shop_Connect_Impl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import model.Constant;

public class Server {

    Eletronic_Shop_Connect remote_server;

    public static void main(String[] args) {
        Server server = new Server();
    }

    public Server() {
        init();
    }

    private void init() {
        launch_RemoteServer();

    }

    //To connect to the server machine
    private void launch_RemoteServer() {
        try {
            Registry registry = LocateRegistry.createRegistry(Constant.RMI_PORT);
            String url = Constant.RMI + Constant.RMI_IP + Constant.RMI_PORT + Constant.RMI_NAME;
            remote_server = new Eletronic_Shop_Connect_Impl();
            Naming.rebind(url, remote_server);
            System.out.println("RMI Registered at: " + url);
            System.out.println("Server is ready");
            System.out.println("Waiting for clients .....");
        } catch (RemoteException ex) {
            System.out.println("Remote Connection to launch Server Failed");
        } catch (MalformedURLException ex) {
            System.out.println("URL of Launching Server Failed");

        }
    }

}
