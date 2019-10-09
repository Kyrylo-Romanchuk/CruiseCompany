package ua.training.dao;

import ua.training.dao.daoimpl.*;

public interface AbstractFactory {

    UserDaoImpl createUserDao();

    CountryDaoImpl createCountryDao();

    CartDaoImpl createCartDao();

    CruiseDaoImpl createCruiseDao();

    ExcursionDaoImpl createExcursionDao();

    ShipDaoImpl createShipDao();

    ShipImageDaoImpl createShipImageDao();

    ExcursionImageDaoImpl createExcursionImageDao();

    OrderDaoImpl createOrderDao();
}
