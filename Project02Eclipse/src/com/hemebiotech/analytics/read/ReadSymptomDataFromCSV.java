package com.hemebiotech.analytics.read;

import com.hemebiotech.analytics.exceptions.EmptyException;
import com.hemebiotech.analytics.exceptions.PathException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class reading for .CSV files
 *
 */
public class ReadSymptomDataFromCSV extends ReadSymptomDataFromFile {

    private String filepath;

    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it,
     *                 one per line
     */
    public ReadSymptomDataFromCSV(String filepath) {
        super(filepath);
        this.filepath = super.filepath;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            if (filepath != null) {
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new FileReader(filepath));
                    String line = reader.readLine();

                    if (line == null) {
                        throw new EmptyException();
                    }
                    while (line != null) {
                        result.add(line);
                        line = reader.readLine();
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("Symptom File not found : please verify the file path.");
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
            else {
                throw new PathException();
            }
        } catch (PathException e) {
            System.out.println("Symptom's filepath is not implemented");
        }
        catch (EmptyException e) {
            System.out.println("Symptom's file is empty");
        }



        return result;
    }

}
