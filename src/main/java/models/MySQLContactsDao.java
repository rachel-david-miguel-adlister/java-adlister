package models;



import com.mysql.cj.jdbc.Driver;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class MySQLContactsDao implements Contacts {

    private Connection connection;

    public MySQLContactsDao() {
        Config config = new Config();
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
    public List<Contact> getContacts() {
        List<Contact> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from contacts");
            while (rs.next()) {
                output.add(
                    new Contact(
                            rs.getInt("id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("phone_number")
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
        long outputId;
        if (contact.getId() != 0) {
            outputId = updateContact(contact);
        } else {
            outputId = insertContact(contact);
        }
        return outputId;
    }

    private long updateContact(Contact contact) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                String.format("update contacts set first_name = '%s', last_name = '%s', phone_number = '%s' where id = %d",
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getPhoneNumber(),
                    contact.getId()
                ));
            return contact.getId();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private long insertContact(Contact contact) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                String.format("insert into contacts (first_name, last_name, phone_number) values ('%s', '%s', '%s')",
                    contact.getFirstName(),
                    contact.getLastName(),
                    contact.getPhoneNumber()
                ),
                Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void deleteContactById(long id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    String.format("delete from contacts where id = %d", id)
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Contact getContactById(long id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(String.format("select * from  contacts where id = %d", id));
            if (rs.next()) {
                return new Contact(
                    rs.getInt("id"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("phone_number")
                );
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        MySQLContactsDao dao = new MySQLContactsDao();

//        testing getting all

//        List<Contact> contacts = dao.getContacts();
//        for (Contact contact : contacts) {
//            System.out.println(contact.getFirstName());
//        }

//        testing getting one

//        testing insert

//        dao.insertContact(new Contact("Billy", "Bob", "8675309"));

//        testing update

//        dao.saveContact(new Contact(1, "ZZZ", "ZZZ", "1112223333"));

//        testing delete

//        dao.deleteContactById(1);

//        testing get one

//        Contact contact = dao.getContactById(1);
//
//        System.out.println(contact.getFirstName());


    }

}
