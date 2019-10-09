package ua.training.controller.command.user;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.Bean.OrderItemBean;
import ua.training.controller.service.OrderService;
import ua.training.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProfileCommand implements Command {
    private OrderService orderService;

    public ProfileCommand() {
        this.orderService = new OrderService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<OrderItemBean> orderItemBeans = orderService.showListOrderByUser(user);
        session.setAttribute("orderItemBeans", orderItemBeans);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.PROFILE_FORM));
    }
}
