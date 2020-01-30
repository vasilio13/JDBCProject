import java.sql.*;


public class Userproc {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/testo?serverTimezone=UTC";

    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[]args){
        CallProc();
    }

 public static void CallProc() {
     String query = "call proc(?)";
     try (Connection connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD)) {
         CallableStatement statement = connection.prepareCall(query);
         statement.setInt(1,3);
         ResultSet resultSet = statement.executeQuery();
         while (resultSet.next()) {
             System.out.println(resultSet.getInt("id"));
         }

     } catch (SQLException e) {
         e.printStackTrace();
     }


 }
}
