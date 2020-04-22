import java.util.ArrayList;

/*
 * StateStatistics class
 */
public class StateStatistics extends Generics {	
	/* fields
	 * 
	 */
	public static final String type = "State";
	public enum KeyType {combo, name, numCases, numDead, percentPositive};
	public static KeyType key = KeyType.combo;
	private String name; 
	private int numCases; 
	private int numDead;
	private String percentPositive;
	public static int totalCases = 824069;
	public static int totalDead = 45142;
	public static int totalRecovered = 75050;
	
	/* constructor
	 * 
	 */
	public StateStatistics(String name, int numCases, int numDead, String percentPositive)
	{
		this.setType(type);
		this.name = name; 
		this.numCases = numCases; 
		this.numDead = numDead; 
		this.percentPositive = percentPositive;
	}
	
	/* 
	 * toString provides output based off of this.key setting
	 */
	@Override
	public String toString()
	{
		String output="";
		switch(key) {
		case name:
			output += this.name;
			break;
		case numCases:
			output += this.numCases;
			break;
		case numDead:
			output += this.numDead;
			break;
		case percentPositive:
			output += this.percentPositive;
			break;
		case combo:
		default:
			output += type + ": " + this.name  + ", Cases- " + this.numCases + ", Dead-" + this.numDead + ", % of Positive Tests-" + this.percentPositive; 
		}
		return output;
		
	}
	
	/* Initialize Animal data
	 * 
	 */
	public static ArrayList<Generics> stateData() {
		ArrayList<Generics> sd = new ArrayList<Generics>();
		sd.add(new StateStatistics("Washington", 12499, 1641, "18.5%"));
		sd.add(new StateStatistics("New York", 258361, 18821, "32.6%"));
		sd.add(new StateStatistics("California", 33943, 1230, "7.4%"));
		sd.add(new StateStatistics("Maryland", 14193, 652, "12.3%"));
		sd.add(new StateStatistics("Wyoming", 438, 2, "13.2%"));
		sd.add(new StateStatistics("Massachusetts", 39643, 1809, "24.6%"));
		sd.add(new StateStatistics("Idaho", 1736, 48, "9.8%"));
		sd.add(new StateStatistics("Indiana", 12097, 635, "9.6%"));
		
		/*
		StateStatistics[] sd = { 
				new StateStatistics("Washington", 12499, 1641, "18.5%"),
				new StateStatistics("New York", 258361, 18821, "32.6%"),
				new StateStatistics("California", 33943, 1230, "7.4%"),
				new StateStatistics("Maryland", 14193, 652, "12.3%"),
				new StateStatistics("Wyoming", 438, 2, "13.2%"),
				new StateStatistics("Massachusetts", 39643, 1809, "24.6%"),
				new StateStatistics("Idaho", 1736, 48, "9.8%"),
				new StateStatistics("Indiana", 12097, 635, "9.6%")
		};
		*/
		return sd;
	}
	
	/* main to test Animal class
	 * 
	 */
	public static void main(String[] args)
	{
		ArrayList<Generics> sd = stateData();
		for(Generics a : sd)
			System.out.println(a);
	}

}
