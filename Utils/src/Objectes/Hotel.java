package Objectes;

import java.util.Random;

public class Hotel {
    private Habitacio[] habitacions;
    private Reserva[] reserves;
    private int cantitatReserves;

    public Hotel() {
        habitacions = new Habitacio[10];
        reserves = new Reserva[100];
        cantitatReserves = 0;
        iniciar();
    }

    private void iniciar(){
        for(int i = 0; i < 8; i++){
            int numero = i + 1;
            String descripcio = "Habitació doble estàndar";
            habitacions[i] = new HabitacioDoble(numero, descripcio);
        }

        String[] nomsSuites = {"Mil i una nit", "Palau Daurat"};

        Random random = new Random();
        for(int i = 0; i < 2; i++) {
            int nombre = 9 + i;
            String descripcio = "Suite de luxe";
            String nom = "Suite " + nomsSuites[i];
            int places = random.nextInt(3) + 3;
            String serveisExtra = "Servei de cocktails, accés a spa";
            habitacions[i+8] = new Suite(nombre, descripcio, nom, places, serveisExtra);
        }
    }
}
