public class AccountSearch {

    // Linear Search (First occurrence)
    static int linearSearch(String[] arr, String key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(key))
                return i;
        }
        return -1;
    }

    // Binary Search + Count occurrences
    static int binarySearch(String[] arr, String key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(key))
                return mid;
            else if (arr[mid].compareTo(key) < 0)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    static int countOccurrences(String[] arr, String key) {
        int count = 0;
        for (String s : arr)
            if (s.equals(key)) count++;
        return count;
    }

    public static void main(String[] args) {

        String[] logs = {"A", "B", "B", "C"};

        System.out.println("Linear Search (B): " + linearSearch(logs, "B"));
        System.out.println("Binary Search (B): " + binarySearch(logs, "B"));
        System.out.println("Count of B: " + countOccurrences(logs, "B"));
    }
}