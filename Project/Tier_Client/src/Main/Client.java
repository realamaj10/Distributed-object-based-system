package Main;

import RMI_Connection.Eletronic_Shop_Connect;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.List;
import java.util.Scanner;
import model.Constant;
import model.Products;

public class Client {

    Eletronic_Shop_Connect remote_connect;
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();
    }

    public Client() {
        init();
    }

    private void init() {
        connectToRMI();
        consoleDisplay();
    }

    //To remote_connect to the server machine
    public Eletronic_Shop_Connect connectToRMI() {
        try {
            LocateRegistry.getRegistry(Constant.RMI_PORT);
            String url = Constant.RMI + Constant.RMI_IP + Constant.RMI_PORT + Constant.RMI_NAME;
            remote_connect = (Eletronic_Shop_Connect) Naming.lookup(url);
            return remote_connect;
        } catch (RemoteException ex) {
            System.out.println("Remote Connection with Server Failed");

            return null;
        } catch (NotBoundException | MalformedURLException ex) {
            System.out.println("Connection with Server Failed");

            return null;
        }
    }

    private void consoleDisplay() {
        try {
            System.out.println("*** Welcome To My Eletronic Shop ***");
            System.out.println("[1] => Number of Total Products in the Database");
            System.out.println("[2] => List of all Products with their Data");
            System.out.println("[3] => List of Products with Available Quantity less than 10 Units.");
            System.out.println("[4] => Number of Total Sales");
            System.out.println("[5] => Number of Total Sales over the Last Month");
            System.out.println("[6] => Total Amount of Sales");
            System.out.println("[7] => Total Amount of Sales over the Last Month.");
            System.out.println("Choose between [1-7] ?");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    int totalProducts = remote_connect.findTotalProducts();
                    System.out.println("Total Eletronics Products ==> " + totalProducts);
                    break;
                case 2:
                    System.out.println("List of All Products");
                    List<Products> products = remote_connect.findAllProducts();
                    for (Products product : products) {
                        System.out.println(product);
                    }
                    break;
                case 3:
                    System.out.println("List of All Products with Availability Less than 10 Units");
                    List<Products> productsAvailability = remote_connect.findAllProductsWithAvailableQuantity_LessThanTen();
                    for (Products product : productsAvailability) {
                        System.out.println(product);
                    }
                    break;
                case 4:
                    int totalSales = remote_connect.findTotalSales();
                    System.out.println("Total Sales ==> " + totalSales);
                    break;
                case 5:
                    int totalSalesLastMonth = remote_connect.findTotalSalesLastMonth();
                    System.out.println("Total Sales Last Month ==> " + totalSalesLastMonth);
                    break;
                case 6:
                    int totalAmountSales = remote_connect.findTotalAmountSales();
                    System.out.println("Total Amount Sales ==> $" + totalAmountSales);
                    break;
                case 7:
                    int totalAmountSalesLastMonth = remote_connect.findTotalAmountSales_LastMonth();
                    System.out.println("Total Amount of Sales Last Month ==> $" + totalAmountSalesLastMonth);
                    break;
                default:
                    System.out.println("Wrong Choice. \nChoose only numbers between 1 to 7");
            }
        } catch (RemoteException ex) {
            System.out.println("Error with Remote Method Connection With The Server");
        }
    }

}
