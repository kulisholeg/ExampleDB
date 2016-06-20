package utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Отвечает за создание соеденения с базой данных и уджаление соеденения
public class ConnectionUtils {

    // указываем тип драйвер соеденения
    public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";

    //указываем адрес базы данных example - имя самой базы
    public static final String URL_CONNECTION = "jdbc:mysql://localhost:3306/adressbook";
    //юзер для входа в базу
    public static final String USER = "root";
    // пароль юзера
    public static final String PASSWORD = "mysql";

    // метод возврашяет созданный конекшн для доступа к базе
    public static Connection getConnection() {

        // обьявляем ссылку на обьект конекшена
        Connection con = null;
        try {
            // Сетим данные в переменные
            String driver = MYSQL_DRIVER;
            String url = URL_CONNECTION;
            String user = USER;
            String password = PASSWORD;
            Class.forName(driver);
            //Устанавливаем соеденение путем создания обьекта Драйвер менеджмент
            // и получения конешена из его метода getConnection
            con = DriverManager.getConnection(url, user, password);
            // после этого в обьекте con будет храниться уже установленное соеденение
            // иначе если содеенение не возможно установить то мы упадем с ошибкой
        } catch (ClassNotFoundException cnfe) {
            System.out.println(cnfe);
        } catch (SQLException sqe) {
            System.out.println(sqe);
        }
        return con;
    }

    // метод удаляет существующие соеденение
    public static void close(Connection connection) {
        try {
            // проверяем установлено ли соеденение , если да то удаляем если нет то ничего не делаем
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException ignored) {
        }
    }
}
