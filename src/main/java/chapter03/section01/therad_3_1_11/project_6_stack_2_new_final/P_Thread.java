package chapter03.section01.therad_3_1_11.project_6_stack_2_new_final;

public class P_Thread extends Thread {

	private P p;

	public P_Thread(P p) {
		super();
		this.p = p;
	}

	@Override
	public void run() {
		while (true) {
			p.pushService();
		}
	}

}
