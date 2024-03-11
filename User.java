package com.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.Dao;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
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
		PrintWriter o = response.getWriter();
		String nid = request.getParameter("name");
		String uid = request.getParameter("email");
		String pwd = request.getParameter("password");
		HttpSession session = request.getSession();
		String sql = "select * from user where email='"+uid+"' and password='"+pwd+"'";
		System.out.println("sql is"+sql);
				if(Dao.getData(sql)) {
					session.setAttribute("email", uid);
					session.setAttribute("name", nid);
					response.sendRedirect("userhome.jsp");
				}	
			else {
				o.println("<script type=\"text/javascript\">");
				o.println("alert('Please Enter Valid Details.../Register Initially...');");
				o.println("window.location='index.html'</script>");
			}
	}
	}
