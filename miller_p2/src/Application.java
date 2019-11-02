import java.io.IOException;



public class Application {

    public static void main (String[] args) throws IOException{
        DuplicateCounter duplicateCounter = new DuplicateCounter();



        duplicateCounter.count("C:\\Users\\denae\\IdeaProjects\\problem2.txt");

        duplicateCounter.write("C:\\Users\\denae\\IdeaProjects\\unique_words_counts.txt");


    }




}
