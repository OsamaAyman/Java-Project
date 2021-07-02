package Day1;

public class Pyramid {
    private String name,ancient_name,site;
    private float height;

    public Pyramid(String name, String ancient_name, String site, float height) {
        this.name = name;
        this.ancient_name = ancient_name;
        this.site = site;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAncient_name() {
        return ancient_name;
    }

    public void setAncient_name(String ancient_name) {
        this.ancient_name = ancient_name;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "name: "+name+",ancient name: "+ancient_name+",site: "+site+",height: "+height;
    }



}

