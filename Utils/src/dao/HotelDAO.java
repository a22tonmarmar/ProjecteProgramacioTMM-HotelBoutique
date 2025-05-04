package dao;

import Objectes.Client;
import Objectes.Host;
import Objectes.Reserva;
import java.util.ArrayList;

public interface HotelDAO {
    void llegir();

    void pujar(Client client);
    void pujar(ArrayList<Reserva> reserves);
}
