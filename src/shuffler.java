
public class shuffler  extends Thread{
	private CurrentList testList;
	private String fileName;
	public shuffler(CurrentList testList,String fileName) {
		this.testList = testList;
		this.fileName = fileName;
	}
	
	@Override
	public void run() {
		System.out.println("shuffle is starting");
		try {
			System.out.print(testList.shuffle(fileName));
		} catch (Exception e) {
			System.out.println("file operation error please check the file authoration!");
		}
		System.out.println("shuffle finished");
	}
}
