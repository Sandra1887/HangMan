public class Player {
    String name;
    int score;

    int guesses;

    public Player(String name) {
        this.name = name;
        score = 0;
        guesses = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public int increaseScore() {
        return score++;
    }

    public void resetGuesses() {
        guesses = 0;
    }

    public int increaseGuesses() {
        return guesses++;
    }

    @Override
    public String toString() {
        return name + " have scored " + score + "points in " + guesses + "guesses";
    }
}