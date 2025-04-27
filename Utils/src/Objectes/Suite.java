package Objectes;

public class Suite extends Habitacio{
    private String nom;
    private int nombrePlaces;
    private String serveisExtra;

    public Suite(int numero, String descripcio, String nom, int nombrePlaces, String serveisExtra) {
        super(numero, Cobrable.PREU_SUITE, descripcio);
        this.nom = nom;
        this.nombrePlaces = nombrePlaces;
        this.serveisExtra = serveisExtra;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public String getServeisExtra() {
        return serveisExtra;
    }

    public void setServeisExtra(String serveisExtra) {
        this.serveisExtra = serveisExtra;
    }
}
