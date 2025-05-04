package dao;

import database.ConnexioBD;
import Objectes.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class bbddDAO implements HotelDAO{
    private static Connection conn;

    public bbddDAO(){
        conn = ConnexioBD.getInstance();
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
}
