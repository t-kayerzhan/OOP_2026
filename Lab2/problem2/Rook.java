package problem2;

//Rook.java
public class Rook extends Piece {
 public Rook(Color color, Position pos) {
     super(color, pos);
     symbol = (color == Color.WHITE) ? '♖' : '♜'; 
 }

 @Override
 public boolean isLegalMove(Position b) {
     int dr = Math.abs(b.getRow() - pos.getRow());
     int dc = Math.abs(b.getCol() - pos.getCol());
     return (dr == 0 && dc > 0) || (dc == 0 && dr > 0); 
 }
}