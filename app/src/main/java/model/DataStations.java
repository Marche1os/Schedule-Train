package model;

import java.util.HashMap;
import java.util.Map;

/**
 * хранение карты Ключ (станция) - значение (код станции, например, у Опалиха 36705)
 */
public abstract class DataStations {
    private static final Map<String, String> mapStations = new HashMap<>();

    static {
        mapStations.put("Опалиха", "36705");
        mapStations.put("Ленинградская", "36105");
    }

    public static Map<String, String> getMapStations() {
        return mapStations;
    }

    /**
     *
     * @param key - station. For example "Опалиха"
     * @return код станции по сайту Tutu.ru
     */
    public static String getKeyStation(String key) {
        return mapStations.get(key);
    }
}
