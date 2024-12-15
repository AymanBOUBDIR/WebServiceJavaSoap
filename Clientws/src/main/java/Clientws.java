import proxy.BanqueService;
import proxy.BanqueWS;
import proxy.Compte;

import java.util.List;
import java.util.Scanner;

public class Clientws {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWS().getBanqueServicePort();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le montant en Euros à convertir en Dirhams : ");
        double amountInEuros = scanner.nextDouble();
        double amountInDh = proxy.conversionEuroToDh(amountInEuros);
        System.out.println("Montant Converti : " + amountInDh);
        System.out.println("----------------recherche methode getCompte----------------------- ");
        // Obtenir l'ID du compte de l'utilisateur
        System.out.print("Entrez l'ID du compte à récupérer : ");
        int accountId = scanner.nextInt();
        Compte cp = proxy.getCompte(accountId);
        System.out.println("----------------------");
        System.out.println("Solde du Compte : " + cp.getSolde());
        System.out.println("Date de Création du Compte : " + cp.getDateCration());
        System.out.println("Code du Compte : " + cp.getCode());
        System.out.println("-----------------------");
        System.out.print("----------------Recuperation methode listComptes ----------------------- ");
        List<Compte> compteList = proxy.listComptes();
        compteList.forEach(c -> {
            System.out.println("----------------------");
            System.out.println("Solde du Compte : " + c.getSolde());
            System.out.println("Date de Création du Compte : " + c.getDateCration());
            System.out.println("Code du Compte : " + c.getCode());
            System.out.println("-----------------------");
        });

        // Fermer le scanner
        scanner.close();
    }
}
