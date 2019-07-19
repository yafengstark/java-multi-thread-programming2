package chapter02.section03.thread_2_3_1.project_1_t99;


public class Run {

	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		printStringService.printStringMethod(); // 阻塞在这个地方

		System.out.println("我要停止它！stopThread="
				+ Thread.currentThread().getName());

		printStringService.setContinuePrint(false);
	}

	static class PrintString {

		private boolean isContinuePrint = true;

		public boolean isContinuePrint() {
			return isContinuePrint;
		}

		public void setContinuePrint(boolean isContinuePrint) {
			this.isContinuePrint = isContinuePrint;
		}

		public void printStringMethod() {
			try {
				while (isContinuePrint == true) {
					System.out.println("run printStringMethod threadName="
							+ Thread.currentThread().getName());
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
	}
}
