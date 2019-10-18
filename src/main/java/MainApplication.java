import java.util.List;

import com.sapient.enums.FileType;
import com.sapient.factory.ReaderFactory;
import com.sapient.model.PerCapitaIncome;
import com.sapient.readers.CsvWriter;
import com.sapient.readers.FileReader;
import com.sapient.service.PerCapitaComputation;

public class MainApplication {

	
	public static void main(String[] args) {
		FileReader reader = ReaderFactory.getReader(FileType.valueOf("CSV"));
		com.sapient.readers.FileWriter writer = new CsvWriter();
		List<PerCapitaIncome> incomes = reader.read("src/main/resources/convertcsv.csv");
		PerCapitaComputation capitaComputation = new PerCapitaComputation();
		writer.write(capitaComputation.compute(incomes), "output.csv");
		for(PerCapitaIncome income : incomes){
			System.out.println(income.getCountry());
			System.out.println(income.getCity());
			System.out.println(income.getAvgIncome());
			System.out.println(income.getCurrency().getCurrencyName());
			System.out.println(income.getGender().toString());
		}

		
	}
}
