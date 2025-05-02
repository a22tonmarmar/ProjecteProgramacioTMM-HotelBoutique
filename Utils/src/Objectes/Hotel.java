package Objectes;

import javax.lang.model.type.ArrayType;
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

    public ArrayList<Habitacio> habitacionsDisponibles(String tipus, LocalDate data, int nombreDies) {
        ArrayList<Habitacio> resultat = new ArrayList<Habitacio>();
        int quantitat = 0;
        for(Habitacio h : habitacions){
            if (this.habitacioDisponible(h.getNumero(),data, nombreDies)){
                if (tipus.equalsIgnoreCase("doble")){
                    if (h instanceof HabitacioDoble){ /*instanceof és un operador lògic que compara els tipus d'objecte entre dos objectes diferents)*/
                        resultat.add(h);
                    }
                } else {
                    if (h instanceof Suite){
                        resultat.add(h);
                    }
                }
            }
        }
        return resultat;
    }

     public void mostrarHabitacions(){
         System.out.println("HABITACIONS DEL HOTEL");
         System.out.println("=====================");
         System.out.println();

         for(Habitacio h : habitacions) {
             String tipus = "";
             if (h instanceof HabitacioDoble){
                 tipus = "Habitació doble";
             } else if (h instanceof Suite s){
                 tipus = "Suite";
             }

             System.out.println("Habitació Nº " + h.getNumero());
             System.out.println("Tipus: " + tipus);
             System.out.println("Preu per nit: %.2f".formatted(h.getPreu())); /*Dins del string %.2f serveix per a després formatejar el string per a que sorti un nombre amb, en aquest cas, 2 decimals. Per això el .2f */
             System.out.println("Descripció: " + h.getDescripcio());

             if (h instanceof Suite s){
                 System.out.println("Nombre: " + s.getNom());
                 System.out.println("Nombre de places: " + s.getNombrePlaces());
                 System.out.println("Serveis extra: " + s.getServeisExtra());
             }

             String disponibilidad = (this.habitacioDisponible(h.getNumero(), LocalDate.now(), 1) ? "Si" : "No");

             System.out.println("Disponible avui: " + disponibilidad);
         }
     }

     public Reserva afegirReserva(Client client, Host[] host, LocalDate dataInici, int nombreDies, String tipusHabitacio){

        /*Cerquem habitacions disponibles avui*/
         ArrayList<Habitacio> disponibles = habitacionsDisponibles(tipusHabitacio, dataInici, nombreDies);
         Reserva r = null;

         if (disponibles.size() > 0){
             // Es revisa si el nom de host es poden allotjar
             if (tipusHabitacio.equalsIgnoreCase("doble")) {
                 if (host.length > 1) {
                     System.out.println("No es poden allotjar més de dues persones en una habitació doble");
                     return r;
                 } else {
                     r = afegirReserva(client, host, dataInici, nombreDies, disponibles.get(0));
                 }
             } else {
                 // Si es una suite, es revisa si el nom de host es poden allotjar
                 for (int i = 0; i < disponibles.size() && r == null; i++){
                     Suite s = (Suite) disponibles.get(i);
                     if (s.getNombrePlaces() >= host.length + 1) {
                         r = afegirReserva(client, host, dataInici, nombreDies, s);
                     }
                 }
                 if (r == null){
                     System.out.println("Ho sentim, però sembla que no hi han suites disponibles amb aquesta capacitat.");
                 }
             }
         } else {
             System.out.println("Ho sentim, no hi han habitacions disponibles");
         }

         return r;
     }

}
