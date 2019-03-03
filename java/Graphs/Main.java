package Graphs;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Main {
	public static void main(String[] args) throws IOException {
		
		// ----- Param√®tres individuels -----
		
		/* Kevin : 
		 * - /Users/kevin/Documents/Repositories/social-graph-java/ressources/Individus.txt
		 * - /Users/kevin/Documents/Repositories/social-graph-java/ressources/Relations.txt
		 * No√© : 
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
		
		// ----- Param√®tres Interfaces -----
		String choice = "no choice";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean a_done = false;
		boolean c_done = false;
		
		// ----- Autres param√®tres -----a
		
		SocialGraph guessWho = new SocialGraph();
		Identifier play = new Identifier();
		
		while (!choice.equals("e"))
		{
			
			System.out.println("\n================================");
			System.out.println("|| --------- Welcome -------- ||");
			System.out.println("================================");
			System.out.println("(a) : Cr√©er le r√©seau social");
			System.out.println("(b) : Afficher le r√©seau social");
			System.out.println("(c) : Jouer √† Qui est-ce ?");
			System.out.println("(d) : Afficher le r√©sultat");
			System.out.println("(e) : Quitter");
			System.out.println("\n");
			System.out.print("Votre choix ?		");
			
			choice = br.readLine();
			
			// -- Switch (la r√©elle m√©thode switch ne fonctionne pas avec des String pour les versions < Java7)
			
			if (choice.equals("a")){
				// ---- Cr√©er le r√©seau social ----
				System.out.println("Entrez le chemin d'acc√®s √† : Individus.txt");
				System.out.println("Exemple : /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Individus.txt\n");
				path_enter = br.readLine();
				
				// Conserve les param√®tres par d√©faut (plus rapide lors du codage)
				if (!path_enter.equals("")){
					path_individus = path_enter;}
				
				System.out.println("Entrez le chemin d'acc√®s √† : Relations.txt");
				System.out.println("Exemple : /Users/noefaure/Desktop/Homeworks/social-graph-java/ressources/Relations.txt\n");
				path_enter = br.readLine();
				
				if (!path_enter.equals("")){
					path_relations = path_enter;}
				
				guessWho.creerReseauSocial(path_individus, path_relations);
				System.out.println("Le graph a √©t√© cr√©√© avec succ√®s");
				a_done = true;
			}
			else if (choice.equals("b")){
				
				if (a_done == true){
					// ---- Afficher le r√©seau social ----
					guessWho.afficherReseauSocial();
				}
				else {
					System.out.println("(!) ---- √âTAPE A MANQUANTE ---- (!)");
				}
			}
			else if(choice.equals("c")){
				if (a_done == true){
					// ---- Jouer √† Qui est-ce ? ----
					
					//Lance la partie
					play.IdentifierIndividus(guessWho, path_individus);
					
					c_done = true;
				}
				else {
					System.out.println("(!) ---- √âTAPE A MANQUANTE ---- (!)");
				}
				
			}
			else if (choice.equals("d")){
				if (c_done == true){
					
					// ---- Afficher le r√©sultat ----
						//affichage du sous-graphe des caratÈristique dÈsirables 
					guessWho.afficherSubGraphMap(); 
						//affichage de la meilleur chaÓne 
					guessWho.afficherChaineContacts();
						//affichage du nombre de question posÈes 
					System.out.println("Nombre de questions posÈes : " + play.getNumberOfQuestionsAsked()); 
						//affichage du nom des individus trouvÈs 
					String[] individus = play.getIndividuTrouve(); 
					System.out.println("Individus mystËres trouvÈs : " + individus[0] + ", " + individus[1]);
						//affichage du nom des individus qui n'ont pas ÈtÈ trouvÈs s'il y a lieu 
					if(play.getIndividuCorrige()[0] != "null" && play.getIndividuCorrige()[1] != "null"){
							System.out.println("Individus mystËres non trouvÈ : " + play.getIndividuCorrige()[0] + ", " + play.getIndividuCorrige()[1]);
					}
						//Les trois caractÈristiques 
					String[] caractÈristiquesIndÈsirables = {guessWho.getArcsIndesirables()[0], guessWho.getArcsIndesirables()[1], guessWho.getArcsIndesirables()[2]};  
					System.out.println("Les trois caractÈristiques indÈsirables sont : " + caractÈristiquesIndÈsirables[0] + ", " + caractÈristiquesIndÈsirables[1] + " et " + caractÈristiquesIndÈsirables[2]); 
					
					/*System.out.println("Sous-Graph des caractÔøΩristiques dÔøΩsirables:");
					guessWho.enleverArcsIndesirables('B', 'M', "GI");
					guessWho.afficherSubGraphMap();
					guessWho.trouverChaineContacts("adrien", "adilard");
					guessWho.afficherChaineContacts();*/
					
				}
				else {
					System.out.println("(!) ---- √âTAPE C MANQUANTE ---- (!)");
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
