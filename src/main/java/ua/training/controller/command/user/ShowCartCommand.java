package ua.training.controller.command.user;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.Bean.CartItemBean;
import ua.training.controller.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowCartCommand implements Command {

    private CartService cartService;

    public ShowCartCommand() {
        this.cartService = new CartService();
    }


    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String login = (String) session.getAttribute("userName");
        List<CartItemBean> items = cartService.findCartsByUser(login);
        session.setAttribute("items", items);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.CARD_LIST_FORM));
    }
}
