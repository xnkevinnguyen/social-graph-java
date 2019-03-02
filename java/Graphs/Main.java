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
		String path_enter;
		String path_individus = "/Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Individus.txt";
		String path_relations = "/Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt";
		
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
				path_enter = br.readLine();
				
				// Conserve les paramètres par défaut (plus rapide lors du codage)
				if (!path_enter.equals("")){
					path_individus = path_enter;}
				
				System.out.println("Entrez le chemin d'accès à : Relations.txt");
				System.out.println("Exemple : /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt\n");
				path_enter = br.readLine();
				
				if (!path_enter.equals("")){
					path_relations = path_enter;}
				
				guessWho.creerReseauSocial(path_individus, path_relations);
				System.out.println("Le graph a été créé avec succès");
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
					play.IdentifierIndividus(guessWho, path_individus);
					
					c_done = true;
				}
				else {
					System.out.println("(!) ---- ÉTAPE A MANQUANTE ---- (!)");
				}
				
			}
			else if (choice.equals("d")){
				if (c_done == true){
					
					// ---- Afficher le résultat ----
						//affichage du sous-graphe des carat�ristique d�sirables 
					guessWho.afficherSubGraphMap(); 
						//affichage de la meilleur cha�ne 
					guessWho.afficherChaineContacts();
						//affichage du nombre de question pos�es 
					System.out.println("Nombre de questions pos�es : " + play.getNumberOfQuestionsAsked()); 
						//affichage du nom des individus trouv�s 
					String[] individus = play.getIndividuTrouve(); 
					System.out.println("Individus myst�res trouv�s : " + individus[0] + ", " + individus[1]);
						//affichage du nom des individus qui n'ont pas �t� trouv�s s'il y a lieu 
					if(play.getIndividuCorrige()[0] != "null" && play.getIndividuCorrige()[1] != "null"){
							System.out.println("Individus myst�res non trouv� : " + play.getIndividuCorrige()[0] + ", " + play.getIndividuCorrige()[1]);
					}
						//Les trois caract�ristiques 
					String[] caract�ristiquesInd�sirables = {guessWho.getArcsIndesirables()[0], guessWho.getArcsIndesirables()[1], guessWho.getArcsIndesirables()[2]};  
					System.out.println("Les trois caract�ristiques ind�sirables sont : " + caract�ristiquesInd�sirables[0] + ", " + caract�ristiquesInd�sirables[1] + " et " + caract�ristiquesInd�sirables[2]); 
					
					/*System.out.println("Sous-Graph des caract�ristiques d�sirables:");
					guessWho.enleverArcsIndesirables('B', 'M', "GI");
					guessWho.afficherSubGraphMap();
					guessWho.trouverChaineContacts("adrien", "adilard");
					guessWho.afficherChaineContacts();*/
					
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
