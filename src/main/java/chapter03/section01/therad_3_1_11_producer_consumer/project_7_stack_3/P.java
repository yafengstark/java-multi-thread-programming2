package chapter03.section01.therad_3_1_11_producer_consumer.project_7_stack_3;

public class P {

	private MyStack myStack;

	public P(MyStack myStack) {
		super();
		this.myStack = myStack;
	}

	public void pushService() {
		myStack.push();
	}
}
