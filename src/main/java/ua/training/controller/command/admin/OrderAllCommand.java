package ua.training.controller.command.admin;

import ua.training.controller.Endpoint;
import ua.training.controller.command.Command;
import ua.training.controller.command.servletAction.Forward;
import ua.training.controller.command.servletAction.ServletAction;
import ua.training.controller.service.Bean.OrderItemBean;
import ua.training.controller.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class OrderAllCommand implements Command {

    private OrderService orderService;

    public OrderAllCommand() {
        this.orderService = new OrderService();
    }

    @Override
    public ServletAction execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        List<OrderItemBean> ordersList = orderService.findAllOrders();
        session.setAttribute("ordersList", ordersList);
        return new Forward(Endpoint.getInstance().getProperty(Endpoint.ORDER_ALL_FORM));
    }
}
