package selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MySqlConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/SeleniumDB";

    private static final String USER =
            "root";

    private static final String PASSWORD = System.getenv("macroot33");


    // This is the method NykaaTest will use
    public static void saveProduct(String productName, double price) {

        String sql =
                "INSERT INTO Products (product_name, price) VALUES (?, ?)";

        try {

            Connection con = DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

            System.out.println("MySQL Connected Successfully!");


            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, productName);
            ps.setDouble(2, price);

            ps.executeUpdate();

            System.out.println(
                    "Product saved to MySQL successfully!"
            );

            ps.close();
            con.close();

        } catch (Exception e) {

            System.out.println("MySQL Error:");
            e.printStackTrace();
        }
    }


    // This allows you to run MySqlConnection.java directly
    public static void main(String[] args) {

        System.out.println("Testing MySQL connection...");

        saveProduct("Test Product", 999.00);

    }
}