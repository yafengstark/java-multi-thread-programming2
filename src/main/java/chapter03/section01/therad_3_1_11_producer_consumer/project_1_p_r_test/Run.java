package chapter03.section01.therad_3_1_11_producer_consumer.project_1_p_r_test;

/**
 * 单生产者，单消费者
 *
 * 交替打印
 *
 *
 */
public class Run {

	public static void main(String[] args) {

		String lock = new String("");
		P p = new P(lock);
		C r = new C(lock);

		ThreadP pThread = new ThreadP(p);
		ThreadC threadC = new ThreadC(r);

		pThread.start();
		threadC.start();
	}

}
