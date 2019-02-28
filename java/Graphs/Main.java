package Graphs;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// ----- Paramètres individuels -----
		
		/* Kevin : 
		 * - /Users/kevin/Documents/Repositories/social-graph-java/ressources/Individus.txt
		 * - /Users/kevin/Documents/Repositories/social-graph-java/ressources/Relations.txt
		 * Noé : 
		 * - /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Individus.txt
		 * - /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt
		 * 
		 * - C:\Users\youce\OneDrive\Cours\LOG2810\TP1\social-graph-java\ressources\Individus.txt
		 * - C:\Users\youce\OneDrive\Cours\LOG2810\TP1\social-graph-java\ressources\Relations.txt
		 */
		
		// ----- Paths -----
		String path_individus = "";
		String path_relations = "";
		
		// ----- Paramètres Interfaces -----
		String choice = "no choice";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean a_done = false;
		boolean c_done = false;
		
		// ----- Autres paramètres -----a
		
		SocialGraph guessWho = new SocialGraph();
		Identifier play = new Identifier();
		
		while (!choice.equals("e"))
		{
			
			System.out.println("\n================================");
			System.out.println("|| --------- Welcome -------- ||");
			System.out.println("================================");
			System.out.println("(a) : Créer le réseau social");
			System.out.println("(b) : Afficher le réseau social");
			System.out.println("(c) : Jouer à Qui est-ce ?");
			System.out.println("(d) : Afficher le résultat");
			System.out.println("(e) : Quitter");
			System.out.println("\n");
			System.out.print("Votre choix ?		");
			
			choice = br.readLine();
			
			// -- Switch (la réelle méthode switch ne fonctionne pas avec des String pour les versions < Java7)
			
			if (choice.equals("a")){
				// ---- Créer le réseau social ----
				System.out.println("Entrez le chemin d'accès à : Individus.txt");
				System.out.println("Exemple : /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Individus.txt\n");
				path_individus = br.readLine();
				System.out.println("Entrez le chemin d'accès à : Relations.txt");
				System.out.println("Exemple : /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt\n");
				path_relations = br.readLine();
				
				guessWho.creerReseauSocial(path_individus, path_relations);
				a_done = true;
			}
			else if (choice.equals("b")){
				
				if (a_done == true){
					// ---- Afficher le réseau social ----
					guessWho.afficherReseauSocial();
				}
				else {
					System.out.println("(!) ---- ÉTAPE A MANQUANTE ---- (!)");
				}
			}
			else if(choice.equals("c")){
				if (a_done == true){
					// ---- Jouer à Qui est-ce ? ----
					
					//Lance la partie
					play.IdentifierIndividus(guessWho);
					
					c_done = true;
				}
				else {
					System.out.println("(!) ---- ÉTAPE A MANQUANTE ---- (!)");
				}
				
			}
			else if (choice.equals("d")){
				if (c_done == true){
					// ---- Afficher le résultat ----
					System.out.println("Sous-Graph des caract�ristiques d�sirables:");
					guessWho.enleverArcsIndesirables('B', 'M', "GI");
					guessWho.afficherSubGraphMap();
					guessWho.trouverChaineContacts("adrien", "adilard");
					guessWho.afficherChaineContacts();
					
				}
				else {
					System.out.println("(!) ---- ÉTAPE C MANQUANTE ---- (!)");
				}
			}
			
			else if(choice.equals("e")){
				// ---- Quitter ----
				System.out.println("Au revoir !");
			}
			
			else if(choice.equals("s")){
				// ---- Quitter ----
				System.out.println("Au revoir !");
			}
			
			else{
				System.out.println("\n--------------------------------");
				System.out.println("(!) ---- INDEX INVALIDE ---- (!)");
			}
		}
		
	}

}
