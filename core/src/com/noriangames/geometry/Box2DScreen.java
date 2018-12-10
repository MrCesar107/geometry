package com.noriangames.geometry;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Box2DScreen extends BaseScreen {


    public Box2DScreen(Main game) {
        super(game);
    }

    private World world;

    private Box2DDebugRenderer renderer;

    private OrthographicCamera camera;

    private Body protaBody;

    private Fixture protaFixture;

    @Override
    public void show() {
        world = new World(new Vector2(0, -9.81f), true);
        renderer = new Box2DDebugRenderer();
        camera = new OrthographicCamera(32, 18);

        BodyDef protaDef = createProtaBodyDef();
        protaBody = world.createBody(protaDef);

        PolygonShape protaShape = new PolygonShape();
        protaShape.setAsBox(1, 1);      //Esto funciona en metros
        protaFixture = protaBody.createFixture(protaShape, 1);
        protaShape.dispose();
    }

    private BodyDef createProtaBodyDef() {
        BodyDef def = new BodyDef();
        def.position.set(0, 10);
        def.type = BodyDef.BodyType.DynamicBody;
        return def;
    }

    @Override
    public void dispose() {
        world.destroyBody(protaBody);
        world.dispose();
        renderer.dispose();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta, 6, 2);

        camera.update();
        renderer.render(world, camera.combined);
    }
}
