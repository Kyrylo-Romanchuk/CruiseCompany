package ua.training.dao;

import ua.training.model.Cruise;

import java.util.List;

public interface CruiseDao extends GenericDao<Cruise> {
    List<Cruise> findAllWithLimit(int offset);

    int countCruise();
}
