package Day2;

import java.util.Map;
import java.util.stream.Collectors;

public class Day2_Exercise3 {
    public static void main(String args[]){
        Map<Integer,Country> countries=Day2_Exercise1.countriesFromExercise1();
        System.out.println("Highest population city of each country:");
        countries.values().stream()
                .map(country->country.getCities().stream()
                        .map(City::getPopulation)
                        .max(Double::compare).get())
                .forEach(c->System.out.println(c));
        System.out.println("---------------------------------------------------------");
        System.out.println("Highest population city by continent:");
        countries.values().stream()
                .collect(Collectors.groupingBy(Country::getContinent))
                .values().stream()
                .map(countriesStream -> countriesStream.stream()
                        .map(country->country.getCities().stream()
                                .map(City::getPopulation).max(Double::compare).get())
                        .max(Double::compare).get())
                .forEach(pop->System.out.println(pop));
        System.out.println("---------------------------------------------------------");
        double maxCapital= countries.values().stream()
                .map(country->country.getCities()
                        .stream().filter(City::isCapital)
                        .map(City::getPopulation)
                        .max(Double::compare).get())
                .max(Double::compare).get();

        System.out.println("Highest population capital= "+maxCapital);
        System.out.println("---------------------------------------------------------");


    }
}

