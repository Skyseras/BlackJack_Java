public enum Couleur {
    DIAMOND("1 \u2666"),//carreau
    HEART("2 \u2665"),//coeur
    SPADE("3 \u2660"),//pique
    CLUB("4 \u2663"); //trèfle

    String couleurCarte;
    Couleur(String couleurCarte) {
        this.couleurCarte = couleurCarte;
    }

    public String toString(){
        return couleurCarte;
    }
}
