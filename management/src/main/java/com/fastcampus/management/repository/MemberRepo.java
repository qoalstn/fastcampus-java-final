package com.fastcampus.management.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepo {
    private String jdbcUrl = "jdbc:mysql://localhost:3306/management";
    private String username = "root";
    private String password = "root";
  
	public int getNewCustNo() {
	  int cust_no = 0;
	  
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");
          Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

          String query = "SELECT cust_no FROM member_tbl ORDER BY cust_no DESC LIMIT 1";
          PreparedStatement preparedStatement = connection.prepareStatement(query);
          ResultSet resultSet = preparedStatement.executeQuery();

          while (resultSet.next()) {
	          	cust_no = resultSet.getInt("cust_no");   
          }

          resultSet.close();
          preparedStatement.close();
          connection.close();
      } catch (ClassNotFoundException e) {
          e.printStackTrace();
      } catch (SQLException e) {
          e.printStackTrace();
      }

      return cust_no+1;
  }
	
	public void saveMember(String cust_name, String phone, String cust_email, String grade) {		  
	      try {
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          Connection connection = DriverManager.getConnection(jdbcUrl, username, password);

	          String query = "INSERT INTO member_tbl (cust_name, phone, cust_email, grade) VALUES (?,?,?,?)";
	          PreparedStatement preparedStatement = connection.prepareStatement(query);

				preparedStatement.setString(1, cust_name);
				preparedStatement.setString(2, phone);
				preparedStatement.setString(3, cust_email);
				preparedStatement.setString(4, grade);

				preparedStatement.executeUpdate();

	          preparedStatement.close();
	          connection.close();
	      } catch (ClassNotFoundException e) {
	          e.printStackTrace();
	      } catch (SQLException e) {
	          e.printStackTrace();
	      }
	  }
	
	
	
}
