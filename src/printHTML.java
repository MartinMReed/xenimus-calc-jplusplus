import java.io.*;

public class printHTML
{
	public printHTML(String fileName, xenimusNode header, xenimusNode trailer)
	{
		try
		{			
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(/* "C:\", */fileName+".html")))); 
			
			pw.println("<html>");
			pw.println("<head>");
			pw.println("<title>Stat Calc by Halloween The Warlock</title>");
			pw.println("</head>");
			pw.println("<body bgcolor=\"FFFFFF\">");
			pw.println("<font face=\"Arial\">");
			pw.println("");
			
			xenimusNode prev = header;
			xenimusNode here = header.getNext();
			if(here == trailer)
			{
				pw.println("NO STATS WERE ADDED");
			}
			while (here != trailer)
			{
				pw.println("<table bgcolor=\"FFFFCC\" width=\"550\" border=\"1\">");
				pw.println("");
				pw.println("<!--Beg.Major.Col.1-->");
				pw.println("<td>");
				pw.println("<br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Class ::<font color=\"#006400\"> "+here.getclass()+"</font></b><br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Level ::<font color=\"#006400\"> "+here.getlevel()+"</font></b><br>");
				pw.println("<br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Strength ::<font color=\"#006400\"> "+here.getstrength()+"</font></b><br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Agility ::<font color=\"#006400\"> "+here.getagility()+"</font></b><br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Constitution ::<font color=\"#006400\"> "+here.getconstitution()+"</font></b><br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Intelligence ::<font color=\"#006400\"> "+here.getintelligence()+"</font></b><br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Wisdom ::<font color=\"#006400\"> "+here.getwisdom()+"</font></b><br>");
				pw.println("<br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Shrines ::<font color=\"#006400\"> "+here.getshrines()+"</font></b><br>");
				pw.println("&nbsp;&nbsp;&nbsp;<b>Jeloc ::<font color=\"#006400\"> "+here.getjeloc()+"</font></b><br>");
				pw.println("<br>");
				
				//print alignment
				if (here.getclass().equals("Cleric"))
				{
					pw.println("&nbsp;&nbsp;&nbsp;<b>Alignment ::<font color=\"#006400\"> "+here.getalignment()+"</font></b><br>");
					pw.println("<br>");
				}
				
				//print spells
				if (here.getspells().length > 0)
				{
					pw.println("&nbsp;&nbsp;&nbsp;<b>"+here.getspells().length+" Spell(s) Earned ::</b>");
					pw.println("<br>");
					for (int i=0; i<here.getspells().length; i++)
					{
						pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b><font color=\"#006400\">"+here.getspells()[i]+"</font></b><br>");
					}
					pw.println("<br>");
				}
				
				//shrine warning
				if(here.getshrines().equals("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") == false && here.getwisdom() < 13)
				{
					pw.println("<font style=\"BACKGROUND-COLOR: lightblue\" size=1><center>&nbsp;WARNING: Shrines Selected With Wisdom Below 13&nbsp;</center></font>");
				}
				
				//jeloc warning
				if(here.getjeloc().equals("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;") == false && here.getlevel() < 36)
				{
					pw.println("<font style=\"BACKGROUND-COLOR: yellow\" size=1><center>&nbsp;WARNING: Jeloc Selected While Below Level 36&nbsp;</center></font>");
				}
				
				//points warning
				if(here.getremaining()<0){ pw.println("<font style=\"BACKGROUND-COLOR: lightgreen\" size=1><center>&nbsp;WARNING: "+(here.getremaining()*(-1))+" Points Above Normal&nbsp;</center></font>"); }
				if(here.getremaining()>0){ pw.println("<font style=\"BACKGROUND-COLOR: pink\" size=1><center>&nbsp;WARNING: "+here.getremaining()+" Points Below Normal&nbsp;</center></font>"); }
				
				pw.println("</td>");
				pw.println("<!--End.Major.Col.1-->");
				pw.println("");
				pw.println("");
				pw.println("");
				pw.println("<!--Beg.Major.Col.2-->");
				pw.println("<td width=\"250\" height=100%>");
				pw.println("<table height=100% width=100% border=\"1\">");
				pw.println("");
				pw.println("<tr>");
				pw.println("<th><center>&nbsp;</center></th>");
				pw.println("<th><center>Health Points</center></th>");
				pw.println("<th><center>Mana Points</center></th>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+0</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpbase()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpbase()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+1</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpone()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpone()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+2</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethptwo()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmptwo()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+3</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpthree()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpthree()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+4</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpfour()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpfour()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+5</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpfive()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpfive()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+6</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpsix()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpsix()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+7</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpseven()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpseven()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("<tr>");
				pw.println("<td><b><center>+8</center></b></td>");
				pw.println("<td><b><font color=\"#FF0000\"><center>"+here.gethpeight()+"</center></font></b></td>");
				pw.println("<td><b><font color=\"#0000FF\"><center>"+here.getmpeight()+"</center></font></b></td>");
				pw.println("</tr>");
				pw.println("");
				pw.println("</table>");
				pw.println("</td>");
				pw.println("<!--End.Major.Col.2-->");
				pw.println("");
				pw.println("</table>");
				pw.println("<br>");
				pw.println("<br>");
				pw.println("<br>");
				prev = here;
				here = here.getNext();
			}
			pw.println("");
			pw.println("</body>");
			pw.println("</html>");

			pw.close();
		}
		catch ( IOException r )
		{
		}	
	}
}