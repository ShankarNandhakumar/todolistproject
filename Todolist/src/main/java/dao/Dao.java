package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

import dto.User;

public class Dao {
	
	private static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/userdatabase","root","root");
		return con;
	}
	
		public int saveData(User user) throws ClassNotFoundException, SQLException
		{
			Connection con= getConnection();
			PreparedStatement pst=con.prepareStatement("insert into user values (?,?,?,?,?,?)");
			pst.setInt(1, user.getUserid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getUseremail());
			pst.setLong(4, user.getUsercontact());
			pst.setString(6, user.getUserpassword());
		 Blob imgblob= new SerialBlob(user.getUserimage());
		 pst.setBlob(5,imgblob);
		 int res=pst.executeUpdate();
		 return res;
		 }
		


		public User findByEmail(String email) throws ClassNotFoundException, SQLException
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select * from user where useremail=?");
			pst.setString(1,email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				User u1=new User();
				u1.setUserid(rs.getInt(1));
				u1.setUsername(rs.getString(2));
				u1.setUseremail(rs.getString(3));
				u1.setUsercontact(rs.getLong(4));
				u1.setUserpassword(rs.getString(6));
				//convert blob image to byte array
				Blob imgblob=rs.getBlob(5);
				byte[] image=imgblob.getBytes(1, (int) imgblob.length());
				u1.setUserimage(image);
				return u1;

			}
			else
			{
			return null;
		}
		}				
}
