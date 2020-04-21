 

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
	public static Generics[] stateData() {
		Generics[] sd = { 
				new StateStatistics("Washington", 12499, 1641, "18.5%"),
				new StateStatistics("New York", 258361, 18821, "32.6%"),
				new StateStatistics("California", 33943, 1230, "7.4%"),
				new StateStatistics("Maryland", 14193, 652, "12.3%"),
				new StateStatistics("Wyoming", 438, 2, "13.2%"),
				new StateStatistics("Massachusetts", 39643, 1809, "24.6%"),
				new StateStatistics("Idaho", 1736, 48, "9.8%"),
				new StateStatistics("Indiana", 12097, 635, "9.6%")
		};
		return sd;
	}
	
	/* main to test Animal class
	 * 
	 */
	public static void main(String[] args)
	{
		Generics[] sd = stateData();
		for(Generics a : sd)
			System.out.println(a);
	}

}
