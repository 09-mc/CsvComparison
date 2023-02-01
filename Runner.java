package ie.app;

import java.io.IOException;
import java.util.List;

public class Runner {

	public static void main(String[] args) throws IOException {
		Compare c = new Compare();
		List<String> list = c.listComparison();
		CsvWriter cw = new CsvWriter();
		cw.writeToCsv(list);
	}

}
