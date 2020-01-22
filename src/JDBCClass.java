import java.sql.*;

public class JDBCClass {
    public static void main(String[] args) {

//        executeQuery();
        //     executeUpdate();
        //execute();
        prepareStatement();

    }

    private static void executeQuery() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "4444");
            Statement statement = connection.createStatement();
            String Query = "SELECT * FROM users";

            ResultSet resultSet = statement.executeQuery(Query);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("id:" + id);
                System.out.println("name:" + name);
                System.out.println("email:" + email);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void executeUpdate() {
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

    private static void execute() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "4444");
            Statement statement = connection.createStatement();

            String Query = "SELECT * FROM users";

            boolean hasResultSet = statement.execute(Query);
            if (hasResultSet) {
                ResultSet resultSet = statement.getResultSet();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");

                    System.out.println("id:" + id);
                    System.out.println("name:" + name);
                    System.out.println("email:" + email);
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static void prepareStatement() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/eshop?serverTimezone=UTC", "root", "4444");
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
            preparedStatement.setInt(1, 1);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();

            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("id:" + id);
                System.out.println("name:" + name);
                System.out.println("email:" + email);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}