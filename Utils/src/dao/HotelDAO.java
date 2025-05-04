package dao;

import Objectes.*;
import java.util.ArrayList;
import java.util.List;

public interface HotelDAO {
    List<Client> llegir();
    void pujar(Client client);
    void pujar(ArrayList<Reserva> reserves);
}
