package dfk;

public class LinkedList<T extends Comparable<T>> {

	Node<T> head;

	public void insert(T data) {
Node newnode=new Node<>(data);

		if(head==null)
			{
			System.out.println(data);
			head=newnode;
			return;
			}
		Node curr=head;
		for(;curr.next!=null&&curr.data.compareTo(data)<0;curr=curr.next);
		if(curr.prev==null&&curr.data.compareTo(data)>0)
		{
			System.out.println(data);
			newnode.next=curr;
			curr.prev=newnode;
			head=newnode;
			
			
		}


		else if(curr.data.compareTo(data)<0&&curr.next==null)
		{
			System.out.println(data);
			curr.next=newnode;
			newnode.prev=curr;
		}
		else {
//			newnode.next=curr.next;
//			newnode.prev=curr;
//			System.out.println(newnode.data);
//		curr.next.prev=newnode;
//		
//			curr.next=newnode;
			
			newnode.next=curr;
			newnode.prev=curr.prev;
		
			curr.prev.next=newnode;
			curr.prev=newnode;
		
		
			
			
		}
		
		
		

	}

	public Node delet(T data) {

if(head==null)
	return null;



Node curr=head;



for(;curr.next!=null&&curr.data.compareTo(data)!=0;curr=curr.next);
if(curr==null)
	return null;

else {
if(curr.prev==null&&curr.data.compareTo(data)==0)
	head=curr.next;

else if(curr.next==null&&curr.data.compareTo(data)==0)
{
	curr.prev.next=null;
}
else if(curr.next !=null&&curr.prev!=null)
{
	curr.prev.next=curr.next;
    curr.next.prev=curr.prev.prev;	
	
}



return curr;
		
		
}
	}

	public Node find(T data) {

		return find(data, head);

	}

	private Node find(T data, Node curr) {
		if (curr == null)
			return null;

		if (curr.data.compareTo(data) == 0)
			return curr;

		return find(data, curr.next);

	}

	//
	//
	//
	//
	// public Node find(T data) {
	//
	// Node<T> curr = head;
	//
	// if(head==null)
	// {
	// return null;
	// }
	// for(;curr != null &&curr.data.compareTo(data)!=0;curr=curr.next);
	// if(curr==null)
	// return null;
	//
	//
	//
	//
	//
	// return curr;
	//
	//
	//
	// }
	//
	public void Reverse_iterative() {
		if (head == null || head.next == null)
			return;

		Node curr = head;
		
	Node prev=null;
	Node next=null;
	
	while (curr !=null) {
		
		
		
		
		next=curr.next;
		curr.next=prev;
		prev=curr;
		curr= next;
		
		
		
	}	
		head=prev;
		
		
		
		
		
		

	}

	public void reverse_Recursive() {
		if (head == null || head.next == null)
			return;

		Node curr = head;
		reverse(head, head.next);
		curr.next = null;

	}

	private void reverse(Node data, Node curr) {
		if (curr.next == null) {
			curr.next = data;
			head = curr;
			return;
		}

		reverse(data.next, curr.next);
		curr.next = data;

	}

	public Node max() {
		if (head == null)
			return null;
		return max(head, head);

	}

	private Node max(Node n, Node maxim) {
		if (n == null)
			return maxim;

		if (n.data.compareTo(maxim.data) > 0)
			maxim = n;

		return max(n.next, maxim);

	}

	public Node min() {
		if (head == null)
			return null;
		return min(head, head);

	}

	private Node min(Node n, Node min) {
		if (n == null)
			return min;

		if (n.data.compareTo(min.data) < 0)
			min = n;

		return min(n.next, min);

	}

	public void travrce() {
		Node<T> curr = head;

		while (curr != null) {
			System.out.print(curr + "-->");
			curr = curr.next;

		}
		System.out.println("null");

	
	}

}
