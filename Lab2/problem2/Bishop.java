package problem2;

public class Bishop extends Piece {
 public Bishop(Color color, Position pos) {
     super(color, pos);
     symbol = (color == Color.WHITE) ? '♗' : '♝';
 }

 @Override
 public boolean isLegalMove(Position b) {
     int dr = Math.abs(b.getRow() - pos.getRow());
     int dc = Math.abs(b.getCol() - pos.getCol());
     return dr == dc && dr > 0; // diagonal
 }
}