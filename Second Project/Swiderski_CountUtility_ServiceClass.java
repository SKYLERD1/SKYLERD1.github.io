/*
Author Name: Skyler Swiderski
Date: 09/12/2019
Program Name: Swiderski_TextAnalzyer
Purpose: In this particular file, it adds all the word occurrences into a collection.
*/

package week07_textanalyzerGUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * This is a service class to the GUI application class. It evaluates the words and its count.
 * 
 * @author Skyler Swiderski
 *
 */
public class Swiderski_CountUtility_ServiceClass
{

	/**
	 * It is a method that evaluates the provided reader to find individual
	 * words and the number of occurrences of the word. If there are processing
	 * errors the exception is thrown to the caller.
	 *
	 * @param reader
	 *            the parameter containing a character-input stream
	 * @return list a list containing the words and no. of occurrences
	 * @throws IOException file error (cannot open or read)
	 */
	public List<Swiderski_WordCountResult_ServiceClass> countWordOccurrences(BufferedReader reader)
			throws IOException
	{

		Map<String, Swiderski_WordCountResult_ServiceClass> occurrences = new TreeMap<>();
		List<Swiderski_WordCountResult_ServiceClass> wordCountResultList = new ArrayList<>();
		String line;
		while((line = reader.readLine()) != null)
		{
			evaluateLine(line, occurrences);
		}
		Collection<Swiderski_WordCountResult_ServiceClass> valuesCollection = occurrences.values();
		if(!valuesCollection.isEmpty())
		{
			for(Swiderski_WordCountResult_ServiceClass wordCountResult : valuesCollection)
			{
				wordCountResultList.add(wordCountResult);
			}
		}

		return wordCountResultList;
	}

	/**
	 * It is a method that that takes in line/s of text and counts the number of
	 * occurrences.
	 *
	 * @param line
	 *            the parameter that contains each individual word (on each
	 *            separate line)
	 * @param occurrences
	 *            the parameter that contains the no. of occurrences of the word
	 */
	private void evaluateLine(String line,
			Map<String, Swiderski_WordCountResult_ServiceClass> occurrences)
	{
		String text = line;
		
		/*
		^'    // matches single quote at start of text
		'$    // matches single quote at end of text
		\\s'  // matches whitespace character followed by single quote
		'\\s  // matches single quote followed by whitespace character
		*/
		text=text.replaceAll("^'|'$|'\\s|\\s'", " "); 

		String words[] = text.split("[ \n\t\r;:!?(){}&|.,--]");

		for(int i = 0; i < words.length; i++)
		{
			String key = words[i];
			
			if(key.length() > 0)
			{
				if(occurrences.containsKey(key))
				{
					Swiderski_WordCountResult_ServiceClass value = occurrences.get(key);
					value.incrementCount();
					occurrences.put(key, value);
				}
				else
				{
					occurrences.put(key, new Swiderski_WordCountResult_ServiceClass(1, key));
				}
			}
		}
	}
}
