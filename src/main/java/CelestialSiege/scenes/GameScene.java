package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.buttons.PauseButton;
import CelestialSiege.entities.AlienManager;
import CelestialSiege.entities.BulletSpawner;
import CelestialSiege.entities.ScoreBoard;
import CelestialSiege.entities.Spaceship;

import CelestialSiege.entities.map.ShieldTileMap;
import CelestialSiege.entities.text.HealthText;
import CelestialSiege.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;

import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer  {

    private CelestialSiege celestialSiege;

    private boolean gamePaused = false;
    private PauseButton pauseButton;

    private AlienManager alienManager;

    private Spaceship spaceship;

    private ScoreBoard scoreBoard;


    public GameScene(CelestialSiege celestialSiege) {
        this.celestialSiege = celestialSiege;
    }


    @Override
    public void setupScene() {
        setBackgroundAudio("audio/Audio1.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {

        HealthText healthText = new HealthText(new Coordinate2D(20, 610));
        addEntity(healthText);
        ScoreText scoreText = new ScoreText(new Coordinate2D(20, 650));
        addEntity(scoreText);
        scoreBoard = new ScoreBoard(scoreText);

        spaceship = new Spaceship(new Coordinate2D(349, 550), healthText);

        alienManager = new AlienManager(new Coordinate2D(100, 0));

        addEntity(alienManager);
        addEntity(spaceship);


        PauseButton pauseButton = new PauseButton(new Coordinate2D(550, 650), this);
        addEntity(pauseButton);
       pauseButton.setFont(Font.font("Roboto", FontWeight.SEMI_BOLD, 50));

    }

    @Override
    public void setupEntitySpawners() {
        BulletSpawner bulletSpawner = new BulletSpawner(800, spaceship, alienManager);
        addEntitySpawner(bulletSpawner);

        // textSpawner = new TextSpawner(700, getWidth(), getHeight());
        //addEntitySpawner(textSpawner);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new ShieldTileMap());
    }
    public void pauseResumeGWU() {
        if (!gamePaused) {
            pause();
            //pauseButton.setResumeTextText();
            gamePaused = true;
        } else {
            resume();
            //pauseButton.setPauseText();
            gamePaused = false;
        }
    }
}
