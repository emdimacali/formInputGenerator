package formInputGenerator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FileIO {
	
	private static String parentDir;
	
	//this opens up a file dialog and returns the file path of the chosen file.
	public static String openFileDialog(String fileExtension){
		File file;
		String fileName = null;
		 
		JFileChooser  fileDialog = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter( fileExtension.toUpperCase() + " Files", fileExtension);
        fileDialog.setFileFilter(filter);
        
        int returnVal = fileDialog.showOpenDialog(new JFrame()); 	//returns whether user cancelled or chose a file.
      
        if (returnVal == JFileChooser.APPROVE_OPTION) { 			//user specified a file
    	   file = fileDialog.getSelectedFile();						//we get the filename 
       	   parentDir = file.getParent();
    	   fileName = parentDir + "\\" + file.getName();
        }
        
        return fileName;
	}
	
	//this returns the read string from the text file specified , (String parameter : file extension to be read)
	public static String readFile(String fileName){
		String content = "";
        File file = new File(fileName);
        
        try {
	       FileReader reader = new FileReader(file);			//adapted from stackoverflow.com solution
	       char[] chars = new char[(int) file.length()];
	       reader.read(chars);
	       reader.close();
	       content = new String(chars);
	       content = content.replaceAll("\t", "");
        }catch(Exception e){
     	   JOptionPane.showMessageDialog(null,"Please contact the developer(ejandramae.16@gmail.com) to address this bug.","Error Encountered!",JOptionPane.PLAIN_MESSAGE);
        }
        
        return content;
	}
	
	//this writes to a .txt file the String toWrite to the specified fileName.
	public static void writeFile(String toWrite){
		String fileName = parentDir + "\\output.txt";
		File file = new File(fileName);
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
	         FileWriter writer = new FileWriter(file);			//adapted from stackoverflow.com solution
	         writer.write(toWrite,0,toWrite.length());
	         writer.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null,"Please contact the developer(ejandramae.16@gmail.com) to address this bug.","Error Encountered!",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public static String getParentDir(){
		return parentDir;
	}
}
