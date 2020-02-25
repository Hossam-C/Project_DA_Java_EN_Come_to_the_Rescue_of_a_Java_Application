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

		//Write the result file
		IWriter writeResult = new Writer(tableSympt , "Project02Eclipse/result.out");
		writeResult.writeSympt();

	}
}
