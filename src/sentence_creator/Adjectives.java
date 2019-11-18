package sentence_creator;

public class Adjectives {
	
	/**
	 * Rank represents the order of the adjective
	 * 0 Quantity or number.
	 * 1 Quality or opinion.
	 * 2 Size.
	 * 2 Age.
	 * 4 Shape.
	 * 5 Colour.
	 * 6 Proper adjective (often nationality, other place of origin, or material).
	 * 7 Purpose or qualifier.
	 */
	private int rank;
	private String adjective;
	
	/**
	 * Constructor for Adjective class
	 * @param rank - order
	 * @param adjective - actual String of Adjective
	 */
	public Adjectives(int rank, String adjective) {
		this.rank = rank;
		this.adjective = adjective;
	}
	
	/**
	 * Returns the rank of the adjective
	 * @return int rank
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns the adjective
	 * @return String adjective
	 */
	public String getAdjective() {
		return adjective;
	}
	
}
