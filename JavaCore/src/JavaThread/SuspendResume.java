package JavaThread;

//Using the suspend() and resume() methods for the
//purposes of demonstration only. Not for new code.
class NewThread3 implements Runnable {
String name; // name of thread
Thread t;

NewThread3(String threadname) {
 name = threadname;
 t = new Thread(this, name);
 System.out.println("New thread: " + t);
 t.start(); // Start the thread
}

// This is the entry point for thread.
public void run() {
 try {
   for(int i = 15; i > 0; i--) {
     System.out.println(name + ": " + i);
     Thread.sleep(200);
   }
 } catch (InterruptedException e) {
   System.out.println(name + " interrupted.");
 }
 System.out.println(name + " exiting.");
}
}

class SuspendResume {
public static void main(String args[]) {
 NewThread3 ob1 = new NewThread3("One");
 NewThread3 ob2 = new NewThread3("Two");

 try {
   Thread.sleep(1000);
   ob1.t.suspend();
   System.out.println("Suspending thread One");
   Thread.sleep(1000);
   ob1.t.resume();
   System.out.println("Resuming thread One");
   ob2.t.suspend();
   System.out.println("Suspending thread Two");
   Thread.sleep(1000);
   ob2.t.resume();
   System.out.println("Resuming thread Two");
 } catch (InterruptedException e) {
   System.out.println("Main thread Interrupted");
 }

 // wait for threads to finish
 try {
   System.out.println("Waiting for threads to finish.");
   ob1.t.join();
   ob2.t.join();
 } catch (InterruptedException e) {
   System.out.println("Main thread Interrupted");
 }
 System.out.println("Main thread exiting.");
}
}
