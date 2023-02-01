package ie.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Compare {
	
	List<String> firstContent = new ArrayList<>();
	List<String> secondContent = new ArrayList<>();
	List<String> emailContent = new ArrayList<>();
	List<String> outputContent = new ArrayList<>();
	String[] parts = new String[2];

	public List<String> listComparison() throws IOException {
		
		GetFiles gf = new GetFiles();
		String[] order = gf.fileOrder();
		String firstFile = order[0];
		String secondFile = order[1];
		String line;
	
		/*Buffered reader to take in data from CSV file
		 *Separate string into name + @domain to remove users who had two similar domains
		 * */
		
		try (BufferedReader br = new BufferedReader(new FileReader(firstFile))) {
			while ((line = br.readLine()) != null) {
				String[] values = line.split(",");
				String email = values[0];
				emailContent.add(email);
				parts = email.split("@");
				String name = parts[0];
				firstContent.add(name);
			}
		} catch (IOException e) {
			System.out.println("Cannot read data from first file");
		}
		;

		try (BufferedReader b = new BufferedReader(new FileReader(secondFile))) {
			while ((line = b.readLine()) != null) {
				String[] values = line.split(",");
				String email = values[0];
				parts = email.split("@");
				String name = parts[0];
				secondContent.add(name);
			}
		} catch (IOException e) {
			System.out.println("Cannot read data from second file");
		}
		;
		
		//Using streams, compare the first and second lists, remove all from firstContent that are in secondContent
		firstContent = firstContent.stream().map(String::toLowerCase).collect(Collectors.toList());
		secondContent = secondContent.stream().map(String::toLowerCase).collect(Collectors.toList());
		firstContent.removeAll(secondContent);
		
		//Using a lambda, go through the emailContent and if any names match names in firstContent, add the email to a list
		emailContent = emailContent.stream().map(String::toLowerCase).collect(Collectors.toList());
		emailContent.forEach((String email) ->{
			parts = email.split("@");
			String name = parts[0];
			if (firstContent.contains(name)) {
				outputContent.add(email);
			}
		});
		return outputContent;
	}

}
