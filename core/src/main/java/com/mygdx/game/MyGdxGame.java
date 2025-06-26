package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private TextureAtlas textureAtlas;
	private Animation<Sprite> animation;
	private float stateTime = 0;

	@Override
	public void create() {
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas("spritesheet.txt");
		animation = new Animation<>(0.066f, textureAtlas.createSprites("capguy"), Animation.PlayMode.LOOP);
	}

	@Override
	public void render() {
		ScreenUtils.clear(0.57f, 0.77f, 0.85f, 1);

		stateTime += Gdx.graphics.getDeltaTime();
		Sprite sprite = animation.getKeyFrame(stateTime, true);
		sprite.setX(stateTime * 250 % (Gdx.graphics.getWidth() + 400) - 200);

		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose() {
		batch.dispose();
		textureAtlas.dispose();
	}
}
