package Graphs;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		
		SocialGraph guessWho = new SocialGraph();
		
		guessWho.creerReseauSocial("/Users/kevin/Documents/Repositories/social-graph-java/ressources/Individus.txt", "/Users/kevin/Documents/Repositories/social-graph-java/ressources/Relations.txt");

		guessWho.afficherReseauSocial();
	}

}
