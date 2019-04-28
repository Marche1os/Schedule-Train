package model;

/**
 * Список классов для извлечения тегов из HTML страницы
 */
public abstract class Consts {
    public static final String URL_REQUEST = "https://www.tutu.ru/rasp.php?st1=%s&st2=%s";
    public static final String MAIN_TABLE_CLASS = "desktop__mainTable__3fRBY desktop__timetable__3wEtY";
    public static final String HEADER_CLASS = "desktop__card__yoy03";
    public static final String BODY_CLASS = "desktop__timetable__3wEtY";
    public static final String BEFORE_TRAINS = "desktop__link__2VlWW";
    public static final String TIME_DEPARTURE = "desktop__cell__2cdVW desktop__depTime__2Ue-g";
    public static final String STANDART_PLUS = "g-link desktop__depTimeLink__1NA_N ";
    public static final String TIME_ARRIVAL = "g-link desktop__arrTimeLink__2TJxM";
}
