package com.hemebiotech.analytics;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/** Class that write in a file the results, ordered alphabetically, of every symptom found in the symptom file
 *
 * @author Hossam Chenaoui
 */


public class Writer implements IWriter{

    /**
     *
     * @param tableList: collection of the results // filePath : file path of the result file
     */

    private TreeMap<String,Integer> tableList = new TreeMap<String,Integer>();
    private String filePath ;

    public Writer(TreeMap<String,Integer> tableList, String filePath) {
        this.tableList = tableList;
        this.filePath = filePath;
    }

    public void writeSympt() {

        FileWriter writer = null;
        try {
            if (filePath == null) {
                throw new PathException();
            }
            writer = new FileWriter (filePath);
        }catch (PathException e) {
            System.out.println("Result's filepath is not implemented");
        }
        catch (FileNotFoundException e) {
            System.out.println("Symptom File not found : please verify the file path.");
        }
        catch (IOException e1) {
            e1.printStackTrace();
        }

        Set<String> kS = tableList.keySet();

        for (String kSympt : kS) {
            try {
                writer.write(kSympt + "=" + tableList.get(kSympt) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
