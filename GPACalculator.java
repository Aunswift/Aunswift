import java.util.Scanner;

public class GPACalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter how much lessons you have: ");
        int lessons = scanner.nextInt();
        scanner.nextLine();

        String[] lessonsYouHave = new String[lessons];

        int[] lessonsECTS = new int[lessons];
        String[] grades = new String[lessons];

        for (int i = 1; i <= lessons; i++) {
            System.out.print(i + ". Lesson's Name: ");
            lessonsYouHave[i - 1] = scanner.nextLine();
            System.out.print(lessonsYouHave[i - 1] + "'s ECTS: ");
            lessonsECTS[i - 1] = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            System.out.print(lessonsYouHave[i - 1] + "'s Letter Grade: ");
            grades[i - 1] = scanner.nextLine();
        }
        calculateECTS(lessonsYouHave, lessonsECTS, grades);
        scanner.close();

    }

    public static void calculateECTS(String[] lessonsName, int[] lessonsECTS, String[] grades) {
        double total = 0;
        for (int i = 0; i < lessonsECTS.length; i++) {
            if (grades[i].equalsIgnoreCase("AA") || grades[i].equalsIgnoreCase("A")) {
                total += (lessonsECTS[i] * 4);
            } else if (grades[i].equalsIgnoreCase("AB") || grades[i].equalsIgnoreCase("A-")) {
                total += (lessonsECTS[i] * 3.67);
            } else if (grades[i].equalsIgnoreCase("BA") || grades[i].equalsIgnoreCase("B+")) {
                total += (lessonsECTS[i] * 3.33);
            } else if (grades[i].equalsIgnoreCase("BB") || grades[i].equalsIgnoreCase("B")) {
                total += (lessonsECTS[i] * 3);
            } else if (grades[i].equalsIgnoreCase("BC") || grades[i].equalsIgnoreCase("B-")) {
                total += (lessonsECTS[i] * 2.67);
            } else if (grades[i].equalsIgnoreCase("CB") || grades[i].equalsIgnoreCase("C+")) {
                total += (lessonsECTS[i] * 2.33);
            } else if (grades[i].equalsIgnoreCase("CC") || grades[i].equalsIgnoreCase("C")) {
                total += (lessonsECTS[i] * 2);
            } else if (grades[i].equalsIgnoreCase("CD") || grades[i].equalsIgnoreCase("C-")) {
                total += (lessonsECTS[i] * 1.67);
            } else if (grades[i].equalsIgnoreCase("DC") || grades[i].equalsIgnoreCase("D+")) {
                total += (lessonsECTS[i] * 1.33);
            } else if (grades[i].equalsIgnoreCase("DD") || grades[i].equalsIgnoreCase("D")) {
                total += (lessonsECTS[i]);
            } else if (grades[i].equalsIgnoreCase("FF") || grades[i].equalsIgnoreCase("F")) {
                total += 0;
            } else if (grades[i].equalsIgnoreCase("NA")) {
                total += 0;
            } else {
                System.out.println("Invalid input.");
            }
        }

        double totalECTS = 0;

        for (int j = 0; j < grades.length; j++) {
            totalECTS += lessonsECTS[j];
        }

        double GPA = total / totalECTS;

        for (int i = 0; i < grades.length; i++) {
            System.out.println("Your " + (i + 1) + ". Lesson: __ " + lessonsName[i] + " __ ECTS: " + lessonsECTS[i]);
        }

        GPA = Math.round(GPA * 100);
        GPA /= 100;

        System.out.println("Your GPA: " + GPA);

    }
}
