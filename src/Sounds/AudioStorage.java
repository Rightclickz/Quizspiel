package Sounds;

import java.util.ArrayList;
import java.util.HashMap;

import DBReader.MySqlConnection;

public class AudioStorage {

	private static HashMap<String, String> audioTable;
	
	public AudioStorage() {
		audioTable = new HashMap<String, String>();
		loadLinks();
	}
	
	public static HashMap<String, String> getAudioTable() {
		return audioTable;
	}

	private void loadLinks() {
		ArrayList<ArrayList<String>> allLinks = MySqlConnection.getEntrys("name, link", 2, "AudioLinks");
		
		for (ArrayList<String> singleLink : allLinks) {
			audioTable.put(singleLink.get(0), singleLink.get(1));
		}
	}
}
