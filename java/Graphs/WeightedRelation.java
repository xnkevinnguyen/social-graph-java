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

	public WeightedRelation( Individual individual,int weight, boolean isSecondInstance) {
		super();
		this.weight = weight;
		this.individual = individual;
		this.isSeconInstance=isSecondInstance;
	}
	
	public WeightedRelation(WeightedRelation original) {
		super();
		this.weight = original.weight;
		this.individual = original.individual;
		this.isSeconInstance = original.isSeconInstance;
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
