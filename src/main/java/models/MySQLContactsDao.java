package models;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLContactsDao implements Contacts {

    private Connection connection;

    public MySQLContactsDao() {
        try {
            Config config = new Config();
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
    public List<Contact> getContacts() {
        List<Contact> output = new ArrayList<>();
        String query = "Select * FROM contacts";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()) {
                output.add(
                    new Contact(
                            rs.getLong("id"), // id
                            rs.getString("first_name"),// first_name
                            rs.getString("last_name"),// last_name
                            rs.getString("phone_number")// phone_number
                    )
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return output;
    }

    @Override
    public long saveContact(Contact contact) {
        return 0;
    }

    @Override
    public void deleteContactById(long id) {

    }

    @Override
    public Contact getContactById(long id) {
        return null;
    }

    public static void main(String[] args) {
        Contacts contactsDao = new MySQLContactsDao();
        List<Contact> contacts = contactsDao.getContacts();
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }
}
