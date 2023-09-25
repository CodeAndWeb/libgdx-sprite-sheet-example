package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	TextureAtlas textureAtlas;
	Animation<Sprite> runningAnimation;
	float stateTime;

	@Override
	public void create () {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("sprites.txt");
		runningAnimation = new Animation<>(0.066f, textureAtlas.createSprites("capguy"), Animation.PlayMode.LOOP);
		stateTime = 0f;
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stateTime += Gdx.graphics.getDeltaTime();
		Sprite sprite = runningAnimation.getKeyFrame(stateTime, true);
		sprite.setX(stateTime * 175 % 640);

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		textureAtlas.dispose();
	}
}
