package CelestialSiege.entities;

import CelestialSiege.UI.UIGameScene;


public class ScoreBoard {

    private final UIGameScene uiGameScene;
    private int totalPoints;

    public ScoreBoard(UIGameScene uiGameScene) {
        this.totalPoints = 0;
        this.uiGameScene = uiGameScene;
    }

    // Adds points to scoreboard & updates text
    public void addPoints(int points) {
        totalPoints += points;
        uiGameScene.updateScoreText(totalPoints);
    }

    // TODO remove if remains unused
    // Might require this to save points in var to pass to another scene.
    public int getTotalPoints() {
        return totalPoints;
    }
}