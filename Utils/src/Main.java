import Objectes.*;
import dao.HotelDAO;
import dao.bbddDAO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static HotelDAO hotelDAO = new bbddDAO();
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner sc = new Scanner(System.in);
        int entrada = 10;

        while (entrada != 0){
            System.out.println();
            System.out.println("BENVINGUT AL MENU, SI US PLAU INTRODUEIX QUE VOL FER");
            System.out.println("========================================================");
            System.out.println("    0. Sortir");
            System.out.println("    1. Mostrar habitacions");
            System.out.println("    2. Mostrar reserves");
            System.out.println("    3. Afegir reserva");
            System.out.println("========================================================");

            entrada = sc.nextInt();
            sc.nextLine();

            switch (entrada){
                case 0:
                    hotelDAO.pujar(hotel.getReserves());
                    System.out.println("Fins la pròxima");
                    break;
                case 1:
                    hotel.mostrarHabitacions();
                    break;
                case 2:
                    hotel.mostrarReserva();
                    break;
                case 3:
                    System.out.println("Primer introduïm les dades del client");
                    System.out.println("=====================================");
                    System.out.print("Nom: ");
                    String clientNom = sc.nextLine();
                    System.out.print("DNI: ");
                    String clientDNI = sc.nextLine();
                    System.out.print("Edat: ");
                    int clientEdat = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tarjeta de credit: ");
                    String tarjetaCredit = sc.nextLine();
                    System.out.println("====================================");
                    Client client = new Client(clientNom, clientDNI, clientEdat, tarjetaCredit);

                    hotelDAO.pujar(client);

                    System.out.println("Client registrat correctament!");
                    System.out.print("Per a quantes persones es la reserva? ");
                    int hosts = sc.nextInt();
                    sc.nextLine();
                    hosts --;
                    ArrayList<Host> llistaHost = new ArrayList<Host>();

                    for (int i = 0; i < hosts; i++){
                        System.out.println();
                        System.out.println("Host " + (i + 1));
                        System.out.println("======");
                        System.out.print("Nom: ");
                        String hostNom = sc.nextLine();
                        System.out.print("DNI: ");
                        String hostDNI = sc.nextLine();
                        System.out.print("Edat: ");
                        int hostEdat = sc.nextInt();
                        sc.nextLine();
                        Host hostCas = new Host(hostNom, hostDNI, hostEdat);
                        llistaHost.add(hostCas);
                        System.out.println();
                    }

                    System.out.println("Hosts registrats correctament");
                    System.out.print("Quin tipus d'habitació vol? Una habitació doble o una suite? (Respon doble o suite): ");
                    String tipusHabitacio = sc.nextLine();
                    System.out.println("Quants dies estaran a les instal·lacions? ");
                    int nombreDies = sc.nextInt();
                    sc.nextLine();
                    LocalDate dataInicial = LocalDate.now();

                    hotel.afegirReserva(client, llistaHost, dataInicial, nombreDies, tipusHabitacio);
                    System.out.println("Reserva concretada!");
                    break;
            }
        }




    }
}