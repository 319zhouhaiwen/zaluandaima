package aba;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/long")
public class Long extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String mm=request.getParameter("pswd");
		String yzm=request.getParameter("yzm");
		String hidcode=request.getParameter("hidcode");
		
		if("".equals(yzm)&&"".equals(hidcode)||"null".equals(hidcode)) {
			if("1".equals(name)&&"1".equals(mm)) {
				response.sendRedirect("list.jsp");
			}else {
				request.setAttribute("abc", "1");
				request.getRequestDispatcher("long.jsp").forward(request, response);
				
			}
		}else {
			String ac=(String) request.getSession().getAttribute("vCode");
			if(ac.equalsIgnoreCase(yzm)) {
				if("1".equals(name)&&"1".equals(mm)) {
					response.sendRedirect("list.jsp");
				}else {
					request.setAttribute("abc", "1");
					request.getRequestDispatcher("long.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("abc", "1");
				request.getRequestDispatcher("long.jsp").forward(request, response);
			}
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
