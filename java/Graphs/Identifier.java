package Graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
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
		// Et que toutes les questions possibles n'ont pas été posées
		while(suspectList.size() > 2 && CheckIfEndQuestions(remaningQuestions) != true){
			askRandomQuestions(remaningQuestions, suspectList);
		}
		
		System.out.println("Je pense que les personnes auxquels vous pensez sont :");
		System.out.println(suspectList.keySet());
	}
	
	//Pose une question aléatoire parmis les questions restantes
	public void askRandomQuestions(String[][] remaningQuestions, Map<String, Individual> suspectList) throws IOException{
		int typeOfQuestion = randInt(0,2);
		int lengthQuestion = randInt(0,remaningQuestions[typeOfQuestion].length-1);
		String questionParameter = remaningQuestions[typeOfQuestion][lengthQuestion];
		String choice;
		
		// La question a déjà été posée
		while (questionParameter == "X")
		{
			typeOfQuestion = randInt(0,2);
			lengthQuestion = randInt(0,remaningQuestions[typeOfQuestion].length-1);
			
			questionParameter = remaningQuestions[typeOfQuestion][lengthQuestion];
		}
		
		if(typeOfQuestion == 0){
			choice = EyesColorQuestion(questionParameter.charAt(0));
			manageChoice(choice, suspectList, typeOfQuestion, questionParameter, remaningQuestions);
			// Les paramètres des questions posées sont remplacées par des X
			remaningQuestions[typeOfQuestion][lengthQuestion] = "X";
			
			//On enlèves les individus qui ne correspondent pas aux critères
		}
		else if(typeOfQuestion == 1){
			choice = HairColorQuestion(questionParameter.charAt(0));
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
	
	public boolean CheckIfEndQuestions(String[][] remaningQuestions){
		
		boolean check = true;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < remaningQuestions[i].length; j++) {
				  if (!(remaningQuestions[i][j]).equals("X")){
					  check = false;
					  break;
				  }
				}
			}
		
		return check;
	}
	
	public void manageChoice(String choice, Map<String, Individual> suspectList, int typeOfCriterion, String parameter, String[][] remaningQuestions){
		
		if(choice.equals("a")){
			theyBothGetCriterion(suspectList, typeOfCriterion, parameter, remaningQuestions);
		}
		else if(choice.equals("b")){
			// On ne peut rien déduire
		}
		else if(choice.equals("c")){
			
		}
		else{
			System.out.println("Entrée incorecte");
		}
	}
	
	public void theyBothGetCriterion(Map<String, Individual> suspectList, int typeOfCriterion, String parameter, String[][] remaningQuestions){

		for (Map.Entry<String, Individual> entry : suspectList.entrySet()) {
		    String key = entry.getKey();
		    Individual value = entry.getValue();
		    
		    //Couleur des yeux
		    if (typeOfCriterion == 0){
		    	char color = value.getEyesColor();
		    	//Si l'individu n'a pas le critère on le supprime de la liste
		    	if (color != parameter.charAt(0)){
		    		suspectList.remove(key);
		    		noAskingAnymore(remaningQuestions, typeOfCriterion);
		    	}
		    }
		    //Couleur des cheveux
		    else if(typeOfCriterion == 1){
		    	char color = value.getHairColor();
		    	//Si l'individu n'a pas le critère on le supprime de la liste
		    	if (color != parameter.charAt(0)){
		    		suspectList.remove(key);
		    		noAskingAnymore(remaningQuestions, typeOfCriterion);
		    	}
		    	
		    }
		    //Génie
		    else if(typeOfCriterion == 2){
		    	String genius = value.getDepartment();
		    	//Si l'individu n'a pas le critère on le supprime de la liste
		    	if (genius != parameter){
		    		suspectList.remove(key);
		    		noAskingAnymore(remaningQuestions, typeOfCriterion);
		    	}
		    	
		    }
		}
	}
	
	public void noAskingAnymore(String[][] remaningQuestions, int index){
		for (int i = 0; i < remaningQuestions[index].length; i++) {
			remaningQuestions[index][i] = "X";
		}
	}

}
