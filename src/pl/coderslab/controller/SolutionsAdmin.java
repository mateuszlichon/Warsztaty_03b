package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.ExcerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.db.DbUtil;
import pl.coderslab.model.Excercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

/**
 * Servlet implementation class Solutions
 */
@WebServlet("/SolutionsAdmin")
public class SolutionsAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SolutionsAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		try {
			conn = DbUtil.getConn();
			Solution[] solutions = SolutionDao.loadAllSolution(conn);
			User[] users = UserDao.loadAllUsers(conn);
			Excercise[] excercises = ExcerciseDao.loadAllExcercises(conn);
			conn.close();
			request.setAttribute("excercises", excercises);
			request.setAttribute("solutions", solutions);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/solutionsAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
