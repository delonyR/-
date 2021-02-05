import java.util.Random;

public class Threads {

//线程太多把我的jvm给炸了，所以我就创了100个而已；
    public static void main(String[] args) {
        Thread t [] = new MyThread[100];
        for(int i = 0;i < 100;i++){
            t[i] = new MyThread();
            t[i].start();
        }

    }
}
class MyThread extends Thread {
    private static final String [] wishs = {"新年快乐，孤寡孤寡","新年新对象，年年不一样"};
    private static Random random = new Random();
    public void run() {
        System.out.println(wishs[random.nextInt(2)]);
    }
}