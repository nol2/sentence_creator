package sentence_creator;

public class Adjectives {
	
	private int rank;
	private String adjective;
	
	public Adjectives(int rank, String adjective) {
		this.rank = rank;
		this.adjective = adjective;
	}
	
	public int getRank() {
		return rank;
	}

	public String getAdjective() {
		return adjective;
	}
	
}
