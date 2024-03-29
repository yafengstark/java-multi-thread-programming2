package chapter03.section01.therad_3_1_11_producer_consumer.project_2_p_c_allWait;

//消费者
public class C {

	private String lock;

	public C(String lock) {
		super();
		this.lock = lock;
	}

	public void getValue() {
		try {
			synchronized (lock) {
				while (ValueObject.value.equals("")) {
					System.out.println("消费者 "
							+ Thread.currentThread().getName() + " WAITING了☆");
					lock.wait();
				}
				System.out.println("消费者 " + Thread.currentThread().getName()
						+ " RUNNABLE了");
				ValueObject.value = "";
				lock.notify(); // 改成notifyAll可解决问题

			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
