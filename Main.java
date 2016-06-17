/****
 * Author : Ejandra Mae T. Dimacali
 * Date Created : June 8, 2016
 * 
 * Form Input Generator
 * This program asks an input text file from a user which contains a list.
 * The user wants to generate a form input (checkboxes) from that list. This program
 * generates a text file which contains the list formatted for form input use.
****/
package formInputGenerator;

import java.awt.EventQueue;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class Main {
	
	private static String[] tagBeforeTextChoices = {"Checkbox"};
	private static String[] tagAfterTextChoices = {"Break"};
	private static String content;
	
	public static void main(String[] args) {
		GUI frame = new GUI(tagBeforeTextChoices,tagAfterTextChoices); //generate the GUI.
		frame.setVisible(true);
	}
	
	
	public static void setContent(String content){
		Main.content = content;
	}
	
	public static void generateTextFile(String choiceBefore, String choiceAfter,String identifier){
		String toWrite = "";
		StringTokenizer strtok = new StringTokenizer(content,"\n");
		int counter = 0;
		String token,tagBefore,tagAfter;
		tagAfter = generateAfterTag(choiceAfter);
		
		while(strtok.hasMoreTokens()){
			token = strtok.nextToken();
			tagBefore = generateBeforeTag(choiceBefore,counter,identifier);
			toWrite += tagBefore + token + tagAfter + "\n";
			counter++;
		}
		
		FileIO.writeFile(toWrite);
		String dir = FileIO.getParentDir() + "\\output.txt";
		JOptionPane.showMessageDialog(null,"Output written in " + dir,"Output.txt Generated",JOptionPane.PLAIN_MESSAGE);
	}
	
	//Returns the tag before the choice according to user's chosen input type and specified identifier.
	private static String generateBeforeTag(String chosen,int iterationNum,String id){
		switch(chosen){
			case "Checkbox":
				return "<input type=\"checkbox\" name=\"" + id + iterationNum + "\" value=\"" + id + iterationNum + "\">";
			default:
				return null;
		}
	}
	
	//Returns the tag after the choice according to user choice
	private static String generateAfterTag(String chosen){
		switch(chosen){
			case "Break":
				return "<br>";
			default :
				return null;
		}
	}
	
}
