package ua.training.controller.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.dao.daoimpl.ExcursionDaoImpl;
import ua.training.model.Excursion;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ExcursionServiceTest {
    @Mock
    ExcursionDaoImpl excursionDao;

    @InjectMocks
    ExcursionService service;

    List<Excursion> excursions;


    @Before
    public void initExcursionDao() {
        excursions = new ArrayList<>();
    }

    @Test
    public void testFindAllExcursions() {
        when(service.showListExcursion()).thenReturn(excursions);
        List<Excursion> allExcursion = service.showListExcursion();
        assertEquals(allExcursion.size(), excursions.size());
    }

}