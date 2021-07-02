package Day2;

public class City {
    private int id,cid,surfaceArea,population;
    private String name;
    private boolean capital;

    public City(int id, int cid,String name, String capital, int surfaceArea, int population) {
        this.setId(id);
        this.setCid(cid);
        this.setName(name);
        this.setSurfaceArea(surfaceArea);
        this.setCapital(capital);
        this.setPopulation(population);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(int surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital.toLowerCase().equals("yes");
    }

    @Override
    public String toString() {
        return "city" +id+ "=" + name ;
    }


}

