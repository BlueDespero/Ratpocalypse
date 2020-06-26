package ratpocalypse.display.areas;

import java.awt.Graphics;

import ratpocalypse.backend.Handler;
import ratpocalypse.display.buttons.CreatureButton;
import ratpocalypse.entities.plantUnits.bitingPlant;
import ratpocalypse.entities.plantUnits.bombPlant;
import ratpocalypse.entities.plantUnits.oddishPlant;
import ratpocalypse.entities.plantUnits.palmPlant;
import ratpocalypse.entities.plantUnits.rosePlant;
import ratpocalypse.entities.plantUnits.roseShinyPlant;
import ratpocalypse.entities.plantUnits.shotgunPlant;
import ratpocalypse.entities.plantUnits.shroomPlant;
import ratpocalypse.entities.plantUnits.uziPlant;

public class SelectionArea extends Area {

	public SelectionArea(Handler handler) {
		super(handler);
		buttonlist.add(new CreatureButton(handler, 0*128, 
				new shotgunPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 1*128, 
				new uziPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 2*128, 
				new bitingPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 3*128, 
				new bombPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 4*128, 
				new oddishPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 5*128, 
				new shroomPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 6*128, 
				new palmPlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 7*128, 
				new rosePlant(0, 0, handler, null)));
		buttonlist.add(new CreatureButton(handler, 8*128, 
				new roseShinyPlant(0, 0, handler, null)));
	}

	@Override
	public void render(Graphics g) {
		renderbuttorlist(g);
	}

	@Override
	public void tick() {
		tickbuttonlist();
	}
	
}
