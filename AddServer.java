package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Dao;

/**
 * Servlet implementation class AddServer
 */
@WebServlet("/AddServer")
public class AddServer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		System.out.println("hiii");
		String emailid = request.getParameter("emailid");
		System.out.println("hiii"+emailid);
		String sql = "select * from serverrequest where emailid='" + emailid + "'";
		ResultSet rs = Dao.getData1(sql);
		String sql1 = "insert into server values(?,?,?,?,?,?)";
		ServerBean sb = new ServerBean();
		try {
			while (rs.next()) {
				sb.setServername(rs.getString(1));
				sb.setPassword(rs.getString(2));
				sb.setDomain(rs.getString(3));
				sb.setEmailid(rs.getString(4));
				sb.setPublishdate(rs.getString(5));
				sb.setCountry(rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("bye");
		int i = Dao.Register(sql1, sb);
		if (i ==1) {
			
			pw.println("CSP approve the Member Request");
			sql = "update serverrequest set approval='Approved' where emailid='" +emailid + "'";
			int k = Dao.update(sql);
			if (k == 1)
				response.sendRedirect("AddSuccess.jsp?name=servername");
		} else {
			response.sendRedirect("addserver.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
