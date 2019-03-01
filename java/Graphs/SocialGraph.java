package Graphs;


import java.io.*;
import java.util.*;

public class SocialGraph {
	private Map<String, Individual> graphMap;
	private Map<String, Individual> subGraphMap;
	private Individual personneSource;
	private Individual personneDestination;
	

	/*
	 * Input: name of files for the list of individual and the list of relations
	 * This function will read the file and create a social graph
	 */

	public SocialGraph() {
		super();
	}
	

	public Map<String, Individual> getGraphMap() {
		return graphMap;
	}


	public Map<String, Individual> getSubGraphMap() {
		return subGraphMap;
	}


	public void creerReseauSocial(String nomFichierIndividu, String nomFichierRelation) throws IOException {

		Map<String, Individual> listIndividus = creerIndividus(nomFichierIndividu);

		this.graphMap = listIndividus;

		this.creerRelations(nomFichierRelation);

	}

	public Map<String, Individual> creerIndividus(String nomFichierIndividu) throws IOException {
		BufferedReader lecture = initierLecture(nomFichierIndividu);

		String line;

		Map<String, Individual> listIndividuals = new HashMap<String, Individual>();

		while ((line = lecture.readLine()) != null) {
			//System.out.println(line);
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
			//System.out.println(line);
			String[] inputs = line.split(" ");
			this.rajouterRelationDeuxDirection(inputs[0], inputs[2], Integer.parseInt(inputs[1]));
	
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
	

	/*==============================================================================================================
	||C4. �crire une fonction � enleverArcsIndesirables() � o� l�agent g�n�re le sous-graphe des caract�ristiques||
	||d�sirables. Cette fonction prend en param�tre trois caract�ristiques ind�sirables.						 ||
	==============================================================================================================*/
	public Map<String, Individual> cloneMap(){
		
		Map<String, Individual> subGraph = new HashMap<String, Individual>();
	    for (Map.Entry<String, Individual> entry : graphMap.entrySet()) {
	    	Individual ind = new Individual();
	    	
	    	Integer subDistance = entry.getValue().getDistance();
	    	List<Individual> subShortestPath = new LinkedList<>();
	    	for (Individual person : entry.getValue().getShortestPath()) {
	    		subShortestPath.add(new Individual(person));
	    	}
	    	
	    	ind.setName(entry.getValue().getName());
	    	ind.setHairColor(entry.getValue().getHairColor());
	    	ind.setEyesColor(entry.getValue().getEyesColor());
	    	ind.setDepartment(entry.getValue().getDepartment());
	    	ind.setDistance(subDistance);
	    	ind.setShortestPath(subShortestPath);
	    	subGraph.put(entry.getKey(), ind);
	    }
	    for (Map.Entry<String, Individual> entry : subGraph.entrySet()) {
	    	String entryName = entry.getValue().getName();
	    	WeightedRelation[] arr = graphMap.get(entryName).getRelations().toArray(new WeightedRelation[graphMap.get(entryName).getRelations().size()]);
	    	int i = 0;
	    	Stack<WeightedRelation> subRelations= new Stack<WeightedRelation>();
	    	for(int j = 0 ; j<graphMap.get(entryName).getRelations().size(); j++)
			{
				subRelations.push(new WeightedRelation(subGraph.get(arr[i].getIndividual().getName()),new Integer(arr[i].getWeight()), arr[i].isSeconInstance));
				i++;
			}
	    	entry.getValue().setRelations(subRelations);
	    }
		return subGraph;
	}
	
	
	public void enleverArcsIndesirables(char cheveux, char yeux, String departement)
	{
	    Map<String, Individual> subGraph = cloneMap();
		for (Map.Entry<String, Individual> individual : subGraph.entrySet()) {
			for (WeightedRelation relation : individual.getValue().relations) {
					if (cheveux == individual.getValue().getHairColor() && cheveux == relation.getIndividual().getHairColor())
						relation.setWeight(0);
					if (yeux == individual.getValue().getEyesColor() && yeux == relation.getIndividual().getEyesColor()) 
						relation.setWeight(0);
					if (departement == individual.getValue().getDepartment() && departement == relation.getIndividual().getDepartment())
						relation.setWeight(0);
			}
		}
		subGraphMap = subGraph;
	}
	
	public void afficherSubGraphMap() {
		for (Map.Entry<String, Individual> individual : subGraphMap.entrySet()) {

			for (WeightedRelation relation : individual.getValue().relations) {
				if(!relation.isSeconInstance)
				System.out.println("(" + individual.getValue().getName() + ", " + relation.getIndividual().getName() + ", "+ relation.getWeight()+ ")");
			}
		}

	}
	
	/*=======================================================================================================
	|| C5. �crire une fonction � trouverChaineContacts() � o� l�agent trouve la meilleure cha�ne de contacts||
	||entre deux individus � partir du sous-graphe des caract�ristiques d�sirables. Cette fonction prend    ||
	||en param�tre deux noms d�individus.																	||
	=========================================================================================================*/
	
	private static Individual getLowestDistanceNode(Set < Individual > unsettledNodes) {
	    Individual lowestDistanceNode = null;
	    int lowestDistance = Integer.MAX_VALUE;
	    for (Individual node: unsettledNodes) {
	        int nodeDistance = node.getDistance();
	        if (nodeDistance < lowestDistance && nodeDistance != 0) {
	            lowestDistance = nodeDistance;
	            lowestDistanceNode = node;
	        }
	    }
	    return lowestDistanceNode;
	}
	
	private static void calculateMinimumDistance(Individual evaluationNode,Integer edgeWeigh, Individual sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		    if (sourceDistance + edgeWeigh < evaluationNode.getDistance() && edgeWeigh != 0) {
		        evaluationNode.setDistance(sourceDistance + edgeWeigh);
		        LinkedList<Individual> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
		        shortestPath.add(sourceNode);
		        evaluationNode.setShortestPath(shortestPath);
		    }
	}
	
	
	private Map<String, Individual> calculateShortestPathFromSource(Map<String, Individual> subGraphMap, String name)
	{
	    
		Individual source = subGraphMap.get(name);
		source.setDistance(1);
	    Set<Individual> settledNodes = new HashSet<>();
	    Set<Individual> unsettledNodes = new HashSet<>();
	    unsettledNodes.add(source);
	    while (unsettledNodes.size() != 0) {
	        Individual currentNode = getLowestDistanceNode(unsettledNodes);
	        if (currentNode == null)
	        	break;
	        unsettledNodes.remove(currentNode);
	        Iterator<WeightedRelation> itr = currentNode.getRelations().iterator();
	        while(itr.hasNext()) {
	        	WeightedRelation relation = itr.next();
	        	Individual adjacentNode = relation.getIndividual();
	        	Integer edgeWeight = relation.getWeight();
	            if (!settledNodes.contains(adjacentNode)) {
	                calculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
	                	unsettledNodes.add(adjacentNode);
	            }
	        }
	        settledNodes.add(currentNode);
	    }
	    return subGraphMap;
	}
	
	public void trouverChaineContacts(String name1, String name2)
	{
		Map<String, Individual> subGraph = this.calculateShortestPathFromSource(subGraphMap, name1);
		personneSource = subGraph.get(name1);
		personneDestination = subGraph.get(name2);
	}
	
	
	public void afficherChaineContacts()
	{
		List<Individual> shortestPath = personneDestination.getShortestPath();
		if (shortestPath.isEmpty()) {
			System.out.println("Pas de cha�ne possible entre " + personneSource.getName() + " et " + personneDestination.getName());
		}
		else {
			for (int i=0; i < shortestPath.size(); i++) {
				System.out.print(shortestPath.get(i).getName() + " --> ");	
			}
			System.out.println(personneDestination.getName());
		}
	}


}



 

