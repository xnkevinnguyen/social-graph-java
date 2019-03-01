package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;


public class Identifier {
	
	// Play the game
	public void IdentifierIndividus(SocialGraph guessWho, String pathIndividus) throws IOException
	{
		String choice;
		SocialGraph social = new SocialGraph();
		String[][] remaningQuestions = {{"B","V","N","G","M"}, {"N","R","B","M"},{"GI","GE","GP","GC","GA","GM","GB","Gind","ER"}};
		Map<String, Individual> suspectList = buildSuspectList(social, pathIndividus);
		
		// Tant que l'agent n'a pas trouvé les deux personnes choisies par l'adversaire
		while(suspectList.size() > 2){
			askRandomQuestions(remaningQuestions);
		}
		
		System.out.println("Je pense que les personne auxquels vous pensez sont :");
		System.out.println(suspectList.keySet());
	}
	
	//Pose une question aléatoire parmis les questions restantes
	public void askRandomQuestions(String[][] remaningQuestions) throws IOException{
		int typeOfQuestion = randInt(0,2);
		int lengthQuestion = randInt(0,remaningQuestions[typeOfQuestion].length-1);
		String questionParameter = remaningQuestions[typeOfQuestion][lengthQuestion];
		String choice;
		
		// La question a déjà été posée
		while (questionParameter == "X")
		{
			typeOfQuestion = randInt(0,2);
			lengthQuestion = randInt(0,remaningQuestions[typeOfQuestion].length);
			questionParameter = remaningQuestions[typeOfQuestion][lengthQuestion];
		}
		
		if(typeOfQuestion == 0){
			choice = EyesColorQuestion(questionParameter.charAt(0));
			// Les paramètres des questions posées sont remplacées par des X
			remaningQuestions[typeOfQuestion][lengthQuestion] = "X";
		}
		else if(typeOfQuestion == 1){
			choice = EyesColorQuestion(questionParameter.charAt(0));
			remaningQuestions[typeOfQuestion][lengthQuestion] = "X";
		}
		else if(typeOfQuestion == 2){
			choice = GenieQuestion(questionParameter);
			remaningQuestions[typeOfQuestion][lengthQuestion] = "X";
		}
		else{
			System.out.println("Il y a une erreur");
		}
	}
	
	// Gère la réponse qu question
	// retourne a,b ou c en fonction de la réponse
	public String getAnswer() throws IOException{
		
		String choice = "null";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(!choice.equals("a") && !choice.equals("b") && !choice.equals("c")){
			
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
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'V'){
			System.out.println("Les individus ont-ils les yeux verts ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'N'){
			System.out.println("Les individus ont-ils les yeux noirs ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'G'){
			System.out.println("Les individus ont-ils les yeux gris ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'M'){
			System.out.println("Les individus ont-ils les yeux marrons ?");
			System.out.println("-----------------------------------------------------------");
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
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'R'){
			System.out.println("Les individus ont-ils les cheveux roux ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'B'){
			System.out.println("Les individus ont-ils les cheveux blonds ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (color == 'M'){
			System.out.println("Les individus ont-ils les cheveux marrons ?");
			System.out.println("-----------------------------------------------------------");
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
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GE")){
			System.out.println("Les individus font-ils partis du génie électrique ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GP")){
			System.out.println("Les individus font-ils partis du génie physique ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GC")){
			System.out.println("Les individus font-ils partis du génie chimique ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GA")){
			System.out.println("Les individus font-ils partis du génie aérospatial ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GM")){
			System.out.println("Les individus font-ils partis du génie mécanique ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GB")){
			System.out.println("Les individus font-ils partis du génie biomédical ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("GInd")){
			System.out.println("Les individus font-ils partis du génie industriel ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else if (genie.equals("ER")){
			System.out.println("Les individus font-ils partis du génie énergétique ?");
			System.out.println("-----------------------------------------------------------");
			return getAnswer();
		}
		else{
			System.out.println("La question est incorrecte");
			return "null";
		}
	}
	
	public  Map<String, Individual>buildSuspectList(SocialGraph social, String path) throws IOException{
		return social.creerIndividus(path);
	}
	
	public static int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}

}
