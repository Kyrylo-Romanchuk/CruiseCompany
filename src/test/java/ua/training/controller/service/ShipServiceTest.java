package ua.training.controller.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.dao.daoimpl.ShipDaoImpl;
import ua.training.model.Ship;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ShipServiceTest {

    @Mock
    ShipDaoImpl shipDao;
    @InjectMocks
    ShipService shipService;
    List<Ship> ships ;

    @Before
    public void init() {
        ships = new ArrayList<>();
    }

    @Test
    public void testFindAllShips() {
        when(shipService.showListShips()).thenReturn(ships);
        List<Ship> allCountries = shipService.showListShips();
        assertEquals(allCountries.size(), ships.size());
    }

}