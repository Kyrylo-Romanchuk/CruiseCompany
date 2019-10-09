package ua.training.controller.command.user;

import org.apache.log4j.Logger;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Redirect;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SignOutCommand implements Command {
    private final static Logger logger = Logger.getLogger(SignOutCommand.class);
    private CartService cartService;

    public SignOutCommand() {
        this.cartService = new CartService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("Log Out");
        cartService.deleteCartByUser((String) request.getSession().getAttribute("userName"));
        request.getSession().invalidate();
        logger.info("Loged Out");
        return new Redirect("/cruiseCompany");
    }
}
