package com.enderzombi102.emr.client.hud;

public abstract class HudBar {

	protected int row;
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	public boolean whiteFrame = false;

	public abstract float getFullLenght();
	public abstract boolean blinking();

	protected void toggleFrame() {
		this.whiteFrame = !whiteFrame;
	}

	public int getV() {
		if (this.row < 1) this.row = 1;
		if (this.row > 4) this.row = 4;
		return this.row * 64;
	}

	public int getU() {
		return 64;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return this.width;
	}

	public int getHeight() {
		return height;
	}
}
