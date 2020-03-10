package com.hemebiotech.analytics;

import com.hemebiotech.analytics.format.FormatingResult;
import com.hemebiotech.analytics.format.IFormat;
import com.hemebiotech.analytics.read.FileReaderFactory;
import com.hemebiotech.analytics.read.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.write.IWriter;
import com.hemebiotech.analytics.write.Writer;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Class counter
 *
 *@author Hossam CHENAOUI
 */

public class Counter {

    private String symptomFilePath;
    private String resultFilePath;

    public Counter(String symptomFilePath, String resultFilePath) {
        this.symptomFilePath=symptomFilePath;
        this.resultFilePath=resultFilePath;
    }


    public void count() {
        List<String> resultListe = new ArrayList<String>();
        TreeMap<String,Integer> tableSympt = new TreeMap<String,Integer>();

        // Read and stock the symptom file
        FileReaderFactory fileReaderFactory = new FileReaderFactory();
        ReadSymptomDataFromFile liste = null;

        liste = fileReaderFactory.getFileType(symptomFilePath);

        //ISymptomReader liste = new ReadSymptomDataFromText(symptomFilePath);
        resultListe = liste.getSymptoms();

        //Formating the table list
        IFormat FormatTable = new FormatingResult(resultListe);
        tableSympt = FormatTable.formatListe();

        //Write the result file
        IWriter writeResult = new Writer(tableSympt , resultFilePath);
        writeResult.writeSympt();
    }

}
