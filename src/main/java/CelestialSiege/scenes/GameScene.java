package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.entities.AlienManager;
import CelestialSiege.entities.ScoreBoard;
import CelestialSiege.entities.Spaceship;
import CelestialSiege.entities.map.ShieldTileMap;
import CelestialSiege.entities.text.HealthText;
import CelestialSiege.entities.text.ScoreText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;

public class GameScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private CelestialSiege celestialSiege;

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

        HealthText healthText = new HealthText(new Coordinate2D(50, 625));
        addEntity(healthText);
        ScoreText scoreText = new ScoreText(new Coordinate2D(400, 625));
        addEntity(scoreText);
        ScoreBoard scoreboard = new ScoreBoard(scoreText);

        Spaceship spaceship = new Spaceship(new Coordinate2D(349, 550), healthText);

        AlienManager alienManager = new AlienManager(new Coordinate2D(50, 0));
        addEntity(alienManager);
        addEntity(spaceship);



    }
    @Override
    public void setupEntitySpawners() {
       // textSpawner = new TextSpawner(700, getWidth(), getHeight());
        //addEntitySpawner(textSpawner);
    }
    @Override
    public void setupTileMaps() {
        addTileMap(new ShieldTileMap());
    }


}
