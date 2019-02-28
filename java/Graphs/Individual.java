package Graphs;

import java.util.*;

public class Individual {
	private String name;
	private char hairColor;
	private char eyesColor;
	private String department;
	Stack<WeightedRelation> relations= new Stack<WeightedRelation>();
    private List<Individual> shortestPath = new LinkedList<>();
    private Integer distance = Integer.MAX_VALUE;
	
	public Individual() {
		super();
	}
	
	public Individual(Individual copy) {
		super();
		this.name = copy.name;
		this.hairColor = copy.hairColor;
		this.eyesColor = copy.eyesColor;
		this.department = copy.department;
		this.relations = copy.relations;
		this.shortestPath = copy.shortestPath;
		this.distance = copy.distance;
	}
	
	public Individual(String name, char hairColor, char eyesColor, String department) {
		super();
		this.name = name;
		this.hairColor = hairColor;
		this.eyesColor = eyesColor;
		this.department = department;
		//this.relations = new Stack<WeightedRelation> ();
	}
	
	public Stack<WeightedRelation> getRelations() {
		return relations;
	}

	public void setRelations(Stack<WeightedRelation> relations) {
		this.relations = relations;
	}
	
	public void addRelation(WeightedRelation relation) {
		this.relations.push(relation);
	}
	
	public List<Individual> getShortestPath() {
		return shortestPath;
	}
	
	public void setShortestPath(List<Individual> shortestPath) {
		this.shortestPath = shortestPath;
	}
	
	public Integer getDistance() {
		return distance;
	}
	
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	public char getHairColor() {
		return hairColor;
	}
	
	public void setHairColor(char hairColor) {
		this.hairColor = hairColor;
	}
	
	public char getEyesColor() {
		return eyesColor;
	}
	
	public void setEyesColor(char eyesColor) {
		this.eyesColor = eyesColor;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}

	public Individual(String name) {
		super();
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() {
		System.out.print(name);
	}

}
