package experiment05;
/*
    Introduction to OOP with Java 3rd Ed, McGraw-Hill

    Wu/Otani

    Chapter 9 Sample Development: Word Concordance

    File: Step3/Ch9WordConcordanceMain.java

    NO CHANGE from Step 2

*/
import java.io.*;
import javax.swing.*;

/**
 *   class Ch9WordConcordanceMain (Step 3)
 *
 *   The instantialble main class for Step 3.
 *
 * @author Dr. Caffeine
 */

class Ch9WordConcordanceMain  {

//----------------------------------
//    Data Members
//----------------------------------
    /** File manager for opening and saving a file */
    private FileManager fileManager;

    /** Word concordance builder */
    private Ch9WordConcordance builder;


//----------------------------------
//      Sample main method
//----------------------------------
    public static void main(String[] args) {
        Ch9WordConcordanceMain main = new Ch9WordConcordanceMain();
        main.start();
    }

//----------------------------------
//    Constructors
//----------------------------------

    /**
     * Default constructor
     */
    public Ch9WordConcordanceMain() {

        fileManager = new FileManager( );
        builder     = new Ch9WordConcordance( );
    }

//----------------------------------
//    Private Methods
//
//          String  build       ( String    )
//          String  inputFile   (           )
//          void    saveFile    ( String    )
//          void    start       (           )
//
//----------------------------------

    /**
     * Build the word concordance.
     */
    private String build(String document) {

        String concordance;

        concordance = builder.build(document);

        return concordance;
    }

    /**
     * Input text data from a file
     */
    private String inputFile( ) {
        String doc = "";

//        try {
            doc = fileManager.openFile( );

//        } catch (FileNotFoundException e) {
//            System.out.println("File not found in the directory it is expected.");
//
//        } catch (IOException e) {
//            System.out.println("Error in opening file: " + e.getMessage());
//        }

    //    System.out.println("Input Document:\n" + doc); //TEMP

        return doc;
    }


    /**
     * Save the word list to a file.
     */
    private void saveFile(String list) {

//        try {
            fileManager.saveFile(list);
//        } catch (IOException e) {
//            System.out.println("Error in saving file: " + e.getMessage());
//        }
    }


    /**
     * Top level control
     */
    private void start( ) {
        int    reply;
        String document, wordList;

        while (true) {

            reply = JOptionPane.showConfirmDialog(null,
                                                  "Run the program?",
                                                  "Word List Builder",
                                                  JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.NO_OPTION) {
                break;
            }

            document = inputFile();

            wordList = build(document);

            saveFile(wordList);
        }

        JOptionPane.showMessageDialog(null, "Thank you for using the program\n"
                                          + "Good-Bye");
    }
}
