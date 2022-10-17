public class Carte {
    private Hauteur hauteur;
    private Couleur couleur;

    public Carte(Hauteur hauteur, Couleur couleur) {
        this.hauteur = hauteur;
        this.couleur = couleur;
    }

    @Override
    public String toString() {
        return "hauteur = " + hauteur +
                ", couleur = " + couleur;
    }

    public Hauteur getHauteur() {
        return this.hauteur;
    }

}
