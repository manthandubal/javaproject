package HadoopProcess;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.File;
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
			//BufferedReader br1 = new BufferedReader(new FileReader("E:\\Eclise_Workspace\\JavaProject\\src\\HelperFiles\\localhost.2008-06-29.log.log"));
			File currentDirFile = new File(".");
			String helper = currentDirFile.getAbsolutePath();		
			BufferedReader br = new BufferedReader(new FileReader(helper+"\\src\\HelperFiles\\localhost.2008-06-29.log.log"));
			String line;
			String DateString;
			List<String> Time= new ArrayList<String>();
			List<String> Error= new ArrayList<String>();
			int ErrorCount = 0;
			String ErrorString;
			/*try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
        stream.forEach(System.out.println());
}*/
			while ((line = br.readLine()) != null) {
				try {
					DateString=line.substring(0, 24).trim();
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
			if (Time.isEmpty())
				System.out.println("No proper Exception / Error details Found in file..!!");
			else {
				for(int i=0; i<Time.size();i++) {
					System.out.println("Exception Time : "+Time.get(i));
					System.out.println("Exception / Error : "+Error.get(i));
				}
			}
			//System.out.println(Time.size() +" " + Error.size() );
			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IO Exception handled");
		}
	}
	private static boolean isValidDate(String inputString)
	{
		if(inputString.matches("^([A-Z][a-z][a-z])( )([0-3][0-9]), \\d{4} (00|[0-9]|1[0-9]|2[0-3]):([0-9]|[0-5][0-9]):([0-9]|[0-5][0-9]) (AM|PM)"))
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
