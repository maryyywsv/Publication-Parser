package soc3;

import java.sql.*;

public class DataBase {

	private String author;
	private String title;
	private String pages;
	private String year;
	//String name = "draig Cunningham;

	public DataBase(String name) {
		this.selection(name);
	}
	

	private void selection(String strs) {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			Connection connect = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "");
			// System.out.println("here") ;
			System.out.println("Success connect Mysql server!");

			Statement stmt = connect.createStatement();
			//System.out.println(strs);
			ResultSet rs = stmt
					.executeQuery("select * from user4 where author like'%"+strs+"%'");
			
			while (rs.next()) {
				this.author = rs.getString("author");
				System.out.println(rs.getString("author"));
			this.title = rs.getString("title");
				System.out.println(rs.getString("title"));
				this.pages = rs.getString("pages");
				System.out.println(rs.getString("pages"));
				this.year = rs.getString("year");
				System.out.println(rs.getString("year"));
			}
			rs.close();
			stmt.close();
			connect.close();
			// System.out.println("close");
		} catch (Exception e) {
			
			System.out.print("get data error!");
			e.printStackTrace();
		}
	}

	public String getAuthor() {
		return this.author;
	}

	public String getTitle() {
		return this.title;
	}

	public String getPages() {
		return this.pages;
	}

	public String getYear() {
		return this.year;
	}
	

}
