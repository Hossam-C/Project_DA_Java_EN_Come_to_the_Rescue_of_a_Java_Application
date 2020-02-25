package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Class reading for .txt files
 *
 */
public class ReadSymptomDataFromText extends ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     *
     * @param filepath a full or partial path to file with symptom strings in it,
     *                 one per line
     */
    public ReadSymptomDataFromText(String filepath) {
        super(filepath);
        this.filepath = filepath;
    }

    @Override
    public List<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();
        try {
            if (filepath != null) {
                try {
                    BufferedReader reader = new BufferedReader (new FileReader(filepath));
                    String line = reader.readLine();

                    if (line == null) {
                        throw new EmptyException();
                    }
                    while (line != null) {
                        result.add(line);
                        line = reader.readLine();
                    }
                    reader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("Symptom File not found : please verify the file path.");
                }
                catch (IOException e) {
                    e.printStackTrace();
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
