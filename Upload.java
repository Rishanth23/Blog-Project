package com.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.bean.UploadBean;
import com.dao.Dao;
import com.dao.PortNumber;
import com.dao.Test;
@MultipartConfig(maxFileSize = 16177215)
/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
		HttpSession session = request.getSession(false);
		String uid=(String)session.getAttribute("email");
		String fname = request.getParameter("filedata");
		Date d = new Date();
		String da = "" + d;
		UploadBean u = new UploadBean();
		u.setFiledata(fname);
		u.setUid(uid);
		u.setDa(da);
		String sql = "insert into blogdata values(0,?,?,?)";
		System.out.println("fffffff"+uid);
		int i = Dao.upload(sql, u);
		if(i > 0){
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Blog Created Sucessfully...');");
			o.println("window.location='upload.jsp';</script>");
		}else{
			o.println("<script type=\"text/javascript\">");
			o.println("alert('Blog not Created');");
			o.println("window.location='upload.jsp';</script>");
		}
	}
	}

