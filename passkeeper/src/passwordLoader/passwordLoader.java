package passwordLoader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class passwordLoader {
	//List to load the passwords of the user
	public static LinkedList<String> passwords = new LinkedList<String>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Read from file line by line
			BufferedReader br = new BufferedReader(new FileReader("pass.txt"));
			String line = null;
			while((line = br.readLine())!=null){
				//Save to linked list
				passwords.add(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
