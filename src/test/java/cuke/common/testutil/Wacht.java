package cuke.common.testutil;

/**
 * Created on 23-1-2017.
 */
public class Wacht {
    public static void milliseconden(int milliseconden) {
        for (int i = milliseconden; i > 0; i--) {
            slaap(1);
        }
    }

    public static void seconden(int seconden) {
        for (int i = seconden; i > 0; i--) {
            if (i % 10 == 0) {
                System.out.println(String.format("Nog %s seconden wachten.", i));
            }
            slaap(1000);
        }
    }

    public static void minuten(int minuten) {
        for (int i = minuten; i > 0; i--) {
            System.out.println(String.format("Nog %s minuten wachten.", i));
            slaap(60000);
        }
    }

    private static void slaap(int milliseconden) {
        try {
            Thread.sleep(milliseconden);
        } catch (InterruptedException e) {
            System.out.println("Kon niet slapen.");
        }
    }
}
