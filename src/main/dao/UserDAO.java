package dao;


import model.User;
import utils.ConnectionUtils;
import utils.ParamUtils;
import utils.Params;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements Params {
    // запрорсы на языке SQL (язык понятынй и читаемый базой базой)
    // запрос содержащий в себе парамтеры - id=? говорит следующие
    // id - параметр который есть в нашей базе в таблице users
    // ? - параметр который мы будем передовать в базу в поле id
    // подургому говоря - id=? id=2

    private static final String DELETE_SQL = "DELETE FROM adressbook.user WHERE id = ?";

    private static final String ADD_SQL = "INSERT INTO adressbook.user  (name ,lastName, photoPath, birthday)  VALUES (?, ?, ?, ?)";

    private static final String UPDATE_SQL = "UPDATE adressbook.user SET name=? , birthday=? WHERE id=?";

    private static final String GET_ONE_SQL = "SELECT * FROM adressbook.user WHERE id=?";

    private static final String GET_ALL_SQL = "SELECT * FROM adressbook.user ";




    public void remove(Integer userId) throws Exception {
        // Получаем соеденение
        Connection conn = ConnectionUtils.getConnection();
        try {
            // Создаем обьект препердстейтманта
            // препейдстейтмент выполняет запросы к базе данных
            // он может посылать данные в базу по средствам SQL запроса
            PreparedStatement ps = conn.prepareStatement(DELETE_SQL);
            // ыетим данные для отправки в базу
            // 1- первый параметр ( id=? - 1) userId (станет вместо ?)  - входящий парамтерт
            ps.setInt(1, userId);
            // выполняет непосредственный запрос в базу
            ps.executeUpdate();
            // закрывает запросы в базу
            ps.close();
        } finally {
            // закрываем соеденение
            ConnectionUtils.close(conn);
        }
    }

    public List<User> getMany() throws Exception {
        List<User> users = new ArrayList<User>();
        Connection conn = ConnectionUtils.getConnection();
        try {

            PreparedStatement ps = conn.prepareStatement(GET_ALL_SQL);

            //обьект резалт сет используется для получения данных из базы
            // получаем обьект резалтсет
            ResultSet rs = ps.executeQuery();

            // пока в резалтсете есть эелменты вытаскиваем их и сетим в нашу модель
            while (rs.next()) {
                // каждый раз проходя круг будет создоватся новый юзер
                // и получать из обьект резалтсет новые данные и сетить в себя
                User user = new User();
                user.setId(rs.getInt(ID));
                user.setName(rs.getString(NAME));
                user.setBirthday(rs.getDate(BIRTHDAY));
                //добовляем юзеров в лист
                users.add(user);
            }
        } finally {
            ConnectionUtils.close(conn);
        }
        // возврошаем заполненый лист юзеров для отправки на вью через процессор класс
        return users;
    }


    public User getOne(Integer id) throws Exception {
        User user = new User();
        Connection conn = ConnectionUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_ONE_SQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(ID));
                user.setName(rs.getString(NAME));
            }
        } finally {
            ConnectionUtils.close(conn);
        }
        return user;
    }


    public void add(User user) throws Exception {
        Connection conn = ConnectionUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_SQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getPhotoPath());
            ps.setDate(4,new Date(user.getBirthday().getTime()));

            ps.executeUpdate();
        } finally {
         conn.close();
        }

    }




}
