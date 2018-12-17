package HadoopProcess;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UnstructuredDataHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ch;
		//Starting to read the file
		System.out.println("Trying to read the file now");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("E:\\Eclise_Workspace\\JavaProject\\src\\HelperFiles\\localhost.2008-06-29.log.log"));
			String line;
			int lineCount = 0;
			String DateString;
			List<String> Time= new ArrayList<String>();
			List<String> Error= new ArrayList<String>();
			int ErrorCount = 0;
			String ErrorString;
			while ((line = br.readLine()) != null) {
				lineCount++;
				try {
					DateString=line.substring(0, 24);
					
					if (isValidDate(DateString))
					 {
						 Time.add(ErrorCount, DateString);
						 ErrorString = line.substring(24);
						 Error.add(ErrorCount, ErrorString.trim()); 
					 }
				}
				catch(StringIndexOutOfBoundsException ae)
				{
					continue;
				}
			 }
			for(int i=0; i<Time.size();i++) {
				System.out.println(Time.get(i));
				System.out.println(Error.get(i));;
			}
			System.out.println(Time.size() +" " + Error.size() );
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
	private static boolean isValidDate(String inputString)
	{
		if(inputString.trim().matches("^([A-Z][a-z][a-z])( )([0-3][0-9]), \\d{4} (00|[0-9]|1[0-9]|2[0-3]):([0-9]|[0-5][0-9]):([0-9]|[0-5][0-9]) (AM|PM)"))
			return true;
		else
			return false;
		/*SimpleDateFormat format;
		format = new SimpleDateFormat("mmm dd, yyyy HH:MM:SS");
		try
		{
			format.parse(inputString);
			return true;
		}
		catch(ParseException e)
		{
			return isValidDate2(inputString);
		}*/
	}
}
