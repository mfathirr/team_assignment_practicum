package Main;

public class Benchmark {

    static final int N = 100000;

    // ================================
    // RUN ALL BENCHMARK
    // ================================
    public static void runAllTests() {

        System.out.println("\n===== BENCHMARK STRUCTURE DATA =====\n");

        testSingleVsDoubleLinkedList();
        testStackVsQueue();
    }

    // ================================
    // SINGLE VS DOUBLY LINKED LIST
    // ================================
    private static void testSingleVsDoubleLinkedList() {

        System.out.println(">> Single Linked List vs Doubly Linked List");

        // Single Linked List
        SingleLinkedList sll = new SingleLinkedList();

        long startSLL = System.nanoTime();
        for (int i = 0; i < N; i++) {
            sll.addLast(i); // sesuaikan jika berbeda
        }
        long endSLL = System.nanoTime();

        // Doubly Linked List
        DoublyLinkedList dll = new DoublyLinkedList();

        long startDLL = System.nanoTime();
        for (int i = 0; i < N; i++) {
            dll.addLast(i); // sesuaikan jika berbeda
        }
        long endDLL = System.nanoTime();

        System.out.println("Single Linked List Time  : " + (endSLL - startSLL) + " ns");
        System.out.println("Doubly Linked List Time  : " + (endDLL - startDLL) + " ns\n");
    }

    // ================================
    // STACK VS QUEUE
    // ================================
    private static void testStackVsQueue() {

        System.out.println(">> Stack vs Queue");

        // Stack
        Stack stack = new Stack();

        long startStack = System.nanoTime();
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }
        for (int i = 0; i < N; i++) {
            stack.pop();
        }
        long endStack = System.nanoTime();

        // Queue
        QueueLinkedList queue = new QueueLinkedList();

        long startQueue = System.nanoTime();
        for (int i = 0; i < N; i++) {
            queue.enqueue(i);
        }
        for (int i = 0; i < N; i++) {
            queue.dequeue();
        }
        long endQueue = System.nanoTime();

        System.out.println("Stack Time : " + (endStack - startStack) + " ns");
        System.out.println("Queue Time : " + (endQueue - startQueue) + " ns\n");
    }
}
