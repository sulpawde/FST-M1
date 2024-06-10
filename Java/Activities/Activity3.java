//Given an age in seconds, calculate how old someone would be on different planets



public class Activity3 {

    public static void main(String[] args) {

        double ageInSeconds = 1000000000;

        double orbitalPeriodInSecondsEarth = 31557600;
        double orbitalPeriodInSecondsMercury = 0.2408467 * orbitalPeriodInSecondsEarth;
        double orbitalPeriodInSecondsVenus = 0.61519726 * orbitalPeriodInSecondsEarth;
        double orbitalPeriodInSecondsMars = 1.8808158 * orbitalPeriodInSecondsEarth;
        double orbitalPeriodInSecondsJupiter = 11.862615 * orbitalPeriodInSecondsEarth;
        double orbitalPeriodInSecondsSaturn = 29.447498 * orbitalPeriodInSecondsEarth;
        double orbitalPeriodInSecondsUranus = 84.016846 * orbitalPeriodInSecondsEarth;
        double orbitalPeriodInSecondsNeptune = 164.79132 * orbitalPeriodInSecondsEarth;

        System.out.println("Age on Earth: " + ageInSeconds / orbitalPeriodInSecondsEarth);
        System.out.println("Age on Mercury: " + ageInSeconds / orbitalPeriodInSecondsMercury);
        System.out.println("Age on Venus: " + ageInSeconds / orbitalPeriodInSecondsVenus);
        System.out.println("Age on Mars: " + ageInSeconds / orbitalPeriodInSecondsMars);
        System.out.println("Age on Jupiter: " + ageInSeconds / orbitalPeriodInSecondsJupiter);
        System.out.println("Age on Saturn: " + ageInSeconds / orbitalPeriodInSecondsSaturn);
        System.out.println("Age on Uranus: " + ageInSeconds / orbitalPeriodInSecondsUranus);
        System.out.println("Age on Neptune: " + ageInSeconds / orbitalPeriodInSecondsNeptune);

    }

}
