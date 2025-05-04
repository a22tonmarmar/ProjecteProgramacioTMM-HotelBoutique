package dao;

import database.ConnexioBD;
import Objectes.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bbddDAO implements HotelDAO{
    private static Connection conn;

    public bbddDAO(){
        conn = ConnexioBD.getInstance();
    }

    @Override
    public List<Client> llegir() {
        List<Client> clients = new ArrayList<>();
        try{
            Connection con = ConnexioBD.getInstance();
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM Client");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                String nom = rs.getString("nom");
                String dni = rs.getString("dni");
                String tarjetaBancaria = rs.getString("tarjetaBancaria");
                int edat = rs.getInt("edat");
                clients.add(new Client(nom, dni, edat, tarjetaBancaria));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return clients;
    }

    @Override
    public void pujar(Client client) {
        try{
            Connection con = ConnexioBD.getInstance();
            String query = "INSERT INTO Client (nom, dni, edat, tarjetaBancaria) " +
                    "VALUES ( ?, ?, ?, ?)";
            PreparedStatement statement =  con.prepareStatement(query);
            statement.setString(1, client.getNom());
            statement.setString(2, client.getDni());
            statement.setInt(3, client.getEdat());
            statement.setString(4, client.getTarjetaCredit());
            statement.execute();
        } catch (SQLException e ){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void pujar(ArrayList<Reserva> reserves) {
        for(int i = 0; i < reserves.size(); i++){
            Reserva r = reserves.get(i);
            try{
                Connection con = ConnexioBD.getInstance();
                String query = "INSERT INTO Reserves (client, dni, Hosts, arribada, sortida, dies, import) " +
                        "VALUES ( ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement statement =  con.prepareStatement(query);
                statement.setString(1, r.getClient().getNom());
                statement.setString(2, r.getClient().getDni());
                statement.setInt(3, r.getHost().size());
                statement.setDate(4, Date.valueOf(r.getDataInici()));
                statement.setDate(5, Date.valueOf(r.getDataFinal()));
                statement.setInt(6, r.getNombreDies());
                statement.setDouble(7, r.getImport());
                statement.execute();
            } catch (SQLException e ){
                throw new RuntimeException(e);
            }
        }
    }
}
