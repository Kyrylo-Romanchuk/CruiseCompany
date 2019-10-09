package ua.training.controller.command.user;

import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Redirect;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddCartCommand implements Command {
    private CartService cartService;

    public AddCartCommand() {
        this.cartService = new CartService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int cruiseID = Integer.parseInt(request.getParameter("id"));
        String login = (String) session.getAttribute("userName");
        String addResult = cartService.addCartToUser(login, cruiseID);
        if (addResult != null) {
            session.setAttribute("msg", addResult);
            return new Redirect("//cruise");
        } else {
            session.setAttribute("msg", "Something wrong!!!");
            return new Redirect("//cruise");
        }

    }
}
