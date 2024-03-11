package com.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.Dao;

/**
 * Servlet implementation class UserReg
 */
@WebServlet("/UserReg")
public class UserReg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserReg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		String firstname = request.getParameter("firstname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sql = "insert into user values(?,?,?);";
		UserBean ub = new UserBean();
		ub.setFirstname(firstname);
		ub.setEmail(email);
		ub.setPassword(password);
		System.out.println("register");
		int i=Dao.setUser(sql,ub);
		if(i > 0){
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Register Successfully...');");
			pw.println("window.location='usersuccess.jsp';</script>");
		}else{
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Please enter valid Details/Already Exist');");
			pw.println("window.location='index.html';</script>");
		}
		}
	}
	
