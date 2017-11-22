package com.bgasparotto.oceejbd6.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bgasparotto.oceejbd6.ejb1.EchoLocalBusiness;

/**
 * Example servlet for EJB testing.
 */
@WebServlet("/dualecho")
public class DualEchoServlet extends HttpServlet {
	private static final long serialVersionUID = -7685590972606998738L;

	@EJB
	private EchoLocalBusiness echo;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		ServletOutputStream out = response.getOutputStream();
		out.print("<html><body>");
		out.print(echo.echoAndReturn("one", "two"));
		out.print("</body></html>");
	}
}