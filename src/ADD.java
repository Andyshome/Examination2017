
public class ADD extends Content{

	public ADD(String name, String length) {
		super(name, length);
		// TODO Auto-generated constructor stub
	}
	
	public String getType() {
		return "ADD";
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
	
	public static ADD read(String[] content) {
		return new ADD(content[0].split(" ")[1],content[1]);
	}

	@Override
	public String printFormat() {
		String result = "Next add: "+ super.getName() + " (" + super.getLength() +")\n" ;
		return result;
	}
}
