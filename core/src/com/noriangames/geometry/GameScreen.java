package com.noriangames.geometry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.noriangames.geometry.actors.ActorJugador;
import com.noriangames.geometry.actors.ActorPuas;

public class GameScreen extends BaseScreen {
    //Stages
    private Stage stage;

    //Actores
    private ActorJugador jugador;
    private ActorPuas puas;

    //Texturas
    private Texture texturaJugador, texturaPuas;

    //Reiones
    private TextureRegion regionPuas;

    public GameScreen(Main game) {
        super(game);
        texturaJugador = new Texture("prota.png");
        texturaPuas = new Texture("puas.png");
        regionPuas = new TextureRegion(texturaPuas, 2, 47, 60, 17);
    }

    @Override
    public void show() {

        stage = new Stage();
        stage.setDebugAll(true);
        jugador = new ActorJugador(texturaJugador);
        puas = new ActorPuas(regionPuas);
        stage.addActor(jugador);
        stage.addActor(puas);

        jugador.setPosition(20, 100);
        puas.setPosition(400, 100);
    }

    @Override
    public void hide() {
        stage.dispose();
        texturaJugador.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.4f, .5f, .8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        comprobarColisiones();
        stage.draw();
    }

    private void comprobarColisiones() {
        if (jugador.isAlive() &&
                (jugador.getX() + jugador.getWidth()) > puas.getX()) {
            System.out.println("Ha colisionado");
            jugador.setAlive(false);
        }
    }
}
