package CelestialSiege.scenes;

import CelestialSiege.CelestialSiege;
import CelestialSiege.entities.AlienManager;
import CelestialSiege.entities.Bullet;
import CelestialSiege.entities.Spaceship;
import CelestialSiege.entities.BulletContainer;
import CelestialSiege.entities.map.ShieldTileMap;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;

import com.github.hanyaeger.api.scenes.TileMapContainer;

public class GameScene extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private CelestialSiege celestialSiege;

    Spaceship spaceship;

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
        spaceship = new Spaceship(new Coordinate2D(349, 550));
        AlienManager alienManager = new AlienManager(new Coordinate2D(50, 0));

        addEntity(alienManager);
        addEntity(spaceship);

    }

    @Override
    public void setupEntitySpawners() {
        BulletContainer bulletContainer = new BulletContainer(1000, spaceship);
        addEntitySpawner(bulletContainer);
        // textSpawner = new TextSpawner(700, getWidth(), getHeight());
        //addEntitySpawner(textSpawner);
    }

    @Override
    public void setupTileMaps() {
        addTileMap(new ShieldTileMap());
    }

}
