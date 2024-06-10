public class Activity1 {

    public static void main(String[] args) {
        Car toyota = new Car();
        toyota.setColor("Black");
        toyota.setMake(2014);
        toyota.setTransmission("Manual");

        toyota.displayCharacteristics();
        toyota.accelarate();
        toyota.brake();

    }

}
