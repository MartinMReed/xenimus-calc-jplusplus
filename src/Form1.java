//-------------------------------------------------------
// XENIMUS STAT CALC
//-------------------------------------------------------

import com.ms.wfc.app.*;
import com.ms.wfc.core.*;
import com.ms.wfc.ui.*;
import com.ms.wfc.html.*;

//-------------------------------------------------------
// This class can take a variable number of parameters on the command
// line. Program execution begins with the main() method. The class
// constructor is not invoked unless an object of type 'Form1' is
// created in the main() method.
//-------------------------------------------------------
public class Form1 extends Form
{
	private String VERSION = "2.2";
	
	private int classNumber = 0;
	private int lvl = 1;
	private int[] statArray = new int[5]; //[0]str, [1]agil, [2]cons, [3]intel, [4]wis
	private int[] shrineArray = new int[5]; //+jeloc and reg shrines
	
	private int[] starterMax = new int[5];
	private int[] starterMin = new int[5];
	private boolean starterHelp = false;
	
	private int remainingPoints = 25;
	private int actualPoints = 75;
	private int usedPoints = 50;
	
	private boolean selectAllShrines = false;
	private boolean selectAllJeloc = false;
	private boolean JELOC = false;
	
	private String[] shrineText = new String[6];
	private String[] jelocText = new String[6];
	
