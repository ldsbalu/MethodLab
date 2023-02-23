
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends JPanel {
    //field

    ArrayList<String> french;
    ArrayList<String> english;

    public Main() { // constructor
        loadEnglishWords();
        loadFrenchWords();
        mainLoop();

    }

    public void loadEnglishWords(){
        File file;
        Scanner scanner;

        file = new File("english.txt");
        try {
            scanner = new Scanner(file);
            english = new ArrayList<>();

            while(scanner.hasNext()){
                english.add(scanner.next());

            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not Found");
        }


    }


    public void loadFrenchWords(){
        File file;
        Scanner scanner;

        file = new File("french.txt");
        try {
            scanner = new Scanner(file);
            french=  new ArrayList<>();

            while(scanner.hasNext()){
                french.add(scanner.next());

            }

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File not Found");
        }


    }

    public String lookup(String word){
        for (int i = 0; i < english.size(); i++) {
            if(word.equals(english.get(i))){
                return french.get(i);
            }
        }

        return "Match not found";
    }

    public void mainLoop(){
        while(true){
            String prompt = JOptionPane.showInputDialog("Enter a english word");
            String wordLookup = lookup(prompt);
            int output = JOptionPane.showConfirmDialog(null, "The french word is " +wordLookup, "Transalator", JOptionPane.YES_NO_OPTION);
            if(output == JOptionPane.NO_OPTION){
                break;
            }
        }

    }





    public static void main(String[] args) {
        new Main();
    }


}