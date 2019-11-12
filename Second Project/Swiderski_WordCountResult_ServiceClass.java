/*
Author Name: Skyler Swiderski
Date: 09/12/2019
Program Name: Swiderski_TextAnalzyer
Purpose: In this particular file, it provides the word count of a word.
*/

package week07_textanalyzerGUI;

public class Swiderski_WordCountResult_ServiceClass {
	private int m_count;
	private String m_word;

	/**
	 * It is a two argument constructor (count and word). It calls the appropriate
	 * set methods to set the data in the parameters to the appropriate variables.
	 * 
	 * @param count takes the word that is to be analyzed
	 * @param word  take the count of the word that is to be analyzed
	 */
	public Swiderski_WordCountResult_ServiceClass(int count, String word) {
		this.setCount(count);
		this.setWord(word);
	}

	/**
	 * It is a method to return the number of occurrences of the word
	 * 
	 * @return m_count a variable that contains the occurrences of the word
	 */
	public int getCount() {
		return this.m_count;
	}

	/**
	 * It is a method to return the word being analyzed
	 * 
	 * @return m_word a variable that contains the word
	 */
	public String getWord() {
		return this.m_word;
	}

	/**
	 * It is a method to increment the occurrence count
	 */
	public void incrementCount() {
		this.m_count += 1;
	}

	/**
	 * It is a setter method. It replaces the old count contained in variable
	 * m_count with the parameter's data (newCount)
	 * 
	 * @param newCount integer variable that contains the new number count of the
	 *                 word
	 */
	public void setCount(int newCount) {
		this.m_count = newCount;
	}

	/**
	 * It is a setter method. It replaces the old word contained in the variable
	 * m_word with the parameter's data (newWord)
	 * 
	 * @param newWord string variable that contains the new word
	 */
	public void setWord(String newWord) {
		this.m_word = newWord;
	}

	/**
	 * It is an override on the toString() method. It sets what the return is and
	 * how it is formatted
	 * 
	 * @return formated syntax "count <tab> word"
	 */
	@Override
	public String toString() {
		String result = String.format("%d\t%s", this.getCount(), this.getWord());

		return result;
	}
}