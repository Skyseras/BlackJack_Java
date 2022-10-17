import com.sun.org.apache.bcel.internal.generic.LOR;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import java.util.ArrayList;
import java.util.Random;

public class Lot {
    private ArrayList<Carte> lotDeCartes;

    public Lot(){
        this.lotDeCartes = new ArrayList<Carte>();
    }

    public void creerUnLotDeCartes(){
        for (Couleur carteCouleur : Couleur.values()){
            for (Hauteur carteHauteur : Hauteur.values()){
                this.lotDeCartes.add(new Carte(carteHauteur,carteCouleur));
            }
        }
    }

    public void defausser(){
        ArrayList<Carte> lotTemporaire = new ArrayList<Carte>();
        Random defausse = new Random();
        int defausseIndex = 0;
        int qLot = this.lotDeCartes.size(); // quantité lot de cartes
        for (int i=0; i<qLot; i++){
            defausseIndex = defausse.nextInt((this.lotDeCartes.size() - 1 - 0) + 1);
            lotTemporaire.add(this.lotDeCartes.get(defausseIndex));
            this.lotDeCartes.remove(defausseIndex);
        }
        this.lotDeCartes = lotTemporaire;
    }

    public void supCarte(int i){
        this.lotDeCartes.remove(i);
    }

    public Carte getCarte(int i){
        return this.lotDeCartes.get(i);
    }

    public void addCarte(Carte addCarte){
        this.lotDeCartes.add(addCarte);
    }


    // piocher une carte du lot de cartes
    public void piocher(Lot tirerLaCarte){
        this.lotDeCartes.add(tirerLaCarte.getCarte(0));
        tirerLaCarte.supCarte(0);
    }


    //donner les cartes dans la main
    public int valeurDuTour(){
        int totalValeur = 0;
        int as = 0;

        for (Carte uneCarte : this.lotDeCartes){
            switch (uneCarte.getHauteur()){
                case ACE: as += 1;
                    break;
                case TWO: totalValeur += 2;
                    break;
                case THREE: totalValeur += 3;
                    break;
                case FOUR: totalValeur += 4;
                    break;
                case FIVE: totalValeur += 5;
                    break;
                case SIX: totalValeur += 6;
                    break;
                case SEVEN: totalValeur += 7;
                    break;
                case EIGHT: totalValeur += 8;
                    break;
                case NINE: totalValeur += 9;
                    break;
                case TEN: totalValeur += 10;
                    break;
                case JACK: totalValeur += 10;
                    break;
                case QUEEN: totalValeur += 10;
                    break;
                case KING: totalValeur += 10;
                    break;
            }

            for (int i=0;i<as;i++){
                if (totalValeur > 10){
                    totalValeur += 1;
                }else {
                    totalValeur += 11;
                }
            }
        }
        return totalValeur;
    }

    public int lotSize(){
        return this.lotDeCartes.size();
    }


    // retourner les cartes au lot
    public void rajouterAuLotDeCartes(Lot LesCartesOùRajoutées) {
        int ceLotDeCartes = this.lotDeCartes.size();

        //prendre les cartes et les rajouter dans le lot de carte
        for (int i=0;i<ceLotDeCartes;i++){
            LesCartesOùRajoutées.addCarte(this.getCarte(i));
        }
        //supprimer les cartes à la fin du deplacement
        for (int i=0;i<ceLotDeCartes;i++){
            this.supCarte(0);
        }
    }

    @Override
    public String toString() {
        String listCarte = "";
        int i=0;
        for (Carte uneCarte : this.lotDeCartes){
            listCarte += "\n"+uneCarte.toString();
            i++;
        }
        return listCarte;
    }
}
