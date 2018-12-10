package com.noriangames.geometry.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class ActorJugador extends Actor {
    private Texture jugador;

    public ActorJugador(Texture jugador) {
        this.jugador = jugador;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(jugador, getX(), getY());
    }
}
