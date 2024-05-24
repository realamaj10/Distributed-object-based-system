package RMI_Connection;

import Database_Connection.Database;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import model.Constant;
import model.Products;

public class Eletronic_Shop_Connect_Impl extends UnicastRemoteObject implements Eletronic_Shop_Connect {

    private static final long serialVersionUID = 1L;
    private final Database database;

    public Eletronic_Shop_Connect_Impl() throws RemoteException {
        super();
        database = new Database();
        boolean checkConnection = database.startDBConnection(Constant.HOST, Constant.PORT, Constant.DB_NAME, Constant.USERNAME, Constant.PASSWORD);
        if (checkConnection) {
            System.out.println("Connection To Database Successful");
        } else {
            System.out.println("Connection To Database Unsuccessful");
        }
    }

    @Override
    public int findTotalProducts() throws RemoteException {
        return database.findTotalProducts();
    }

    @Override
    public List<Products> findAllProducts() throws RemoteException {
        List<Products> products = database.findAllProducts();
        return products;
    }

    @Override
    public List<Products> findAllProductsWithAvailableQuantity_LessThanTen() throws RemoteException {
        return database.findAllProductsWithAvailableQuantity_LessThanTen();
    }

    @Override
    public int findTotalSales() throws RemoteException {
        return database.findTotalSales();
    }

    @Override
    public int findTotalSalesLastMonth() throws RemoteException {
        return database.findTotalSalesLastMonth();
    }

    @Override
    public int findTotalAmountSales() throws RemoteException {
        return database.findTotalAmountSales();
    }

    @Override
    public int findTotalAmountSales_LastMonth() throws RemoteException {
        return database.findTotalAmountSales_LastMonth();
    }

}
