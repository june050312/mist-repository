import org.postgresql.Driver;

import java.sql.*;

public class JDBCExample {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "mist1234";
        Connection connection = DriverManager.getConnection(url, user, password);

        String sql = "select * from mist.person p where id = ? and school_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, 16);
        preparedStatement.setInt(2, 1);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.next();

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");

        System.out.println(id);
        System.out.println(name);
        System.out.println(age);
    }
}