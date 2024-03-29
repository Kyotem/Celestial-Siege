package CelestialSiege.entities;

import CelestialSiege.UI.UIGameScene;


public class ScoreBoard {

    private final UIGameScene UIGAMESCENE;
    private int totalPoints;

    public ScoreBoard(UIGameScene uiGameScene) {
        this.totalPoints = 0;
        this.UIGAMESCENE = uiGameScene;
    }

    // Adds points to scoreboard & updates text
    public void addPoints(int points) {
        totalPoints += points;
        UIGAMESCENE.updateScoreText(totalPoints);
    }

}