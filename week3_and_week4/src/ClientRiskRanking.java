class Client {
    String name;
    int risk;

    Client(String name, int risk) {
        this.name = name;
        this.risk = risk;
    }

    void display() {
        System.out.println(name + " : " + risk);
    }
}

public class ClientRiskRanking {

    // Bubble Sort (Ascending)
    static void bubbleSort(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Insertion Sort (Descending)
    static void insertionSort(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].risk < key.risk) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        Client[] arr = {
                new Client("C", 80),
                new Client("A", 20),
                new Client("B", 50)
        };

        System.out.println("Bubble Sort (Ascending):");
        bubbleSort(arr);
        for (Client c : arr) c.display();

        System.out.println("\nInsertion Sort (Descending):");
        insertionSort(arr);
        for (Client c : arr) c.display();

        System.out.println("\nTop Risks:");
        for (int i = 0; i < arr.length; i++)
            arr[i].display();
    }
}