package com.hemebiotech.analytics;

import java.util.List;
import java.util.TreeMap;

/** Class that can count, put in form and order the list of symptoms
 *
 */

public class FormatingResult implements IFormat {

    private List<String> resultList;


    /**
     *
     * @param resultList : Raw list from the symptom file
     */

    public FormatingResult(List<String> resultList) {
        this.resultList = resultList;
    }

    @Override
    public TreeMap<String,Integer> formatListe() {

        TreeMap<String,Integer> Liste = new TreeMap<String,Integer>();

        for (String kSympt:resultList) {
            if (Liste.get(kSympt) == null) {
                Liste.put(kSympt,1);
            }
            else {
                Liste.put(kSympt, Liste.get(kSympt)+1 ) ;
            }
        }
        return Liste;
    }
}
