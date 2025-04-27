package Objectes;

public class Servei implements Cobrable {
    private String nom;
    private double preu;

    public Servei(String nom, double preu) {
        this.nom = nom;
        this.preu = preu;
    }

    @Override
    public double getImporte(){
        return preu;
    }
}
