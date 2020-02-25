package com.hemebiotech.analytics;

/**
 * Main function
 *
 *@author Hossam CHENAOUI
 *
 *@description
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
		String resultFilePath = "result.out";

		Counter count = new Counter(symptomFilePath, resultFilePath);
		count.count();
	}
}