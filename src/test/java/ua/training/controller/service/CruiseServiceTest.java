package ua.training.controller.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.dao.daoimpl.CruiseDaoImpl;
import ua.training.dao.daoimpl.ExcursionDaoImpl;
import ua.training.model.Cruise;
import ua.training.model.Excursion;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CruiseServiceTest {
    @Mock
    CruiseDaoImpl cruiseDao;
    @InjectMocks
    CruiseService cruiseService;

    List<Cruise> cruises;

    @Before
    public void initExcursionDao() {
        cruises = new ArrayList<>();
    }

    @Test
    public void testFindAllExcursions() {
        when(cruiseService.showListCruise()).thenReturn(cruises);
        List<Excursion> allCruises= cruiseService.showListCruise();
        assertEquals(allCruises.size(), cruises.size());
    }

}