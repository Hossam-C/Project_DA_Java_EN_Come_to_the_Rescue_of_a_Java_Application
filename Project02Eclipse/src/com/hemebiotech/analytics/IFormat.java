package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * Format and count the symptoms in the array into a collection ordered alphabetically
 *
 *@author Hossam CHENAOUI
 */

public interface IFormat {

    /**
     * @exception
     *
     * @throws
     *
     * @return a list of all the symptoms with their counts, ordered alphabetically
     */
    TreeMap<String,Integer> formatListe();
}
