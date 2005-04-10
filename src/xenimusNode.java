public class xenimusNode
{
	private String CLASS;
	private int LEVEL;
	private int STRENGTH;
	private int AGILITY;
	private int CONSTITUTION;
	private int INTELLIGENCE;
	private int WISDOM;
	private String SHRINES;
	private String JELOC;
	private int HPBASE;
	private int HPONE;
	private int HPTWO;
	private int HPTHREE;
	private int HPFOUR;
	private int HPFIVE;
	private int HPSIX;
	private int HPSEVEN;
	private int HPEIGHT;
	private int MPBASE;
	private int MPONE;
	private int MPTWO;
	private int MPTHREE;
	private int MPFOUR;
	private int MPFIVE;
	private int MPSIX;
	private int MPSEVEN;
	private int MPEIGHT;
	private String ALIGNMENT;
	private int REMAIN;
	
	private String[] SPELLS;
	
	private xenimusNode NEXTNODE = null;
	
	public xenimusNode (String cla, int level, int strength, int agility, int constitution, int intelligence, int wisdom,
						String shrines, String jeloc, int hpbase, int hpone, int hptwo, int hpthree, int hpfour, int hpfive,
						int hpsix, int hpseven, int hpeight, int mpbase, int mpone, int mptwo, int mpthree, int mpfour, int mpfive,
						int mpsix, int mpseven, int mpeight, String alignment, int REMAINain, String[] spells, xenimusNode nextNode)
	{
		CLASS = cla;
		LEVEL = level;
		STRENGTH = strength;
		AGILITY = agility;
		CONSTITUTION = constitution;
		INTELLIGENCE = intelligence;
		WISDOM = wisdom;
		SHRINES = shrines;
		JELOC = jeloc;
		HPBASE = hpbase;
		HPONE = hpone;
		HPTWO = hptwo;
		HPTHREE = hpthree;
		HPFOUR = hpfour;
		HPFIVE = hpfive;
		HPSIX = hpsix;
		HPSEVEN = hpseven;
		HPEIGHT = hpeight;
		MPBASE = mpbase;
		MPONE = mpone;
		MPTWO = mptwo;
		MPTHREE = mpthree;
		MPFOUR = mpfour;
		MPFIVE = mpfive;
		MPSIX = mpsix;
		MPSEVEN = mpseven;
		MPEIGHT = mpeight;
		ALIGNMENT = alignment;
		REMAIN = REMAINain;
		SPELLS = spells;
		NEXTNODE = nextNode;                
	}
	
	public String getclass(){ return CLASS; }
	public int getlevel(){ return LEVEL; }
	public int getstrength(){ return STRENGTH; }
	public int getagility(){ return AGILITY; }
	public int getconstitution(){ return CONSTITUTION; }
	public int getintelligence(){ return INTELLIGENCE; }
	public int getwisdom(){ return WISDOM; }
	public String getshrines(){ return SHRINES; }
	public String getjeloc(){ return JELOC; }
	public int gethpbase(){ return HPBASE; }
	public int gethpone(){ return HPONE; }
	public int gethptwo(){ return HPTWO; }
	public int gethpthree(){ return HPTHREE; }
	public int gethpfour(){ return HPFOUR; }
	public int gethpfive(){ return HPFIVE; }
	public int gethpsix(){ return HPSIX; }
	public int gethpseven(){ return HPSEVEN; }
	public int gethpeight(){ return HPEIGHT; }
	public int getmpbase(){ return MPBASE; }
	public int getmpone(){ return MPONE; }
	public int getmptwo(){ return MPTWO; }
	public int getmpthree(){ return MPTHREE; }
	public int getmpfour(){ return MPFOUR; }
	public int getmpfive(){ return MPFIVE; }
	public int getmpsix(){ return MPSIX; }
	public int getmpseven(){ return MPSEVEN; }
	public int getmpeight(){ return MPEIGHT; }
	public String getalignment(){ return ALIGNMENT; }
	public int getremaining(){ return REMAIN; }
	
	public String[] getspells(){ return SPELLS; }
	
	public void setNext(xenimusNode set){ NEXTNODE=set; }
	public xenimusNode getNext(){ return NEXTNODE; }
}