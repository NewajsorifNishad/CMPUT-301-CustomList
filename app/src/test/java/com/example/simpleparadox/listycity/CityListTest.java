package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CityListTest {



    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.length());
        City city1 = new City("Panchagarh", "Rangpur");
        cityList.add(city1);
        City city2 = new City("Natore", "Rajshahi");
        cityList.add(city2);
        City city3 = new City("Naraynganj", "Dhaka");
        cityList.add(city3);
        assertEquals(4, cityList.length());

        cityList.delete(city3);
        assertEquals(3, cityList.length());
        assertFalse(cityList.getCities().contains(city3));

    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.length());
        City city1 = new City("Panchagarh", "Rangpur");
        cityList.add(city1);
        City city2 = new City("Natore", "Rajshahi");
        cityList.add(city2);

        assertEquals(3, cityList.length());

        cityList.delete(city1);
        assertEquals(2, cityList.length());

        assertThrows(IllegalArgumentException.class, ()-> {
            cityList.delete(city1);
        });

    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testlength() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.length());
        City city1 = new City("Rangamati", "Chittagong");
        cityList.add(city1);
        City city2 = new City("Natore", "Rajshahi");
        cityList.add(city2);
        assertEquals(3, cityList.length());

    }
}