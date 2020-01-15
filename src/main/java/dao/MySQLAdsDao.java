package dao;

import com.mysql.cj.jdbc.Driver;
import dao.Config;
import models.Ad;
import models.Ads;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {

    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            this.connection = DriverManager.getConnection(
              config.getUrl(),
              config.getUsername(),
              config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ad> all() {

        List<Ad> output = new ArrayList<>();

        String query = "SELECT * FROM ads";

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {
                output.add(
                        new Ad(
                            rs.getLong("id"),
                            rs.getLong("user_id"),
                            rs.getString("title"),
                            rs.getString("description")
                        )
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return output;

    }

    @Override
    public Long insert(Ad ad) {

        Long lastInsertedId = 0L;

        String query = String.format(
                "INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')",
                ad.getUserId(),
                ad.getTitle(),
                ad.getDescription()
        );

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                lastInsertedId = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lastInsertedId;
    }

    public static void main(String[] args) {

        // testing all method
//        models.Ads adsDao = new dao.MySQLAdsDao();
//        List<models.Ad> ads = adsDao.all();
//        for (models.Ad ad : ads) {
//            System.out.println(ad);
//        }

        // test insert
//        models.Ad adToInsert = new models.Ad(
//                1,
//                "Test models.Ad Insert 1",
//                "This is the first insert test ad"
//        );
//
//        models.Ads adsDao = new dao.MySQLAdsDao();
//        long lastInsertedId = adsDao.insert(adToInsert);
//        System.out.println(lastInsertedId);

    }
}
