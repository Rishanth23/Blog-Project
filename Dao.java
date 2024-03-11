package com.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.bean.UploadBean;
import com.bean.UserBean;
import com.control.ServerBean;

public class Dao {
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3307/blog", "root", "root");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
	public static int setUser(String sql, UserBean ub) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, ub.getFirstname());
			ps.setString(3, ub.getPassword());
			ps.setString(2, ub.getEmail());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getUserInfo() throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from ukey");
		return rs;
	}
	public static boolean getData(String sql) {
		// TODO Auto-generated method stub
		boolean b = false;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			b = rs.next();
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}

	public static String getName(String sql) {
		// TODO Auto-generated method stub
		String name = "";
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				name = rs.getString(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;

}
	public static int Server( ServerBean sb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			con=Dao.connect();
			String sql = "insert into server values(?,?,?,?,?,?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sb.getServername());
			ps.setString(2, sb.getPassword());
			ps.setString(3, sb.getDomain());
			ps.setString(5, sb.getEmailid());
			ps.setString(4, sb.getPublishdate());
			ps.setString(6, sb.getCountry());
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static String getServername(String sql)
	{
		
			String name = "";
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					name = rs.getString(1);
				}
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return name;
	}
		public static int update(String sql) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}
	public static ResultSet getAllusers() throws SQLException {
		List al = new ArrayList();
		String sql = "select * from user where status1='pending'";
	//	String sql = "SELECT  from user   AES_DECRYPT(username,'mykey'),AES_DECRYPT(password,'mykey'),AES_DECRYPT(dob,'mykey'),AES_DECRYPT(gender,'mykey'),AES_DECRYPT(emailid,'mykey'),AES_DECRYPT(city,'mykey'),AES_DECRYPT(address,'mykey') where status1='pending'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		/*while (rs.next()) {

			
				al.add(rs.getString(1));
				al.add(rs.getString(3));al.add(rs.getString(4));al.add(rs.getString(5));al.add(rs.getString(6));al.add(rs.getString(7));al.add(rs.getString(8));
			
		}*/
		return rs;
	}
	public static ResultSet getUserDetails() throws SQLException {
		Connection con = Dao.connect();
		String sql = "select * from user";
		Statement s = con.createStatement();
		ResultSet r = s.executeQuery(sql);
		return r;
	}
	public static boolean updateUser(String s) throws SQLException {
		String sql = "update user set status1='Approved' where emailid='" + s + "'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		boolean f = st.execute(sql);
		System.out.println("boolean is" + f);
		return f;
	}

	public static int setServerreg(String sql, ServerBean sb) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = connect();
		try {
			System.out.println("Sreekanth sir");
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, sb.getServername());
			ps.setString(2, sb.getPassword());
			ps.setString(3, sb.getDomain());
			ps.setString(4, sb.getEmailid());
			ps.setString(5, sb.getPublishdate());
			ps.setString(6, sb.getCountry());
			ps.setString(7, "pending");
			i = ps.executeUpdate();
		}catch(Exception e)
		{
			return 0;
		}
		return i;
	}
	public static ResultSet getAllServers() throws SQLException {
		List al = new ArrayList();
		String sql = "select * from serverrequest where approval='pending'";
		Connection con = Dao.connect();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		/*while (rs.next()) {

			
				al.add(rs.getString(1));
				al.add(rs.getString(3));al.add(rs.getString(4));al.add(rs.getString(5));al.add(rs.getString(6));al.add(rs.getString(7));al.add(rs.getString(8));
			
		}*/
		return rs;
	}
	public static ResultSet getServerreg() throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from serverrequest");
		return rs;
	}
	public static ResultSet getData1(String sql) {
		// TODO Auto-generated method stub
		Connection con = connect();
		ResultSet rs = null;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			rs =  ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	public static int Register(String sql, ServerBean sb) 
	{
	int i = 0;
	Connection con = connect();
	try {
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, sb.getServername());
		ps.setString(2, sb.getPassword());
		ps.setString(3, sb.getDomain());
		ps.setString(4, sb.getEmailid());
		ps.setString(5, sb.getPublishdate());
		ps.setString(6, sb.getCountry());
		i = ps.executeUpdate();
		ps.close();
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
}
	public static int upload(String sql, UploadBean u) 
	{
		// TODO Auto-generated method stub
			int i = 0;
			Connection con = connect();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(3, u.getDa());
				ps.setString(2, u.getFiledata());
				ps.setString(1, u.getUid());
				i = ps.executeUpdate();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i;
		}
	public static ResultSet getUserUpload(String uid) throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from blogdata where uid !='"+uid+"'");
		return rs;
	}
	public static ResultSet getUserUpload1(String uid) throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from blogdata where uid='"+uid+"'");
		return rs;
	}
	public static ResultSet getUserUpload2() throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from blogdata");
		return rs;
	}
	public static ResultSet getUserUpload3() throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from user");
		return rs;
	}
	public static List<String> getUFile(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static ResultSet getServername() throws SQLException
	{
		Connection con=connect();
		java.sql.Statement s=con.createStatement();
		ResultSet rs=(ResultSet) s.executeQuery("select * from upload ");
		return rs;
	}
	public static List<String> getAFiles(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(7));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	
	public static String getUserkey(String sql) {
		String s = "";
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				s = rs.getString(1);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}
	public static List<String> getAkey(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getOkey(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
			//	lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getOwnerKeys(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(7));
				lt.add(rs.getString(8));
				
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getOkey1(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
				lt.add(rs.getString(2));
				lt.add(rs.getString(3));
				lt.add(rs.getString(4));
			lt.add(rs.getString(5));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getKeys(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(8));
				lt.add(rs.getString(9));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getUKey(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(3));
				//lt.add(rs.getString(4));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static List<String> getFid(String sql) {
		// TODO Auto-generated method stub
		List<String> lt = new ArrayList<String>();
		Connection con = connect();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				lt.add(rs.getString(1));
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lt;
	}
	public static ResultSet getUser() throws SQLException
	{
		Connection con=Dao.connect();
		java.sql.Statement s=con.createStatement();
	//	ResultSet r=s.executeQuery("SELECT AES_DECRYPT(username,'mykey'),AES_DECRYPT(password,'mykey'),AES_DECRYPT(dob,'mykey'),AES_DECRYPT(gender,'mykey'),AES_DECRYPT(emailid,'mykey'),AES_DECRYPT(city,'mykey'),AES_DECRYPT(address,'mykey'),status1 FROM USER;");
		//ResultSet r=s.executeQuery("select * from user where status1='Approved'");
		ResultSet r=s.executeQuery("select * from userrequest ");
		return r;
	}
	public static ResultSet getData2(String sql) {
		// TODO Auto-generated method stub
		Connection con = connect();
		ResultSet rs = null;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			rs =  ps.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
	}
	}
	

