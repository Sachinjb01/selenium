package sandeepsir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class PRACTICE {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn=null;
		try
		{
	
		Driver d=new  Driver();
		DriverManager.registerDriver(d);
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement st = conn.createStatement();
		
		String qu = "select * from project";
		
		ResultSet rs = st.executeQuery(qu);
		
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		
	}
		catch(Exception e)
		{
			
		}
		finally
		{
			conn.close();
			System.out.println("db close");
		}
	
	}
}