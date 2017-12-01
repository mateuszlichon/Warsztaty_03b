package pl.coderslab.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.coderslab.dao.UserDao;
import pl.coderslab.dao.UserGroupDao;
import pl.coderslab.db.DbUtil;
import pl.coderslab.model.User;
import pl.coderslab.model.UserGroup;

/**
 * Servlet implementation class UsersAdminAdd
 */
@WebServlet("/UsersAdminAdd")
public class UsersAdminAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersAdminAdd() {
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
			User[] users = UserDao.loadAllUsers(conn);
			UserGroup[] groups = UserGroupDao.loadAllGroups(conn);
			conn.close();
			request.setAttribute("users", users);
			request.setAttribute("groups", groups);
			getServletContext().getRequestDispatcher("/usersAdmin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn;
		try {
			conn = DbUtil.getConn();
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			int groupId = Integer.parseInt(request.getParameter("groupId"));
			UserDao.addUser(conn, name, email, password, groupId);
			conn.close();
		} catch (SQLException e) {
			getServletContext().getRequestDispatcher("/usersError.jsp").forward(request, response);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}


}
