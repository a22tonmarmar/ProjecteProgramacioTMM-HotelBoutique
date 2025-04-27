package Objectes;

import java.time.LocalDate;
import java.util.Arrays;

public class Reserva {

    private LocalDate dataInici;
    private int nombreDies;
    private Client client;
    private Host[] host;
    private Habitacio habitacio;

    public Reserva(LocalDate dataInici, int nombreDies, Client client, Host[] host, Habitacio habitacio){
        this.dataInici = dataInici;
        this.nombreDies = nombreDies;
        this.client = client;
        this.host = host;
        this.habitacio = habitacio;
    }

    public LocalDate getDataInici() {
        return dataInici;
    }

    public void setDataInici(LocalDate dataInici) {
        this.dataInici = dataInici;
    }

    public int getNombreDies() {
        return nombreDies;
    }

    public void setNombreDies(int nombreDies) {
        this.nombreDies = nombreDies;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Host[] getHost() {
        return host;
    }

    public void setHost(Host[] host) {
        this.host = host;
    }

    public Habitacio getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacio habitacio) {
        this.habitacio = habitacio;
    }

    public LocalDate getDataFinal(){
        return dataInici.plusDays(nombreDies);
    }

    public double getImport() {
        return habitacio.getPreu() * nombreDies;
    }

    @Override
    public String toString() {
        return "Reserva [" + "dataInici=" + dataInici + ", nombreDies=" + nombreDies + ", client=" + client + ", host=" + Arrays.toString(host) + ", habitacio=" + habitacio + ']';
    }
}

