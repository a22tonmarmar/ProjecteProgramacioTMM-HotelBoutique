package Objectes;

import java.time.LocalDate;

public abstract class Reserva implements Cobrable {
    public LocalDate dataInici;
    public int nombreDies;
    public Client client;
    public Host[] host;
    public Habitacio habitacio;
}
