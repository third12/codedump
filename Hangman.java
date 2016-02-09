import java.util.Scanner;
import java.util.*;
import java.io.*;
class Hangman{

public static void main(String[] args){
	Scanner scan = new Scanner(System.in);
	System.out.println("Enter word to guess: ");
	String word = scan.nextLine();
	int x = word.length();

	char ar1[] = new char[x];
	char ar2[] = new char[x];
	String ar3[] = new String[x];
	String used = "";
	String print[] ={"_____\n|   |\n|   O\n|  -|-\n|  / \\","_____\n|   |\n|   O\n|  -|-\n|  /","_____\n|   |\n|   O\n|  -|-\n|","_____\n|   |\n|   O\n|  -|\n|","_____\n|   |\n|   O\n|   |\n|", "_____\n|   |\n|   O\n|\n|","_____\n|   |\n|\n|\n|"};
	String hangman ="\n\n\n\n\n\n\n\n\n\n  _   _      _      _   _    ____   __  __      _      _   _ \n | | | |    / \\    | \\ | |  / ___| |  \\/  |    / \\    | \\ | |\n | |_| |   / _ \\   |  \\| | | |  _  | |\\/| |   / _ \\   |  \\| |\n |  _  |  / ___ \\  | |\\  | | |_| | | |  | |  / ___ \\  | |\\  |\n |_| |_| /_/   \\_\\ |_| \\_|  \\____| |_|  |_| /_/   \\_\\ |_| \\_|\n";

	System.out.println(hangman);
	for(int i=0;i<x;i++){
		ar1[i]=word.charAt(i);
		System.out.print(" _ ");
		ar3[i] = " _ ";
	}
	int lives = 6;
	System.out.print("\n");	
	System.out.println(print[lives]);	
	int count = 0;
	while (lives != 0){
	System.out.println("\nGuess a letter: ");
	String guess = scan.nextLine();
	char letter = guess.charAt(0);
	int in = word.indexOf(letter);
	int use = used.indexOf(letter);
	used = used + letter;
	
		if(in==-1&&use==-1){
			System.out.println("\n Wrong!!\n");
			lives--;
			System.out.println(print[lives]+"\n");	
			}
		else if((in==-1&&use!=-1)||(in!=-1&&use!=-1)){
			System.out.println("\nYou already used that letter\n");
			System.out.println(print[lives]+"\n");
		}
		
		else{
			for(int i=0;i<x;i++){
	
				if(ar1[i]==letter){
					ar2[i]=ar1[i];
					ar1[i]=0;
					ar3[i] = " " + ar2[i];
					}
			}
			System.out.println("\n Correct!!\n");
			System.out.println(print[lives]+"\n");
			}

		for(int i=0;i<x;i++){
			System.out.print(ar3[i]);
		}
		System.out.println("\n");
		String a = new String(ar2);

		if(a.equals(word)&&lives!=0){
		System.out.println("You win!!!");
		lives=0;
		}
		else if(lives==0){
		System.out.println("You lose!!!");
		System.out.println(print[lives]);
		}

	}
	scan.close();
}

}
