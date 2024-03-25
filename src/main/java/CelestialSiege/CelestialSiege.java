package CelestialSiege;

import CelestialSiege.scenes.GameScene;
import CelestialSiege.scenes.TitleScene;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;

public class CelestialSiege extends YaegerGame {

    @Override
    public void setupGame() {
        setGameTitle("Celestial Siege");
        setSize(new Size(700, 700));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameScene(this));
    }
}
