package ie.app;

import java.util.Scanner;

public class GetFiles {

	public String[] fileOrder() {
		//Method to get file path to both files and put them into string[]
		System.out.println("We will remove the users on file 2 that are also on file 1.");
		System.out.println("This leaves us with unique users on file 1.");
		String[] files = new String[2];
		try {
		System.out.println("Please enter the path to the first file.");
		Scanner sc = new Scanner(System.in);
		String file1 = sc.next();
		files[0] = file1;
		}catch(Exception e) {
			System.out.println("There is no file at this path");
		}
		try {
		System.out.println("Please enter the path to the second file.");
		Scanner s = new Scanner(System.in);
		String file2 = s.next();		
		files[1] = file2;
		}catch(Exception e) {
			System.out.println("There is no file at this path");
		}
		return files;
	}

}
