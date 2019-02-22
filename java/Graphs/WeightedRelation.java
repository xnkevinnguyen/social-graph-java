package Graphs;

public class WeightedRelation {
	int weight;
	Individual individual;
	/*There is two instances of a relation
	 * Example: Sophie -> Marie (First Instance)
	 * Marie ->Sophie (Second Instance)
	 * We do not print second instances
	 */
	Boolean isSeconInstance;

	public WeightedRelation(int weight, Individual individual) {
		super();
		this.weight = weight;
		this.individual = individual;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Individual getIndividual() {
		return individual;
	}

	public void setIndividual(Individual individual) {
		this.individual = individual;
	}

}
