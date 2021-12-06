import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {
	public static void main(String[] args) {

//		Check arguments
		if (!args[0].equals("a") && !args[0].equals("r") &&  !args[0].contains("+") && !args[0].contains("?") && !args[0].contains("c")){
			System.out.println("You Entered wrong argument, Run Again ... ");
			System.exit(0);

		}

		if(args[0].equals("a")) {
			System.out.println("Loading data ...");	

			try {
				BufferedReader readFile = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String fileText = readFile.readLine();
				String students[] = fileText.split(",");			
				for(String student : students) { System.out.println(student); }
			} catch (Exception e){} 

			System.out.println("Data Loaded.");
		}

		else if(args[0].equals("r")){
			System.out.println("Loading data ...");	

			try {
				BufferedReader readFile = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String fileText = readFile.readLine();
				String students[] = fileText.split(",");	
				Random x = new Random();
				int randomNum = x.nextInt(students.length);
				System.out.println(students[randomNum]);
			} catch (Exception e){} 

			System.out.println("Data Loaded.");			
		}

		else if(args[0].contains("+")){
			System.out.println("Loading data ...");	

			try {
				BufferedWriter writeFile = new BufferedWriter(
					new FileWriter("students.txt", true));
				String newStudent = args[0].substring(1);
	        	Date d = new Date();
	        	String df = "dd/mm/yyyy-hh:mm:ss a";
	        	DateFormat dateFormat = new SimpleDateFormat(df);
	        	String fd= dateFormat.format(d);
				writeFile.write(", "+newStudent+"\nList last updated on "+fd);
				writeFile.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}

		else if(args[0].contains("?")){
			System.out.println("Loading data ...");	

			try {
				BufferedReader readFile = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String fileText = readFile.readLine();
				String students[] = fileText.split(",");	
				boolean done = false;
				String searchStudent = args[0].substring(1);

				for(int idx = 0; idx<students.length && !done; idx++) {
					if(students[idx].trim().equals(searchStudent)) {
						System.out.println("We found it!");
						done=true;
					}
				}
			} catch (Exception e){} 

			System.out.println("Data Loaded.");				
		}

		else if(args[0].contains("c")){
			System.out.println("Loading data ...");	

			try {
				BufferedReader readFile = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
				String fileText = readFile.readLine();
				char charFileText[] = fileText.toCharArray();			
				int count=1;

				for(char c:charFileText) {
					if(c ==' ') {	
						count++;		
					}
				}
			System.out.println(count +" word(s) found ");
			} catch (Exception e){} 

			System.out.println("Data Loaded.");				
		}
	}
}