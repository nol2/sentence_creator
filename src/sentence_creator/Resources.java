package sentence_creator;

//Just a comment

import java.util.*;

public class Resources {
	
	private ArrayList<String> nouns = new ArrayList<>();
	private ArrayList<Adjectives> adjectives = new ArrayList<>();
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<String> verbs = new ArrayList<>();
	
	private boolean debug;
	private boolean wasNameAlready = false;
	private boolean generateMore = false;
	
	private InputOutput read = new InputOutput();
	
	private int prev_rank = 0;
	
	/**
	 * Constructor, just reads every files into ArrayLists
	 */
	public Resources() {
		readFiles();
	}
	
	/**
	 * Gets the value of boolean debug
	 * @return debug
	 */
	public boolean isDebug() {
		return debug;
	}
	
	/**
	 * If debug is True, then we output the types of each word
	 * @param debug
	 */
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	/**
	 * Reads files into the ArrayLists
	 */
	private void readFiles() {
		InputOutput fileRead = new InputOutput();
		fileRead.read("noun_list.txt", nouns);
		fileRead.read_A("adjective_list.txt", adjectives);
		fileRead.read("name_list.txt", names);
		fileRead.read("verb_list.txt", verbs);
	}
	
	/**
	 * Our driver code, calls every method according to the grammar
	 * <S> -> <NounPhrase><Verb2><NounPhrase>
	 */
	public void sentence() {
		do {
			nounPhrase();
			verb();
			nounPhrase();
			System.out.println();
			readUserInput();
		} while (generateMore);

	}
	
	/**
	 * Gets the <NounPhrase> according to the grammar
	 * <NounPhrase> -> <Name><NounPhrase>
	 * <NounPhrase> -> <Name><Conjunction><NounPhrase>
	 * <NounPhrase> -> <Article><NounGroup>
	 * 
	 */
	private void nounPhrase() {
		Random rd = new Random();
		int which = rd.nextInt(1000);
		if(which<=499) {
			if(!wasNameAlready) {
					this.wasNameAlready = true;
					nameWrite();
					nounPhrase();
				}
			else {
					conjunction();
					nameWrite();
					nounPhrase();
			}
		}
		else {
			article();
			nounGroup();
		}
	}
	
	/**
	 * Prints out a random name from the ArrayList
	 */
	private void nameWrite() {
		if(debug) {
			System.out.print(names.get(randomWord(names.size()))+" (name) ");
		}
		else {
			System.out.print(names.get(randomWord(names.size()))+ " ");
		}
	}
	
	/**
	 * Prints out an "and"
	 */
	private void conjunction() {
		if(debug) {
			System.out.print("and (conjunction) ");
		}
		else {
			System.out.print("and ");
		}
		
	}
	
	/**
	 * Prints out an article
	 * 
	 * TODO: articles rules (a -> nouns starting with a consonant; an -> nouns starting with a vowel) 
	 */
	private void article() {
		Random rd = new Random();
		int which = rd.nextInt(1000);
		if(which<=499) {
			if(debug) {
				System.out.print("a (article) ");
			}
			else {
				System.out.print("a ");
			}
		}
		else {
			if(debug) {
				System.out.print("the (article) ");
			}
			else {
				System.out.print("the ");
			}
		}
	}
	
	/**
	 * Simulates an <NounGroup>
	 * <NounGroup> -> <Noun>
	 * <NounGroup> -> <Adjective><NounGroup>
	 */
	private void nounGroup() {
		Random rd = new Random();
		int which = rd.nextInt(1000);
		if(which<=499) {
			noun();
		}
		else {
			adjective();
			nounGroup();
		}
	}
	
	/**
	 * Prints out a random verb
	 */
	private void verb() {
		if(debug) {
			System.out.print(verbs.get(randomWord(verbs.size()))+" (verb) ");
		}
		else {
			System.out.print(verbs.get(randomWord(verbs.size())) + " ");
		}

	}
	
	/**
	 * Prints out a random noun
	 */
	private void noun() {
		if(debug) {
			System.out.print(nouns.get(randomWord(nouns.size())) + " (noun) ");
		}
		else {
			System.out.print(nouns.get(randomWord(nouns.size())) + " ");
		}
	}
	
	/**
	 * Prints out an adjective
	 * Gets a random adjective from the list, until the rank is right
	 * Rank cannot be lower than the previous rank
	 */
	private void adjective() {
		Adjectives temp = null;
		do {
			temp = adjectives.get(randomWord(adjectives.size()));
		}while(temp.getRank()<prev_rank);
		
		prev_rank = temp.getRank();
		
		if(debug) {
			System.out.print(temp.getAdjective() + " (" + prev_rank + " adjective) ");
		}
		else {
			System.out.print(temp.getAdjective() + " ");
		}

	}
	
	/**
	 * Returns a random int which represents a place in the ArrayList
	 * @param size - the current size of the ArrayList we use
	 * @return index of random word
	 */
	private int randomWord(int size) {
		Random rnd = new Random();
		int place = rnd.nextInt(size);
		return place;
	}
	
	/**
	 * Calls the readUserIO from InputOutput class
	 */
	public void readUserInput() {
		this.wasNameAlready = false;
		this.generateMore = read.readUserIO(this.generateMore);
	}
}
