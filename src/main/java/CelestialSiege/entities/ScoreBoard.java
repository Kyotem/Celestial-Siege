package CelestialSiege.entities;



import CelestialSiege.entities.text.ScoreText;

public class ScoreBoard {
    private ScoreText scoreText;
    private int totalPoints;

    public ScoreBoard(ScoreText scoreText) {
        this.totalPoints = 0;
        this.scoreText = scoreText; // Initialize the ScoreText object
        scoreText.setScoreText(totalPoints);
    }

    public void addPoints(int points) {
        totalPoints += points;

    }

    public int getTotalPoints() {

        return totalPoints;
    }
}