package RMI_Connection;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Products;

public interface Eletronic_Shop_Connect extends Remote {

    public int findTotalProducts() throws RemoteException;

    public List<Products> findAllProducts() throws RemoteException;

    public List<Products> findAllProductsWithAvailableQuantity_LessThanTen() throws RemoteException;

    public int findTotalSales() throws RemoteException;

    public int findTotalSalesLastMonth() throws RemoteException;

    public int findTotalAmountSales() throws RemoteException;

    public int findTotalAmountSales_LastMonth() throws RemoteException;
}
