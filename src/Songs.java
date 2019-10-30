
public class Songs extends Content{
	private String player;
	private String CDName;
	private String year;
	public Songs(String name, String length, String CDName, String year,String player) {
		super(name, length);
		this.CDName = CDName;
		this.year = year;
		this.player = player;
		// TODO Auto-generated constructor stub
	}
	
	public String getPlayer() {
		return player;
	}

	public String getYear() {
		return year;
	}

	public String getType() {
		return "Song";
	}
	
	public String getCDName() {
		return this.CDName;
	}
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}
	
	public static Songs read(String[] content,String CDName,String year,String player) {
		return new Songs(content[1],content[2],CDName,year,player);
	}
	@Override
	public String printFormat() {
		// TODO Auto-generated method stub
		return "Album: " + this.player +"'s "+ this.getCDName() + "\n\tTrack " + super.getName() + "  (" + super.getLength() +")\n" ;
	}
	
	
	
}
