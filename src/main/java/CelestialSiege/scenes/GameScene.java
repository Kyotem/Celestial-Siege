package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.UI.UIGameScene;
import CelestialSiege.UI.buttons.PauseButton;
import CelestialSiege.entities.AlienManager;
import CelestialSiege.entities.BulletSpawner;
import CelestialSiege.entities.ScoreBoard;
import CelestialSiege.entities.Spaceship;

import CelestialSiege.entities.map.ShieldTileMap;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;

import com.github.hanyaeger.api.scenes.TileMapContainer;

public class GameScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer  {

    private CelestialSiege celestialSiege;


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



        UIGameScene uiGameScene = new UIGameScene(new Coordinate2D(0,0), this);


        scoreBoard = new ScoreBoard(uiGameScene);

        spaceship = new Spaceship(new Coordinate2D(349, 550), uiGameScene);

        alienManager = new AlienManager(new Coordinate2D(100, 0), scoreBoard);

        addEntity(uiGameScene);
        addEntity(alienManager);
        addEntity(spaceship);



    }

    @Override
    public void setupEntitySpawners() {
        BulletSpawner bulletSpawner = new BulletSpawner(800, spaceship, alienManager);
        addEntitySpawner(bulletSpawner);

        // What does textSpawner do? TODO Remove if remains unused
        // textSpawner = new TextSpawner(700, getWidth(), getHeight());
        //addEntitySpawner(textSpawner);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new ShieldTileMap());
    }

}
