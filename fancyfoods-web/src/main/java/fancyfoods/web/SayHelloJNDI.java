package fancyfoods.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fancyfoods.food.Food;
import fancyfoods.offers.CurrentOffers;
import fancyfoods.offers.SpecialOffer;

public class SayHelloJNDI extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Locale locale = request.getLocale();
		String bundleName = "resources/messages";

		ResourceBundle resources = ResourceBundle.getBundle(bundleName, locale);
		String greeting = resources.getString("SayHello.hello");

		PrintWriter html = response.getWriter();
		html.append("<html>");
		html.append(greeting);

		try {
			InitialContext ctx = new InitialContext();
			String jndiName = "osgi:service/" + CurrentOffers.class.getName();
			CurrentOffers offers = (CurrentOffers) ctx.lookup(jndiName);
			List<SpecialOffer> currentOffers = offers.getCurrentOffers();

			for (SpecialOffer offer : currentOffers) {
				writeRowForOffer(html, offer);
			}

		} catch (NamingException e) {
			html.append("We have no special offers today. " + "Try again tomorrow.");
		}

	}

	private void writeRowForOffer(PrintWriter html, SpecialOffer offer) {
		html.append("<tr>");
		String description = offer.getDescription();
		Food offerFood = offer.getOfferFood();
		html.append("<td>" + offerFood.getName() + "</td>");
		html.append("<td>" + offerFood.getPrice() + "</td>");
		html.append("<td>" + description + "</td>");
		html.append("</tr>");
	}

}
