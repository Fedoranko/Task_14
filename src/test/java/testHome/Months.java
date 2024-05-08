package testHome;

import java.util.Random;

public enum Months {
    January, February, March, April, May, June, July, August, September, October, November, December;
    private static final Random month = new Random();

    public static String randomMonth()  {
        Months[] directions = values();
        return directions[month.nextInt(directions.length - 1)].toString();
    }
}
