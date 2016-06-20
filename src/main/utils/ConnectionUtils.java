package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// �������� �� �������� ���������� � ����� ������ � ��������� ����������
public class ConnectionUtils {

    // ��������� ��� ������� ����������
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    //��������� ����� ���� ������ example - ��� ����� ����
    public static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/adressbook";
    //���� ��� ����� � ����
    public static final String USER = "root";
    // ������ �����
    public static final String PASSWORD = "mysql";

    // ����� ���������� ��������� ������� ��� ������� � ����
    public static Connection getConnection() {

        // ��������� ������ �� ������ ���������
        Connection con = null;
        try {
            // ����� ������ � ����������
            String driver = MYSQL_DRIVER;
            String url = URL_CONNECTION;
            String user = USER;
            String password = PASSWORD;
            Class.forName(driver);
            //������������� ���������� ����� �������� ������� ������� ����������
            // � ��������� �������� �� ��� ������ getConnection
            con = DriverManager.getConnection(url, user, password);
            // ����� ����� � ������� con ����� ��������� ��� ������������� ����������
            // ����� ���� ���������� �� �������� ���������� �� �� ������ � �������
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
        return con;
    }

    // ����� ������� ������������ ����������
    public static void close(Connection connection) {
        try {
            // ��������� ����������� �� ���������� , ���� �� �� ������� ���� ��� �� ������ �� ������
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ignored) {
        }
    }
}
