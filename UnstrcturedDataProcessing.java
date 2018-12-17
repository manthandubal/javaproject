package HadoopProcess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnstructuredDataHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		//Starting to read the file
		System.out.println("Trying to read the file now");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("E:\\Eclise_Workspace\\JavaProject\\src\\HelperFiles\\localhost.2008-06-29.log.log"));
			String line;
			int lineCount=0;
			 while ((line = br.readLine()) != null) {
				 lineCount++;
				 System.out.println(line);
			 }
			 System.out.println("Read lines"+lineCount);
			 br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception handled");
		}
		System.out.println("File has been closed..!!");
	}

}
