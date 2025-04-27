package Objectes;

public abstract class Habitacio {
    protected int numero;
    protected double preu;
    protected String descripcio;

    public Habitacio(int numero, double preu, String descripcio) {
        this.numero = numero;
        this.preu = preu;
        this.descripcio = descripcio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    @Override
    public String toString(){
        return "Habitacion [numero = " + numero + ", preu = " + preu + ", descripció = " + descripcio + "]";
    }
}
