package ua.training.controller.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.training.dao.daoimpl.CountryDaoImpl;
import ua.training.model.Country;
import ua.training.model.Excursion;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
        import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CountryServiceTest {
    @Mock
    CountryDaoImpl countryDao;
    @InjectMocks
    CountryService countryService;
    List<Country> countries ;

    @Before
    public void init() {
        countries = new ArrayList<>();
    }

    @Test
    public void testFindAllCountries() {
        when(countryService.showListContry()).thenReturn(countries);
        List<Country> allCountries = countryService.showListContry();
        assertEquals(allCountries.size(), countries.size());
    }
    @Test
    public void testFindByCountry() {
        Country country = mock(Country.class);
        when(country .getId()).thenReturn(3);
        int id = country .getId();
        assertEquals(id, 3);
    }


}