	private Calc calc = new Calc(classNumber,lvl,0,0,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
	
	private boolean saveToHTML = false;
	
	private xenimusNode trailer = new xenimusNode(null,0,0,0,0,0,0,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0,null,null);
	private xenimusNode header = new xenimusNode(null,0,0,0,0,0,0,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0,null,trailer);
	private xenimusNode newNode = null;
	
	
	//-------------------------------------------------------
	// CONSTRUCTOR
	//-------------------------------------------------------
	public Form1()
	{
		// RequiRED for Visual J++ Form Designer support
		initForm();
		
		this.setText("JAVA Stat Calculator (windows version "+VERSION+") by Halloween The Warlock");
		
		statArray[0] = 10;  shrineArray[0] = 0;
		statArray[1] = 10;  shrineArray[1] = 0;
		statArray[2] = 10;  shrineArray[2] = 0;
		statArray[3] = 10;  shrineArray[3] = 0;
		statArray[4] = 10;  shrineArray[4] = 0;
		
		this.redo();
		
		statusBar.setText("For help with the starting stats of races, use the six buttons above ^ ^ ^ ^ ^ ^");
	}
	
	//-------------------------------------------------------
	// FORM CLICK (BACKGROUND)
	//-------------------------------------------------------
	private void Form1_click(Object source, Event e) { }

	
	//-------------------------------------------------------
	// Form1 overrides dispose so it can clean up the
	// component list.
	//-------------------------------------------------------
	public void dispose()
	{
		super.dispose();
		components.dispose();
	}

	
	//-------------------------------------------------------
	// CLASS (MINUS)
	//-------------------------------------------------------
	private void classMinus_click(Object source, Event e)
	{
		//reset alignment
		neutralButton.setChecked(true);
		
		//change class
		if (classNumber == 0)
		{
			classNumber = 8;
		}
		else
		{
			classNumber--;
		}
		
		this.redo(); 
	}

	
	//-------------------------------------------------------
	// CLASS (PLUS)
	//-------------------------------------------------------
	private void classPlus_click(Object source, Event   e)
	{
		//reset alginment
		neutralButton.setChecked(true);
		
		//change class
		if (classNumber == 8)
		{
			classNumber = 0;
		}
		else
		{
			classNumber++;
		}
		
		this.redo();
	}

	
	//-------------------------------------------------------
	// ALIGNMENT NEUTRAL
	//-------------------------------------------------------
	private void neutralButton_checkedChanged(Object source, Event e)
	{
		this.redo();
	}

	
	//-------------------------------------------------------
	// ALIGNMENT FULL GOOD
	//-------------------------------------------------------
	private void fullButton_checkedChanged(Object source, Event   e)
	{
		//only clerics can use this feature
		if (classNumber != 3)
		{
			fullButton.setChecked(false);
		}
		
		this.redo();
	}

	
	//-------------------------------------------------------
	// FILENAME INPUT
	//-------------------------------------------------------
	private void saveIn_textChanged(Object source, Event e)
	{
		String tempFileName = "";
		
		for(int i=0; i<saveIn.getText().length(); i++)
		{
			//if user types illegal characters =
			if("\\".equals(saveIn.getText().charAt(i)+"") ||
			   "/".equals(saveIn.getText().charAt(i)+"") ||
			   ":".equals(saveIn.getText().charAt(i)+"") ||
			   "*".equals(saveIn.getText().charAt(i)+"") ||
			   "?".equals(saveIn.getText().charAt(i)+"") ||
			   "\"".equals(saveIn.getText().charAt(i)+"") ||
			   "<".equals(saveIn.getText().charAt(i)+"") ||
			   ">".equals(saveIn.getText().charAt(i)+"") ||
			   "|".equals(saveIn.getText().charAt(i)+""))
			{
				//it gets erased
			}
			else
			{
				tempFileName += saveIn.getText().charAt(i);
			}
		}
		
		saveIn.setText(tempFileName);
		
		//show secret if found
		if (tempFileName.equalsIgnoreCase("doc savage"))
		{
			secret_click(null,null);
		}
	}

	
	//-------------------------------------------------------
	// STATS (MONITOR)
	//-------------------------------------------------------
	private void strMinus_click(Object source, Event e) { statMinus(0); }
	private void agilMinus_click(Object source, Event e) { statMinus(1); }
	private void consMinus_click(Object source, Event e) { statMinus(2); }
	private void intelMinus_click(Object source, Event e) { statMinus(3); }
	private void wisMinus_click(Object source, Event e) { statMinus(4); }
	
	private void strPlus_click(Object source, Event e) { statPlus(0); }
	private void agilPlus_click(Object source, Event e) { statPlus(1); }
	private void consPlus_click(Object source, Event e) { statPlus(2); }
	private void intelPlus_click(Object source, Event e) { statPlus(3); }
	private void wisPlus_click(Object source, Event e) { statPlus(4); }

	
	//-------------------------------------------------------
	// STATS (CHANGE)
	//-------------------------------------------------------
	private void statMinus(int i)
	{
		if (starterHelp == false)
		{
			if(statArray[i]-shrineArray[i] > 10)
			{
				statArray[i]--;
			}
		}
		else
		{
			if(statArray[i]-shrineArray[i] > starterMin[i])
			{
				statArray[i]--;
			}
		}
		
		this.redo();
	}
	
	private void statPlus(int i)
	{
		if (starterHelp == false)
		{
			statArray[i]++;
		}
		else
		{
			if(statArray[i]-shrineArray[i] < starterMax[i])
			{
				statArray[i]++;
			}
		}
		
		this.redo();
	}

	
	//-------------------------------------------------------
	// LEVEL (MINUS)
	//-------------------------------------------------------
	private void levelMinus_click(Object source, Event e) {
		boolean show = false;
		if(saveToHTML == true)
		{
			xenimusNode prev = null;
			xenimusNode here = header;
			xenimusNode next = header.getNext();
			
			//cycle to end
			while (next != trailer)
			{
				prev = here;
				here = next;
				next = next.getNext();
			}
			
			//not empty
			if(prev != null)
			{
				prev.setNext(trailer);
				show = true;
			}
			
			//empty
			if(header.getNext() == trailer)
			{
				menuPrint.setEnabled(false);
			}
		}
		lvl--;
		this.redo();
		
		//must do after re-draw
		if (show == true) { statusBar.setText("Planner :: DELETED LAST"); }
	}

	
	//-------------------------------------------------------
	// LEVEL (PLUS)
	//-------------------------------------------------------
	private void levelPlus_click(Object source, Event e)
	{
		starterHelp = false;
		
		boolean show = false;
		if(saveToHTML == true)
		{
			xenimusNode prev = header;
			xenimusNode here = header.getNext();
			
			//cycle to end
			while (here != trailer)
			{
				prev = here;
				here = here.getNext();
			}
			prev.setNext(newNode);
			menuPrint.setEnabled(true);
			show = true;
		}
		lvl++;
		this.redo();
		
		//must do after re-draw
		if (show == true) { statusBar.setText("Planner :: ADDED"); }
	}


	//-------------------------------------------------------
	// STATS (MONITOR TEXT CHANGES) 
	//-------------------------------------------------------
	private void lvlIn_textChanged(Object source, Event e)
	{
		try { lvl = Integer.parseInt(lvlIn.getText());
			  if(lvl<1){ throw new NumberFormatException();} } 
		catch(NumberFormatException ex) { lvl = 1; } 
		this.redo(); 
	}
	private void strIn_textChanged(Object source, Event e)
	{
		try { statArray[0] = Integer.parseInt(strIn.getText()); } 
		catch(NumberFormatException ex) { statArray[0] = 10; }
		this.redo();
	}
	private void agilIn_textChanged(Object source, Event e)
	{
		try { statArray[1] = Integer.parseInt(agilIn.getText()); } 
		catch(NumberFormatException ex) { statArray[1] = 10; }
		this.redo();
	}
	private void consIn_textChanged(Object source, Event e)
	{
		try { statArray[2] = Integer.parseInt(consIn.getText()); } 
		catch(NumberFormatException ex) { statArray[2] = 10; }
		this.redo();
	}
	private void intelIn_textChanged(Object source, Event e)
	{
		try { statArray[3] = Integer.parseInt(intelIn.getText()); } 
		catch(NumberFormatException ex) { statArray[3] = 10; }
		this.redo();
	}
	private void wisIn_textChanged(Object source, Event e)
	{
		try { statArray[4] = Integer.parseInt(wisIn.getText()); } 
		catch(NumberFormatException ex) { statArray[4] = 10; }
		this.redo();
	}
	

	//-------------------------------------------------------
	// GREAT HALL (MONITOR AND CHANGE)
	//-------------------------------------------------------
	private void ghShrine_click(Object source, Event e)
	{
		//if selected
		if (ghShrine.getCheckState() == 1)
		{
			ghShrine.setBackColor(Color.GREEN);
			ghShrine.setForeColor(Color.BLACK);
			
			//if less then 13 wisdom
			if (statArray[4]<13){ statArray[4]=13; }
			
			//add 1 more to each stat
			statArray[0]++; shrineArray[0]++;
			statArray[1]++; shrineArray[1]++;
			statArray[2]++; shrineArray[2]++;
			statArray[3]++; shrineArray[3]++;
			statArray[4]++; shrineArray[4]++;
		}
		//if de-selected
		else
		{
			ghShrine.setBackColor(Color.RED);
			ghShrine.setForeColor(Color.WHITE);
			
			statArray[0]--; shrineArray[0]--;
			statArray[1]--; shrineArray[1]--;
			statArray[2]--; shrineArray[2]--;
			statArray[3]--; shrineArray[3]--;
			statArray[4]--; shrineArray[4]--;
		}
		this.redo();
	}

	
	//-------------------------------------------------------
	// SHRINES (MONITOR)
	//-------------------------------------------------------
	private void strShrine_click(Object source, Event e) { this.displayShrines(strengthShrine,0); }
	private void agilShrine_click(Object source, Event e) { this.displayShrines(agilityShrine,1); }
	private void consShrine_click(Object source, Event e) { this.displayShrines(constitutionShrine,2); }
	private void intelShrine_click(Object source, Event e) { this.displayShrines(intelligenceShrine,3); }
	private void wisShrine_click(Object source, Event e) { this.displayShrines(wisdomShrine,4); }

	
	//-------------------------------------------------------
	// SHRINES (CHANGE) -- called by all shrines
	//-------------------------------------------------------
	private void displayShrines(CheckBox shrine, int stat)
	{
		//if selected
		if (shrine.getCheckState() == 1)
		{
			shrine.setBackColor(Color.GREEN);
			if (statArray[4]<13){ statArray[4]=13; }
			statArray[stat]++; shrineArray[stat]++;
		}
		//if de-selected
		else
		{
			shrine.setBackColor(Color.RED);
			statArray[stat]--; shrineArray[stat]--;
		}
		this.redo();
	}

	
	//-------------------------------------------------------
	// SIXTH JELOC (MONITOR AND CHANGE)
	//-------------------------------------------------------
	private void sixJeloc_click(Object source, Event e)
	{
		//if selected
		if (sixthJeloc.getCheckState() == 1)
		{
			sixthJeloc.setBackColor(Color.GREEN);
			sixthJeloc.setForeColor(Color.BLACK);
			
			statArray[0]+=5; shrineArray[0]+=5;
			statArray[1]+=5; shrineArray[1]+=5;
			statArray[2]+=5; shrineArray[2]+=5;
			statArray[3]+=5; shrineArray[3]+=5;
			statArray[4]+=5; shrineArray[4]+=5;
			
			//select the remaining jeloc shrines that are not already selected
			if(strengthJeloc.getCheckState()!=1) { strengthJeloc.setCheckState(1); this.strJeloc_click(null,null); }  
			if(agilityJeloc.getCheckState()!=1) { agilityJeloc.setCheckState(1); this.agilJeloc_click(null,null); }
			if(constitutionJeloc.getCheckState()!=1) { constitutionJeloc.setCheckState(1); this.consJeloc_click(null,null); }
			if(intelligenceJeloc.getCheckState()!=1) { intelligenceJeloc.setCheckState(1); this.intelJeloc_click(null,null); }
			if(wisdomJeloc.getCheckState()!=1) { wisdomJeloc.setCheckState(1); this.wisJeloc_click(null,null); }
			
			//disable the other jeloc shrines while sixth is enabled
			strengthJeloc.setEnabled(false); agilityJeloc.setEnabled(false);
			constitutionJeloc.setEnabled(false); intelligenceJeloc.setEnabled(false);
			wisdomJeloc.setEnabled(false); JELOC = true;
		}
		//if de-selected
		else
		{
			sixthJeloc.setBackColor(Color.RED);
			sixthJeloc.setForeColor(Color.WHITE);
			
			statArray[0]-=5; shrineArray[0]-=5;
			statArray[1]-=5; shrineArray[1]-=5;
			statArray[2]-=5; shrineArray[2]-=5;
			statArray[3]-=5; shrineArray[3]-=5;
			statArray[4]-=5; shrineArray[4]-=5;
			
			//enable the other jeloc shrines
			strengthJeloc.setEnabled(true); agilityJeloc.setEnabled(true);
			constitutionJeloc.setEnabled(true); intelligenceJeloc.setEnabled(true);
			wisdomJeloc.setEnabled(true); JELOC = false;
		}
		this.redo();
	}

	
	//-------------------------------------------------------
	// JELOC SHRINES (MONITOR)
	//-------------------------------------------------------
	private void strJeloc_click(Object source, Event e) { displayJeloc(strengthJeloc,0); }
	private void agilJeloc_click(Object source, Event e) { displayJeloc(agilityJeloc,1); }
	private void consJeloc_click(Object source, Event e) {  displayJeloc(constitutionJeloc,2); }
	private void intelJeloc_click(Object source, Event e) { displayJeloc(intelligenceJeloc,3); }
	private void wisJeloc_click(Object source, Event e) { displayJeloc(wisdomJeloc,4); }

	
	//-------------------------------------------------------
	// JELOC SHRINES (CHANGE) -- called by all jelocs
	//-------------------------------------------------------
	private void displayJeloc(CheckBox jeloc, int stat)
	{
		//if selected
		if (jeloc.getCheckState() == 1)
		{
			jeloc.setBackColor(Color.GREEN);
			statArray[stat]+=2; shrineArray[stat]+=2;
		}
		//if de-selected
		else
		{
			jeloc.setBackColor(Color.RED);
			statArray[stat]-=2; shrineArray[stat]-=2;
		}
		this.redo();
	}

	
	//-------------------------------------------------------
	// SHRINE BUTTON
	//-------------------------------------------------------
	private void shrineButton_click(Object source, Event e)
	{
		//if shrineButton button has not been pushed, select all shrines not already selected
		if (selectAllShrines == false)
		{
			if(strengthShrine.getCheckState()!=1) { strengthShrine.setCheckState(1); this.strShrine_click(null,null); }
			if(agilityShrine.getCheckState()!=1) { agilityShrine.setCheckState(1); this.agilShrine_click(null,null); }
			if(constitutionShrine.getCheckState()!=1) { constitutionShrine.setCheckState(1); this.consShrine_click(null,null); }
			if(intelligenceShrine.getCheckState()!=1) { intelligenceShrine.setCheckState(1); this.intelShrine_click(null,null); }
			if(wisdomShrine.getCheckState()!=1) { wisdomShrine.setCheckState(1); this.wisShrine_click(null,null); }
			if(ghShrine.getCheckState()!=1) { ghShrine.setCheckState(1); this.ghShrine_click(null,null); }
			
			//shrineButton = pushed
			selectAllShrines = true;
			shrineButton.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		}
		//if shrineButton has been pushed already, unselect all shrines not already unselected
		else if (selectAllShrines == true)
		{
			if(strengthShrine.getCheckState()!=0) { strengthShrine.setCheckState(0); this.strShrine_click(null,null); }
			if(agilityShrine.getCheckState()!=0) { agilityShrine.setCheckState(0); this.agilShrine_click(null,null); }
			if(constitutionShrine.getCheckState()!=0) { constitutionShrine.setCheckState(0); this.consShrine_click(null,null); }
			if(intelligenceShrine.getCheckState()!=0) { intelligenceShrine.setCheckState(0); this.intelShrine_click(null,null); }
			if(wisdomShrine.getCheckState()!=0) { wisdomShrine.setCheckState(0); this.wisShrine_click(null,null); }
			if(ghShrine.getCheckState()!=0) { ghShrine.setCheckState(0); this.ghShrine_click(null,null); }
			
			//shrineButton = not pushed
			selectAllShrines = false;
			shrineButton.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		}
		this.redo();
	}

	
	//-------------------------------------------------------
	// JELOC BUTTON
	//-------------------------------------------------------
	private void jelocButton_click(Object source, Event e)
	{
		starterHelp = false;
		
		//if jelocButton has not been pushed, jeloc all
		if(selectAllJeloc == false) 
		{
			if(lvl<36) { lvl = 36; }
			
			//take action if sixth has not already been selected
			if(JELOC==false) { sixthJeloc.setCheckState(1); this.sixJeloc_click(null,null); }
			
			//jelocButton = pushed
			selectAllJeloc = true;
			jelocButton.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		}
		//if jelocButton has been pushed already, un-jeloc all
		else if(selectAllJeloc == true)
		{
			//if sixth is selected, unselect all jeloc shrines, enable all jeloc shrines, and take action
			if(JELOC==true)
			{
				sixthJeloc.setCheckState(0);
				strengthJeloc.setCheckState(0); strengthJeloc.setEnabled(true);
				agilityJeloc.setCheckState(0); agilityJeloc.setEnabled(true);
				constitutionJeloc.setCheckState(0); constitutionJeloc.setEnabled(true);
				intelligenceJeloc.setCheckState(0); intelligenceJeloc.setEnabled(true);
				wisdomJeloc.setCheckState(0); wisdomJeloc.setEnabled(true);
				
				JELOC = false;
				
				this.sixJeloc_click(null,null); this.strJeloc_click(null,null);
				this.agilJeloc_click(null,null); this.consJeloc_click(null,null);
				this.intelJeloc_click(null,null); this.wisJeloc_click(null,null);
			}
			//jelocButton = not pushed
			selectAllJeloc = false;
			jelocButton.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		}
		this.redo();
	}

	
	//-------------------------------------------------------
	// PLANNER (ENABLE)
	//-------------------------------------------------------
	private void HTML_click(Object source, Event e)
	{
		if(HTML.getCheckState() == 1) { saveToHTML = true; }
		else { saveToHTML = false; }
	}

	
	//-------------------------------------------------------
	// SAVE FILE
	//-------------------------------------------------------
	private void save_click(Object source, Event e)
	{
		printHTML newprintHTML = new printHTML(saveIn.getText(),header,trailer);
		statusBar.setText("Planner :: SAVED to "+saveIn.getText()+".html");
	}

	
	//-------------------------------------------------------
	// UPDATES (CHECK)
	//-------------------------------------------------------
	private void updateButton_click(Object source, Event e)
	{
		Update up = new Update();
		if (up.getUpdate().equals("NO CONNECTION DETECTED")) 
		{ 
			statusBar.setText("Update :: "+up.getUpdate()); 
		}
		else if (up.getUpdate().equals("UPDATE CHECKER FILE NOT FOUND")) 
		{ 
			statusBar.setText("Update :: "+up.getUpdate()); 
		}
		else if (up.getUpdate().equals(VERSION)) 
		{ 
			statusBar.setText("Update :: NOTHING NEW"); 
		}
		else if (up.getUpdate().equals(VERSION) == false) 
		{ 
			statusBar.setText("Update :: NEW UPDATE AVAILABLE ("+up.getUpdate()+")"); 
		}
	}

	
	//-------------------------------------------------------
	// SECRET
	//-------------------------------------------------------
	private void secret_click(Object source, Event e)
	{
			clear_click(null,null);
			
			lvl = 41;
			classNumber = 5;
			
			selectAllShrines = false;
			shrineButton_click(null, null);
			
			selectAllJeloc = false;
			jelocButton_click(null, null);
			
			statArray[0] = 22;	shrineArray[0] = 9;
			statArray[1] = 22;	shrineArray[1] = 9;
			statArray[2] = 36;	shrineArray[2] = 9;
			statArray[3] = 45;	shrineArray[3] = 9;
			statArray[4] = 35;	shrineArray[4] = 9;
			
			shrineText[0]="gh&nbsp;";		jelocText[0]="six&nbsp;";
			shrineText[1]="str&nbsp;";		jelocText[1]="str&nbsp;";
			shrineText[2]="agil&nbsp;";		jelocText[2]="agil&nbsp;";
			shrineText[3]="cons&nbsp;";		jelocText[3]="cons&nbsp;";
			shrineText[4]="intel&nbsp;";	jelocText[4]="intel&nbsp;";
			shrineText[5]="wis&nbsp;";		jelocText[5]="wis&nbsp;";
			
			this.redo();
			
			saveIn.setText("Doc_Savage");
	}

	private void DregStarter_click(Object source, Event e)
	{
		clear_click(null,null);
		DregStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		
		statArray[0] = 17;	
		statArray[1] = 10;	
		statArray[2] = 15;	
		statArray[3] = 10;	
		statArray[4] = 10;	
		
		starterMin[0] = 17;	starterMax[0] = 22;
		starterMin[1] = 10;	starterMax[1] = 18;
		starterMin[2] = 15;	starterMax[2] = 21;
		starterMin[3] = 10;	starterMax[3] = 15;
		starterMin[4] = 10;	starterMax[4] = 14;
		
		starterHelp = true;
		
		this.redo();
	}

	private void ElfStarter_click(Object source, Event e)
	{
		clear_click(null,null);
		ElfStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		
		statArray[0] = 10;	
		statArray[1] = 15;	
		statArray[2] = 10;	
		statArray[3] = 12;	
		statArray[4] = 12;	
		
		starterMin[0] = 10;	starterMax[0] = 16;
		starterMin[1] = 15;	starterMax[1] = 22;
		starterMin[2] = 10;	starterMax[2] = 16;
		starterMin[3] = 12;	starterMax[3] = 18;
		starterMin[4] = 12;	starterMax[4] = 18;
		
		starterHelp = true;
		
		this.redo();
	}

	private void GnomeStarter_click(Object source, Event e)
	{
		clear_click(null,null);
		GnomeStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		
		statArray[0] = 10;	
		statArray[1] = 10;	
		statArray[2] = 10;	
		statArray[3] = 12;	
		statArray[4] = 15;	
		
		starterMin[0] = 10;	starterMax[0] = 18;
		starterMin[1] = 10;	starterMax[1] = 16;
		starterMin[2] = 10;	starterMax[2] = 16;
		starterMin[3] = 12;	starterMax[3] = 18;
		starterMin[4] = 15;	starterMax[4] = 22;
		
		starterHelp = true;
		
		this.redo();
	}

	private void ScallionStarter_click(Object source, Event e)
	{
		clear_click(null,null);
		ScallionStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		
		statArray[0] = 12;	
		statArray[1] = 10;	
		statArray[2] = 10;	
		statArray[3] = 16;	
		statArray[4] = 10;	
		
		starterMin[0] = 12;	starterMax[0] = 20;
		starterMin[1] = 10;	starterMax[1] = 16;
		starterMin[2] = 10;	starterMax[2] = 16;
		starterMin[3] = 16;	starterMax[3] = 22;
		starterMin[4] = 10;	starterMax[4] = 18;
		
		starterHelp = true;
		
		this.redo();
	}

	private void HumanStarter_click(Object source, Event e)
	{
		clear_click(null,null);
		HumanStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		
		statArray[0] = 12;	
		statArray[1] = 12;	
		statArray[2] = 12;	
		statArray[3] = 10;	
		statArray[4] = 10;	
		
		starterMin[0] = 12;	starterMax[0] = 18;
		starterMin[1] = 12;	starterMax[1] = 18;
		starterMin[2] = 12;	starterMax[2] = 18;
		starterMin[3] = 10;	starterMax[3] = 18;
		starterMin[4] = 10;	starterMax[4] = 18;
		
		starterHelp = true;
		
		this.redo();
	}

	private void BehockStarter_click(Object source, Event e)
	{
		clear_click(null,null);
		BehockStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false));
		
