package CelestialSiege.entities;

import CelestialSiege.entities.text.ScoreText;

public class ScoreBoard {
    private ScoreText scoreText;
    private int totalPoints;

    public ScoreBoard(ScoreText scoreText) {
        this.totalPoints = 0;
        this.scoreText = scoreText;
        scoreText.setScoreText(totalPoints);
    }

    // Adds points to scoreboard & updates text
    public void addPoints(int points) {
        totalPoints += points;
        scoreText.setScoreText(totalPoints);
    }

    // TODO remove if remains unused
    public int getTotalPoints() {
        return totalPoints;
    }
}