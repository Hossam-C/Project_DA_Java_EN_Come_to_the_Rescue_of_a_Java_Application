package com.hemebiotech.analytics;

/**
 * Main function
 *
 *@author Hossam CHENAOUI
 *
 *@description Application that read a file symptom as input, counts every symptoms and writes it in an output file
 */

public class AnalyticsCounter {

	public static void main(String args[])  throws Exception{

		/**
		 *
		 * @param symptomFilePath : File Path of the symptom file
		 * @param resultFilePath  : File Path of the result file
		 */
		// Initialize the files paths / The files are in the local libraries.
		String symptomFilePath = "symptoms.txt";
		//String symptomFilePath = "symptoms.CSV";
		String resultFilePath = "result.out";

		Counter count = new Counter(symptomFilePath, resultFilePath);
		count.count();
	}
}