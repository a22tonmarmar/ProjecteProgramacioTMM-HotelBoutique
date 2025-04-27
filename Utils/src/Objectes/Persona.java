package Objectes;

public abstract class Persona {
    protected String nom;
    protected String dni;
    protected int edat;

    public Persona(String nom, String dni, int edat){
        this.nom = nom;
        this.dni = dni;
        this.edat = edat;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    public int getEdat() {
        return edat;
    }

    @Override
    public String toString() {
        return "Persona [Nom =" + nom + ", dni = " + dni + ", edat = " + edat +"]";
    }
}
