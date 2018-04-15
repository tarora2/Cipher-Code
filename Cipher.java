import java.util.*; 
import java.io.*;
/**
 * This program reads in the data from the user entered files
 * and makes an encoded or decoded (as per user request)
 * file.
 * 
 * @author Tushar Arora
 */
public class Cipher {
    /**
     * Writes a Cipher Encryption code
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
	    Scanner input = null;
	    PrintStream output = null;
	    boolean action = true;
	    String a = "e";
	    System.out.println("CIPHER ENCRYPTION: ENCODE and DECODE");
	    while (a.equals("e") || a.equals("E") || a.equals("D") || a.equals("d")) {
	        System.out.println(); 
	        System.out.print("Enter E-ncode, D-ecode, or Q-uit: ");
	        a = console.next();
	        if (a.equals("q") || a.equals("Q"))
			System.exit(1);
	    	else if (a.equals("e") || a.equals("E") || a.equals("D") || a.equals("d")) 
			{
				if (a.equals("e") || a.equals("E"))
		       		{
	    			   	input = getInputScanner(console);
	    				output = getOutputPrintStream(console);
						processFile (action, input, output);
		    		}
				else 
				{	
					input = getInputScanner(console);
	    			output = getOutputPrintStream(console);
					action = false;
					processFile(action, input, output);
		    	}
	    	}
	    	else 
			{
	    		System.out.println("Invalid action!!!!");
			    a = "e";
				continue;
	    	}
		}   
        input.close(); // Close the Scanner 
        output.close(); // Close the PrintStream
    }

    /**
     * Repeatedly prompts the user for the name of an input
     * file until the user enters tha name of an existing 
     * file; then creates and returns a Scanner for the input file
     *
     * @param Scanner console to read from the console
     */
    public static Scanner getInputScanner(Scanner console) {
		Scanner input = null;
		String name = "";
		System.out.print("Enter the name of the input file: ");
		while (input == null) {	
		    try {
		       	name = console.next();
		    	input = new Scanner(new File(name));
		    }  catch (FileNotFoundException e) {
		    	System.out.println("File does not exist.");
		    	System.out.print("Try again: ");
		    }
		}
		return input;
	}

    /**
     * Prompts the user for the name of an output file.
     * If the file does not exist, creates and returns 
     * a PrintStream for the output file.
     * If the user enters an output file that already exists
     * the user is asked to overwrite. If not the user is reprompted.
     *
     * @param Scanner console to read from the console
     */
    public static PrintStream getOutputPrintStream(Scanner console) {
		PrintStream output = null;
		String name = "";
		String ans = "";
		System.out.print("Enter the name of the output file: ");
		name = console.next();
    	  	try {
		    File f = new File(name);	
		    if (f.exists()) 
			{
				System.out.print("The file already exists, do you want to overwrite(y/n): ");
				ans = console.next();
				if (ans.equals("y") || ans.equals("Y")) 
				{
				    output = new PrintStream(f);
				}
				else 
				{
				    while (output == null) 
					{
						System.out.print("Enter the name of the other output file: ");	
		    	    	try {
	       		    		name = console.next();
			    			f = new File(name);
			    				while (f.exists()) 
								{
                					System.out.print("This file also exists(try again): ");
									name = console.next();
									f = new File(name);
			    				}
	    		    			output = new PrintStream(new File(name));
	    					}  catch (FileNotFoundException e) {
	    		    			System.out.println("Could not create this file.");
			    				System.exit(1);
	    					}
		    		}
				}
	    	}
	    	else 
			{
				output = new PrintStream(f);
	    	}
       		} catch (FileNotFoundException e) {
	    	System.out.println("Problem creating file.");
	    }
	return output;
    }

    /**
     * If encode is true, encodes lines in input and outputs encoded file
     * If encode is false, decodes lines in input and outputs decoded file
     *
     * @param boolean encode to check for encoding or decoding
     * @param Scanner input read from the file
     * @param PrintStream output to write in the file
     */
    public static void processFile(boolean encode, Scanner input, PrintStream output) {
		String line = " ";
		while (input.hasNextLine()) {
		    line = input.nextLine();
		    if (encode) {
			output.println(encodeLine(line));
		    }
		    else
			output.println(decodeLine(line));
		}
    }
	
    /**
     * Returns line containing encoded line
     * 
     * @param String line to encode a particular line
     * @return output encoded line
     */
    public static String encodeLine(String line) {
		String output = "";
		for (int i = 0 ; i < line.length() ; i+=2) {
		    output = output + line.charAt(i);
		}
		for (int i = 1 ; i < line.length() ; i+=2) {
		    output = output + line.charAt(i);
		}
		return output;
    }

    /**
     * Return string containing decoded line
     * 
     * @param String line to decode that particular line
     * @return output decoded line
     */
    public static String decodeLine(String line) {
		String output = "";
		for (int i = 0; i < line.length()/2; i++) {
		    output+=line.charAt(i);
		    if (line.length() % 2 == 0) 
				output += line.charAt(line.length()/2 + i);
		    else if ((line.length()/2 + 1) == i)
				output += line.charAt(line.length()/2);
		    else 
				output += line.charAt(line.length()/2 + i + 1);
		}
		if (line.length()%2 != 0)
		    output += line.charAt(line.length()/2);
		return output;
    }
}
















