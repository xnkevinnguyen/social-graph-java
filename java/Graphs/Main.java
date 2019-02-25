package Graphs;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// ----- Paramètres individuels -----
		
		/* Kevin : 
		 * - /Users/kevin/Documents/Repositories/social-graph-java/ressources/Individus.txt
		 * - /Users/kevin/Documents/Repositories/social-graph-java/ressources/Relations.txt
		 * Noé : 
		 * - /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Individus.txt
		 * - /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt
		 */
		
		String path_individus = "/Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Individus.txt";
		String path_relations = "/Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt";
		
		// ----- Paramètres Interfaces -----
		String choice = "no choice";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean a_done = false;
		boolean c_done = false;
		
		// ----- Autres paramètres -----
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
					// Sélectionne deux individus au hasard
					//Individual first_people = play.SelectARandomPeople(guessWho);
					//Individual second_people = play.SelectARandomPeople(guessWho);
					
					//Lance la partie
					//play.IdentifierIndividus(first_people, second_people);
					
					c_done = true;
				}
				else {
					System.out.println("(!) ---- ÉTAPE A MANQUANTE ---- (!)");
				}
				
			}
			else if (choice.equals("d")){
				if (c_done == true){
					// ---- Afficher le résultat ----
					
				}
				else {
					System.out.println("(!) ---- ÉTAPE C MANQUANTE ---- (!)");
				}
			}
			
			else if(choice.equals("e")){
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
