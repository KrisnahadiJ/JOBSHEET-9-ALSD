public class StackKonversi11 {
    int[] tumpukanBiner;
    int size;
    int top;

    public StackKonversi11() {
        this.size = 32; // Asumsi 32 bit
        tumpukanBiner = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack penuh!");
        } else {
            top++;
            tumpukanBiner[top] = data;
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong.");
            return -1;
        } else {
            int data = tumpukanBiner[top];
            top--;
            return data;
        }
    }

    public String konversiDesimalKeBiner(int nilai) {
        while (nilai != 0) {
            int sisa = nilai % 2;
            push(sisa);
            nilai = nilai / 2;
        }

        String biner = "";
        while (!isEmpty()) {
            biner += pop();
        }
        return biner;
    }
}