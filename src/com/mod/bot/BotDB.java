package com.mod.bot;
import java.net.URL;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class BotDB {
	static Connection connection;
	public static void startConnection() {
		  try {
	            String url = "jdbc:mysql://localhost:3306/Bot";
	            String username = "root";
	            String password = "Saransh@2004";

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            connection = DriverManager.getConnection(url, username, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	
	public static String queryDatabase(String userInput) {
      try {
          PreparedStatement preparedStatement = connection.prepareStatement("SELECT bot FROM ChatBot WHERE you=?");
          preparedStatement.setString(1, userInput);
          ResultSet resultSet = preparedStatement.executeQuery();
          if (resultSet.next()) {
              return resultSet.getString("bot");
          } else {
        	  try {
                  URL url = new URL("https://google.com/search?q=" + userInput.replace(" ", "+"));
                  java.awt.Desktop.getDesktop().browse(url.toURI());
                  return "Maybe this will answer your question.";
              }
        	  catch (Exception e) {
        		  return "Please connect to the internet for better results.";
        	  }
          }
      }catch (SQLException e) {
          e.printStackTrace();
          return "An error occurred while processing your request";
      }
	}
}
