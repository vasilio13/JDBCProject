import java.sql.*;

public class Bank {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/bank/?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
       printAllAccount();
       updateAmounts();
       printAllAccount();

    }

    private static void updateAmounts(){
        try(Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {

            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();

            statement.executeUpdate("update account set amount = 50 where id = 1");
            statement.executeUpdate("update account set amount = 250 where id = 2");

            connection.commit();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void printAllAccount(){
        try(Connection connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD)) {


            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM account");

            while (resultSet.next()){
                System.out.println("id: "+resultSet.getInt("id"));
                System.out.println("amount: "+ resultSet.getInt("amount"));
                System.out.println("----------------------------------------");
            }
        }
         catch (SQLException e) {
            e.printStackTrace();
         }
    }
}
