package problem3;

public class TestTemperature {
    public static void main(String[] args) {
        Temperature t = new Temperature(25, 'C');
        System.out.println("25 C in Fahr: " + t.inFahrenheit());
    }
}