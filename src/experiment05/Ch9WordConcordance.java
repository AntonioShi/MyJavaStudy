package experiment05;
 
/*
    Introduction to OOP with Java 4th Ed, McGraw-Hill

    Wu/Otani

    Chapter 9 Sample Development: Word Concordance

    File: Step3/Ch9WordConcordance.java

*/


/**
 *   class Ch9WordConcordance (Step 3)
 *
 *   The word list builder class.
 *
 * @author Dr. Caffeine
 */

import java.util.regex.*;

class Ch9WordConcordance  {

//----------------------------------
//    Data Members
//----------------------------------
    /** pattern for extracting a word */
    private static final String WORD = "\\b\\w+\\b";

    /** Helper word list maintainer */
    private WordList wordList;

    /** Compiled pattern for a word */
    private Pattern pattern;


//----------------------------------
//      Sample main method
//----------------------------------

//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch9WordConcordance() {
        wordList = new WordList();
        pattern  = Pattern.compile(WORD);
    }

//----------------------------------
//    Public Methods
//
//          String build    ( String   )
//
//----------------------------------

    public String build(String document) {

        Matcher matcher = pattern.matcher(document);

        wordList.reset();

        while (matcher.find()) {
//TEMP
/*
            System.out.println(document.substring(matcher.start(),
                                                  matcher.end())
                                    + "  "
                                    + matcher.start()+ ":"
                                    + matcher.end());
*/
            wordList.add(document.substring(matcher.start(), matcher.end()));
        }

        return wordList.getConcordance();
    }
}
