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
					System.out.println("(!) ---- ETAPE A MANQUANTE ---- (!)");
				}
			}
			else if(choice.equals("c")){
				if (a_done == true){
					// ---- Jouer à Qui est-ce ? ----
					
					//Lance la partie
					play.IdentifierIndividus(guessWho, path_individus);
					
					//Genere le subgraph avec les arcs indesirables 
					System.out.println("Choisissez trois caracteristique indesirables. "); 
					
					char cheveux = 'r';
					
					while(cheveux == 'r'){
						System.out.println("Couleur de cheveux : "); 
						System.out.println("(a) : Noir"); 
						System.out.println("(b) : Roux"); 
						System.out.println("(c) : Blond"); 
						System.out.println("(d) : Marron");  
						
						switch(br.readLine().toLowerCase()){
							case "a" : cheveux = 'N'; break; 
							case "b" : cheveux = 'R'; break; 
							case "c" : cheveux = 'B'; break; 
							case "d" : cheveux = 'M'; break; 
							default : cheveux = 'r'; break; 
						}
					}
					
					char yeux = 'r'; 
					
					while(yeux == 'r'){ 
						System.out.println("Couleur de yeux : "); 
						System.out.println("(a) : Bleu"); 
						System.out.println("(b) : Vert"); 
						System.out.println("(c) : Noir"); 
						System.out.println("(d) : Gris"); 
						System.out.println("(e) : Marron"); 
						
						switch(br.readLine().toLowerCase()){ 
						case "a" : yeux = 'B'; break; 
						case "b" : yeux = 'V'; break; 
						case "c" : yeux = 'N'; break; 
						case "d" : yeux = 'G'; break; 
						case "e" : yeux = 'M'; break; 
						default : yeux = 'r'; break; 
						}
					}
					
					String departement = "r"; 
					
					while(departement == "r"){ 
						System.out.println("Departement de genie : "); 
						System.out.println("(a) : Genie informatique"); 
						System.out.println("(b) : Genie electrique "); 
						System.out.println("(c) : Genie physique"); 
						System.out.println("(d) : Genie chimique"); 
						System.out.println("(e) : Genie aerospatial"); 
						System.out.println("(f) : Genie mecanique"); 
						System.out.println("(g) : Genie biomedical"); 
						System.out.println("(h) : Genie industriel"); 
						System.out.println("(i) : Genie energetique"); 
						
						switch(br.readLine().toLowerCase()){ 
						case "a" : departement = "GI"; break; 
						case "b" : departement = "GE"; break; 
						case "c" : departement = "GP"; break; 
						case "d" : departement = "GC"; break; 
						case "e" : departement = "GA"; break; 
						case "f" : departement = "GM"; break; 
						case "g" : departement = "GB"; break; 
						case "h" : departement = "GInd"; break; 
						case "i" : departement = "ER"; break; 
						default : yeux = 'r'; break; 
						}
					}
					
					System.out.println("Vous avez choisi les caracterisques indesirables " + String.valueOf(cheveux) + ", " + String.valueOf(yeux) + " et " + departement); 
					
					guessWho.enleverArcsIndesirables(cheveux, yeux, departement); 

					if(play.getIndividuCorrige()[0] != "null" && play.getIndividuCorrige()[1] != "null"){
						guessWho.trouverChaineContacts(play.getIndividuCorrige()[0], play.getIndividuCorrige()[1]);
					}
					else {
						guessWho.trouverChaineContacts(play.getIndividuTrouve()[0], play.getIndividuTrouve()[1]);
					}

					
					c_done = true;
				}
				else {
					System.out.println("(!) ---- ETAPE A MANQUANTE ---- (!)");
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
