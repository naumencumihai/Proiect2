package storage;

import entities.Child;
import entities.City;
import enums.Cities;

import java.util.*;

public class CitySorter {
    private static Set<Cities> cityNames = new HashSet<>();
    private static List<City> cities;

    public CitySorter() { }

    public static List<Child> sortByCities(List<Child> children) {
        cities = extractSortedCities(children);

        List<Child> childrenSortedByCity = new ArrayList<>();
        for (City city : cities) {
            childrenSortedByCity.addAll(city.getChildren());
        }

        return childrenSortedByCity;
    }

    private static List<City> extractSortedCities(List<Child> children) {
       List<City> citiesSorted = new ArrayList<>();
       for (Child child : children) {
            cityNames.add(child.getCity());
       }
       for (Cities cityName : cityNames) {
           citiesSorted.add(new City(cityName));
       }
       for (City city : citiesSorted) {
           for (Child child : children) {
               if (child.getCity().equals(city.getName())) {
                   city.addChild(child);
                   city.addToCityScores(child.getAverageScore());
               }
           }
           city.calculateAverageScore();
       }
       citiesSorted.sort(Comparator.comparing(City::getScore).reversed().
               thenComparing(City::getNameString));
       return citiesSorted;
    }
}
