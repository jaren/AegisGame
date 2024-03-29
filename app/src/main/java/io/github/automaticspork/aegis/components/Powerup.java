package io.github.automaticspork.aegis.components;

import android.graphics.Color;

import io.github.automaticspork.aegis.GameView;
import io.github.automaticspork.aegis.Vector;

public class Powerup extends CenterMovingSprite {
    public PowerupType type;
    public float value;

    public Powerup(Vector pos, float radius, float sMult, PowerupType t) {
        super(pos, radius, sMult);
        score = 5;
        String colorString = "#000000";
        type = t;
        value = 20;
        switch (type) {
            case Health:
                colorString = "#4caf50";
                break;
            case Sweep:
                colorString = "#9c27b0";
                break;
            case Radius:
                colorString = "#ff9800";
                break;
        }
        paint.setColor(Color.parseColor(colorString));
    }

    @Override
    public void onCollide(GameView view) {
        super.onCollide(view);

        switch (type) {
            case Health:
                view.core.health += value;
                break;
            case Sweep:
                view.shield.sweep += value;
                break;
            case Radius:
                view.shield.radius += value;
                break;
        }
    }
}
