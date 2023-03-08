public class CurrentWord {
    private String word;

    private String guess;

    public CurrentWord(String word) {
        this.word = word;
        this.guess = "";
        for (int i = 0; i < word.length(); i++) {
            guess += "-";
        }
    }

    public String getWord() {
        return word;
    }

    public String getGuess() {
        return guess;
    }

    /*public boolean matchLetter(char letter) { //if (matchLetter(letter) == true) { replaceLetter
        if (word.indexOf(letter) != -1) {
            return true;
        } else {
            return false;
        }
    }*/

    public String replaceLetter(char letter) {
        String currentGuess = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == letter) {
                currentGuess += letter;
            } else {
                currentGuess += guess.charAt(i);
            }
        }
        guess = currentGuess;
        return guess;
    }

    public boolean won() {
        return guess.equals(word);
    }
}