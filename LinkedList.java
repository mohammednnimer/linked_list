package lab4;
//that make in lab its nee some idyt
public class curserArray<T extends Comparable<T>> {

	CNode<T> newnode[];

	public curserArray(int x) {
		inttilized(x);

	}

	public void inttilized(int n) {
		newnode = new CNode[n];
		for (int i = 0; i <= newnode.length - 2; i++) {

			newnode[i] = new CNode(null, i + 1);

		}

		newnode[n - 1] = new CNode(null, 0);

	}

	public int malloc() {
		int p = newnode[0].next;
		newnode[0].next = newnode[p].next;
		return p;
	}

	public void free(int p) {
		if (p > newnode.length) {
			return;
		}

		newnode[p] = new CNode<>(null, newnode[0].next);
		newnode[0].next = p;

	}

	public int creartlist() {
		int n = malloc();
		if (n != 0) {
			newnode[n] = new CNode("domain", 0);
			return n;

		}
		System.out.println("sorry the list is full");
		return 0;
	}

	public boolean isnull(int l) {

		return newnode[l].data == null;

	}

	public void insertFirst(T data, int l) {
		if (isnull(l))
			return;

		int p = malloc();
		if (p != 0) {
			newnode[p] = new CNode<>(data, newnode[l].next);

			newnode[l].next = p;

		} else {
			System.out.println("full");
		}

	}

	public void tracverce(int n) {
		
		System.out.println();
		if (isnull(n)) {
			return;

		}

		int l = newnode[n].next;
		while (l != 0) {

			System.out.print(newnode[l].data + "-->");
			l = newnode[l].next;
		}

	}

	public void insertlast(T data, int l) {
		int p = malloc();
		if (p != 0) {

			newnode[p] = new CNode<>(data, p);
			int last = l;
			while (newnode[last].next != 0) {
				last = newnode[last].next;
			}
			newnode[p].next = newnode[last].next;
			newnode[last].next = p;

		} else {
			System.out.println("sorry the arrayis full");
		}

	}
	public void marge(int l,int m)
	{
		if(!is_Empty(l)&&!is_Empty(m))
		{
			l=newnode[l].next;
			while (newnode[l].next!=0) {
				l=newnode[l].next;
			}
			
			newnode[l].next=newnode[m].next;
			free(m);
			
			
			
			
			
		}
		
		
		
	}

	public void insert_last_rec(T data, int n) {
		int p = malloc();
		if (p != 0) {

			insert_last(data, n, p);

		}

	}
	public boolean is_Empty(int l)
	{
		if(newnode[l].next==0)
			return true;
		return false;
	}
	
	public void clear(int l)
	{
		while (!is_Empty(l)) {
			int p=newnode[l].next;
			
			newnode[l].next=newnode[p].next;
			free(p);
			
			
			
		}
		
		
//		int curr=0;
//		while (newnode[l].next!=0) {
//			int p=newnode[l].next;
//			
//			newnode[l].next=newnode[p].next;
//	free(p);
//	
//		
//	
//		
//		}
		
	}
	private void insert_last(T data, int n, int p) {

		if (newnode[n].next != 0) {
			n = newnode[n].next;
			insert_last(data, n, p);

		} else if (newnode[n].next == 0) {

			newnode[p] = new CNode<>(data, p);
			newnode[p].next = 0;
			newnode[n].next = p;
		}

	}

	public T Delet_At_last(int l) {
		if (newnode[l].next != 0) {
			int last = 0;

			while (newnode[newnode[l].next].next != 0) {

				l = newnode[l].next;
			}
			T data = newnode[newnode[l].next].data;
			free(newnode[l].next);

			newnode[l].next = 0;

			return data;

		}
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	

	public int length(int n) {
		int curr = 0;
		while (newnode[n].next != 0) {

			curr++;
			n = newnode[n].next;

		}
		return curr;

	}

	public int length_rec(int n) {

		return length_rec(n, 0);

	}

	private int length_rec(int n, int i) {

		if (newnode[n].next == 0) {
			return i;
		}
		return length_rec(newnode[n].next, ++i);

	}

	public T deletFirst(int l) {
		if (newnode[l] != null) {
			int x = newnode[l].next;
			newnode[l].next = newnode[x].next;
			T data = newnode[x].data;
			free(x);
			newnode[x].data = null;
			return data;

		}

		return null;
	}

	public void Insert_Sorting(T data, int l) {
		int p = malloc();
		if (p != 0) {
			if (newnode[l] != null) {

				newnode[p] = new CNode<>(data, 0);
				int first = newnode[l].next;

				if (newnode[first].data == null) {

					newnode[p].next = 0;

					newnode[l].next = p;

					return;

				}

				int last = first;
				if (newnode[first].data.compareTo(newnode[p].data) > 0) {

					newnode[p].next = newnode[l].next;
					newnode[l].next = p;

					return;

				}
				while (newnode[first].data.compareTo(newnode[p].data) < 0 && newnode[first].next != 0) {

					last = first;
					System.out.println(last);
					first = newnode[first].next;

				}
				if (newnode[first].next == 0 && newnode[first].data.compareTo(newnode[p].data) < 0) {

					newnode[p].next = 0;
					newnode[first].next = p;

				} else if (newnode[first].next == 0) {
					newnode[p].next = first;
					newnode[last].next = p;
					System.out.println(data);

				} else {

					newnode[p].next = first;
					newnode[last].next = p;

				}

			}
		}

	}

	public void travarce_rec(int n) {
		if (newnode[n].next == 0)
			return;
System.out.println();
		int newn = newnode[n].next;

		if (newnode[newn].next == 0) {
			System.out.println(newnode[newn].data + " -->null");

			return;
		}
		System.out.print(newnode[newn].data + " -->");
		travarce_rec(newn);

	}

	public void trvarse() {

		for (int i = 0; i < newnode.length; i++) {
			System.out.println(newnode[i]);
		}

	}
}




















/*package dfk;

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
*/
