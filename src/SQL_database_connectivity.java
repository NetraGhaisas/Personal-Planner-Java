import java.sql.*;
public class SQL_database_connectivity 
{
	public static void main(String [] args) 
	{
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "";
		try 
		{
			Class.forName("com.mysql.jdbc.Driver").newInstance(); //Create and initializes a java JDBC Driver
			Connection con = DriverManager.getConnection(url, user, password); //Creates a Connection with MYSQL Database
			Statement st = con.createStatement();
			//create and execute queries in DB
			st.execute("CREATE DATABASE IF NOT EXISTS test");
			st.execute("USE test");
			//create out table
			st.execute("DROP TABLE IF EXISTS people");
			st.execute("CREATE TABLE people ("+ "id BIGINT NOT NULL AUTO_INCREMENT,"+"username VARCHAR(25),"
					+ "password VARCHAR(25),"
					+ "PRIMARY KEY(id)"
					+ ")");
			st.execute("INSERT INTO people (username,password) VALUES" + "('RusherRG','1234567@R'),('Netra','Ghaisas'),('Athmika','Hebbar')");
			
			st.execute("DROP TABLE IF EXISTS todo");
			st.execute("CREATE TABLE todo ("+ "username VARCHAR(25),"
					+ "time DATETIME,"
					+ "todo LONGTEXT,"
					+ "status INT(11)"
					+ ")");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
