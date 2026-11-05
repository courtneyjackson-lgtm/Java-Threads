
public class JavaThreads {

	public static void main(String[] args) {
		Thread threadA = new Thread(() -> {
			System.out.println("Thread A: Ascending up");
			
			for (int i = 1; i <= 20; i++) {
				System.out.println("Ascending Up: " + i);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		});
		
		Thread threadB = new Thread(() -> {
			System.out.println("Thread B: Descending down");
			
			for (int i = 20; i >= 0; i--) {
				System.out.println("Descending down: " + i);
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException ex) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		});
		
		threadA.start();
		
		try {
			threadA.join();
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
			return;
		}
		
		threadB.start();
		
	}

}
