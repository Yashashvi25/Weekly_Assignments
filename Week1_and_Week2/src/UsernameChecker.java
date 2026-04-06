import java.util.*;

public class UsernameChecker {

    // Store existing usernames (username → userId)
    static HashMap<String, Integer> users = new HashMap<>();

    // Track how many times a username is searched
    static HashMap<String, Integer> attempts = new HashMap<>();

    // Check availability in O(1)
    static boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);

        if (users.containsKey(username))
            return false;
        else
            return true;
    }

    // Suggest alternatives if taken
    static List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            String newName = username + i;
            if (!users.containsKey(newName))
                suggestions.add(newName);
        }

        // Replace "_" with "."
        String modified = username.replace("_", ".");
        if (!users.containsKey(modified))
            suggestions.add(modified);

        return suggestions;
    }

    // Get most attempted username
    static String getMostAttempted() {
        String maxUser = "";
        int maxCount = 0;

        for (String key : attempts.keySet()) {
            if (attempts.get(key) > maxCount) {
                maxCount = attempts.get(key);
                maxUser = key;
            }
        }
        return maxUser;
    }

    public static void main(String[] args) {

        // Existing users
        users.put("john_doe", 1);
        users.put("admin", 2);

        // Check availability
        System.out.println("john_doe → " + checkAvailability("john_doe")); // false
        System.out.println("jane_smith → " + checkAvailability("jane_smith")); // true

        // Suggestions
        System.out.println("Suggestions for john_doe: " + suggestAlternatives("john_doe"));

        // Simulate attempts
        checkAvailability("admin");
        checkAvailability("admin");
        checkAvailability("admin");

        // Most attempted
        System.out.println("Most Attempted: " + getMostAttempted());
    }
}