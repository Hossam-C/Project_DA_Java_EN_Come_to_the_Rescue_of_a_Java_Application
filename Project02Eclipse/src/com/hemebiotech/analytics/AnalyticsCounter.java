package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AnalyticsCounter {
	private static int headacheCount = 0;	// initialize to 0
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception {

		List<String> resultListe = new ArrayList<String>();
		TreeMap<String,Integer> tableSympt = new TreeMap<String,Integer>();

		// Read and stock the symptom file
		ISymptomReader liste = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		resultListe = liste.getSymptoms();

		//Formating the table list
		IFormat FormatTable = new FormatingResult(resultListe);
		tableSympt = FormatTable.formatListe();

		int i = 0;	// set i to 0
		while ( i < resultListe.size())  {
			System.out.println("symptom from file: " + resultListe.get(i));
			if (resultListe.get(i).equals("headache")) {
				headacheCount++;
				System.out.println("number of headaches: " + headacheCount);
			}
			else if (resultListe.get(i).equals("rash")) {
				rashCount++;
			}
			else if (resultListe.get(i).contains("pupils")) {
				pupilCount++;
			}
			i++;	// increment i

		}
		
		// next generate output
		FileWriter writer = new FileWriter ("Project02Eclipse/result.out");
		writer.write("headache: " + headacheCount + "\n");
		writer.write("rash: " + rashCount + "\n");
		writer.write("dialated pupils: " + pupilCount + "\n");
		writer.close();
	}
}
