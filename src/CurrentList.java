import java.util.*;
import java.io.*;
public class CurrentList {
	List<Content> currentList;
	private PlayList myList;
	public CurrentList() {
		currentList = new ArrayList<Content>();
		myList = new PlayList();
	}
	
	
	public PlayList getMyList() {
		return myList;
	}
	
	public synchronized void addSongs(Scanner myScanner) throws Exception{
		System.out.println("Please enter the CD name");
		String CDName = myScanner.nextLine();
		System.out.println("Please enter the CD Player");
		String player = myScanner.nextLine();
		System.out.println("Please enter the CD Year");
		String Year = myScanner.nextLine();
		System.out.println("Please input the total numbers of songs!");
		int total = Integer.parseInt(myScanner.nextLine());
		int tempIndex = 0;
		List<ADD> addList = myList.getAddList();
		for (int i = 0 ; i < total ; i ++) {
			System.out.println("Please enter the song name");
			String name = myScanner.nextLine();
			System.out.println("Please enter the length");
			String length = myScanner.nextLine();
			Songs temp = new Songs(name, length, CDName, Year, player);
			currentList.add(temp);
			myList.addSong(temp);
			currentList.add(addList.get(tempIndex));
			tempIndex += 1;
			if (tempIndex == addList.size()) {
				tempIndex = 0;
			}
		}
		
	}
	public synchronized String shuffle(String fileName) throws IOException {
		myList.play((Songs)currentList.get(0));
		String result = "";
		result += currentList.get(0).printFormat();
		currentList.remove(0);
		result += currentList.get(0).printFormat();
		currentList.remove(0);
		Collections.shuffle(currentList);
		myList.write(fileName);
		return result;
	}

	public String play(String fileName) throws IOException {
		myList.play((Songs)currentList.get(0));
		String result = "";
		result += currentList.get(0).printFormat();
		currentList.remove(0);
		result += currentList.get(0).printFormat();
		currentList.remove(0);
		myList.write(fileName);
		return result;
		
	}
	public void setMyList(PlayList myList) {
		this.myList = myList;
	}


	public List<Content> getCurrentList() {
		return currentList;
	}

	public void generateCurrentList() {
		List<Songs> songList = myList.getSongList();
		List<ADD> addList = myList.getAddList();
		int addIndex = 0;
		for (int i = 0 ; i< songList.size() ; i ++) {
			currentList.add(songList.get(i));
			currentList.add(addList.get(addIndex));
			addIndex += 1;
			if (addIndex == addList.size()) {
				addIndex = 0;
			}
		}
	}
	public static CurrentList read(String fileName) throws FileNotFoundException {
		File readFile = new File(fileName);
		Scanner myScanner = new Scanner(readFile);
		CurrentList result = new CurrentList();
		PlayList testList = PlayList.read(myScanner);
		result.setMyList(testList);
		result.generateCurrentList();
		return result;
	}
	
	public String getPrintFormat() {
		String result = "";
		for (int i = 0; i < currentList.size(); i++) {
			result += currentList.get(i).printFormat();
		}
		return result;
	}
}
