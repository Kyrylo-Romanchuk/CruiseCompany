package ua.training.dao;

import ua.training.model.Excursion;

import java.util.List;

public interface ExcursionDao extends GenericDao<Excursion> {
    List<Excursion> findByCountryId(int id);
}
