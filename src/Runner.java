import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        try {
            Connection connection = ConnectionPool.getConnection();

            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("select * from users");

            while (result.next()) {
                System.out.println(result.getString("login"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
