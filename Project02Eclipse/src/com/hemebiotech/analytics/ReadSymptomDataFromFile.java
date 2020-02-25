package com.hemebiotech.analytics;

import java.util.List;

/**
 * This class will be extended for the reading class.
 * For now, there is only the .txt reader, but eventually, other format file will be available
 *
 */
public abstract class ReadSymptomDataFromFile {

	private String filepath;
	/**
	 *
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

}