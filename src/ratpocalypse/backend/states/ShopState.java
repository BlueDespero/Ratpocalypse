package ratpocalypse.backend.states;

import java.awt.Color;
import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.areas.ShopArea;
import ratpocalypse.display.gfx.Assets;

public class ShopState extends State {
	private ShopArea shopArea;

	public ShopState(Handler handler) {
		super(handler);
		shopArea = new ShopArea(handler);
	}

	@Override
	public void tick() {
		handler.getGame().setStateName("shop");
		shopArea.tick();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.shopBackground, 0*renderUnitWidth, 0*renderUnitHeight, null);
		g.setColor(Color.blue);
		shopArea.render(g);
	}
	
	@Override
	public void OnClick(int MouseX, int MouseY) {
		shopArea.onClick(MouseX, MouseY);
	}

	public ShopArea getShopArea() {
		return shopArea;
	}

	public void setShopArea(ShopArea shopArea) {
		this.shopArea = shopArea;
	}
}
