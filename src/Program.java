import java.util.*;
import java.io.*;
public class Program {
	public static void main(String[] main) {
		Scanner myScanner = new Scanner(System.in);
		System.out.println("please input the file path:");
		try {
			String fileName = myScanner.nextLine();
			CurrentList testList = CurrentList.read(fileName);
			boolean status = true;
			while(status) {
				System.out.println("Please make your choice:");
				System.out.println("1 - Show the current playlist");
				System.out.println("2 - Add a new CD inluding songs");
				System.out.println("3 - Play");
				System.out.println("4 - shuffle");
				System.out.println("5 - stop the program");
				String temp = myScanner.nextLine();
				switch(temp) {
					case "1":
						System.out.println(testList.getPrintFormat());
						break;
					case "2":
						try {
							testList.addSongs(myScanner);
							break;
						} catch(Exception e) {
							System.out.println("please check your input!");
						}
					case "3":
						try {
							System.out.println(testList.play(fileName));
							break;
						} catch (IOException e) {
							e.printStackTrace();
						}
					case "4":
						new shuffler(testList, fileName).start();
						break;
					case "5":
						status = false;
						System.out.println("Thank you for using our program, see you next time!");
						break;
					default:
						System.out.println("Inlegal instruction, please check your input!");
				}
			}
		} catch(FileNotFoundException e) {
			System.out.println("file is not found please check your input, this program is terminating!");
		}
	}
}
