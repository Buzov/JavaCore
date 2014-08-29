package JavaThread;

//This program uses a synchronized block.
class CallmeMy {
void call(String msg) {
 System.out.print("[" + msg);
 try {
   Thread.sleep(1000);
 } catch (InterruptedException e) {
   System.out.println("Interrupted");
 }
 System.out.println("]");
}
}

class CallerMy implements Runnable {
String msg;
CallmeMy target;
Thread t;

public CallerMy(CallmeMy targ, String s) {
 target = targ;
 msg = s;
 t = new Thread(this);
 t.start();
}

// synchronize calls to call()
public void run() {
 synchronized(target) { // synchronized block
   target.call(msg);
 }
}
}

class Synch1 {
public static void main(String args[]) {
 CallmeMy target = new CallmeMy();
 CallerMy ob1 = new CallerMy(target, "Hello");
 CallerMy ob2 = new CallerMy(target, "Synchronized");
 CallerMy ob3 = new CallerMy(target, "World");

 // wait for threads to end
 try {
   ob1.t.join();
   ob2.t.join();
   ob3.t.join();
 } catch(InterruptedException e) {
   System.out.println("Interrupted");
 }
}
}

