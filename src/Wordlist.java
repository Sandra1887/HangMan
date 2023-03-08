import java.util.ArrayList;
import java.util.Scanner;

public class Wordlist {
    ArrayList<String> wordList;
    //String currentWord;

    public Wordlist() {
        wordList = new ArrayList<>();
        wordList.add("ibrahimovic");
        wordList.add("allbäck");
        wordList.add("toivonen");
        wordList.add("ronaldo");
        wordList.add("messi");
    }

    public String randomWord() {
        int index = ((int) (Math.random() * wordList.size()));
        String word = wordList.get(index);
        return word;
    }

    /*public String getCurrentWord() {
        return currentWord;
    }*/

    public void addWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Word to add?");
        wordList.add(sc.nextLine());
    }

    public void removeWord() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Word to remove?");
        String word = sc.nextLine();
        if(wordList.contains(word)) {
            wordList.remove(word);
        } else {
            System.out.println("The wordlist does not contain that word");
        }
    }
    public void showWords(){
        for (String word : wordList) {
            System.out.println(word.toString());
        }
    }
}
