package yzm;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/long")
public class Long extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String mm = req.getParameter("mm");
		String yzm = req.getParameter("yzm");
		String hidden = req.getParameter("hidden");
		String vcode = (String) req.getSession().getAttribute("vCode");
		if (hidden.equals("")) {
			if (name.equals("1") && mm.equals("2")) {
				resp.sendRedirect("list.jsp");
			} else {
				req.setAttribute("hidden", "1");
				req.getRequestDispatcher("long.jsp").forward(req, resp);
			}
		} else {
			if (vcode.equalsIgnoreCase(yzm)) {
				if (name.equals("1") && mm.equals("2")) {
					resp.sendRedirect("list.jsp");
				} else {
					req.setAttribute("hidden", "1");
					req.getRequestDispatcher("long.jsp").forward(req, resp);
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
