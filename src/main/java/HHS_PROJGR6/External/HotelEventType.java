package HHS_PROJGR6.External;

public enum HotelEventType {
    NONE, // empty event
    CHECK_IN, // gastID, sterren
    CHECK_OUT, // gastID
    CLEANING_EMERGENCY, // kamerID, tijd in HTE
    EVACUATE, // .
    GODZILLA, // .
    GOTO_RESTAURANT, // gastID
    GOTO_CINEMA, // gastID
    GOTO_FITNESS, // gastID, HTE
    START_CINEMA, // cinemaID
    NEED_FOOD
}
