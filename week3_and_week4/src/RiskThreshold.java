public class RiskThreshold {

    // Linear Search
    static boolean linearSearch(int[] arr, int key) {
        for (int x : arr) {
            if (x == key) return true;
        }
        return false;
    }

    // Binary Search
    static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    // Floor & Ceiling
    static void floorCeil(int[] arr, int x) {
        int floor = -1, ceil = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == x) {
                floor = ceil = arr[mid];
                break;
            }

            if (arr[mid] < x) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Floor: " + floor);
        System.out.println("Ceil: " + ceil);
    }

    public static void main(String[] args) {

        int[] risks = {10, 25, 50, 100};

        System.out.println("Linear Search (30): " + linearSearch(risks, 30));
        System.out.println("Binary Search (50): " + binarySearch(risks, 50));

        floorCeil(risks, 30);
    }
}