import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	
	static String read(){
		String fileText = null;
		try {
			BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			fileText = readFile.readLine();
		} catch(Exception e){}
		return fileText;
	}

	static void write(String newStudent){

		try {
			BufferedWriter writeFile = new BufferedWriter(new FileWriter("students.txt", true));
			Date d = new Date();
			String df = "dd/mm/yyyy-hh:mm:ss a";
			DateFormat dateFormat = new SimpleDateFormat(df);
			String fd = dateFormat.format(d);
			writeFile.write(", " + newStudent + "\nList last updated on " + fd);
			writeFile.close();
		} catch(Exception e){}

	}







	public static void main(String[] args) {

//		Check arguments
		if (!args[0].equals("a") && !args[0].equals("r") &&  !args[0].contains("+") && !args[0].contains("?") && !args[0].contains("c")){
			//System.out.println("You Entered wrong argument, Run Again ... ");
			System.out.println("You Entered wrong argument, please Run Again ... ");
			System.exit(0);

		}
		Constants cons = new Constants();

		if(args[0].equals("a")) {
			System.out.println(cons.loading);	

			String students[] = read().split(",");			
			for(String student : students) { 
				System.out.println(student); 
			}
			System.out.println(cons.loaded);
		}

		else if(args[0].equals("r")){
			System.out.println(cons.loading);	

			String students[] = read().split(",");	
			Random x = new Random();
			System.out.println(students[x.nextInt(students.length)]);

			System.out.println(cons.loaded);			
		}

		else if(args[0].contains("+")){
			System.out.println(cons.loading);	

			write(args[0].substring(1));
							
			System.out.println(cons.loaded);	
		}

		else if(args[0].contains("?")){
			System.out.println(cons.loading);	

			String students[] = read().split(",");	

			for(int idx = 0; idx<students.length; idx++) {
				if(students[idx].trim().equals(args[0].substring(1))) {
					System.out.println("We found it!");	
					
				}
			}

			System.out.println(cons.loaded);				
		}

		else if(args[0].contains("c")){
			System.out.println(cons.loading);	

			String students[] = read().split(",");	
			System.out.println(students.length +" word(s) found ");

			System.out.println(cons.loaded);				
		}
	}
}