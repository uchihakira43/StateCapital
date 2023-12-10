import java.util.*;

public class StateCapitalApp {
    public static void main(String[] args) {
        // Part 1: Sorting Arrays
        String[][] stateCapitalsArray = {
                {"Alabama", "Montgomery"},
                {"Alaska", "Juneau"},
                {"Arizona", "Phoenix"},
                {"Arkansas", "Little Rock"},
                {"California", "Sacramento"},
                {"Colorado", "Denver"},
                {"Connecticut", "Hartford"},
                {"Delaware", "Dover"},
                {"Florida", "Tallahassee"},
                {"Georgia", "Atlanta"},
                {"Hawaii", "Honolulu"},
                {"Idaho", "Boise"},
                {"Illinois", "Springfield"},
                {"Indiana", "Indianapolis"},
                {"Iowa", "Des Moines"},
                {"Kansas", "Topeka"},
                {"Kentucky", "Frankfort"},
                {"Louisiana", "Baton Rouge"},
                {"Maine", "Augusta"},
                {"Maryland", "Annapolis"},
                {"Massachusetts", "Boston"},
                {"Michigan", "Lansing"},
                {"Minnesota", "St. Paul"},
                {"Mississippi", "Jackson"},
                {"Missouri", "Jefferson City"},
                {"Montana", "Helena"},
                {"Nebraska", "Lincoln"},
                {"Nevada", "Carson City"},
                {"New Hampshire", "Concord"},
                {"New Jersey", "Trenton"},
                {"New Mexico", "Santa Fe"},
                {"New York", "Albany"},
                {"North Carolina", "Raleigh"},
                {"North Dakota", "Bismarck"},
                {"Ohio", "Columbus"},
                {"Oklahoma", "Oklahoma City"},
                {"Oregon", "Salem"},
                {"Pennsylvania", "Harrisburg"},
                {"Rhode Island", "Providence"},
                {"South Carolina", "Columbia"},
                {"South Dakota", "Pierre"},
                {"Tennessee", "Nashville"},
                {"Texas", "Austin"},
                {"Utah", "Salt Lake City"},
                {"Vermont", "Montpelier"},
                {"Virginia", "Richmond"},
                {"Washington", "Olympia"},
                {"West Virginia", "Charleston"},
                {"Wisconsin", "Madison"},
                {"Wyoming", "Cheyenne"}
        };

        // Display the current contents of the array
        displayArray(stateCapitalsArray);

        // Sort the array by capital using bubble sort
        bubbleSortByCapital(stateCapitalsArray);

        // Display the sorted array
        displayArray(stateCapitalsArray);

        // Prompt the user to enter state capitals
        int correctCount = quizUser(stateCapitalsArray);

        // Display the total correct count
        System.out.println("Total correct count: " + correctCount);

        // Part 2: Sorting & Searching HashMap
        Map<String, String> stateCapitalMap = new HashMap<>();

        // Populate the HashMap with state-capital pairs
        populateHashMap(stateCapitalsArray, stateCapitalMap);

        // Display the content of the HashMap
        displayHashMap(stateCapitalMap);

        // Sort the HashMap using TreeMap for ordering
        Map<String, String> sortedStateCapitalMap = new TreeMap<>(stateCapitalMap);

        // Prompt the user to enter a state and display the capital
        promptUserForState(sortedStateCapitalMap);
    }

    // Utility method to display the contents of a 2D array
    private static void displayArray(String[][] array) {
        System.out.println("States and Capitals:");
        for (String[] pair : array) {
            System.out.println(pair[0] + ": " + pair[1]);
        }
        System.out.println();
    }

    // Utility method to perform bubble sort on the array based on the capital
    private static void bubbleSortByCapital(String[][] array) {
        int n = array.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (array[i][1].compareToIgnoreCase(array[i + 1][1]) > 0) {
                    // Swap elements if they are in the wrong order
                    String[] temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // Utility method to quiz the user on state capitals
    private static int quizUser(String[][] array) {
        Scanner scanner = new Scanner(System.in);
        int correctCount = 0;
        for (String[] pair : array) {
            System.out.print("Enter the capital of " + pair[0] + ": ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equalsIgnoreCase(pair[1])) {
                System.out.println("Correct!");
                correctCount++;
            } else {
                System.out.println("Incorrect. The correct capital is " + pair[1]);
            }
        }
        return correctCount;
    }

    // Utility method to populate a HashMap with state-capital pairs
    private static void populateHashMap(String[][] array, Map<String, String> map) {
        for (String[] pair : array) {
            map.put(pair[0], pair[1]);
        }
    }

    // Utility method to display the content of a HashMap
    private static void displayHashMap(Map<String, String> map) {
        System.out.println("HashMap Content:");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    // Utility method to prompt the user for a state and display the capital
    private static void promptUserForState(Map<String, String> sortedMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a state to find its capital: ");
        String userState = scanner.nextLine();

        String capital = sortedMap.get(userState);
        if (capital != null) {
            System.out.println("The capital of " + userState + " is " + capital);
        } else {
            System.out.println("State not found.");
        }
    }
}
