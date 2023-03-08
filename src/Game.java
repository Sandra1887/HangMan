import java.util.*;

public class Game {
    ArrayList<Character> guessedLetters;
    Wordlist wordList;
    CurrentWord word;
    Player player;

    public Game() {
        this.wordList = new Wordlist();
    }

    boolean play = true;
    boolean continuePlaying = false;

    public void run() {
            String name = askForName();
            player = new Player(name);
            welcomePlayer(name);
        while (!continuePlaying) {
            Menu.showMainMenu();
            int choice = Menu.askForNumber(1, 5);
            switch (choice) {
                case 1 -> play = true;
                case 2 -> wordList.addWord();
                case 3 -> wordList.removeWord();
                case 4 -> wordList.showWords();
                case 5 -> endGame();
                default -> System.out.println("Invalid choice");
            }
            while (play) {
                Scanner sc = new Scanner(System.in);
                guessedLetters = new ArrayList<>();
                word = new CurrentWord(wordList.randomWord());
                System.out.println("The word has " + word.getWord().length() + " letters. ");
                while (word.won() == false) {//efter
                    System.out.println("Guessed letters: "); //efter
                    printGuessedLetters(guessedLetters);
                    makeAGuess();
                    char guess = sc.next().charAt(0);
                    word.replaceLetter(guess);
                    guessedLetters.add(guess); //efter
                    player.increaseGuesses(); //efter
                    System.out.println(word.getGuess());
                    if (word.won() == true) {
                        player.increaseScore();
                        congrats(word.getWord());
                        System.out.println("\nYou, " + player.getName() + " made it in " + player.guesses + " guesses. \n" +
                                "Your current score is " + player.getScore()); //efter
                        thankYou();
                        play = false;
                    }
                }
            }
            continuePlaying = true;
        }
    }

    /*public void play() {
        word = new CurrentWord(wordList.randomWord());
        Scanner sc = new Scanner(System.in);
        System.out.println("The current word is: " + word + ". Make a guess?");
        String letter = sc.nextLine();
        if (letter.length() > 1) {
            if (word.equals(letter)) {
                maxGuesses--;
                currentGuesses++;
                winner = true;
                System.out.println("You won! You did it in " + currentGuesses + " guesses");
                System.out.println("Play again? y/n?");
                if(sc.nextLine() == "y") {
                    play();
                } else {
                    exit = true;
                }
            }
        }
    }*/

    public String askForName () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Hangman! Please, enter your name");
        return sc.nextLine();
    }

    public void welcomePlayer (String name){
        System.out.println("Welcome " + name);
    }

    public static void printGuessedLetters(ArrayList<Character> arraylist) { //efter
        for (Character c : arraylist) {
            System.out.print(c + ", ");
        }
        System.out.println();
    }

    public void makeAGuess () {
        System.out.println("Make a guess: ");
    }

    public void congrats(String word) {
        System.out.println("Congratz! Your guess was right! The word is " + word + ".");
    }

    public void thankYou() {
        System.out.println("Thank you for playing.");
        System.out.println();
    }

    private void endGame() {
        System.exit(0);
    }
}

