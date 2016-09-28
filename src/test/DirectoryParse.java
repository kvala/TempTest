package test;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class DirectoryParse {

	/*
	public static void main(String[] args) {
		
	}
	*/
	public static void testFile(){
		
		
		File[] directories1 = new File("c://temp").listFiles(File::isDirectory);
		
		for (File file : directories1) {
			System.out.println(file);
		}
		
		File file = new File("c://temp");
		String[] directories = file.list(new FilenameFilter() {
		  @Override
		  public boolean accept(File current, String name) {
		    return new File(current, name).isDirectory();
		  }
		});
		System.out.println(Arrays.toString(directories));
		
		
	}
	
	
}
