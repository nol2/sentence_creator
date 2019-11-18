package sentence_creator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputOutput {
	
	private static Scanner sc = null;
	
	/**
	 * Reads a file into an ArrayList
	 * The file need to be formatted into one line with delimiters of ';'
	 * @param file - the file which we want to read in
	 * @param list - the ArrayList which we store the data
	 */
	public void read(String file, ArrayList<String> list) {
			try {
				sc = new Scanner(new File(file));
				while(sc.hasNextLine()) {
					StringTokenizer st = new StringTokenizer(sc.nextLine(),";");
					while(st.hasMoreTokens()) {
						list.add(st.nextToken());
					}
				}
				
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			finally {
				if(sc!=null) {
					sc.close();
				}
				System.out.println("Read OK " + file);
			}
	}
	
	/**
	 * Reads the file into an ArrayList of Adjective classes, and creates an Adjective class for each adjective
	 * The file need to be formatted into one line with delimiters of ';'
	 * @param file - the file which we want to read in
	 * @param adjectives - an ArrayList of Adjective classes
	 */
	public void read_A(String file, ArrayList<Adjectives> adjectives) {
		int current_index = 0;
		String temp = "";
		Adjectives adj_temp = null;
		try {
			sc = new Scanner(new File(file));
			while(sc.hasNextLine()) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(),";");
				while(st.hasMoreTokens()) {
					current_index = Integer.parseInt(st.nextToken());
					temp = st.nextToken();
					adj_temp = new Adjectives(current_index,temp);
					adjectives.add(adj_temp);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if(sc!=null) {
				sc.close();
			}
			System.out.println("Read OK adjective_list.txt");
		}
	}
	
	/**
	 * Handles user input for generating more sentences
	 * @param generateMore - current boolean for generating more
	 * @return boolean for generating more, True if we want to generate more
	 */
	public boolean readUserIO(boolean generateMore) {
		boolean correctAnswer = false;
		do {
			generateMore = false;
			System.out.println("\nGenerate more? Y/N:");
			Scanner sc = new Scanner(System.in);
			String answer = sc.nextLine();
			if(answer.equals("Y") || answer.equals("N")) {
				correctAnswer = true;
				if(answer.equals("Y")) {
					generateMore = true;
				}
				else {
					sc.close();
					System.out.println("Exiting...");
				}
			}
			else {
				System.out.println("Wrong input!");
			}
		}while(!correctAnswer);
		
		
		
		return generateMore;
	}
}
