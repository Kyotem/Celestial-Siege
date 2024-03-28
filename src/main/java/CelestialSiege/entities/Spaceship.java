package CelestialSiege.entities;

import CelestialSiege.entities.text.HealthText;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;


public class Spaceship extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {

    private HealthText healthText;
    private int health = 3;

    public Spaceship(Coordinate2D location, HealthText healthText) {
        super("sprites/SpaceShip.png", location, new Size(80, 40));
        this.healthText = healthText;
        healthText.setHealthText(health);
        setFrictionConstant(0.05);
        setGravityConstant(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
        }
    }
    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        setSpeed(0);
        switch (sceneBorder) {
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onCollision(List<Collider> list) {
        System.out.println("Spaceship got hit");
        health--;
        // Logic to decrease HP visualizer? Or does HP UI update based on the value?
        handleLoss();
    }

    private void handleLoss() {
        if (isDead()) {
            System.out.println("Lost Game");
            // Logic here to change scene to endscreen
        }
    }

    private boolean isDead() {
        return health <= 0;
    }

    public int getPlayerHP() {
        return health;

    public void setPlayerHP(int newPlayerHP) {
        playerHP = newPlayerHP;
    }

}
