package coreProject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Album> albums=new ArrayList();
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Album album=new Album("Album1", "AC/DC");
       
       album.addSongs("TNT", 4.5);
       album.addSongs("Highway to hell", 3.5);
       album.addSongs("ThunderStruck", 5.0);
       albums.add(album);
       
       album =new Album("Album2","Eminem");
       
       album.addSongs("Rap god", 4.5);
       album.addSongs("Not Afraid", 3.5);
       album.addSongs("Lose yourself", 4.5);
       albums.add(album);
       
       LinkedList<Song> playList1=new LinkedList();
       albums.get(0).addToPlayList("TNT", playList1);
       albums.get(0).addToPlayList("Highway to hell", playList1);
       albums.get(1).addToPlayList("Rap god", playList1);
       albums.get(1).addToPlayList("Lose yourself", playList1);
       
       play(playList1);
	}
	
//	play the song******
	public static void play(LinkedList<Song> playList)
	{
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Song> listIterator=playList.listIterator();
		
		if(playList.size()==0)
		{
			System.out.println("The playlist doesn't have song");
		}
		else
		{
			System.out.println("Now playing "+listIterator.next().toString());
			printMenu();
		}
		
		while(!quit)
		{
			System.out.println("Enter your choice");
			int action=sc.nextInt();
			sc.nextLine();
			
			switch(action)
			{
			case 0:
				System.out.println("playList complete");
			    quit=true;
			    break;
			
			case 1:
				if(!forward)
				{
					if(listIterator.hasNext())
					{
						listIterator.next();
					}
					forward=true;
				}
				if(listIterator.hasNext())
				{
					System.out.println("Now playing "+listIterator.next().toString());
				}
				else
				{
					System.out.println("no song available, reached to the end of the list");
					forward=false;
				}
				break;
				
			case 2:
				if(forward)
				{
					if(listIterator.hasPrevious()) {
						listIterator.previous();
					}
					forward=false;
				}
				if(listIterator.hasPrevious()) {
					System.out.println("Now playing "+listIterator.previous().toString());
				}
				else {
					System.out.println("This is the first song");
					forward=false;
				}
				break;
				
			case 3:
				if(forward)
				{
					if(listIterator.hasPrevious()) {
						System.out.println("Now playing "+listIterator.previous().toString());
						forward=false;
					}else {
						System.out.println("we are at the start of the list");
					}					
				}else {
					if(listIterator.hasNext()) {
						System.out.println("Now playing "+listIterator.next().toString());
						forward=true;
					}else {
						System.out.println("we have reached to the end of list");
					}
				}
				break;
				
			case 4:
				printList(playList);
				break;
				
			case 5:
				printMenu();
				break;
				
			case 6:
				if(playList.size()>0) {
					listIterator.remove();
					if(listIterator.hasNext()) {
						System.out.println("Now removing "+listIterator.next().toString());
					}else {
						if(listIterator.hasPrevious())
						{
							System.out.println("Now playing "+listIterator.previous().toString());
						}
					}
				}
			}
		}
	}
	
//	print all song and perform some operation*****
	private static void printMenu()
	{
		System.out.println("Available options\n press");
		System.out.println("0 - to quit\n"
				+ "1 - press to next song\n"
				+ "2 - press to previous song\n"
				+ "3 - to replay the current song\n"
				+ "4 - list to all song\n"
				+ "5 - print all available options\n"
				+ "6 - to delete current song");
	}

	private static void printList(LinkedList<Song> playList)
	{
		Iterator<Song> iterator= playList.iterator();
		System.out.println("--------------");
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		System.out.println("-------------");
	}
}
