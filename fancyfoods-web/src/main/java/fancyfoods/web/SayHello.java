package fancyfoods.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fancyfoods.offers.SpecialOffer;

public class SayHello extends HttpServlet {

	private SpecialOffer offer;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();

		Locale locale = request.getLocale();
		String bundleName = "resources/messages";

		ResourceBundle resources = ResourceBundle.getBundle(bundleName, locale);
		String greeting = resources.getString("SayHello.hello");
		writer.append(greeting);
	}

	public void setOffer(SpecialOffer offer) {
		this.offer = offer;
	}

	public SpecialOffer getOffer() {
		return offer;
	}

}
