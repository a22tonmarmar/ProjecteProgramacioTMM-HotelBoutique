package Objectes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;

public class Hotel {
    private Habitacio[] habitacions;
    private ArrayList<Reserva> reserves;
    private int quantitatReserves;

    public Hotel() {
        habitacions = new Habitacio[10];
        ArrayList<Reserva> reserves = new ArrayList<Reserva>();
        quantitatReserves = 0;
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

    /* Aquesta funció només la trucarem quan hagim comprobat abans que hi han reserves disponibles*/
    public Reserva afegirReserva(Client client, Host[] host, LocalDate dataInici, int nombreDies, Habitacio habitacio){
        Reserva r = new Reserva(dataInici, nombreDies, client, host, habitacio);
        reserves.add(r);
        return r;
    }

    public void mostrarReserva() {
        System.out.println("RESERVES DEL HOTEL");
        System.out.println("==================");
        System.out.println();

        if(quantitatReserves == 0) {
            System.out.println("L'hotel no disposa encara de reserves");
        }

        for(int i = 0; i < quantitatReserves; i++){
            Reserva r = reserves.get(i);
            System.out.println("RESERVA" + (i+1));
            System.out.println("-------");
            System.out.println("Client: " + r.getClient().getNom());
            System.out.println("DNI: " + r.getClient().getDni());
            System.out.println("Nº Hosts: " + r.getHost().length + 1);
            System.out.println("Arribada: " + r.getDataInici().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) );
            System.out.println("Sortida: " + r.getDataFinal().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) );
            System.out.println("Nº Dies: " + r.getNombreDies());
            System.out.println("Import: " + r.getImport());
            System.out.println();
        }
        System.out.println();
    }

    public boolean habitacioDisponible(int numero, LocalDate data, int nombreDies){
        boolean disponible = true;
        int i = 0;
        while(i < quantitatReserves && disponible){
            Reserva r = reserves.get(i);
            if (r.getHabitacio().getNumero() == numero){
                disponible = !UtilData.esSolapa(r.getDataInici(), r.getDataFinal(), data, data.plusDays(nombreDies));
            }
            i++;

        }
        return disponible;
    }
}
