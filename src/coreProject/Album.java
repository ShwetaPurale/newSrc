package coreProject;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;
	public Album(String name, String artist) {
		super();
		this.name = name;
		this.artist = artist;
		this.songs = new ArrayList<Song>();
	}
	public Album() {
		
   }
	
//	find Song is already exist or not*********
	public Song findSong(String title)
	{
		for(Song checkedSong:songs)
		{
			if(checkedSong.equals(title))
			{
				return checkedSong;
			}
		}
		return null;
	}
	
//  add songs in song list***********	
    public boolean addSongs(String title,double duration)
    {
    	if(findSong(title)==null)
    	{
    		songs.add(new Song(title, duration));
//    		System.out.println(title+" the song added successfully");
    		return true;
    	}
    	else
    	{
    		System.out.println(title+" This song already exist in list");
    	return false;
    	}
    }
    
//   base on track number fetch the song and add that song in play list which is exist in arrayList*****
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
    {
    	int index=trackNumber-1;
    	if(index > 0 && index < this.songs.size())
    	{
    		playList.add(this.songs.get(index));
    		return true;
    	}
    	System.out.println("This album does not have song with track number "+trackNumber);
    	return false;
    }
    
//    base on song title fetch the song and add that song in play list which is exist in arrayList*******
    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
    	for(Song checkedSong: this.songs)
    	{
    		if(checkedSong.getTitle().equalsIgnoreCase(title))
    		{
    			playList.add(checkedSong);
    	        return true;
    		}
    	}
    	System.out.println(title+" There is no such a song in album");
    	return false;
    }
    
}

















