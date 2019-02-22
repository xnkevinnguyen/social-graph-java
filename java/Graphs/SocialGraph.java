package Graphs;


import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class SocialGraph {
	private Map<String, Individual> graphMap;

	/*
	 * Input: name of files for the list of individual and the list of relations
	 * This function will read the file and create a social graph
	 */

	public SocialGraph() {
		super();
	}

	

	public void creerReseauSocial(String nomFichierIndividu, String nomFichierRelation) throws IOException {

		Map<String, Individual> listIndividus = creerIndividus(nomFichierIndividu);
		System.out.print("a");
		this.graphMap = listIndividus;

		this.creerRelations(nomFichierRelation);

	}

	public Map<String, Individual> creerIndividus(String nomFichierIndividu) throws IOException {
		BufferedReader lecture = initierLecture(nomFichierIndividu);

		String line;

		Map<String, Individual> listIndividuals = new HashMap<String, Individual>();

		while ((line = lecture.readLine()) != null) {
			System.out.println(line);
			String[] inputs = line.split(" ");

			Individual newIndividual = new Individual(inputs[0].toLowerCase(), inputs[1].charAt(0), inputs[2].charAt(0), inputs[3]);
			listIndividuals.put(newIndividual.getName(), newIndividual);
		}

		return listIndividuals;
	}

	public void creerRelations(String nomFichierRelation) throws IOException {
		BufferedReader lecture = initierLecture(nomFichierRelation);
		String line;

		while ((line = lecture.readLine()) != null) {
			System.out.println(line);
			String[] inputs = line.split(" ");
			this.rajouterRelationDeuxDirection(inputs[0], inputs[2], Integer.parseInt(inputs[1]));
			;
		}

	}

	public void rajouterRelationDeuxDirection(String nameA, String nameB, int weight) {
		this.rajouterRelationUneDirection(nameA, nameB, weight, false);
		this.rajouterRelationUneDirection(nameB, nameA, weight, true);

	}
	public void rajouterRelationUneDirection(String nameA, String nameB, int weight, Boolean isSecondInstance) {
		Individual individual= this.graphMap.get(nameA.toLowerCase()); 
		WeightedRelation nouvelleRelation=new WeightedRelation(this.graphMap.get(nameB.toLowerCase()), weight, isSecondInstance);
		individual.addRelation(nouvelleRelation);

	}

	public BufferedReader initierLecture(String nomFichierIndividu) throws FileNotFoundException {

		File file = new File(nomFichierIndividu);
		FileReader fr;
		fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);

		return br;

	}

	/*
	 * Prints out the social graph on terminal
	 */
	public void afficherReseauSocial() {
		for (Map.Entry<String, Individual> individual : graphMap.entrySet()) {

			for (WeightedRelation relation : individual.getValue().relations) {
				if(!relation.isSeconInstance)
				System.out.println("(" + individual.getValue().getName() + ", " + relation.getIndividual().getName() + ", "+ relation.getWeight()+ ")");
			}
		}

	}

}
