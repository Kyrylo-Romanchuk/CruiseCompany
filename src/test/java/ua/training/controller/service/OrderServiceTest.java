package ua.training.controller.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.controller.service.Bean.OrderItemBean;
import ua.training.dao.daoimpl.OrderDaoImpl;
import ua.training.model.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceTest {

    @Mock
    OrderDaoImpl orderDao;
    @InjectMocks
    OrderService orderService;
    private List<OrderItemBean> ordersList;

    @Before
    public void init() {
        ordersList = new ArrayList<>();
    }

    @Test
    public void testFindAllOrders() {
        when(orderService.findAllOrders()).thenReturn(ordersList);
        List<OrderItemBean> allOrders = orderService.findAllOrders();
        assertEquals(allOrders.size(), ordersList.size());
    }

    @Test
    public void testShowOrdersByUser(){
        User user = mock(User.class);
        when(user.getLogin()).thenReturn("admin");
        when(orderService.showListOrderByUser(user)).thenReturn(ordersList);
        List<OrderItemBean> allOrders = orderService.showListOrderByUser(user);
        assertEquals(allOrders.size(), ordersList.size());
    }


}