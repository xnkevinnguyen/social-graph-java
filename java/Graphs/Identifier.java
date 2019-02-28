package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Identifier {
	
	// Play the game
	public void IdentifierIndividus(SocialGraph guessWho)
	{
		boolean end = false;
		
		// Tant que l'agent n'a pas trouver les deux personne choisie par l'adversaire
		while(end != true){
			
			
		}
	}
	
	// Gère la réponse qu question
	// retourne a,b ou c en fonction de la réponse
	public String getAnswer() throws IOException{
		
		String choice = "null";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(!choice.equals("a") && !choice.equals("b") && !choice.equals("c")){
			
			System.out.println("\n");
			System.out.println("a : Oui pour les deux individus");
			System.out.println("b : Oui pour un seul individu");
			System.out.println("c : Non pour les deux individus");
			
			choice = br.readLine();
		}
		
		return choice;
	}
	
	// Pose la question de la couleur des yeux pour la couleur passé en paramètre
	public String EyesColorQuestion(char color) throws IOException{
		
		if (color == 'B'){
			System.out.println("Les individus ont-ils les yeux bleus ?");
			return getAnswer();
		}
		else if (color == 'V'){
			System.out.println("Les individus ont-ils les yeux verts ?");
			return getAnswer();
		}
		else if (color == 'N'){
			System.out.println("Les individus ont-ils les yeux noirs ?");
			return getAnswer();
		}
		else if (color == 'G'){
			System.out.println("Les individus ont-ils les yeux gris ?");
			return getAnswer();
		}
		else if (color == 'M'){
			System.out.println("Les individus ont-ils les yeux marrons ?");
			return getAnswer();
		}
		else{
			System.out.println("La question est incorrecte");
			return "null";
		}
	}
	
	// Pose la question de la couleur des cheveux pour la couleur passé en paramètre
	public String HairColorQuestion(char color) throws IOException{
		
		if (color == 'N'){
			System.out.println("Les individus ont-ils les cheuveux noirs ?");
			return getAnswer();
		}
		else if (color == 'R'){
			System.out.println("Les individus ont-ils les cheveux roux ?");
			return getAnswer();
		}
		else if (color == 'B'){
			System.out.println("Les individus ont-ils les cheveux blonds ?");
			return getAnswer();
		}
		else if (color == 'M'){
			System.out.println("Les individus ont-ils les cheveux marrons ?");
			return getAnswer();
		}
		else{
			System.out.println("La question est incorrecte");
			return "null";
		}
	}
	
	// Pose la question du génie pour l'identifiant passé en paramètre
	public String GenieQuestion(String genie) throws IOException{
		
		if (genie.equals("GI")){
			System.out.println("Les individus font-ils partis du génie informatique ?");
			return getAnswer();
		}
		else if (genie.equals("GE")){
			System.out.println("Les individus font-ils partis du génie électrique ?");
			return getAnswer();
		}
		else if (genie.equals("GP")){
			System.out.println("Les individus font-ils partis du génie physique ?");
			return getAnswer();
		}
		else if (genie.equals("GC")){
			System.out.println("Les individus font-ils partis du génie chimique ?");
			return getAnswer();
		}
		else if (genie.equals("GA")){
			System.out.println("Les individus font-ils partis du génie aérospatial ?");
			return getAnswer();
		}
		else if (genie.equals("GM")){
			System.out.println("Les individus font-ils partis du génie mécanique ?");
			return getAnswer();
		}
		else if (genie.equals("GB")){
			System.out.println("Les individus font-ils partis du génie biomédical ?");
			return getAnswer();
		}
		else if (genie.equals("GInd")){
			System.out.println("Les individus font-ils partis du génie industriel ?");
			return getAnswer();
		}
		else if (genie.equals("ER")){
			System.out.println("Les individus font-ils partis du génie énergétique ?");
			return getAnswer();
		}
		else{
			System.out.println("La question est incorrecte");
			return "null";
		}
	}

}
