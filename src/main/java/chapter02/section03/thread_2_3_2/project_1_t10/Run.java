package chapter02.section03.thread_2_3_2.project_1_t10;

/**
 * 可以停止
 *
 * 但是在-server模式的jvm中，会出现死循环
 *
 * 公共堆栈和私有堆栈的问题。
 *
 * -server模式中，只会在私有堆栈中操作，不会刷新到公共堆栈中
 *
 */
public class Run {

	public static void main(String[] args) {
		PrintString printStringService = new PrintString();
		new Thread(printStringService).start();

		System.out.println("我要停止它！stopThread="
				+ Thread.currentThread().getName());
		printStringService.setContinuePrint(false);
	}

	static class PrintString implements Runnable {

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

		@Override
		public void run() {
			printStringMethod();
		}
	}
}
