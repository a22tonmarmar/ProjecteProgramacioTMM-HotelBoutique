package Objectes;

public class Client extends Host{
    public String tarjetaCredit;

    public Client(String nom, String dni, int edat, String tarjetaCredit){
        super(nom, dni, edat);
        this.tarjetaCredit = tarjetaCredit;
    }

    public String getTarjetaCredit() {
        return tarjetaCredit;
    }

    public void setTarjetaCredit(String tarjetaCredit) {
        this.tarjetaCredit = tarjetaCredit;
    }
}
