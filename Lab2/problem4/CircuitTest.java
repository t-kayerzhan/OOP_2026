package problem4;

public class CircuitTest {
    public static void main(String[] args) {
       
        Circuit r1 = new Resistor(7.0);
        Circuit r2 = new Resistor(10.0);
        Circuit r3 = new Resistor(6.0);
        Circuit r4 = new Resistor(4.0);

        Circuit c1 = new Parallel(r1, r2);
        Circuit c2 = new Series(r3, r4);
        Circuit circuit = new Parallel(c1, c2);

        double R = circuit.getResistance();
        System.out.println(" resistance: " + R + " Ом");


        circuit.applyPotentialDiff(12.0); // 12 V
        System.out.println("Applied voltage: " + circuit.getPotentialDiff() + " V");
        System.out.println("Total current: " + circuit.getCurrent() + " A"); //ток
        System.out.println("Total power: " + circuit.getPower() + " Wt"); //мощность


        System.out.println("\nVoltage r1: " + r1.getPotentialDiff() + " V");
        System.out.println("Voltage  r2: " + r2.getPotentialDiff() + " V");
        System.out.println("Voltage  r3: " + r3.getPotentialDiff() + " V");
        System.out.println("Voltage  r4: " + r4.getPotentialDiff() + " V");
    }
}