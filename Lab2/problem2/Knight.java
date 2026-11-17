package problem2;

public class Knight extends Piece {
 public Knight(Color color, Position pos) {
     super(color, pos);
     symbol = (color == Color.WHITE) ? '♘' : '♞';
 }

 @Override
 public boolean isLegalMove(Position b) {
     int dr = Math.abs(b.getRow() - pos.getRow());
     int dc = Math.abs(b.getCol() - pos.getCol());
     return (dr == 2 && dc == 1) || (dr == 1 && dc == 2); // L‑shape
 }
}
