package jdbcbasics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class jdbctest {

	public static void main(String[] args) {
			System.out.println("JDBC Test");
			
			try(
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","sreekar2001");
					Statement statement=conn.createStatement();
					ResultSet set=statement.executeQuery("select * from account");
					
					
					) {
				
				//int res=statement.executeUpdate("insert into account values(2,'kohli','virat',5000)");
				//System.out.println("Rows inserted are: "+res);
				
				
				//int res=statement.executeUpdate("update account set balance=13000 where accno=2");
				//System.out.println("Rows inserted are: "+res);
				
				//int res=statement.executeUpdate("delete from account where accno=1");
				//System.out.println("Number of rows delete: "+res);
				
				//int res=statement.executeUpdate("insert into account values(3,'sreekar','palavai',6000)");
				//System.out.println("Rows inserted are: "+res);
				
				
				while(set.next())
				{
					System.out.println(set.getInt(1)+","+set.getString(2)+","+set.getString(3)+":"+set.getInt(4));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

	}

}
