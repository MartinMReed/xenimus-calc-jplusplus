
import java.io.*;
import java.net.*; 

public class Update
{
	URL newURL = null;
	InputStream newInputStream = null;
	InputStreamReader newInputStreamReader = null;
	StreamTokenizer newStreamTokenizer = null;
	String newString = "x";
	
	public Update()
	{
		try
		{
			newURL = new URL("http://www.csl.mtu.edu/~mmreed/other/xenimus/update.txt");
			newInputStream = newURL.openStream();
			newInputStreamReader = new InputStreamReader(newInputStream);
			newStreamTokenizer = new StreamTokenizer(newInputStreamReader);
			
			boolean correctFile = false;
			String UpdateCheckerFile = "UpdateCheckerFile";
			
			while (newStreamTokenizer.nextToken() != StreamTokenizer.TT_EOF )
			{
				if (newStreamTokenizer.ttype == '"')
				{
					if ( correctFile == false && (newStreamTokenizer.sval).equals(UpdateCheckerFile))
					{
						correctFile = true;
					}
					else if ( correctFile == true )
					{
						newString = newStreamTokenizer.sval;
					}
				}
			}
			newInputStream.close();
			newInputStreamReader.close();
			
			if (correctFile == false)
			{
				newString = "UPDATE CHECKER FILE NOT FOUND";
			}
		}
		catch(MalformedURLException ex)
		{
			System.exit(0);
		}
		catch(IOException ex)
		{
			newString = "NO CONNECTION DETECTED";
		}
	}
	
	public String getUpdate()
	{
		return newString;
	}

}//end of update