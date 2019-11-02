import java.io.IOException;

public class Application {


    public static void main(String[] args) throws IOException {
        DuplicateRemover duplicateRemover = new DuplicateRemover();

        duplicateRemover.remove("C:\\Users\\denae\\IdeaProjects\\problem1.txt");

        duplicateRemover.write("C:\\Users\\denae\\IdeaProjects\\unique_words.txt");

    }




}
