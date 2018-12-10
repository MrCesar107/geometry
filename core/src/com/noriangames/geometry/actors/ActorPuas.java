package com.noriangames.geometry.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorPuas extends Actor {
    private TextureRegion puas;

    public ActorPuas(TextureRegion puas) {
        this.puas = puas;
    }

    @Override
    public void act(float delta) {
        setX(getX() - (250 * delta));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(puas, getX(), getY());
    }
}
