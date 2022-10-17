public enum Hauteur {

        ACE("As", 11),
        TWO("Deux", 2),
        THREE("Trois", 3),
        FOUR("Quatre",4),
        FIVE("Cinq",5),
        SIX("Six",6),
        SEVEN("Sept",7),
        EIGHT("Huit",8),
        NINE("Neuf",9),
        TEN("Dix",10),
        JACK("Valet",10),
        QUEEN("Rein",10),
        KING("Roi",10);

        String hauteurCarte;
        int hauteurValeur;

        //constructeur chaque carte a une hauteur et une valeur
        Hauteur(String hauteurCarte, int hauteurValeur){
            this.hauteurCarte = hauteurCarte;
            this.hauteurValeur = hauteurValeur;
        }

        public String toString(){
            return hauteurCarte;
        }
}
