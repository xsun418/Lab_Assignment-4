// public class representing the linked list
// which stores item of the given type E.
public class LinkedList<E>
{
    // private subclass that represents a node in a linked list
    private class Node<E>
    {
        // item to store
        private E item;
        // the next node of the list, null if there are no further nodes
        private Node<E> next;

        // constructor that stores item and makes next = null
        public Node(E item)
        {
            this.item = item;
            next = null;
        }

        // getter for the item
        public E getItem()
        {
            return item;
        }

        // getter for the next
        public Node<E> getNext()
        {
            return next;
        }

        // setter for the next
        public void setNext(Node<E> next)
        {
            this.next = next;
        }
    }

    // the starting node of the linked list, null if the list is empty.
    private Node<E> head;
    // number of elements in the list, 0 of the list is empty
    private int count;

    // default constructor for an empty list
    public LinkedList()
    {
        head = null;
        count = 0;
    }

    // the function to add the given item at the given position.
    // position = 0 means at the head of the list
    public void add(E item, int position)
    {
        if(position < 0 || position > count)
            return; // invalid position, do nothing

        // create new node to add
        Node<E> node = new Node<E>(item);

        // special case for position = 0, updating the head
        if(position == 0)
        {
            // the new node will point to the current head
            node.setNext(head);
            // and will become the new head
            head = node;

            count++;
            return;
        }

        // for position > 0
        Node<E> after = head;
        // find node to be before the new node
        for(int i=0; i<position-1; i++)
            after = after.getNext();
        Node<E> next = after.getNext();
        // the previous node will point to the new node
        after.setNext(node);
        // the new node will point to the node to which previous node pointed
        node.setNext(next);

        count++;
    }

    // special case for add function: adding to the end
    public void add(E item)
    {
        // call for the general function
        add(item,count);
    }

    // function to output the contents of the list
    public String toString()
    {
        String c = new String();
        Node<E> node = head;
        for(int i=0; i<count; i++)
        {
            c += node.getItem().toString() + "->";
            node = node.getNext();
        }

        return c + "NULL";
    }

    // returns item at the requested position, null if position is invalid
    public E get(int position)
    {
        if(position < 0 || position >= count)
            return null; // invalid position, return null

        // go to the requested position
        Node<E> node = head;
        for(int i=0; i<position; i++)
            node = node.getNext();

        // and return item stored at it
        return node.getItem();
    }

    // removes the node at the requested position and returns its item.
    // Returns null if position is invalid.
    public E remove(int position)
    {
        if(position < 0 || position >= count)
            return null;

        Node<E> node = head; // the node to remove
        Node<E> prev = null; // its previous node if any
        // go to the requested position
        for(int i=0; i<position; i++)
        {
            prev = node;
            node = node.getNext();
        }

        // if the given node is the current head, 
        if(prev == null)
            head = node.getNext(); // update the head
        else
        {
            // if not, the previous node will point to the next node
            // of the removed node
            prev.setNext(node.getNext());
        }

        count--;

        return node.getItem(); // return the item of the removed node
    }

    // reverses the current linked list
    // hardly can be public E reverse(E head)
    public E reverse()
    {
        // special case for an empty list: nothing to do
        if(count == 0)
            return null;

        // the current head to iterate the list
        Node<E> node = head;

        // remember the count and empty the current list.
        // But the item is still accessible by node variable.
        int countOld = count;
        count = 0;
        head = null;

        // go through the old list and add each node TO THE START of the current list.
        // This will maintain head and count.
        for(int i=0; i<countOld; i++)
        {
            add(node.getItem (),0);
            node = node.getNext();
        }

        return head.getItem(); // return the item of the new head
    }
}
