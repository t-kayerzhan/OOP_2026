package problem2;

//King.java
public class King extends Piece {
 public King(Color color, Position pos) {
     super(color, pos);
     symbol = (color == Color.WHITE) ? '♔' : '♚';
 }

 @Override
 public boolean isLegalMove(Position b) {
     int dr = Math.abs(b.getRow() - pos.getRow());
     int dc = Math.abs(b.getCol() - pos.getCol());
     return (dr <= 1 && dc <= 1) && !(dr == 0 && dc == 0); // one step in any direction
 }
}
