package sentence_creator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class InputOutput {
	
	private static Scanner sc = null;
	
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
	
	public boolean readUserIO() {
		boolean rightAnswer = false;
		boolean whatto_return = false;
		try {
			sc = new Scanner(System.in);
			String answer = null;
			do {
				System.out.println("Generate one more? Y/N : ");
				answer = System.console().readLine();
				if(answer.equals("Y") || answer.equals("N")) {
					rightAnswer = true;
					if(answer.equals("Y")) {
						whatto_return = true;
					}
					else {
						whatto_return = false;
					}
				}
				else {
					System.out.println("Did not understand your answer, try again!");
				}
			} while (!rightAnswer);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		sc.close();
		return whatto_return;
	}
}
