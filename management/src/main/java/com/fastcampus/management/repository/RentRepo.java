package com.fastcampus.management.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import model.Rent;

@Repository
public class RentRepo {

    private String jdbcUrl = "jdbc:mysql://localhost:3306/management";
    private String username = "root";
    private String password = "root";

    public List<Rent> getAllRent() {
    	 List<Rent> rentList = new ArrayList<Rent>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

            String query = "SELECT * FROM rent_tbl";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
            	Rent rent = new Rent();
            	rent.setCust_no(resultSet.getInt("cust_no"));
            	rent.setRent_no(resultSet.getInt("rent_no"));
            	rent.setBook_code(resultSet.getString("book_code"));
            	rent.setRent_price(resultSet.getInt("rent_price"));
            	rent.setRent_date(resultSet.getDate("rent_date"));
            	rentList.add(rent);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rentList;
    }
}
