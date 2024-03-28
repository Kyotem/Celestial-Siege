package CelestialSiege.entities;

import CelestialSiege.UI.UIGameScene;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.*;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.List;
import java.util.Set;


public class Spaceship extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Newtonian, Collided, Collider {

    private UIGameScene uiGameScene;
    private int playerHP = 3;
    private final int PLAYER_SPEED = 3;

    public Spaceship(Coordinate2D location, UIGameScene uiGameScene) {
        super("sprites/SpaceShip.png", location, new Size(80, 40));
        this.uiGameScene = uiGameScene;
        setFrictionConstant(0.05);
        setGravityConstant(0);
    }

    // Used to allow the player to move left & right based on arrowkey input.
    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(PLAYER_SPEED, Direction.LEFT);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(PLAYER_SPEED, Direction.RIGHT);
        }
    }

    // Checks which border is being touched, based on that, reset position to the edge.
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

    // Called when Spaceship collided with collider, if hit, deduct HP, update UI and check if player is dead.
    @Override
    public void onCollision(List<Collider> list) {
        playerHP--;
        uiGameScene.updateHealthText("Health: " + playerHP);
        checkForLoss();
    }

    // Checks if player is dead, if true, send user to endscreen
    private void checkForLoss() {
        if (isDead()) {
            System.out.println("Lost Game"); // TODO Remove once implemented properly
            // TODO Implement logic here to change scene to endscreen
        }
    }

    private boolean isDead() {
        return playerHP <= 0;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public void setPlayerHP(int newPlayerHP) {
        playerHP = newPlayerHP;
    }

}
