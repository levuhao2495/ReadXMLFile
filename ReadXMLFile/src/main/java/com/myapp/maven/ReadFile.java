package com.myapp.maven;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.*;

public class ReadFile {
		
	void addList(String filelink,Structure strture, List<Structure> listst){
		try{
			File xmlFile= new File (filelink); //D:/Java Exercise/5-17-2017/sandboxsuite5_output.xml
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();// build parser
			Document doc= dBuilder.parse(xmlFile);
			doc.getDocumentElement().normalize();
			// read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			// The name of this node, depending on its type; see the table above
			NodeList nList =doc.getElementsByTagName("test");
			// Returns a NodeList of all the Elements in document order with a given tag name 
			for(int i= 0; i <nList.getLength(); i++){
				strture= new Structure ();
				Node nNode=nList.item(i); //Returns the indexth item in the collection
				if(nNode.getNodeType() == Node.ELEMENT_NODE){
					Element eElement = (Element) nNode;
					strture.setId((String) eElement.getAttribute("id"));
					strture.setName((String) eElement.getAttribute("name"));
					String str_author=eElement.getElementsByTagName("doc").item(0).getTextContent();
					String[] str_array= str_author.split("\\r?\\n"); //cut by each line
					if(str_array[0].equalsIgnoreCase("")){
						strture.setAuthor("");
					}else{
						strture.setAuthor((String)str_array[0].trim().substring(9));
					}
					listst.add(strture);
				} 
			}
		}catch (Exception e){
			e.printStackTrace();
			System.out.println("Read xml file or add List not success !"); 
		}
		System.out.println("Add success !");
	}
	
	
	void viewList(List<Structure> listst){
		System.out.println("-----VIEW LIST------");
		if(listst.size()==0){
			System.out.println("No structure!");
		}else{
			/*Iterator<Structure> iStr= listst.iterator();
			while(iStr.hasNext()){
				System.out.println("----------");
				System.out.println(iStr.next().getId().toString());
				System.out.println(iStr.next().getName().toString());
				if(iStr.next().getAuthor().toString().equalsIgnoreCase("")){
					System.out.println("");
				}
				else{
					System.out.println(iStr.next().getAuthor());
				}
			}*/
			for(Structure struc : listst){
				System.out.println("------------");
				System.out.println(struc.getId());
				System.out.println(struc.getName());
				System.out.println(struc.getAuthor());
			}
			/*for(int i=0; i<listst.size();i++){
				System.out.println("-----"+i+"------");
				System.out.println("Id: "+listst.get(i).getId());
				System.out.println("Name: "+listst.get(i).getName());
				System.out.println("Author: "+listst.get(i).getAuthor());
			} */
		}
	}
			
}
