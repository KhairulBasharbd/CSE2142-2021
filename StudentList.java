import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList {

	//This function is used to read a text file as string.
	static String read(){
		String fileText = null;
		try {
			BufferedReader readFile = new BufferedReader(new InputStreamReader(new FileInputStream("students.txt")));
			fileText = readFile.readLine();
		} catch(Exception e){}
		return fileText;
	}

	//This function is used to write a string in text file.
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
			System.out.println("You Entered wrong argument, please Run Again ... ");
			System.exit(0);

		}
		
		Constants cons = new Constants();//creating object of Constants class.

		//printing all single student of text file.
		if(args[0].equals("a")) {
			System.out.println(cons.loading);	

			String students[] = read().split(",");//spliting the text of file as single student.			
			for(String student : students) { 
				System.out.println(student); 
			}//printing all single student of text file.

			System.out.println(cons.loaded);
		}

		//printing a random student.
		else if(args[0].equals("r")){
			System.out.println(cons.loading);	

			String students[] = read().split(",");	//spliting the text of file as single student.
			Random x = new Random();//creating object of random class.
			System.out.println(students[x.nextInt(students.length)]);//generate random index of student list and print random student.

			System.out.println(cons.loaded);			
		}

		//add new student.
		else if(args[0].contains("+")){
			System.out.println(cons.loading);	

			write(args[0].substring(1));;//calling write function to write any student in text file.
							
			System.out.println(cons.loaded);	
		}

		//search a student in text file.
		else if(args[0].contains("?")){
			System.out.println(cons.loading);	

			String students[] = read().split(",");	//spliting the text of file as single student.
			
			for(int i = 0; i<students.length; i++) {
				if(students[i].trim().equals(args[0].substring(1))) {
					System.out.println("We found it!");	
					
				}
			}

			System.out.println(cons.loaded);				
		}

		//printing the number of student.
		else if(args[0].contains("c")){
			System.out.println(cons.loading);	

			String students[] = read().split(",");	//spliting the text of file as single student.
			System.out.println(students.length +" word(s) found ");//print the number of single student.

			System.out.println(cons.loaded);				
		}
	}
}