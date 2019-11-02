import java.util.*;
import java.io.*;
import java.lang.*;

public class DuplicateCounter {
    HashMap<String, Integer>  mapper = new HashMap<String, Integer>();

    HashMap<String, String>  map = new HashMap<String, String>();

    ArrayList<String> words = new ArrayList<String>(); //use these first then put it into the map

    HashSet<String> set = new HashSet<String>();


    public void count(String dataFile) throws IOException{

        BufferedReader file = null;

        try {
            file = new BufferedReader(new FileReader(dataFile));

            String theWord;


            //putting elements in map
            while ((theWord = file.readLine()) != null) {
                mapper.put(theWord, 0);

                map.put(theWord, " ");

                words.add(theWord);
            }

            //adding ArrayList to Set for later purposes
            set.addAll(words);

            //didn't know you can do this with a for loop
            //basically says the for loop starting at String i not index i,
            //going through the ArrayList
            for (String i : words) {
                //gets the frequencies
                Integer wordCounter = mapper.get(i);

                if (wordCounter == null) {
                    mapper.put(i, 1);
                } else {
                    mapper.put(i, (wordCounter + 1));
                }

                //copies all the values in mapper to map, but as a string
                //for the second value
                map.put(i, mapper.get(i).toString());

            }


            //so I can use the new array list later
            words.clear();
            words.addAll(set);
        }

        catch(IOException excpt)
        {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }

        finally
        {
            file.close();
            set.clear();
            mapper.clear();
        }


    }
    //---------------------------------------------------------------------------------------










    public void write(String outputFile) throws IOException{
        File file = null;
        BufferedWriter writer = null;

        try
        {
            file = new File (outputFile);
            writer = new BufferedWriter(new FileWriter(file));

            Scanner x = null;
            Scanner y = null;

            //i believe it needs this so there is no null pointer error



            String all = "";

            for (int i = 0; i < words.size(); i++)
            {
                all = all.concat(words.get(i) + " ");
            }



            String allNum = "";

            for(String i : words)
            {
                allNum = allNum.concat(map.get(i) + " ");
            }


            x = new Scanner (all);
            y = new Scanner (allNum);



            if(file.exists())
            {

                //BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                while (x.hasNext())
                {
                    String z1 = x.next();
                    String z2 = y.next();
                    writer.write(z1 + " Frequency: " + z2 + "\n");
                }
                System.out.println("The Frequencies Have Been Printed");

            }
            else if(!(file.exists()))
            {

                file.createNewFile();
                writer = new BufferedWriter(new FileWriter(file));

                while (x.hasNext())
                {
                    String z1 = x.next();
                    String z2 = y.next();
                    writer.write(z1 + " Frequency: " + z2 + "\n");
                }
                System.out.println("The Frequencies Have Been Printed To New File");

            }
        }

        catch (IOException excpt)
        {
            System.out.println("Caught IOException: " + excpt.getMessage());
        }


        finally
        {
            writer.close();
            words.clear();
            map.clear();
        }





    }

}
