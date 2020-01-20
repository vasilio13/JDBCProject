import java.sql.*;

public class JDBCClass {
    public static void main(String[] args) {

//        executeQuery();
        executeUpdate();

    }

    private static void executeQuery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "4444");
            Statement statement = connection.createStatement();
            String Query = "SELECT * FROM users";

            ResultSet resultSet=statement.executeQuery(Query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("id:"+id);
                System.out.println("name:"+name);
                System.out.println("email:"+email);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeUpdate(){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "4444");
            Statement statement = connection.createStatement();
            String Query = "INSERT INTO users (id,name,email) VALUE (5,'newUser','ff@smail.com')";
            
//            String Query = "show databases";
            int num = statement.executeUpdate(Query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}