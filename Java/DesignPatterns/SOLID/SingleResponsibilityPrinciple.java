import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

class Journal{

    private List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String s){
        entries.add(String.format("%d: %s", ++count, s));
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

}

class Persistance{

    public static void saveToFile(Journal journal, String filePath) throws IOException{
        System.out.println(filePath);
        File file = new File(filePath);
        file.createNewFile();
        try(FileOutputStream out = new FileOutputStream(file, false)){
            out.write(journal.toString().getBytes());
        }
        catch(IOException ex){
            // System.out.println(ex.getMessage());
            throw ex;
        }
    }
}



public class SingleResponsibilityPrinciple{
    public static void main(String[] args) throws IOException{
        Journal j = new Journal();

        j.addEntry("I ate biriyani");
        j.addEntry("I went for work");
        j.addEntry("I washed my clothes");


        // System.out.println(j);

        Persistance.saveToFile(j, "C:\\Habeeb\\Dev\\Java\\DesignPatterns\\Output\\journal.txt");
    }
}