package Objectes;

import java.time.LocalDate;

public interface UtilData {

    static boolean esSolapa(LocalDate arribada1, LocalDate marxa1, LocalDate arribada2, LocalDate marxa2){
        return (arribada1.isBefore(marxa2) && arribada2.isBefore(marxa1));
    }
}
