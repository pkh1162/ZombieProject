package pkh1162.model;

public class ZombieSleep extends Thread {

	volatile boolean isAttack;
	volatile boolean endProgram;
	private int duration = 120000; // in milliseconds
	private Object lock = new Object();

	public ZombieSleep() {
		this.isAttack = false;
		this.endProgram = true;
	}

	public Object getLock() {
		return lock;
	}

	public boolean getIsAttack() {
		return isAttack;
	}

	public void startUpTimer() {
		synchronized (lock) {
			lock.notify();
			isAttack = false;
		}
	}

	public void run() {

		synchronized (lock) {

			while (!Thread.currentThread().isInterrupted()) {

				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
				//	System.out.println("Sleep inter");
                    Thread.currentThread().interrupt();
				//	e.printStackTrace();
				}

				isAttack = true;
				
				try {
					lock.wait();
				} catch (InterruptedException e) {
				//	System.out.println("Wait inter");
                    Thread.currentThread().interrupt();
				//	e.printStackTrace();
				}
				
			}
		}
	}
}
