package chapter03.section01.therad_3_1_11_producer_consumer.project_3_stack_1;

/**
 * 操作栈 一生产者一消费者
 *
 */
public class Run {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();

		P p = new P(myStack);
		C r = new C(myStack);

		P_Thread pThread = new P_Thread(p);
		C_Thread rThread = new C_Thread(r);
		pThread.start();
		rThread.start();
	}

}
