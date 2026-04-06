public class TransactionFeeSorting {
}
class Transaction {
    String id;
    double fee;
    String timestamp;

    Transaction(String id, double fee, String timestamp) {
        this.id = id;
        this.fee = fee;
        this.timestamp = timestamp;
    }

    void display() {
        System.out.println(id + " : " + fee + " @ " + timestamp);
    }
}

public class TransactionFeeSorting {

    // Bubble Sort (by fee)
    static void bubbleSort(Transaction[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].fee > arr[j + 1].fee) {
                    Transaction temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break; // optimization
        }
    }

    // Insertion Sort (fee + timestamp)
    static void insertionSort(Transaction[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Transaction key = arr[i];
            int j = i - 1;

            while (j >= 0 &&
                    (arr[j].fee > key.fee ||
                            (arr[j].fee == key.fee &&
                                    arr[j].timestamp.compareTo(key.timestamp) > 0))) {

                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    // High fee detection
    static void highFee(Transaction[] arr) {
        boolean found = false;
        for (Transaction t : arr) {
            if (t.fee > 50) {
                System.out.println("High Fee Outlier: " + t.id);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No High Fee Outliers");
        }
    }

    public static void main(String[] args) {

        Transaction[] arr = {
                new Transaction("id1", 10.5, "10:00"),
                new Transaction("id2", 25.0, "09:30"),
                new Transaction("id3", 5.0, "10:15")
        };

        System.out.println("=== Bubble Sort (by fee) ===");
        bubbleSort(arr);
        for (Transaction t : arr) t.display();

        System.out.println("\n=== Insertion Sort (fee + timestamp) ===");
        insertionSort(arr);
        for (Transaction t : arr) t.display();

        System.out.println("\n=== High Fee Check ===");
        highFee(arr);
    }
}