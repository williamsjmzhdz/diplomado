package edu.dgtic.lsp;

public class Square implements Shape {
	private int width;
	private int height;

	public Square(int side) {
		setSide(side);
	}

	public void setWidth(int width) {
		setSide(width);
	}

	public void setHeight(int height) {
		setSide(height);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void setSide(int side) {
		this.width = side;
		this.height = side;
	}

	@Override
	public int computeArea() {
		return width * height;
	}
}
