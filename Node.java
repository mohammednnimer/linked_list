package dfk;

public class Node <T extends Comparable<T> >{

	  T data;
	 Node<T> next;
	 Node<T> prev;
	public Node(T data)
	{this.data=data;

	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	@Override
	public String toString() {
		return data+"";
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}


}