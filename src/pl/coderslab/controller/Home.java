package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.SolutionDtoDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.db.DbUtil;
import pl.coderslab.model.SolutionDto;
import pl.coderslab.model.User;

/**
 * Servlet implementation class Home
 */
@WebServlet({"/Home", "/"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int limit = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));
			Connection conn = DbUtil.getConn();
			SolutionDto[] solutions = SolutionDtoDao.loadSolutionsWithUsers(conn, limit);
			conn.close();
			request.setAttribute("solutions", solutions);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
