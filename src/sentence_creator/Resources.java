package sentence_creator;

import java.util.*;

public class Resources {
	
	private ArrayList<String> nouns = new ArrayList<>();
	private ArrayList<Adjectives> adjectives = new ArrayList<>();
	private ArrayList<String> names = new ArrayList<>();
	private ArrayList<String> verbs = new ArrayList<>();
	
	private boolean debug;
	private boolean wasNameAlready = false;
	private boolean generateMore = false;
	
	private int prev_rank = 0;
	
	public Resources() {
		readFiles();
	}
	
	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	private void readFiles() {
		InputOutput fileRead = new InputOutput();
		fileRead.read("noun_list.txt", nouns);
		fileRead.read_A("adjective_list.txt", adjectives);
		fileRead.read("name_list.txt", names);
		fileRead.read("verb_list.txt", verbs);
	}
	
	public void sentence() {
		do {
			nounPhrase();
			verb();
			nounPhrase();
			System.out.println();
			//readUserInput(); needs resolving, does not read it the second time
		} while (generateMore);

	}
	
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
	
	private void nameWrite() {
		if(debug) {
			System.out.print(names.get(randomWord(names.size()))+" (name) ");
		}
		else {
			System.out.print(names.get(randomWord(names.size()))+ " ");
		}
	}
	
	private void conjunction() {
		if(debug) {
			System.out.print("and (conjunction) ");
		}
		else {
			System.out.print("and ");
		}
		
	}
	
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
	
	private void verb() {
		if(debug) {
			System.out.print(verbs.get(randomWord(verbs.size()))+" (verb) ");
		}
		else {
			System.out.print(verbs.get(randomWord(verbs.size())) + " ");
		}

	}
	
	private void noun() {
		if(debug) {
			System.out.print(nouns.get(randomWord(nouns.size())) + " (noun) ");
		}
		else {
			System.out.print(nouns.get(randomWord(nouns.size())) + " ");
		}
	}
	
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
	
	private int randomWord(int size) {
		Random rnd = new Random();
		int place = rnd.nextInt(size);
		return place;
	}
	
	public void readUserInput() {
		InputOutput read = new InputOutput();
		this.generateMore = read.readUserIO();
	}
}
