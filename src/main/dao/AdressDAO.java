package dao;


import model.Adress;
import utils.ConnectionUtils;

import java.sql.*;

public class AdressDAO {

    private static final String CREATE_ADDRESS_TABLE = "CREATE TABLE address(\n" +
            "address_id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
            "country VARCHAR(30) NOT NULL,\n" +
            "city VARCHAR(20) NOT NULL,\n" +
            "street VARCHAR(250) NOT NULL,\n" +
            "house_number INTEGER NOT NULL,\n" +
            "house_suffix VARCHAR(20) NOT NULL,\n" +
            "appartment INTEGER NOT NULL,\n" +
            "post_code INTEGER NOT NULL,\n" +
            "PRIMARY KEY (address_id)\n" +
            ");";
    private static final String GET_BY_ID = "SELECT * FROM adressbook.user WHERE iduser=?";
    private static final String ADD_SQL = "INSERT INTO adressbook.user " +
            "(country, city, street,houseNumber,houseSuffix,postCode)" +
            " VALUE (?,?,?,?,?,?) ";


    public void add (Adress adress) throws SQLException {
        Connection conn = ConnectionUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_SQL);
            ps.setString(1, adress.getCountry());
            ps.setString(2, adress.getCity());
            ps.setString(3, adress.getStreet());
            ps.setLong(4, adress.getHouseNumber());
            ps.setString(5, adress.getHouseSuffix());
            ps.setLong(6, adress.getPostCode());
            ps.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public Adress getOne(Integer id) throws Exception {
        Adress adress = new Adress();
        Connection conn = ConnectionUtils.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                adress.setCountry(rs.getString("country"));
                adress.setCity(rs.getString("city"));
                adress.setStreet(rs.getString("street"));
                adress.setHouseNumber(rs.getLong("houseNumber"));
                adress.setHouseSuffix(rs.getString("houseSuffix"));
                adress.setPostCode(rs.getLong("postCode"));
            }
        } finally {
            ConnectionUtils.close(conn);
        }
        return adress;
    }


}
