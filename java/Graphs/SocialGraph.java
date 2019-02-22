package Graphs;

import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.io.*;

public class SocialGraph<Type> {
	private Map<Individual, List<WeightedRelation>> graphMap;

	public SocialGraph() {

	}

	/*
	 * Input: name of files for the list of individual and the list of relations
	 * This function will read the file and create a social graph
	 */

	public void creerReseauSocial(String nomFichierIndividu, String nomFichierRelation) throws IOException {

		List<Individual> listIndividus =creerIndividus(nomFichierIndividu);
		Map <String, List<WeightedRelation>> listRelations= creerRelations(nomFichierRelation);

	}

	public List<Individual> creerIndividus(String nomFichierIndividu) throws IOException {
		BufferedReader lecture = initierLecture(nomFichierIndividu);

		String line;

		List<Individual> listIndividuals = new Stack<Individual>();

		while ((line = lecture.readLine()) != null) {
			System.out.println(line);
			String[] inputs = line.split(" ");

			Individual newIndividual = new Individual(inputs[0], inputs[1].charAt(0), inputs[2].charAt(0), inputs[3]);
			listIndividuals.add(newIndividual);
		}

		return listIndividuals;
	}
	
	public Map<String, List<WeightedRelation>> creerRelations(string nomFichierRelation){
		
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
		for (Map.Entry<Individual, List<WeightedRelation>> individualRelation : graphMap.entrySet()) {

			for (WeightedRelation relation : individualRelation.getValue()) {
				System.out.print("(" + individualRelation.getKey() + "," + relation.getIndividual().getName() + ",");
			}
		}

	}

}
