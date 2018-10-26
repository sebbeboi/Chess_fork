package board;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pieces.Piece;

public class Square extends Group {

	public static final double SIZE = 80;

	public static Square active;

	private Rectangle bg;
	private Color originalColor;
	private Piece piece;

	public Square(Color c) {
		originalColor = c;
		bg = new Rectangle(SIZE, SIZE, c);
		this.getChildren().add(bg);

		this.setOnMouseClicked(event -> {

			makeActive();
			
			// EXEMPEL:
		});
	}
		
			

	private void makeActive() {
		
		if (active == this){
			makeInactive();
			return;
		
		}
		
		else if(!hasPiece()){
			
			this.addPiece(active.getPiece());
			active.piece = null;
			active.makeInactive();
			return;
			
		}
	
		else if(active != null){
			active.makeInactive();
		}
		
		active = this;
		
		this.getBackground().setFill(Color.RED);
		
		
		

	}

	private void makeInactive() {
		active = null;
		this.getBackground().setFill(originalColor);
	}

	public void addPiece(Piece p) {
		this.piece = p;
		this.getChildren().add(p);
	}

	public boolean hasPiece() {
		return this.piece != null;
	}

	public Piece getPiece(){
		return this.piece;
	}
	
	public Rectangle getBackground() {
		return this.bg;
	}

}
