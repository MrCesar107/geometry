package com.noriangames.geometry;

import com.badlogic.gdx.Game;


public class Main extends Game {

	@Override
	public void create() {
	    setScreen(new Box2DScreen(this));
	}
}
