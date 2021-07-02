package Day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day2_Exercise1 {
    public static void main(String args[]){

        Map<Integer,Country> countries=countriesFromExercise1();

        for (Country c:countries.values())
            System.out.println(c.getName()+"--->"+c.getCities());



        int countryToSort=1;
        sortCountries(countries,countryToSort);
        countries.get(countryToSort).getCities().forEach(c -> {
            System.out.println(c.getPopulation());
        });

    }

    public static  Map<Integer,Country> countriesFromExercise1(){
        List<String[]> countryFile=readFile("src/main/resources/data/Countries.csv",false);
        List<String[]> CityFile=readFile("src/main/resources/data/Cities.csv",false);
        String[] item;
        Map<Integer,Country> countries=new HashMap();
        List<City> cities=new ArrayList();

        Iterator<String[]> it = CityFile.iterator();
        while (it.hasNext()) {
            item = it.next();
            City c=new City(Integer.parseInt(item[0]),Integer.parseInt(item[1]),item[2],item[3],Integer.parseInt(item[4]),Integer.parseInt(item[5]));
            cities.add(c);


        }
        it = countryFile.iterator();
        while (it.hasNext()) {
            item = it.next();
            Country Country=new Country(Integer.parseInt(item[0]),item[1],item[2]);
            for (City c:cities)
            {
                if(c.getCid()==Country.getCid())
                    Country.addCity(c);

            }

            countries.put(Country.getCid(),Country);


        }
        return countries;

    }

    private static void sortCountries(Map<Integer, Country> countries, int cid) {
        countries.get(cid).getCities().sort(Comparator.comparing(City::getPopulation));
    }

    private static List<String[]> readFile(String fileName, boolean returnHeader) {
        FileReader reader = null;
        List<String[]> allData = new ArrayList<String[]>();
        try {
            File f = new File(fileName);
            reader = new FileReader(f);
            BufferedReader breader = new BufferedReader(reader);
            String line;
            if (!returnHeader) {

                breader.readLine();

            }
            line = breader.readLine();

            String data[];
            while (line != null) {
                data = line.split(",");
                allData.add(data);
                line = breader.readLine();
            }

        }catch (IOException e) {
            e.printStackTrace();
        }


        return allData;

    }


}


