package problem2;

public abstract class Piece {
 public enum Color { WHITE, BLACK }

 protected Color color;
 protected Position pos; 
 protected char symbol;  

 public Piece(Color color, Position pos) {
     this.color = color;
     this.pos = pos;
 }

 public Color getColor() { return color; }
 public Position getPos() { return pos; }
 public void setPos(Position pos) { this.pos = pos; }
 public char getSymbol() { return symbol; }

 
 public abstract boolean isLegalMove(Position b);
}