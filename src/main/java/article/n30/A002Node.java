package article.n30;

public class A002Node {
	public int value;
	public A002Node next;
	
	public A002Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public A002Node getNext() {
		return next;
	}

	public void setNext(A002Node next) {
		this.next = next;
	}

}
