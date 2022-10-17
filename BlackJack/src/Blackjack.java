import javax.crypto.spec.PSource;
import java.util.Scanner;

public class Blackjack {
    public static void main(String[] args) {
        System.out.println("Bienvenue A Youcode BlackJack!");
        Lot nouveauLot = new Lot();
        nouveauLot.creerUnLotDeCartes();
        nouveauLot.defausser();

        Lot joueurLot = new Lot();
        Lot croupierLot = new Lot();

        double joueurSolde = 1000.00;
        Scanner joueurinput = new Scanner(System.in);

        while (joueurSolde>0){
            System.out.println("Tu as MAD "+joueurSolde+", Combien veux-tu parier?");
            double joueurPari = joueurinput.nextDouble();
            if (joueurPari>joueurSolde) {
                System.out.println("Tu n'as pas ce montant dans votre solde");
                break;
            }


            boolean tourTerminer = false;

            //commencer la partie
            //deux cartes pour le joueur
            joueurLot.piocher(nouveauLot);
            joueurLot.piocher(nouveauLot);

            //deux cartes pour le croupier
            croupierLot.piocher(nouveauLot);
            croupierLot.piocher(nouveauLot);

            while (true){
                //montrer main du joueur
                System.out.println("Ta main : ");
                System.out.print(joueurLot.toString());
                System.out.println("\n\nTa main est d'une valeur de : " + joueurLot.valeurDuTour());

                //montrer main du croupier
                System.out.println("\nLa main du croupier : \n\n"+croupierLot.getCarte(0).toString()+" et [Carte Cachée] \uD83C\uDCA0");

                //choix
                System.out.println("\nTu veux (1)rajouter une carte ou (2)rester sur votre main actuelle?");
                int choix = joueurinput.nextInt();

                if (choix==1){
                    joueurLot.piocher(nouveauLot);
                    System.out.print("Ta nouvelle carte est : ");
                    System.out.print(joueurLot.getCarte(joueurLot.lotSize()-1).toString()+"\n");
                    //perdre le pari si +21
                    if (joueurLot.valeurDuTour()>21){
                        System.out.println("Tu as perdu le pari! Votre main est de :"+joueurLot.valeurDuTour());
                        joueurSolde -= joueurPari;
                        tourTerminer = true;
                        break;
                    }
                }

                if (choix==2){
                    break;
                }
            }

            //voir si le croupier a mieux que le joueur
            System.out.println("La main du Croupier : "+ croupierLot.toString());
            //voir si le croupier a plus que le joueur
            if (croupierLot.valeurDuTour() > joueurLot.valeurDuTour() && tourTerminer == false){
                System.out.println("Dommage! Le croupier à remporter la pari.");
                joueurSolde -= joueurPari;
                tourTerminer = true;
            }

            //croupier tire 17 ou plus
            while ((croupierLot.valeurDuTour()<17) && tourTerminer == false){
                croupierLot.piocher(nouveauLot);
                System.out.println("Le croupier a pioché : "+ croupierLot.getCarte(croupierLot.lotSize()-1).toString());
            }

            //montrer la nouvelle carte du croupier
            System.out.println("La main du Croupier est de :"+ croupierLot.valeurDuTour());
            //voir si le croupier a perdu
            if ((croupierLot.valeurDuTour() > 21) && tourTerminer == false){
                System.out.println("Le croupier a perdu le pari. Tu as gagné "+joueurPari+" MAD !");
                joueurSolde += joueurPari;
                tourTerminer = true;
            }

            // voir si ya une égalité
            if (joueurLot.valeurDuTour()==croupierLot.valeurDuTour() && tourTerminer == false){
                System.out.println("égalité!");
                tourTerminer = true;
            }

            if ((joueurLot.valeurDuTour() > croupierLot.valeurDuTour()) && tourTerminer==false){
                System.out.println("Le croupier a perdu le pari. Tu as gagné "+joueurPari+" MAD !");
                joueurSolde += joueurPari;
                tourTerminer = true;
            }

            //rendre les carte au lot initial
            joueurLot.rajouterAuLotDeCartes(nouveauLot);
            croupierLot.rajouterAuLotDeCartes(nouveauLot);
            System.out.println("La partie est terminée!");

            //on va repeter cette loupe jusqu'a ce que le joueur arrete le pari ou e solde est epuiser.
        }
        //fin du jeu
        System.out.println("Tu n'as plus de d'argent. Alimenter votre solde");
    }
}