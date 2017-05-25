package com.myapp.maven;

import java.util.ArrayList;
import java.util.List;
import com.myapp.maven.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest  {
	public static void main ( String[] args ){
		List<Structure> listExample= new ArrayList<Structure>();
		Structure structure = new Structure();
		String urlXml="sandboxsuite5_output.xml";
		ReadFile rf= new ReadFile();
	    	rf.addList(urlXml,structure,listExample);
	    	rf.viewList(listExample);			 
	    	}
}
