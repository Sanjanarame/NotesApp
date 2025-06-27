import java.io.*;
import java.util.Scanner;

public class TextBasedNotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n(Day 4) Notes functions ");
            System.out.println("1. Write Note");
            System.out.println("2. Read Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    writeNote(sc);
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting Notes...");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 3);

        sc.close();
    }

    static void writeNote(Scanner sc) {
        try (FileWriter fw = new FileWriter("notes.txt", true)) {
            System.out.print("Enter your note: ");
            String note = sc.nextLine();
            fw.write(note + "\n");
            System.out.println("Note saved.");
        } catch (IOException e) {
            System.out.println("Error while writing: " + e.getMessage());
        }
    }

    static void readNotes() {
        try (BufferedReader br = new BufferedReader(new FileReader("notes.txt"))) {
            String line;
            System.out.println("\n--- Your Notes ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes found.");
        } catch (IOException e) {
            System.out.println("Error while reading: " + e.getMessage());
        }
    }
}
