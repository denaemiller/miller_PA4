import java.util.*;
import java.io.*;
import java.lang.*;



public class DuplicateRemover {
    private ArrayList<String> unique = new ArrayList<String>();
    private HashSet<String> uniqueWords = new HashSet<String>();

    // this method calls the file, reads it in the method,
    // and creates another array for the none duplicated words
    public void remove (String dataFile) throws IOException{
        BufferedReader file = null;

        try {

            file = new BufferedReader (new FileReader(dataFile));

            String words;

            //just copying the file list to the array uniqueWords

            while ((words = file.readLine()) != null)
            {
                unique.add(words);
            }

            uniqueWords.addAll(unique); //hashset removes the duplicates for you

        }

        catch(IOException excpt)
        {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

        finally
        {
            file.close();
            unique.clear();
        }

    }

    //---------------------------------------------------------------------------------------------------------------------

    public void write(String outputFile) throws IOException{
        File file = null;
        FileWriter fileWrite = null;

        try{
            file = new File (outputFile);
            Iterator iterate = uniqueWords.iterator();

            String word;

            if (file.exists())
            {
                fileWrite = new FileWriter (file);

                while (iterate.hasNext())
                {
                    word = (String)iterate.next();
                    fileWrite.write(word + " " + "\n");
                }

                System.out.println("The File Has Been Written");
                fileWrite.close();

            }

            else if (!(file.exists()))
            {
                file.createNewFile();
                fileWrite = new FileWriter (file);

                while (iterate.hasNext())
                {
                    word = (String)iterate.next();
                    fileWrite.write(word + " " + "\n");
                }

                System.out.println("YThe File Has Been Written To New File");
                fileWrite.close();
            }


        }

        catch(IOException excpt)
        {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

        finally
        {
            fileWrite.close();
            uniqueWords.clear();
        }



    }






}
