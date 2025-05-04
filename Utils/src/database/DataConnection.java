package database;

public class DataConnection {
    private static String USR = "a22tonmarmar_HCUadmin";
    private static String PWD = "Uf800Up|3e7AzsQ2";
    private static String URL = "jdbc:mysql://daw.inspedralbes.cat:3306/a22tonmarmar_HotelClientUsuaris";

    public static String getUSR() {
        return USR;
    }

    public static String getPWD() {
        return PWD;
    }

    public static String getURL() {
        return URL;
    }
}
