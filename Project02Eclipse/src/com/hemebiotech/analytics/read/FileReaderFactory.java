package com.hemebiotech.analytics.read;

/**
 * Pattern Factory function
 *
 *@author Hossam CHENAOUI
 *
 *@description This class allows to choose the correct class to instantiate depending on the file format of the symptom file.
 *              If another file format is to be added, only this class would be modified, and a new one added for the new extension.
 */
public class FileReaderFactory {

    public static final String FICTXT = "TXT";
    public static final String FICCSV = "CSV";

    /**
     *
      * @param filepath
     * @return the right class for the input file
     */
    public ReadSymptomDataFromFile getFileType( String filepath) {
        ReadSymptomDataFromFile readSymptomDataFromFile = null;



        String[] fileparts = filepath.split("\\.");
        String fileType  = fileparts[fileparts.length - 1];
        // Sometimes, the name file is written in uppercase, sometimes in lowercase
        // the file extension is converted in uppercase every time
        fileType = fileType.toUpperCase();

        switch (fileType) {
            case FICTXT :
                readSymptomDataFromFile = new ReadSymptomDataFromText(filepath);
                break;
            case FICCSV :
                readSymptomDataFromFile = new ReadSymptomDataFromCSV(filepath);
                break;
            default :
                throw new IllegalArgumentException("File type unknown");
        }

        return readSymptomDataFromFile;
    }
}
