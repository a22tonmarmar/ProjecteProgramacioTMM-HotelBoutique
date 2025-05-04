package dao;

import Objectes.*;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class csvDAO implements HotelDAO{
    private static Path path = Path.of("files", "Reserves.csv");
    private static Path path2 = Path.of ("files", "Clients.csv");

    File file = null;
    @Override
    public void pujar(Client client){
        file = new File(path2.toString());
        try{
            FileWriter myWriter = new FileWriter(file,true);
            BufferedWriter bw = new BufferedWriter(myWriter);
            bw.write(ClientToCSV(client));
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Ha succeit un error.");
            e.printStackTrace();
        }
    }

    private String ClientToCSV(Client client){
        StringBuilder csv = new StringBuilder();
        csv.append(client.getNom()).append(",");
        csv.append(client.getDni()).append(",");
        csv.append(client.getEdat()).append(",");
        csv.append(client.getTarjetaCredit()).append(".");
        return csv.toString();
    }

    @Override
    public void pujar(ArrayList<Reserva> reserves){
        file = new File(path.toString());
        for(int i = 0; i < reserves.size(); i++){
            Reserva r = reserves.get(i);
            try{
                FileWriter myWriter = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(myWriter);
                bw.write(r.toString());
                bw.newLine();
                bw.close();
            } catch (IOException e) {
                System.out.println("Ha succeit un error.");
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Client> llegir(){
        List<Client> clients = new ArrayList<>();
        try{
            file = new File(file.toString());
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                clients.add(ClientFromCSV(data));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return clients;
    }

    private Client ClientFromCSV(String data){
        String[] camps = data.split(",");
        try {
            String nom = camps[0];
            String dni = camps[1];
            String tarjetaBancaria = camps[3];
            int edat = Integer.parseInt(camps[2]);
            return new Client(nom, dni, edat, tarjetaBancaria);
        } catch (Exception e){
            System.out.println("Error al escriure el client");
        }
        return null;
    }






}
