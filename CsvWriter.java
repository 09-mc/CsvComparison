package ie.app;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CsvWriter {

	public void writeToCsv(List<String> list) throws IOException {
		//File writer class and enter file name
		System.out.println("Please enter the output file name.");
		Scanner s = new Scanner(System.in);
		String fileName = s.next();
		Collections.sort(list);
		try {
			FileWriter file = new FileWriter(fileName + ".csv");
			PrintWriter write = new PrintWriter(file);
			for (String email : list) {
				write.println(email);
			}
			write.close();
		} catch (IOException e) {
			System.out.println("Cannot create file");
		}
	}
}
