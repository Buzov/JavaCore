package JavaThread;

//A correct implementation of a producer and consumer.
class QMy {
int n;
boolean valueSet = false;

synchronized int get() {
 while(!valueSet)
   try {
     wait();

   } catch(InterruptedException e) {
     System.out.println("InterruptedException caught");
   }

   System.out.println("Got: " + n);
   valueSet = false;
   notify();
   return n;
}

synchronized void put(int n) {
 while(valueSet)
   try {
     wait();
   } catch(InterruptedException e) {
     System.out.println("InterruptedException caught");
   }

   this.n = n;
   valueSet = true;
   System.out.println("Put: " + n);
   notify();
}
}

class ProducerMy implements Runnable {
QMy q;

ProducerMy(QMy q) {
 this.q = q;
 new Thread(this, "Producer").start();
}

public void run() {
 int i = 0;

 while(true) {
   q.put(i++);
 }
}
}

class ConsumerMy implements Runnable {
QMy q;

ConsumerMy(QMy q) {
 this.q = q;
 new Thread(this, "Consumer").start();
}

public void run() {
 while(true) {
   q.get();
 }
}
}

class PCFixed {
public static void main(String args[]) {
 QMy q = new QMy();
 new ProducerMy(q);
 new ConsumerMy(q);

 System.out.println("Press Control-C to stop.");
}
}