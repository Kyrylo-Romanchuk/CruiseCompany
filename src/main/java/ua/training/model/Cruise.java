package ua.training.model;


import ua.training.controller.util.Util;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Cruise implements Serializable {
    private final static long serialVersionUID = 1L;
    private int id;
    private String name;
    private int shipById;
    private Ship ship;
    private int countryFromById;
    private int countryToById;
    private Country countryFrom;
    private Country countryTo;
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private String departureFormat;
    private String arrivalFormat;
    private String durability;

    private CruiseCategory category;
    private int countPort;
    private long price;

    public Cruise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Country getCountryFrom() {
        return countryFrom;
    }

    public void setCountryFrom(Country countryFrom) {
        this.countryFrom = countryFrom;
    }

    public Country getCountryTo() {
        return countryTo;
    }

    public void setCountryTo(Country countryTo) {
        this.countryTo = countryTo;
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }
    /**
     * @see Util#calculateDuration(LocalDateTime, LocalDateTime)
     */
    public String getDurability() {
        return Util.calculateDuration(departure,arrival);
    }

    public CruiseCategory getCategory() {
        return category;
    }

    public void setCategory(CruiseCategory category) {
        this.category = category;
    }

    public int getCountPort() {
        return countPort;
    }

    public void setCountPort(int countPort) {
        this.countPort = countPort;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getCountryFromById() {
        return countryFromById;
    }

    public void setCountryFromById(int countryFromById) {
        this.countryFromById = countryFromById;
    }

    public int getCountryToById() {
        return countryToById;
    }

    public void setCountryToById(int countryToById) {
        this.countryToById = countryToById;
    }

    public int getShipById() {
        return shipById;
    }

    public void setShipById(int shipById) {
        this.shipById = shipById;
    }

    /**
     * @see DateTimeFormatter#format(TemporalAccessor)
     * @return format "dd-MM-yyyy HH:mm"
     */
    public String getDepartureFormat() {
        return this.getDeparture().format( DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }
    /**
     * @see DateTimeFormatter#format(TemporalAccessor)
     * @return format "dd-MM-yyyy HH:mm"
     */
    public String getArrivalFormat() {
        return this.getArrival().format( DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
    }

    /**
     *  Convert from timestap to LocalDAteTime
     * @param timestap
     * @return localDateStap
     */
    public LocalDateTime convertToLocalDateTime(Timestamp timestap) {
        if (timestap != null) {
            return timestap.toLocalDateTime();
        }
        return null;
    }

    /**
     * Convert from localDateTime To Timestamp
     * @param localDateTime
     * @return timestap
     */
    public Timestamp convertToTimestap(LocalDateTime localDateTime) {
        return Timestamp.valueOf(localDateTime);
    }


    @Override
    public String toString() {
        return "Cruise{" +
                "name='" + name + '\'' +
                ", departure=" + departure +
                ", arrival=" + arrival +
                ", durability="+durability+
                ", category=" + category +
                ", countPort=" + countPort +
                ", price=" + price +
                '}';
    }
}
