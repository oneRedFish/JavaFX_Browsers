/*
 * @filename  FileUtils.java
 * @author MinyiYang, 040847473
 * @course CST8284 - OOP (java)
 * @Assignment 2
 * @date January 12th, 2018
 * @professor DaveHoutman
 * @purpose  This class is used for getting different menu items which have different function. 
 */
package assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is used for getting webEngine and webView and change the browser's title and catch MalformedURLException,IllegalArgumentException.
 *
 * @author Minyi Yang
 * @version 1.0 
 * @see package assignment2;
 * @see java.io.BufferedReader;
 * @see java.io.BufferedWriter;
 * @see java.io.File;
 * @see java.io.FileInputStream;
 * @see java.io.FileNotFoundException;
 * @see java.io.FileOutputStream;
 * @see java.io.FileWriter;
 * @see java.io.IOException;
 * @see java.io.InputStreamReader;
 * @see java.io.OutputStreamWriter;
 * @see java.io.PrintWriter;
 * @see java.util.ArrayList;
 * @see java.util.Scanner;
 * @since 1.8.0_144
 */
public class FileUtils {
	/**
	 * Create a String variable named filrName
	 */
	private String filrName;
	/**
	 * Create a String variable named path
	 */
	private String path;
	
	/**
	 * if file which name is 'bookmarks.web.txt' existed Save the string from ArrayList to file f,
	 * else save the default address 'http://www.google.ca' into it 
	 * @param f  a File is used to store the web addresses
	 * @param ar a String type of ArrayList which passes the value of address
	 */
	public static void saveFilrContents(File f, ArrayList<String> ar) {
			//insert to the file
		if(f.getName()=="bookmarks.web.txt") {
			try {
					 FileWriter fw = new FileWriter(f.getName(), true);
					 BufferedWriter bw = new BufferedWriter(fw);
					 PrintWriter ouput = new PrintWriter(bw);
					 String str = ar.get(0);
					 ouput.println(str);
					 ouput.close();
	
				} catch (IOException e1) {
					e1.printStackTrace();
				}	
			}
		else {
			if(fileExists(f)) {
				//instead of the file
				try {
					PrintWriter ouput = new PrintWriter(f);
					ouput.print("");
					ouput.print(ar.get(0));
					ouput.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
			else {
				//create a file named default.web
				try {
					PrintWriter ouput = new PrintWriter(f);
					ouput.print("http://www.google.ca");
					ouput.close();
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Return a String type of ArrayList which stores the value of address from the file f
	 * @param f a File is used to store the web addresses
	 * @return  a String type ArrayList which stores the value of address
	 */
	public static ArrayList<String> getFileContentsAsArrayList(File f){
					ArrayList<String> list = new ArrayList<>();
					if(f.getName()=="bookmarks.web.txt") {
						try {
								Scanner fileIn = new Scanner(f);//read the file
								while(fileIn.hasNext()) {
									list.add(fileIn.next());
								}
								fileIn.close();
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						return list;
					}
					else {
						if(fileExists(f)) {
							try {
									Scanner fileIn = new Scanner(f);//read the file
									while(fileIn.hasNext()) {
										list.add(fileIn.next());
									}//get words add \n to each word;
									fileIn.close();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							return list;
								
						}
						else {
							try {
								PrintWriter ouput = new PrintWriter(f);
								ouput.print("http://www.google.ca");
								list.add("http://www.google.ca");
								ouput.close();
							} catch (FileNotFoundException e1) {
								e1.printStackTrace();
							}
							return list;
						}
					}
					
	}
	
	/**
	 * if Bookmark file is not empty delete the a string from it, else delete the file 
	 * @param f    a File is used to store the web addresses
	 * @param url  the String which is from the Bookmark file
	 */
	public static void deleteFilrContents(File f, String url) {
		if(f.getName()=="bookmarks.web.txt") {
			try {
				File temp = File.createTempFile("file", ".txt", f.getParentFile());
				String charset = "UTF-8";
				String delete = url;
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f), charset));
				PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(temp), charset));
				for (String line; (line = reader.readLine()) != null;) {
					line = line.replace(delete, "");
					writer.println(line);
				}
				
				f.delete();
				temp.renameTo(f);
				if( reader.readLine() == null) {
					f.delete();
				}
				reader.close();
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Check a file exists or not
	 * @param f a File passed to this method 
	 * @return Boolean type true if file Exists
	 */
	public static Boolean fileExists(File f) {
		if(f.exists()) {
			return true;
		}
			return false;
	}
	
	/**
	 * Get the path
	 * @return the String value of file path
	 */
    public String getPath() {
    		return path;
    } 
    
    /**
     * Get the filename
     * @return  the String value of file name 
     */
    public String getFileName() {
    		return filrName;
    }
    
    /**
     * Set the path
     * @param s the String value of file path
     */
    public void setPath(String s) {
    		path=s;
    }
    
    /**
     * Set the filename
     * @param s the String value of file name 
     */
    public void setFileName(String s) {
    		filrName=s;
    }

}
