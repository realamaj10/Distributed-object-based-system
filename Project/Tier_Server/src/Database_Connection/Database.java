package Database_Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Products;

public class Database {

    private Connection connection = null;
    private ResultSet resultSet = null;
    private Products product = null;

    public Database() {
        product = new Products();
    }

    public boolean startDBConnection(String host, String port, String DBName, String username, String pass) {
        String url = "jdbc:mysql://" + host + port + "/" + DBName;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, pass);
            return true;
        } catch (SQLException e) {
            return false;
        } catch (ClassNotFoundException ex) {
            System.out.println("MySQL DB Class Path could not be found. \n Import the mysql-connector to the project");
            return false;
        }
    }

    public int findTotalProducts() {
        int total;
        String query = "SELECT COUNT(id) FROM products";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            if (resultSet.first()) {
                total = resultSet.getInt(1);
            } else {
                total = 0;
            }
        } catch (SQLException ex) {
            total = 0;
            System.out.println("SQL Query Error");
        }
        return total;
    }

    public List<Products> findAllProducts() {
        List<Products> products = new ArrayList<>();
        String query = "SELECT * FROM products";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            while (resultSet.next()) {
                Products allProducts = new Products();
                allProducts.setId(resultSet.getLong("id"));
                allProducts.setName(resultSet.getString("name"));
                allProducts.setPrice(resultSet.getDouble("price"));
                allProducts.setArrival_date(resultSet.getDate("arrival_date"));
                allProducts.setManufacturer(resultSet.getString("manufacturer"));
                allProducts.setQuantity(resultSet.getInt("quantity"));
                products.add(allProducts);
            }
            return products;
        } catch (SQLException ex) {
            System.out.println("SQL Query Error");
            return null;
        }
    }

    public List<Products> findAllProductsWithAvailableQuantity_LessThanTen() {
        List<Products> products = new ArrayList<>();
        String query = "SELECT * FROM products WHERE quantity < 10";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            while (resultSet.next()) {
                product = new Products();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setArrival_date(resultSet.getDate("arrival_date"));
                product.setManufacturer(resultSet.getString("manufacturer"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
            }
            return products;
        } catch (SQLException ex) {
            System.out.println("SQL Query Error");
            return null;
        }
    }

    public int findTotalSales() {
        int total;
        String query = "SELECT COUNT(id) FROM sales";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            if (resultSet.first()) {
                total = resultSet.getInt(1);
            } else {
                total = 0;
            }
        } catch (SQLException ex) {
            total = 0;
            System.out.println("SQL Query Error");
        }
        return total;
    }

    public int findTotalSalesLastMonth() {
        int totalSalesLastMonth = 0;
        String query = "SELECT COUNT(id) FROM sales"
                + " WHERE MONTH(sale_date) = MONTH(CURDATE() - INTERVAL 1 MONTH)";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            if (resultSet.first()) {
                totalSalesLastMonth = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("SQL Query Error");
        }
        return totalSalesLastMonth;
    }

    public int findTotalAmountSales() {
        int total = 0;
        String query = "SELECT total_amount FROM sales";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            while (resultSet.next()) {
                total += resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("SQL Query Error");
        }
        return total;
    }

    public int findTotalAmountSales_LastMonth() {
        int totalAmountSalesLastMonth = 0;
        String query = "SELECT SUM(total_amount) FROM sales "
                + "WHERE MONTH(sale_date) = MONTH(CURDATE() - INTERVAL 1 MONTH)";
        try {
            PreparedStatement prepare = connection.prepareStatement(query);
            resultSet = prepare.executeQuery();
            if (resultSet.first()) {
                totalAmountSalesLastMonth = resultSet.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("SQL Query Error");
        }
        return totalAmountSalesLastMonth;
    }
}
