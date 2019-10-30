import java.util.*;
import java.io.*;

public class PlayList {
	List<Songs> songList;
 	List<ADD> addList;

 	
 	public PlayList() {
 		songList = new ArrayList<Songs>();
 		addList = new ArrayList<ADD>();
 	}
 	
 	public void addSong(Songs content) {
 		this.songList.add(content);
 	} 
 	public void addADDs(ADD content) {
 		this.addList.add(content);
 	}
 	public void play(Songs content) {
 		this.songList.remove(content);
 	}
 	public static PlayList read(Scanner myScanner)  {
 		myScanner.nextLine();
 		String player = null; 
 		String cdName = null;
 		String year = null;
 		PlayList result = new PlayList();
 		while(true) {
 			String Line = myScanner.nextLine();
 			if (Line.equals("ADDS")) {
 				break;
 			}
 			String[] LineContent = Line.split(", ");
 			String[] type = LineContent[0].split(" ");
 			if (type[0].equals("CD")){
 				cdName = LineContent[1];
 				year = LineContent[2];
 				player = type[1];
 			} else {
 				
 				result.addSong(Songs.read(LineContent, cdName,year,player));
 			}
 			
 			
 		}
 		
 		while(myScanner.hasNextLine()) {
 			String Line = myScanner.nextLine();
 			String[] LineContent = Line.split(", ");
 			result.addADDs(ADD.read(LineContent));
 		}
 		return result;
 		
 	}
 	
 	public void write(String flieName) throws IOException {
 		File writeFile = new File(flieName);
 		BufferedWriter writer = new BufferedWriter(new FileWriter(writeFile));
 		writer.write("CDS\n");
 		String CDName = "" ;
 		String playerName = "";
 		String year = "";
 		int tempCounter = 1;
 		for (int i = 0; i < songList.size(); i ++) {
 			String tempCDName = songList.get(i).getCDName();
 	 		String tempPlayerName = songList.get(i).getPlayer();
 	 		String tempYear = songList.get(i).getYear();
 			
 	 		if(!tempCDName.equals(CDName) || !tempPlayerName.equals(playerName) || !tempYear.equals(year)) {
 	 			CDName = tempCDName;
 	 			playerName = tempPlayerName;
 	 			year = tempYear;
 	 			writer.write("CD "+playerName+", "+ CDName+", "+year+"\n");
 	 			tempCounter = 1;
 	 		}
 	 		Songs tempSong = songList.get(i);
 	 		writer.write("SONG " + tempCounter + ", " + tempSong.getName() + ", " + tempSong.getLength() +"\n" );
 	 		tempCounter += 1;
 		}
 		writer.write("ADDS\n");
 		for (int i = 0; i < addList.size(); i++) {
 			ADD tempAdd = addList.get(i);
 			writer.write("ADD "+tempAdd.getName()+", "+tempAdd.getLength()+"\n");
 		}
 		writer.flush();
 		writer.close();
 	}
 	
 	
	public List<Songs> getSongList() {
		return songList;
	}

	public List<ADD> getAddList() {
		return addList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addList == null) ? 0 : addList.hashCode());
		result = prime * result + ((songList == null) ? 0 : songList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayList other = (PlayList) obj;
		if (addList == null) {
			if (other.addList != null)
				return false;
		} else if (!addList.equals(other.addList))
			return false;
		if (songList == null) {
			if (other.songList != null)
				return false;
		} else if (!songList.equals(other.songList))
			return false;
		return true;
	}
 	
 	
 	
}
