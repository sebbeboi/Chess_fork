package board;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import pieces.Pawn;

public class ChessBoard extends Group {

	public ChessBoard() {

		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {

				Color bg = Color.SANDYBROWN;
				if ((row + col) % 2 == 0) {
					bg = Color.WHITE;
				}

				
				
				Square s = new Square(bg);
				s.setTranslateX(col * Square.SIZE);
				s.setTranslateY(row * Square.SIZE);
				this.getChildren().add(s);

				if(row == 1){
					s.addPiece(new Pawn(Color.BLACK));
				}
				if(row == 6){
					s.addPiece(new Pawn(Color.WHITE));
				}
			}

		}
	}
}