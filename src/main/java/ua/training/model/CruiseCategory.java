package ua.training.model;

public enum CruiseCategory {

ECONOM("No"),
BUSSINES("pool,cinema,fitness"),
VIP("all inclusive");
private String bonus;
CruiseCategory(String bonus){
    this.bonus=bonus;
}

    public String getBonus() {
        return bonus;
    }

    @Override
    public String toString() {
        return CruiseCategory.this.name() +
                "bonus='" + bonus + '\'' +
                '}';
    }
}
