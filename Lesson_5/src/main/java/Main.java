import java.util.Arrays;

public class Main {
    public static Object monitor = new Object();
    public static void main(String[] args) {

        Runnable TestTimeOne = new Runnable() {
            public void run() {
                arrayOneTestTime();
            }
        };
        new Thread(TestTimeOne, "Thread #0").start();

        arrayOneTestTwo();

    }

    public static void arrayOneTestTime() {
        final int SIZEARRAY = 10000000;
        float[] arrayOne = new float[SIZEARRAY];

        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = 1;
        }

        long leadTime = System.currentTimeMillis();

        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = (float) (arrayOne[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.currentTimeMillis();
        System.out.println("Время работы первого метода: " + (System.currentTimeMillis() - leadTime));
    }

    public synchronized static void arrayOneTestTwo() {
        final int SIZEARRAY = 10000000;
        final int SIZEARRAYTWO = SIZEARRAY / 2;
        final float[] arrayOne = new float[SIZEARRAY];
        final float[] arrayTwo = new float[SIZEARRAYTWO];
        final float[] arrayTree = new float[SIZEARRAYTWO];

        for (int i = 0; i < arrayOne.length; i++) {
            arrayOne[i] = 1;
        }
        final long leadTime = System.currentTimeMillis();

    //Разбивка массива. Массив 1.
    System.arraycopy(arrayOne, 0, arrayTwo, 0, SIZEARRAYTWO);
    long breakdownTimeOne = System.currentTimeMillis();

    //Разбивка массива. Массив 2.
    System.arraycopy(arrayOne, SIZEARRAYTWO, arrayTree, 0, SIZEARRAYTWO);
    long breakdownTimeTwo = System.currentTimeMillis();

        synchronized (monitor) {
                for (int i = 0; i < arrayTwo.length; i++) {
                    arrayTwo[i] = (float) (arrayTwo[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }

                for (int i = 0; i < arrayTree.length; i++) {
                    arrayTree[i] = (float) (arrayTree[i] * Math.sin(0.2f + i / 5)
                            * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
        }

        //Соединение двух массивов в 1.
        System.arraycopy(arrayTwo, 0, arrayOne, 0, SIZEARRAYTWO);
        System.arraycopy(arrayTree, 0, arrayOne, SIZEARRAYTWO, SIZEARRAYTWO);
        System.currentTimeMillis();
        System.out.println("Время работы второго метода: " + (System.currentTimeMillis() - leadTime));
    }
}