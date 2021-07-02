package Day2;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private int cid;
    private String name,continent;
    private List<City> cities;

    public Country(int cid, String name, String continent) {
        this.cid = cid;
        this.name = name;
        this.continent = continent;
        cities=new ArrayList();

    }

    public List<City> getCities() {
        return cities;
    }

    public void addCity(City c) {
        this.cities.add(c);
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Override
    public String toString() {
        return "Country{" + "name=" + name + '}';
    }

}