		statArray[0] = 15;	
		statArray[1] = 10;	
		statArray[2] = 17;	
		statArray[3] = 10;	
		statArray[4] = 10;	
		
		starterMin[0] = 15;	starterMax[0] = 21;
		starterMin[1] = 10;	starterMax[1] = 18;
		starterMin[2] = 17;	starterMax[2] = 22;
		starterMin[3] = 10;	starterMax[3] = 14;
		starterMin[4] = 10;	starterMax[4] = 15;
		
		starterHelp = true;
		
		this.redo();
	}

	/**
	 * NOTE: The following code is required by the Visual   J++ form
	 * designer.    It can be modified using the form editor.  Do not
	 * modify   it using the code editor.
	 */
	Container components = new Container();
	Button classPlus = new Button();
	Button classMinus = new Button();
	Button levelMinus = new Button();
	Button levelPlus = new Button();
	Button strMinus = new Button();
	Button strPlus = new Button();
	Button agilMinus = new Button();
	Button agilPlus = new Button();
	Button consMinus = new Button();
	Button consPlus = new Button();
	Button intelMinus = new Button();
	Button intelPlus = new Button();
	Button wisMinus = new Button();
	Button wisPlus = new Button();
	Button shrineButton = new Button();
	Button jelocButton = new Button();
	MenuItem menuSpacerTwo = new MenuItem();
	CheckBox strengthShrine = new CheckBox();
	CheckBox agilityShrine = new CheckBox();
	CheckBox constitutionShrine = new CheckBox();
	CheckBox intelligenceShrine = new CheckBox();
	CheckBox wisdomShrine = new CheckBox();
	CheckBox ghShrine = new CheckBox();
	CheckBox strengthJeloc = new CheckBox();
	CheckBox agilityJeloc = new CheckBox();
	CheckBox constitutionJeloc = new CheckBox();
	CheckBox intelligenceJeloc = new CheckBox();
	CheckBox wisdomJeloc = new CheckBox();
	CheckBox sixthJeloc = new CheckBox();
	CheckBox HTML = new CheckBox();
	Edit lvlIn = new Edit();
	Edit agilIn = new Edit();
	Edit consIn = new Edit();
	Edit intelIn = new Edit();
	Edit wisIn = new Edit();
	Edit strIn = new Edit();
	Edit saveIn = new Edit();
	Label classShow = new Label();
	Label levelLabel = new Label();
	Label strengthLabel = new Label();
	Label agilityLabel = new Label();
	Label constitutionLabel = new Label();
	Label intelligenceLabel = new Label();
	Label wisdomLabel = new Label();
	Label classLabel = new Label();
	Label mpseven = new Label();
	Label mpeight = new Label();
	Label actualLabel = new Label();
	Label actual = new Label();
	Label usedLabel = new Label();
	Label used = new Label();
	Label remainingLabel = new Label();
	Label remain = new Label();
	Label mpsix = new Label();
	Label mpfive = new Label();
	Label mpfour = new Label();
	Label mpthree = new Label();
	Label mptwo = new Label();
	Label mpone = new Label();
	Label mpbase = new Label();
	Label hpthree = new Label();
	Label hpfour = new Label();
	Label hpfive = new Label();
	Label hpsix = new Label();
	Label hpseven = new Label();
	Label hpeight = new Label();
	Label hpbase = new Label();
	Label hpone = new Label();
	Label hptwo = new Label();
	Label eightLabel = new Label();
	Label sevenLabel = new Label();
	Label sixLabel = new Label();
	Label fiveLabel = new Label();
	Label fourLabel = new Label();
	Label threeLabel = new Label();
	Label twoLabel = new Label();
	Label oneLabel = new Label();
	Label healthLabel = new Label();
	Label baseLabel = new Label();
	Label manaLabel = new Label();
	ListBox spellList = new ListBox();
	StatusBar statusBar = new StatusBar();
	Button DregStarter = new Button();
	Button ElfStarter = new Button();
	Button GnomeStarter = new Button();
	Button ScallionStarter = new Button();
	Button HumanStarter = new Button();
	Button BehockStarter = new Button();
	RadioButton neutralButton = new RadioButton();
	RadioButton fullButton = new RadioButton();
	GroupBox starterHelpGroup = new GroupBox();
	GroupBox alignmentGroup = new GroupBox();
	MenuItem menuBonus = new MenuItem();
	MainMenu mainMenu1 = new MainMenu();
	MenuItem menuFile = new MenuItem();
	MenuItem menuReset = new MenuItem();
	MenuItem menuExit = new MenuItem();
	MenuItem menuPlanner = new MenuItem();
	MenuItem menuPrint = new MenuItem();
	Label experienceShow = new Label();
	MenuItem menuUpdate = new MenuItem();
	MenuItem menuSpacerOne = new MenuItem();
	Label label2 = new Label();
	Label experienceNeededLabel = new Label();
	Label spellsEarnedLabel = new Label();
	MenuItem menuBonusEJTwo = new MenuItem();
	MenuItem menuBonusEJThree = new MenuItem();
	MenuItem menuBonusEJFour = new MenuItem();
	MenuItem menuBonusHallTwo = new MenuItem();
	MenuItem menuItem8 = new MenuItem();
	MenuItem menuBonusHallThree = new MenuItem();
	MenuItem menuBonusHallFour = new MenuItem();
	MenuItem menuBonusEJOne = new MenuItem();
	MenuItem menuBonusHallOne = new MenuItem();

	private void initForm()
	{
		// NOTE:  This form is storing resource information in an
		// external file.  Do not modify the string parameter to any
		// resources.getObject() function call. For example, do not
		// modify "foo1_location" in the following line of code
		// even if the name of the Foo object changes: 
		//   foo1.setLocation((Point)resources.getObject("foo1_location"));

		IResourceManager resources = new ResourceManager(this, "Form1");
		classPlus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		classPlus.setLocation(new Point(440, 48));
		classPlus.setSize(new Point(48, 32));
		classPlus.setTabIndex(1);
		classPlus.setText("+");
		classPlus.addOnClick(new EventHandler(this.classPlus_click));

		classMinus.setFont(new Font("MS Shell\tDlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		classMinus.setLocation(new Point(384, 48));
		classMinus.setSize(new Point(48, 32));
		classMinus.setTabIndex(0);
		classMinus.setText("-");
		classMinus.addOnClick(new EventHandler(this.classMinus_click));

		levelMinus.setFont(new Font("MS Shell\tDlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		levelMinus.setLocation(new Point(384, 88));
		levelMinus.setSize(new Point(48, 32));
		levelMinus.setTabIndex(2);
		levelMinus.setText("-");
		levelMinus.addOnClick(new EventHandler(this.levelMinus_click));

		levelPlus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		levelPlus.setLocation(new Point(440, 88));
		levelPlus.setSize(new Point(48, 32));
		levelPlus.setTabIndex(3);
		levelPlus.setText("+");
		levelPlus.addOnClick(new EventHandler(this.levelPlus_click));

		strMinus.setFont(new Font("MS\tShell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		strMinus.setLocation(new Point(384, 136));
		strMinus.setSize(new Point(48, 32));
		strMinus.setTabIndex(6);
		strMinus.setText("-");
		strMinus.addOnClick(new EventHandler(this.strMinus_click));

		strPlus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		strPlus.setLocation(new Point(440, 136));
		strPlus.setSize(new Point(48, 32));
		strPlus.setTabIndex(7);
		strPlus.setText("+");
		strPlus.addOnClick(new EventHandler(this.strPlus_click));

		agilMinus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		agilMinus.setLocation(new Point(384, 176));
		agilMinus.setSize(new Point(48, 32));
		agilMinus.setTabIndex(8);
		agilMinus.setText("-");
		agilMinus.addOnClick(new EventHandler(this.agilMinus_click));

		agilPlus.setFont(new Font("MS\tShell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		agilPlus.setLocation(new Point(440, 176));
		agilPlus.setSize(new Point(48, 32));
		agilPlus.setTabIndex(9);
		agilPlus.setText("+");
		agilPlus.addOnClick(new EventHandler(this.agilPlus_click));

		consMinus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		consMinus.setLocation(new Point(384, 216));
		consMinus.setSize(new Point(48, 32));
		consMinus.setTabIndex(10);
		consMinus.setText("-");
		consMinus.addOnClick(new EventHandler(this.consMinus_click));

		consPlus.setFont(new Font("MS\tShell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		consPlus.setLocation(new Point(440, 216));
		consPlus.setSize(new Point(48, 32));
		consPlus.setTabIndex(11);
		consPlus.setText("+");
		consPlus.addOnClick(new EventHandler(this.consPlus_click));

		intelMinus.setFont(new Font("MS Shell\tDlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		intelMinus.setLocation(new Point(384, 256));
		intelMinus.setSize(new Point(48, 32));
		intelMinus.setTabIndex(12);
		intelMinus.setText("-");
		intelMinus.addOnClick(new EventHandler(this.intelMinus_click));

		intelPlus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		intelPlus.setLocation(new Point(440, 256));
		intelPlus.setSize(new Point(48, 32));
		intelPlus.setTabIndex(13);
		intelPlus.setText("+");
		intelPlus.addOnClick(new EventHandler(this.intelPlus_click));

		wisMinus.setFont(new Font("MS\tShell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		wisMinus.setLocation(new Point(384, 296));
		wisMinus.setSize(new Point(48, 32));
		wisMinus.setTabIndex(14);
		wisMinus.setText("-");
		wisMinus.addOnClick(new EventHandler(this.wisMinus_click));

		wisPlus.setFont(new Font("MS Shell Dlg", 20.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		wisPlus.setLocation(new Point(440, 296));
		wisPlus.setSize(new Point(48, 32));
		wisPlus.setTabIndex(15);
		wisPlus.setText("+");
		wisPlus.addOnClick(new EventHandler(this.wisPlus_click));

		shrineButton.setFont(new Font("Arial", 9.0f));
		shrineButton.setLocation(new Point(16, 56));
		shrineButton.setSize(new Point(56, 24));
		shrineButton.setTabIndex(67);
		shrineButton.setText("Shrines");
		shrineButton.addOnClick(new EventHandler(this.shrineButton_click));

		jelocButton.setFont(new Font("Arial", 9.0f));
		jelocButton.setLocation(new Point(80, 56));
		jelocButton.setSize(new Point(56, 24));
		jelocButton.setTabIndex(66);
		jelocButton.setText("Jeloc");
		jelocButton.addOnClick(new EventHandler(this.jelocButton_click));

		menuSpacerTwo.setText("-");

		strengthShrine.setBackColor(Color.RED);
		strengthShrine.setForeColor(Color.WHITE);
		strengthShrine.setLocation(new Point(16, 136));
		strengthShrine.setSize(new Point(56, 32));
		strengthShrine.setTabIndex(5);
		strengthShrine.setText("");
		strengthShrine.addOnClick(new EventHandler(this.strShrine_click));

		agilityShrine.setBackColor(Color.RED);
		agilityShrine.setForeColor(Color.WHITE);
		agilityShrine.setLocation(new Point(16, 176));
		agilityShrine.setSize(new Point(56, 32));
		agilityShrine.setTabIndex(16);
		agilityShrine.setText("");
		agilityShrine.addOnClick(new EventHandler(this.agilShrine_click));

		constitutionShrine.setBackColor(Color.RED);
		constitutionShrine.setForeColor(Color.WHITE);
		constitutionShrine.setLocation(new Point(16, 216));
		constitutionShrine.setSize(new Point(56, 32));
		constitutionShrine.setTabIndex(17);
		constitutionShrine.setText("");
		constitutionShrine.addOnClick(new EventHandler(this.consShrine_click));

		intelligenceShrine.setBackColor(Color.RED);
		intelligenceShrine.setForeColor(Color.WHITE);
		intelligenceShrine.setLocation(new Point(16, 256));
		intelligenceShrine.setSize(new Point(56, 32));
		intelligenceShrine.setTabIndex(18);
		intelligenceShrine.setText("");
		intelligenceShrine.addOnClick(new EventHandler(this.intelShrine_click));

		wisdomShrine.setBackColor(Color.RED);
		wisdomShrine.setForeColor(Color.WHITE);
		wisdomShrine.setLocation(new Point(16, 296));
		wisdomShrine.setSize(new Point(56, 32));
		wisdomShrine.setTabIndex(19);
		wisdomShrine.setText("");
		wisdomShrine.addOnClick(new EventHandler(this.wisShrine_click));

		ghShrine.setBackColor(Color.RED);
		ghShrine.setForeColor(Color.BLACK);
		ghShrine.setLocation(new Point(16, 88));
		ghShrine.setSize(new Point(56, 32));
		ghShrine.setTabIndex(4);
		ghShrine.setText("GH");
		ghShrine.addOnClick(new EventHandler(this.ghShrine_click));

		strengthJeloc.setBackColor(Color.RED);
		strengthJeloc.setEnabled(false);
		strengthJeloc.setForeColor(Color.WHITE);
		strengthJeloc.setLocation(new Point(80, 136));
		strengthJeloc.setSize(new Point(56, 32));
		strengthJeloc.setTabIndex(21);
		strengthJeloc.setText("");
		strengthJeloc.addOnClick(new EventHandler(this.strJeloc_click));

		agilityJeloc.setBackColor(Color.RED);
		agilityJeloc.setEnabled(false);
		agilityJeloc.setForeColor(Color.WHITE);
		agilityJeloc.setLocation(new Point(80, 176));
		agilityJeloc.setSize(new Point(56, 32));
		agilityJeloc.setTabIndex(22);
		agilityJeloc.setText("");
		agilityJeloc.addOnClick(new EventHandler(this.agilJeloc_click));

		constitutionJeloc.setBackColor(Color.RED);
		constitutionJeloc.setEnabled(false);
		constitutionJeloc.setForeColor(Color.WHITE);
		constitutionJeloc.setLocation(new Point(80, 216));
		constitutionJeloc.setSize(new Point(56, 32));
		constitutionJeloc.setTabIndex(23);
		constitutionJeloc.setText("");
		constitutionJeloc.addOnClick(new EventHandler(this.consJeloc_click));

		intelligenceJeloc.setBackColor(Color.RED);
		intelligenceJeloc.setEnabled(false);
		intelligenceJeloc.setForeColor(Color.WHITE);
		intelligenceJeloc.setLocation(new Point(80, 256));
		intelligenceJeloc.setSize(new Point(56, 32));
		intelligenceJeloc.setTabIndex(24);
		intelligenceJeloc.setText("");
		intelligenceJeloc.addOnClick(new EventHandler(this.intelJeloc_click));

		wisdomJeloc.setBackColor(Color.RED);
		wisdomJeloc.setEnabled(false);
		wisdomJeloc.setForeColor(Color.WHITE);
		wisdomJeloc.setLocation(new Point(80, 296));
		wisdomJeloc.setSize(new Point(56, 32));
		wisdomJeloc.setTabIndex(25);
		wisdomJeloc.setText("");
		wisdomJeloc.addOnClick(new EventHandler(this.wisJeloc_click));

		sixthJeloc.setBackColor(Color.RED);
		sixthJeloc.setEnabled(false);
		sixthJeloc.setForeColor(Color.BLACK);
		sixthJeloc.setLocation(new Point(80, 88));
		sixthJeloc.setSize(new Point(56, 32));
		sixthJeloc.setTabIndex(20);
		sixthJeloc.setText("6th");
		sixthJeloc.addOnClick(new EventHandler(this.sixJeloc_click));

		HTML.setBackColor(Color.ORANGE);
		HTML.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		HTML.setForeColor(Color.BLACK);
		HTML.setLocation(new Point(576, 432));
		HTML.setSize(new Point(128, 28));
		HTML.setTabIndex(78);
		HTML.setText("Save To Planner");
		HTML.addOnClick(new EventHandler(this.HTML_click));

		lvlIn.setBackColor(Color.YELLOW);
		lvlIn.setForeColor(Color.BLACK);
		lvlIn.setLocation(new Point(288, 96));
		lvlIn.setSize(new Point(64, 20));
		lvlIn.setTabIndex(65);
		lvlIn.setText("1");
		lvlIn.setTextAlign(HorizontalAlignment.CENTER);
		lvlIn.addOnTextChanged(new EventHandler(this.lvlIn_textChanged));

		agilIn.setBackColor(Color.WHITE);
		agilIn.setForeColor(Color.BLACK);
		agilIn.setLocation(new Point(288, 184));
		agilIn.setSize(new Point(64, 20));
		agilIn.setTabIndex(70);
		agilIn.setText("10");
		agilIn.setTextAlign(HorizontalAlignment.CENTER);
		agilIn.addOnTextChanged(new EventHandler(this.agilIn_textChanged));

		consIn.setBackColor(Color.WHITE);
		consIn.setForeColor(Color.BLACK);
		consIn.setLocation(new Point(288, 224));
		consIn.setSize(new Point(64, 20));
		consIn.setTabIndex(71);
		consIn.setText("10");
		consIn.setTextAlign(HorizontalAlignment.CENTER);
		consIn.addOnTextChanged(new EventHandler(this.consIn_textChanged));

		intelIn.setBackColor(Color.WHITE);
		intelIn.setForeColor(Color.BLACK);
		intelIn.setLocation(new Point(288, 264));
		intelIn.setSize(new Point(64, 20));
		intelIn.setTabIndex(72);
		intelIn.setText("10");
		intelIn.setTextAlign(HorizontalAlignment.CENTER);
		intelIn.addOnTextChanged(new EventHandler(this.intelIn_textChanged));

		wisIn.setBackColor(Color.WHITE);
		wisIn.setForeColor(Color.BLACK);
		wisIn.setLocation(new Point(288, 304));
		wisIn.setSize(new Point(64, 20));
		wisIn.setTabIndex(73);
		wisIn.setText("10");
		wisIn.setTextAlign(HorizontalAlignment.CENTER);
		wisIn.addOnTextChanged(new EventHandler(this.wisIn_textChanged));

		strIn.setBackColor(Color.WHITE);
		strIn.setForeColor(Color.BLACK);
		strIn.setLocation(new Point(288, 144));
		strIn.setSize(new Point(64, 20));
		strIn.setTabIndex(69);
		strIn.setText("10");
		strIn.setTextAlign(HorizontalAlignment.CENTER);
		strIn.addOnTextChanged(new EventHandler(this.strIn_textChanged));

		saveIn.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		saveIn.setForeColor(Color.BLACK);
		saveIn.setLocation(new Point(576, 464));
		saveIn.setSize(new Point(128, 22));
		saveIn.setTabIndex(68);
		saveIn.setText("Calc_Stats");
		saveIn.setMaxLength(50);
		saveIn.setTextAlign(HorizontalAlignment.RIGHT);
		saveIn.addOnTextChanged(new EventHandler(this.saveIn_textChanged));

		classShow.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		classShow.setForeColor(Color.GREEN);
		classShow.setLocation(new Point(256, 56));
		classShow.setSize(new Point(120, 24));
		classShow.setTabIndex(26);
		classShow.setTabStop(false);
		classShow.setText("Fighter");
		classShow.setTextAlign(HorizontalAlignment.CENTER);

		levelLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		levelLabel.setForeColor(Color.YELLOW);
		levelLabel.setLocation(new Point(176, 96));
		levelLabel.setSize(new Point(64, 24));
		levelLabel.setTabIndex(33);
		levelLabel.setTabStop(false);
		levelLabel.setText("Level:");
		levelLabel.setTextAlign(HorizontalAlignment.CENTER);

		strengthLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		strengthLabel.setForeColor(Color.WHITE);
		strengthLabel.setLocation(new Point(156, 144));
		strengthLabel.setSize(new Point(104, 24));
		strengthLabel.setTabIndex(32);
		strengthLabel.setTabStop(false);
		strengthLabel.setText("Strength:");
		strengthLabel.setTextAlign(HorizontalAlignment.CENTER);

		agilityLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		agilityLabel.setForeColor(Color.WHITE);
		agilityLabel.setLocation(new Point(172, 184));
		agilityLabel.setSize(new Point(72, 24));
		agilityLabel.setTabIndex(31);
		agilityLabel.setTabStop(false);
		agilityLabel.setText("Agility:");
		agilityLabel.setTextAlign(HorizontalAlignment.CENTER);

		constitutionLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		constitutionLabel.setForeColor(Color.WHITE);
		constitutionLabel.setLocation(new Point(156, 224));
		constitutionLabel.setSize(new Point(104, 24));
		constitutionLabel.setTabIndex(30);
		constitutionLabel.setTabStop(false);
		constitutionLabel.setText("Constitution:");
		constitutionLabel.setTextAlign(HorizontalAlignment.CENTER);

		intelligenceLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		intelligenceLabel.setForeColor(Color.WHITE);
		intelligenceLabel.setLocation(new Point(156, 264));
		intelligenceLabel.setSize(new Point(104, 24));
		intelligenceLabel.setTabIndex(29);
		intelligenceLabel.setTabStop(false);
		intelligenceLabel.setText("Intelligence:");
		intelligenceLabel.setTextAlign(HorizontalAlignment.CENTER);

		wisdomLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		wisdomLabel.setForeColor(Color.WHITE);
		wisdomLabel.setLocation(new Point(164, 304));
		wisdomLabel.setSize(new Point(88, 24));
		wisdomLabel.setTabIndex(28);
		wisdomLabel.setTabStop(false);
		wisdomLabel.setText("Wisdom:");
		wisdomLabel.setTextAlign(HorizontalAlignment.CENTER);

		classLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		classLabel.setForeColor(Color.GREEN);
		classLabel.setLocation(new Point(176, 56));
		classLabel.setSize(new Point(64, 24));
		classLabel.setTabIndex(27);
		classLabel.setTabStop(false);
		classLabel.setText("Class:");
		classLabel.setTextAlign(HorizontalAlignment.CENTER);

		mpseven.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpseven.setForeColor(new Color(0, 192, 192));
		mpseven.setLocation(new Point(648, 272));
		mpseven.setSize(new Point(72, 32));
		mpseven.setTabIndex(40);
		mpseven.setTabStop(false);
		mpseven.setText("3");
		mpseven.setTextAlign(HorizontalAlignment.CENTER);

		mpeight.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpeight.setForeColor(new Color(0, 192, 192));
		mpeight.setLocation(new Point(648, 304));
		mpeight.setSize(new Point(72, 32));
		mpeight.setTabIndex(38);
		mpeight.setTabStop(false);
		mpeight.setText("3");
		mpeight.setTextAlign(HorizontalAlignment.CENTER);

		actualLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		actualLabel.setForeColor(new Color(224, 224, 224));
		actualLabel.setLocation(new Point(24, 16));
		actualLabel.setSize(new Point(64, 24));
		actualLabel.setTabIndex(48);
		actualLabel.setTabStop(false);
		actualLabel.setText("Actual: ");
		actualLabel.setTextAlign(HorizontalAlignment.RIGHT);

		actual.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		actual.setForeColor(Color.ORANGE);
		actual.setLocation(new Point(88, 16));
		actual.setSize(new Point(104, 24));
		actual.setTabIndex(49);
		actual.setTabStop(false);
		actual.setText("75");

		usedLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		usedLabel.setForeColor(new Color(224, 224, 224));
		usedLabel.setLocation(new Point(192, 16));
		usedLabel.setSize(new Point(56, 24));
		usedLabel.setTabIndex(43);
		usedLabel.setTabStop(false);
		usedLabel.setText("Used: ");
		usedLabel.setTextAlign(HorizontalAlignment.RIGHT);

		used.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		used.setForeColor(Color.ORANGE);
		used.setLocation(new Point(248, 16));
		used.setSize(new Point(104, 24));
		used.setTabIndex(46);
		used.setTabStop(false);
		used.setText("50");

		remainingLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		remainingLabel.setForeColor(new Color(224, 224, 224));
		remainingLabel.setLocation(new Point(352, 16));
		remainingLabel.setSize(new Point(96, 24));
		remainingLabel.setTabIndex(34);
		remainingLabel.setTabStop(false);
		remainingLabel.setText("Remaining: ");
		remainingLabel.setTextAlign(HorizontalAlignment.RIGHT);

		remain.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		remain.setForeColor(Color.ORANGE);
		remain.setLocation(new Point(448, 16));
		remain.setSize(new Point(104, 24));
		remain.setTabIndex(35);
		remain.setTabStop(false);
		remain.setText("25");

		mpsix.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpsix.setForeColor(new Color(0, 192, 192));
		mpsix.setLocation(new Point(648, 240));
		mpsix.setSize(new Point(72, 32));
		mpsix.setTabIndex(41);
		mpsix.setTabStop(false);
		mpsix.setText("2");
		mpsix.setTextAlign(HorizontalAlignment.CENTER);

		mpfive.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpfive.setForeColor(new Color(0, 192, 192));
		mpfive.setLocation(new Point(648, 208));
		mpfive.setSize(new Point(72, 32));
		mpfive.setTabIndex(44);
		mpfive.setTabStop(false);
		mpfive.setText("2");
		mpfive.setTextAlign(HorizontalAlignment.CENTER);

		mpfour.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpfour.setForeColor(new Color(0, 192, 192));
		mpfour.setLocation(new Point(648, 176));
		mpfour.setSize(new Point(72, 32));
		mpfour.setTabIndex(47);
		mpfour.setTabStop(false);
		mpfour.setText("1");
		mpfour.setTextAlign(HorizontalAlignment.CENTER);

		mpthree.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpthree.setForeColor(new Color(0, 192, 192));
		mpthree.setLocation(new Point(648, 144));
		mpthree.setSize(new Point(72, 32));
		mpthree.setTabIndex(50);
		mpthree.setTabStop(false);
		mpthree.setText("1");
		mpthree.setTextAlign(HorizontalAlignment.CENTER);

		mptwo.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mptwo.setForeColor(new Color(0, 192, 192));
		mptwo.setLocation(new Point(648, 112));
		mptwo.setSize(new Point(72, 32));
		mptwo.setTabIndex(53);
		mptwo.setTabStop(false);
		mptwo.setText("0");
		mptwo.setTextAlign(HorizontalAlignment.CENTER);

		mpone.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpone.setForeColor(new Color(0, 192, 192));
		mpone.setLocation(new Point(648, 80));
		mpone.setSize(new Point(72, 32));
		mpone.setTabIndex(54);
		mpone.setTabStop(false);
		mpone.setText("0");
		mpone.setTextAlign(HorizontalAlignment.CENTER);

		mpbase.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		mpbase.setForeColor(new Color(0, 192, 192));
		mpbase.setLocation(new Point(648, 48));
		mpbase.setSize(new Point(72, 32));
		mpbase.setTabIndex(57);
		mpbase.setTabStop(false);
		mpbase.setText("0");
		mpbase.setTextAlign(HorizontalAlignment.CENTER);

		hpthree.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpthree.setForeColor(Color.RED);
		hpthree.setLocation(new Point(576, 144));
		hpthree.setSize(new Point(72, 32));
		hpthree.setTabIndex(77);
		hpthree.setTabStop(false);
		hpthree.setText("9");
		hpthree.setTextAlign(HorizontalAlignment.CENTER);

		hpfour.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpfour.setForeColor(Color.RED);
		hpfour.setLocation(new Point(576, 176));
		hpfour.setSize(new Point(72, 32));
		hpfour.setTabIndex(63);
		hpfour.setTabStop(false);
		hpfour.setText("9");
		hpfour.setTextAlign(HorizontalAlignment.CENTER);

		hpfive.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpfive.setForeColor(Color.RED);
		hpfive.setLocation(new Point(576, 208));
		hpfive.setSize(new Point(72, 32));
		hpfive.setTabIndex(58);
		hpfive.setTabStop(false);
		hpfive.setText("10");
		hpfive.setTextAlign(HorizontalAlignment.CENTER);

		hpsix.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpsix.setForeColor(Color.RED);
		hpsix.setLocation(new Point(576, 240));
		hpsix.setSize(new Point(72, 32));
		hpsix.setTabIndex(52);
		hpsix.setTabStop(false);
		hpsix.setText("11");
		hpsix.setTextAlign(HorizontalAlignment.CENTER);

		hpseven.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpseven.setForeColor(Color.RED);
		hpseven.setLocation(new Point(576, 272));
		hpseven.setSize(new Point(72, 32));
		hpseven.setTabIndex(45);
		hpseven.setTabStop(false);
		hpseven.setText("11");
		hpseven.setTextAlign(HorizontalAlignment.CENTER);

		hpeight.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpeight.setForeColor(Color.RED);
		hpeight.setLocation(new Point(576, 304));
		hpeight.setSize(new Point(72, 32));
		hpeight.setTabIndex(39);
		hpeight.setTabStop(false);
		hpeight.setText("12");
		hpeight.setTextAlign(HorizontalAlignment.CENTER);

		hpbase.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpbase.setForeColor(Color.RED);
		hpbase.setLocation(new Point(576, 48));
		hpbase.setSize(new Point(72, 32));
		hpbase.setTabIndex(74);
		hpbase.setTabStop(false);
		hpbase.setText("7");
		hpbase.setTextAlign(HorizontalAlignment.CENTER);

		hpone.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hpone.setForeColor(Color.RED);
		hpone.setLocation(new Point(576, 80));
		hpone.setSize(new Point(72, 32));
		hpone.setTabIndex(75);
		hpone.setTabStop(false);
		hpone.setText("8");
		hpone.setTextAlign(HorizontalAlignment.CENTER);

		hptwo.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		hptwo.setForeColor(Color.RED);
		hptwo.setLocation(new Point(576, 112));
		hptwo.setSize(new Point(72, 32));
		hptwo.setTabIndex(76);
		hptwo.setTabStop(false);
		hptwo.setText("8");
		hptwo.setTextAlign(HorizontalAlignment.CENTER);

		eightLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		eightLabel.setForeColor(new Color(224, 224, 224));
		eightLabel.setLocation(new Point(520, 304));
		eightLabel.setSize(new Point(56, 32));
		eightLabel.setTabIndex(42);
		eightLabel.setTabStop(false);
		eightLabel.setText("+8 :");
		eightLabel.setTextAlign(HorizontalAlignment.RIGHT);

		sevenLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		sevenLabel.setForeColor(new Color(224, 224, 224));
		sevenLabel.setLocation(new Point(520, 272));
		sevenLabel.setSize(new Point(56, 32));
		sevenLabel.setTabIndex(51);
		sevenLabel.setTabStop(false);
		sevenLabel.setText("+7 :");
		sevenLabel.setTextAlign(HorizontalAlignment.RIGHT);

		sixLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		sixLabel.setForeColor(new Color(224, 224, 224));
		sixLabel.setLocation(new Point(520, 240));
		sixLabel.setSize(new Point(56, 32));
		sixLabel.setTabIndex(59);
		sixLabel.setTabStop(false);
		sixLabel.setText("+6 :");
		sixLabel.setTextAlign(HorizontalAlignment.RIGHT);

		fiveLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		fiveLabel.setForeColor(new Color(224, 224, 224));
		fiveLabel.setLocation(new Point(520, 208));
		fiveLabel.setSize(new Point(56, 32));
		fiveLabel.setTabIndex(64);
		fiveLabel.setTabStop(false);
		fiveLabel.setText("+5 :");
		fiveLabel.setTextAlign(HorizontalAlignment.RIGHT);

		fourLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		fourLabel.setForeColor(new Color(224, 224, 224));
		fourLabel.setLocation(new Point(520, 176));
		fourLabel.setSize(new Point(56, 32));
		fourLabel.setTabIndex(62);
		fourLabel.setTabStop(false);
		fourLabel.setText("+4 :");
		fourLabel.setTextAlign(HorizontalAlignment.RIGHT);

		threeLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		threeLabel.setForeColor(new Color(224, 224, 224));
		threeLabel.setLocation(new Point(520, 144));
		threeLabel.setSize(new Point(56, 32));
		threeLabel.setTabIndex(61);
		threeLabel.setTabStop(false);
		threeLabel.setText("+3 :");
		threeLabel.setTextAlign(HorizontalAlignment.RIGHT);

		twoLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		twoLabel.setForeColor(new Color(224, 224, 224));
		twoLabel.setLocation(new Point(520, 112));
		twoLabel.setSize(new Point(56, 32));
		twoLabel.setTabIndex(60);
		twoLabel.setTabStop(false);
		twoLabel.setText("+2 :");
		twoLabel.setTextAlign(HorizontalAlignment.RIGHT);

		oneLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		oneLabel.setForeColor(new Color(224, 224, 224));
		oneLabel.setLocation(new Point(520, 80));
		oneLabel.setSize(new Point(56, 32));
		oneLabel.setTabIndex(56);
		oneLabel.setTabStop(false);
		oneLabel.setText("+1 :");
		oneLabel.setTextAlign(HorizontalAlignment.RIGHT);

		healthLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		healthLabel.setForeColor(new Color(224, 224, 224));
		healthLabel.setLocation(new Point(576, 16));
		healthLabel.setSize(new Point(72, 24));
		healthLabel.setTabIndex(37);
		healthLabel.setTabStop(false);
		healthLabel.setText("Health");
		healthLabel.setTextAlign(HorizontalAlignment.CENTER);

		baseLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		baseLabel.setForeColor(new Color(224, 224, 224));
		baseLabel.setLocation(new Point(520, 48));
		baseLabel.setSize(new Point(56, 32));
		baseLabel.setTabIndex(55);
		baseLabel.setTabStop(false);
		baseLabel.setText("Base :");
		baseLabel.setTextAlign(HorizontalAlignment.RIGHT);

		manaLabel.setFont(new Font("Arial", 14.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		manaLabel.setForeColor(new Color(224, 224, 224));
		manaLabel.setLocation(new Point(648, 16));
		manaLabel.setSize(new Point(72, 24));
		manaLabel.setTabIndex(36);
		manaLabel.setTabStop(false);
		manaLabel.setText("Mana");
		manaLabel.setTextAlign(HorizontalAlignment.CENTER);

		spellList.setBackColor(Color.DARKGRAY);
		spellList.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		spellList.setForeColor(Color.WHITE);
		spellList.setLocation(new Point(24, 368));
		spellList.setSize(new Point(264, 52));
		spellList.setTabIndex(80);
		spellList.setText("listBox1");
		spellList.setUseTabStops(true);
		spellList.setItems(new Object[] {
						   "1", 
						   "2", 
						   "3"});

		statusBar.setBackColor(Color.CONTROL);
		statusBar.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		statusBar.setLocation(new Point(0, 498));
		statusBar.setSize(new Point(721, 20));
		statusBar.setTabIndex(79);
		statusBar.setText("STATUS BAR");

		DregStarter.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		DregStarter.setLocation(new Point(24, 456));
		DregStarter.setSize(new Point(80, 24));
		DregStarter.setTabIndex(86);
		DregStarter.setText("Dreg");
		DregStarter.addOnClick(new EventHandler(this.DregStarter_click));

		ElfStarter.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		ElfStarter.setLocation(new Point(112, 456));
		ElfStarter.setSize(new Point(80, 24));
		ElfStarter.setTabIndex(85);
		ElfStarter.setText("Elf");
		ElfStarter.addOnClick(new EventHandler(this.ElfStarter_click));

		GnomeStarter.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		GnomeStarter.setLocation(new Point(200, 456));
		GnomeStarter.setSize(new Point(80, 24));
		GnomeStarter.setTabIndex(84);
		GnomeStarter.setText("Gnome");
		GnomeStarter.addOnClick(new EventHandler(this.GnomeStarter_click));

		ScallionStarter.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		ScallionStarter.setLocation(new Point(288, 456));
		ScallionStarter.setSize(new Point(80, 24));
		ScallionStarter.setTabIndex(83);
		ScallionStarter.setText("Scallion");
		ScallionStarter.addOnClick(new EventHandler(this.ScallionStarter_click));

		HumanStarter.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		HumanStarter.setLocation(new Point(376, 456));
		HumanStarter.setSize(new Point(80, 24));
		HumanStarter.setTabIndex(82);
		HumanStarter.setText("Human");
		HumanStarter.addOnClick(new EventHandler(this.HumanStarter_click));

		BehockStarter.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		BehockStarter.setLocation(new Point(464, 456));
		BehockStarter.setSize(new Point(80, 24));
		BehockStarter.setTabIndex(81);
		BehockStarter.setText("Behock");
		BehockStarter.addOnClick(new EventHandler(this.BehockStarter_click));

		neutralButton.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		neutralButton.setLocation(new Point(600, 376));
		neutralButton.setSize(new Point(80, 16));
		neutralButton.setTabIndex(88);
		neutralButton.setTabStop(true);
		neutralButton.setText("Neutral");
		neutralButton.setChecked(true);
		neutralButton.addOnCheckedChanged(new EventHandler(this.neutralButton_checkedChanged));

		fullButton.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		fullButton.setLocation(new Point(600, 400));
		fullButton.setSize(new Point(80, 16));
		fullButton.setTabIndex(87);
		fullButton.setText("Full Good");
		fullButton.addOnCheckedChanged(new EventHandler(this.fullButton_checkedChanged));

		starterHelpGroup.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		starterHelpGroup.setLocation(new Point(16, 432));
		starterHelpGroup.setSize(new Point(536, 56));
		starterHelpGroup.setTabIndex(89);
		starterHelpGroup.setTabStop(false);
		starterHelpGroup.setText("Starter Help");

		alignmentGroup.setFont(new Font("Arial", 10.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		alignmentGroup.setLocation(new Point(584, 352));
		alignmentGroup.setSize(new Point(112, 72));
		alignmentGroup.setTabIndex(90);
		alignmentGroup.setTabStop(false);
		alignmentGroup.setText("Alignment");

		menuReset.setShortcut(Shortcut.CTRL_R);
		menuReset.setText("Reset");
		menuReset.addOnClick(new EventHandler(this.clear_click));

		menuExit.setShortcut(Shortcut.CTRL_E);
		menuExit.setText("Exit");
		menuExit.addOnClick(new EventHandler(this.menuItem3_click));

		menuPrint.setEnabled(false);
		menuPrint.setShortcut(Shortcut.CTRL_P);
		menuPrint.setText("Print To File");
		menuPrint.addOnClick(new EventHandler(this.save_click));

		menuPlanner.setMenuItems(new MenuItem[] {
								 menuPrint});
		menuPlanner.setText("Planner");

		experienceShow.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		experienceShow.setForeColor(Color.YELLOW);
		experienceShow.setLocation(new Point(312, 400));
		experienceShow.setSize(new Point(240, 24));
		experienceShow.setTabIndex(93);
		experienceShow.setTabStop(false);
		experienceShow.setText("0");
		experienceShow.setTextAlign(HorizontalAlignment.CENTER);

		menuUpdate.setShortcut(Shortcut.CTRL_U);
		menuUpdate.setText("Check For Updates");
		menuUpdate.addOnClick(new EventHandler(this.updateButton_click));

		menuSpacerOne.setText("-");

		menuFile.setMenuItems(new MenuItem[] {
							  menuReset, 
							  menuSpacerOne, 
							  menuUpdate, 
							  menuSpacerTwo, 
							  menuExit});
		menuFile.setText("File");

		label2.setBackColor(Color.GRAY);
		label2.setLocation(new Point(16, 336));
		label2.setSize(new Point(688, 8));
		label2.setTabIndex(92);
		label2.setTabStop(false);
		label2.setText("");

		experienceNeededLabel.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.BOLD, false, false, false, CharacterSet.DEFAULT, 0));
		experienceNeededLabel.setForeColor(Color.YELLOW);
		experienceNeededLabel.setLocation(new Point(312, 368));
		experienceNeededLabel.setSize(new Point(240, 24));
		experienceNeededLabel.setTabIndex(95);
		experienceNeededLabel.setTabStop(false);
		experienceNeededLabel.setText("Experience needed to obtain this level :");
		experienceNeededLabel.setTextAlign(HorizontalAlignment.CENTER);

		spellsEarnedLabel.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false, CharacterSet.DEFAULT, 0));
		spellsEarnedLabel.setLocation(new Point(24, 352));
		spellsEarnedLabel.setSize(new Point(144, 16));
		spellsEarnedLabel.setTabIndex(91);
		spellsEarnedLabel.setTabStop(false);
		spellsEarnedLabel.setText("Spells earned this level :");

		menuBonusEJTwo.setText("15, 17, 19");

		menuBonusEJThree.setText("21, 25, 29");

		menuBonusEJFour.setText("34, 39, 45");

		menuBonusHallTwo.setText("50");

		menuItem8.setText("-");

		menuBonusHallThree.setText("61, 71, 81, 91");

		menuBonusHallFour.setText("etc...");

		menuBonusEJOne.setText("EJ Confirmed :");

		menuBonusHallOne.setText("Halloween added :");

		menuBonus.setMenuItems(new MenuItem[] {
							   menuBonusEJOne, 
							   menuBonusEJTwo, 
							   menuBonusEJThree, 
							   menuBonusEJFour, 
							   menuItem8, 
							   menuBonusHallOne, 
							   menuBonusHallTwo, 
							   menuBonusHallThree, 
							   menuBonusHallFour});
		menuBonus.setText("Bonuses");

		mainMenu1.setMenuItems(new MenuItem[] {
							   menuFile, 
							   menuPlanner, 
							   menuBonus});

		this.setBackColor(Color.BLACK);
		this.setForeColor(new Color(224, 224, 224));
		this.setText("JAVA Stat Calculator (windows version) by Halloween The Warlock");
		this.setAutoScaleBaseSize(new Point(5, 13));
		this.setBorderStyle(FormBorderStyle.FIXED_SINGLE);
		this.setClientSize(new Point(721, 518));
		this.setIcon((Icon)resources.getObject("this_icon"));
		this.setMaximizeBox(false);
		this.setMenu(mainMenu1);
		this.setStartPosition(FormStartPosition.CENTER_SCREEN);
		this.addOnClick(new EventHandler(this.Form1_click));

		this.setNewControls(new Control[] {
							experienceShow, 
							experienceNeededLabel, 
							label2, 
							spellsEarnedLabel, 
							fullButton, 
							neutralButton, 
							BehockStarter, 
							HumanStarter, 
							ScallionStarter, 
							GnomeStarter, 
							ElfStarter, 
							DregStarter, 
							spellList, 
							statusBar, 
							HTML, 
							jelocButton, 
							shrineButton, 
							saveIn, 
							lvlIn, 
							strIn, 
							agilIn, 
							consIn, 
							intelIn, 
							wisIn, 
							mpbase, 
							mpone, 
							mptwo, 
							mpthree, 
							mpfour, 
							mpfive, 
							mpsix, 
							mpseven, 
							mpeight, 
							hpbase, 
							hpone, 
							hptwo, 
							hpthree, 
							hpfour, 
							hpfive, 
							hpsix, 
							hpseven, 
							hpeight, 
							manaLabel, 
							healthLabel, 
							baseLabel, 
							oneLabel, 
							twoLabel, 
							threeLabel, 
							fourLabel, 
							fiveLabel, 
							sixLabel, 
							sevenLabel, 
							eightLabel, 
							actualLabel, 
							usedLabel, 
							remainingLabel, 
							actual, 
							used, 
							remain, 
							classShow, 
							classLabel, 
							agilityLabel, 
							constitutionLabel, 
							intelligenceLabel, 
							wisdomLabel, 
							classMinus, 
							classPlus, 
							levelLabel, 
							strengthLabel, 
							strengthShrine, 
							agilityShrine, 
							constitutionShrine, 
							intelligenceShrine, 
							wisdomShrine, 
							ghShrine, 
							strengthJeloc, 
							agilityJeloc, 
							constitutionJeloc, 
							intelligenceJeloc, 
							wisdomJeloc, 
							sixthJeloc, 
							strMinus, 
							strPlus, 
							agilMinus, 
							agilPlus, 
							consMinus, 
							consPlus, 
							intelMinus, 
							intelPlus, 
							wisMinus, 
							wisPlus, 
							levelMinus, 
							levelPlus, 
							starterHelpGroup, 
							alignmentGroup});
	}

	
	//-------------------------------------------------------
	// CLEAR
	//-------------------------------------------------------
	private void clear_click(Object source, Event e)
	{
		DregStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		ElfStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		GnomeStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		ScallionStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		HumanStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		BehockStarter.setFont(new Font("Arial", 9.0f, FontSize.POINTS, FontWeight.NORMAL, false, false, false));
		
		trailer = new xenimusNode(null,0,0,0,0,0,0,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0,null,null);
		header = new xenimusNode(null,0,0,0,0,0,0,null,null,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,null,0,null,trailer);
		menuPrint.setEnabled(false);
		saveIn.setText("Calc_Stats");
		HTML.setCheckState(0);
		saveToHTML = false;
		
		neutralButton.setChecked(true);
		
		shrineText = new String[6];
		jelocText = new String[6];
		
		strengthShrine.setCheckState(0);
		agilityShrine.setCheckState(0);
		constitutionShrine.setCheckState(0);
		intelligenceShrine.setCheckState(0);
		wisdomShrine.setCheckState(0);
		ghShrine.setCheckState(0);
		
		sixthJeloc.setCheckState(0);
		strengthJeloc.setCheckState(0);
		agilityJeloc.setCheckState(0);
		constitutionJeloc.setCheckState(0);
		intelligenceJeloc.setCheckState(0);
		wisdomJeloc.setCheckState(0);
		
		sixthJeloc.setEnabled(false);
		strengthJeloc.setEnabled(false);
		agilityJeloc.setEnabled(false);
		constitutionJeloc.setEnabled(false);
		intelligenceJeloc.setEnabled(false);
		wisdomJeloc.setEnabled(false);
		
		strengthShrine.setBackColor(Color.RED);
		agilityShrine.setBackColor(Color.RED);
		constitutionShrine.setBackColor(Color.RED);
		intelligenceShrine.setBackColor(Color.RED);
		wisdomShrine.setBackColor(Color.RED);
		ghShrine.setBackColor(Color.RED);
		sixthJeloc.setBackColor(Color.RED);
		strengthJeloc.setBackColor(Color.RED);
		agilityJeloc.setBackColor(Color.RED);
		constitutionJeloc.setBackColor(Color.RED);
		intelligenceJeloc.setBackColor(Color.RED);
		wisdomJeloc.setBackColor(Color.RED);
		
		selectAllShrines = false;
		JELOC = false;
		selectAllJeloc = false;
		
		shrineButton.setFont(new Font("MS Shell Dlg", 11.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false));
		jelocButton.setFont(new Font("MS Shell Dlg", 11.0f, FontSize.CHARACTERHEIGHT, FontWeight.NORMAL, false, false, false));
		
		classNumber = 0;
		lvl = 1;
		statArray[0] = 10;  shrineArray[0] = 0;
		statArray[1] = 10;  shrineArray[1] = 0;
		statArray[2] = 10;  shrineArray[2] = 0;
		statArray[3] = 10;  shrineArray[3] = 0;
		statArray[4] = 10;  shrineArray[4] = 0;
		
		starterHelp = false;
		starterMin[0] = 10;	starterMax[0] = 10;
		starterMin[1] = 10;	starterMax[1] = 10;
		starterMin[2] = 10;	starterMax[2] = 10;
		starterMin[3] = 10;	starterMax[3] = 10;
		starterMin[4] = 10;	starterMax[4] = 10;
		
		neutralButton.setChecked(true);
		fullButton.setChecked(false);
		
		this.redo();
		
		statusBar.setText("For help with the starting stats of races, use the six buttons above ^ ^ ^ ^ ^ ^");
	}

	
	//-------------------------------------------------------
	// redo
	//-------------------------------------------------------
	private void redo()
	{
		if (starterHelp == true)
		{
			statusBar.setText("The min and max bounds will be removed after hitting either the lvl up, or the Jeloc button");
		}
		else
		{
			statusBar.setText("");
		}
		
		//write class name to label
		
		if (classNumber == 0){ classShow.setText("Fighter"); }
		if (classNumber == 1){ classShow.setText("Ranger"); }
		if (classNumber == 2){ classShow.setText("Paladin"); }
		if (classNumber == 3){ classShow.setText("Cleric"); }
		if (classNumber == 4){ classShow.setText("Wizard"); }
		if (classNumber == 5){ classShow.setText("Warlock"); }
		if (classNumber == 6){ classShow.setText("Druid"); }
		if (classNumber == 7){ classShow.setText("Darkwar"); }
		if (classNumber == 8){ classShow.setText("Barbarian"); }

		//enable jeloc shrines after turning level 36+
		//but not if sixth shrine is selected
		if(lvl>=36 && JELOC==false)
		{
			sixthJeloc.setEnabled(true);
			strengthJeloc.setEnabled(true);
			agilityJeloc.setEnabled(true);
			constitutionJeloc.setEnabled(true);
			intelligenceJeloc.setEnabled(true);
			wisdomJeloc.setEnabled(true);
		}
		
		//write statArray to text boxes (needed when using -/+ buttons)
		lvlIn.setText(lvl+"");
		strIn.setText(statArray[0]+"");
		agilIn.setText(statArray[1]+"");
		consIn.setText(statArray[2]+"");
		intelIn.setText(statArray[3]+"");
		wisIn.setText(statArray[4]+"");

		//determine points actual/used/remaining, and write to labels
		actualPoints = 75+(lvl-1);
		usedPoints = (statArray[0]+statArray[1]+statArray[2]+statArray[3]+statArray[4])-(shrineArray[0]+shrineArray[1]+shrineArray[2]+shrineArray[3]+shrineArray[4]);
		remainingPoints = actualPoints-usedPoints;
		actual.setText(actualPoints+"");
		used.setText(usedPoints+"");
		remain.setText(remainingPoints+"");

		//calculate health and mana for 0 bases
		calc = new Calc(classNumber,lvl,0,0,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpbase.setText(calc.getHealth()+"");
		this.displayMP(mpbase,calc.getMana());

		//calculate health and mana for +1 bases
		calc = new Calc(classNumber,lvl,1,1,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpone.setText(calc.getHealth()+"");
		this.displayMP(mpone,calc.getMana());

		//calculate health and mana for +2 bases
		calc = new Calc(classNumber,lvl,2,2,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hptwo.setText(calc.getHealth()+"");
		this.displayMP(mptwo,calc.getMana());

		//calculate health and mana for +3 bases
		calc = new Calc(classNumber,lvl,3,3,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpthree.setText(calc.getHealth()+"");
		this.displayMP(mpthree,calc.getMana());

		//calculate health and mana for +4 bases
		calc = new Calc(classNumber,lvl,4,4,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpfour.setText(calc.getHealth()+"");
		this.displayMP(mpfour,calc.getMana());

		//calculate health and mana for +5 bases
		calc = new Calc(classNumber,lvl,5,5,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpfive.setText(calc.getHealth()+"");
		this.displayMP(mpfive,calc.getMana());

		//calculate health and mana for +6 bases
		calc = new Calc(classNumber,lvl,6,6,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpsix.setText(calc.getHealth()+"");
		this.displayMP(mpsix,calc.getMana());

		//calculate health and mana for +7 bases
		calc = new Calc(classNumber,lvl,7,7,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpseven.setText(calc.getHealth()+"");
		this.displayMP(mpseven,calc.getMana());

		//calculate health and mana for +8 bases
		calc = new Calc(classNumber,lvl,8,8,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4]);
		hpeight.setText(calc.getHealth()+"");
		this.displayMP(mpeight,calc.getMana());

		for (int i=0; i<6; i++){ shrineText[i]="&nbsp;&nbsp;"; }
		if (ghShrine.getCheckState() == 1) { shrineText[0]="gh&nbsp;"; }
		if (strengthShrine.getCheckState() == 1) { shrineText[1]="str&nbsp;"; }
		if (agilityShrine.getCheckState() == 1) { shrineText[2]="agil&nbsp;"; }
		if (constitutionShrine.getCheckState() == 1) { shrineText[3]="cons&nbsp;"; }
		if (intelligenceShrine.getCheckState() == 1) { shrineText[4]="intel&nbsp;"; }
		if (wisdomShrine.getCheckState() == 1) { shrineText[5]="wis&nbsp;"; }
		
		for (int i=0; i<6; i++){ jelocText[i]="&nbsp;&nbsp;"; }
		if (sixthJeloc.getCheckState() == 1) { jelocText[0]="six&nbsp;"; }
		if (strengthJeloc.getCheckState() == 1) { jelocText[1]="str&nbsp;"; }
		if (agilityJeloc.getCheckState() == 1) { jelocText[2]="agil&nbsp;"; }
		if (constitutionJeloc.getCheckState() == 1) { jelocText[3]="cons&nbsp;"; }
		if (intelligenceJeloc.getCheckState() == 1) { jelocText[4]="intel&nbsp;"; }
		if (wisdomJeloc.getCheckState() == 1) { jelocText[5]="wis&nbsp;"; }
		
		String shrineTemp = "";
		String jelocTemp = "";
		for (int i=0; i<6; i++){ shrineTemp+=shrineText[i]; }
		for (int i=0; i<6; i++){ jelocTemp+=jelocText[i]; }
		
		String alignText = "Neutral";
		if (fullButton.getChecked() == true){ alignText = "Full Good"; }
		
		Spells spells = new Spells(classNumber,lvl);
		spellList.setItems(spells.get());
		
		Experience exp = new Experience(lvl);
		experienceShow.setText(exp.get());
		
		newNode = new xenimusNode(classShow.getText(),lvl,statArray[0],statArray[1],statArray[2],statArray[3],statArray[4],shrineTemp,jelocTemp,
								  Integer.parseInt(hpbase.getText()),Integer.parseInt(hpone.getText()),Integer.parseInt(hptwo.getText()),
								  Integer.parseInt(hpthree.getText()),Integer.parseInt(hpfour.getText()),Integer.parseInt(hpfive.getText()),
								  Integer.parseInt(hpsix.getText()),Integer.parseInt(hpseven.getText()),Integer.parseInt(hpeight.getText()),
								  Integer.parseInt(mpbase.getText()),Integer.parseInt(mpone.getText()),Integer.parseInt(mptwo.getText()),
								  Integer.parseInt(mpthree.getText()),Integer.parseInt(mpfour.getText()),Integer.parseInt(mpfive.getText()),
								  Integer.parseInt(mpsix.getText()),Integer.parseInt(mpseven.getText()),Integer.parseInt(mpeight.getText()),
								  alignText,remainingPoints,spells.get(),trailer);
	}

	
	//-------------------------------------------------------
	// Display the MP, account for Alignment if necessary
	//-------------------------------------------------------
	public void displayMP(Label change, int mp)
	{
		if (fullButton.getChecked() == true)
		{
			if (classNumber == 3){ change.setText((int)(mp*1.624)+""); }
			else { /*change.setText((int)(calc.getMana()));*/ }
		}
		else { change.setText(mp+""); }
	}
	

	private void menuItem3_click(Object source, Event e)
	{
		System.exit(0);
	}
	
	
	//-------------------------------------------------------
	// The main entry point for the application. 
	//
	// @param args Array of parameters passed to the application
	// via the command line.
	//-------------------------------------------------------
	public static void main(String args[])
	{ Application.run(new Form1()); }
}
