package com.example.choresplit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ChoreManager {

    private List<String> people = Arrays.asList("MEGHA", "MONALI", "MUSHKAN", "NITHYA");
    private List<Chore> choresList;

    public ChoreManager() {
        choresList = new ArrayList<>();

        // Weekday Chores (Fixed Order)
        assignWeekdayChores();

        // Weekend Chores (Rotating)
        assignWeekendChores();
    }

    private void assignWeekdayChores() {
        // Define the weekdays
        String[] weekdays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        // Loop through each weekday
        for (int i = 0; i < weekdays.length; i++) {
            String day = weekdays[i];

            // Assign Lunch to Megha
            choresList.add(new Chore("Lunch", day, "MEGHA"));

            // Assign Curry to Monali
            choresList.add(new Chore("Curry", day, "MONALI"));

            // Alternate between Mushkan and Nithya for Dishes and Rice
            if (i % 2 == 0) { // On even-indexed days (Monday, Wednesday, Friday)
                choresList.add(new Chore("Dishes", day, "MUSHKAN"));
                choresList.add(new Chore("Rice", day, "NITHYA"));
            } else { // On odd-indexed days (Tuesday, Thursday)
                choresList.add(new Chore("Dishes", day, "NITHYA"));
                choresList.add(new Chore("Rice", day, "MUSHKAN"));
            }
        }
    }

//    private void assignWeekendChores() {
//        String[] weekendDays = {"Saturday", "Sunday"};
//
//        // Saturday's Chores
//        List<String> saturdayChores = Arrays.asList(
//                "1. Washing Dishes - Lunch \n2. Clean the Bathroom \n3. Make Dinner",
//                "1. Make Lunch \n2. Clean the Kitchen \n3. Vacuum Stairs and Corridors",
//                "1. Clean the Toilet \n2. Make Dinner \n3. Washing Dishes - Dinner",
//                "1. Make Lunch \n2. Take out the Trash - Big \n3. Vacuum Downstairs"
//        );
//
//        // Sunday's Chores
//        List<String> sundayChores = Arrays.asList(
//                "1. Make Lunch \n2. Take out the Trash - Food",
//                "1. Make Dinner \n2. Washing Dishes - Lunch",
//                "1. Make Lunch \n2. Washing Dishes - Dinner",
//                "1. Make Dinner"
//        );
//
//        // Determine the week of the month for rotation
//        int weekOfMonth = getWeekOfMonth();
//
//        // Assign rotating weekend chores based on the week
//        for (int i = 0; i < saturdayChores.size(); i++) {
//            String person = people.get((i + weekOfMonth - 1) % people.size());
//            choresList.add(new Chore(saturdayChores.get(i), "Saturday", person));
//            choresList.add(new Chore(sundayChores.get(i), "Sunday", person));
//        }
//    }
private void assignWeekendChores() {
    String[] weekendDays = {"Saturday", "Sunday"};

    // Saturday's Chores
    List<String> saturdayChores = Arrays.asList(
            "1. Washing Dishes - Lunch \n2. Clean the Bathroom \n3. Make Dinner",
            "1. Make Lunch \n2. Clean the Kitchen \n3. Vacuum Stairs and Corridors",
            "1. Clean the Toilet \n2. Make Dinner \n3. Washing Dishes - Dinner",
            "1. Make Lunch \n2. Take out the Trash - Big \n3. Vacuum Downstairs"
    );

    // Sunday's Chores
    List<String> sundayChores = Arrays.asList(
            "1. Make Lunch \n2. Take out the Trash - Food",
            "1. Make Dinner \n2. Washing Dishes - Lunch",
            "1. Make Lunch \n2. Washing Dishes - Dinner",
            "1. Make Dinner"
    );

    // Determine the week of the month for rotation
    int weekOfMonth = getWeekOfMonth();

    // Calculate the starting index for this week's rotation
    int startIndex = (weekOfMonth - 1) % people.size();

    // Rotate the people list for the current week
    List<String> rotatedPeople = new ArrayList<>();
    for (int i = 0; i < people.size(); i++) {
        rotatedPeople.add(people.get((startIndex + i) % people.size()));
    }

    // First, assign all Saturday's chores
    for (int i = 0; i < saturdayChores.size(); i++) {
        // Get the person for Saturday from the rotated list
        String personForSaturday = people.get((startIndex + i) % people.size());

        // Assign Saturday's chores to the person
        choresList.add(new Chore(saturdayChores.get(i), "Saturday", personForSaturday));
    }

    // Then, assign all Sunday's chores
    for (int i = 0; i < sundayChores.size(); i++) {
        // Get the person for Sunday from the rotated list
        String personForSunday = people.get((startIndex + i) % people.size());

        // Assign Sunday's chores to the person
        choresList.add(new Chore(sundayChores.get(i), "Sunday", personForSunday));

    }
}

    private int getWeekOfMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.WEEK_OF_MONTH);
    }

    public List<Chore> getChoresForDay(String day, String person) {
        List<Chore> filteredChores = new ArrayList<>();
        for (Chore chore : choresList) {
            if (chore.getDay().equalsIgnoreCase(day) && chore.getAssignedPerson().equalsIgnoreCase(person)) {
                filteredChores.add(chore);
            }
        }
        return filteredChores;
    }

    public List<Chore> getAllChores() {
        return choresList;
    }
}

