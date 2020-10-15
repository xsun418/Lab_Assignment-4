To implement a linked list that stores any number of elements of some type E,
we need the Node class first.

The Node class stores the data and the reference to the next Node in the list.
The end of the list is the node which has null next member.

The start of the list is the Node member called head. It is null for an empty list.

To simplify operations, our implementation stores the number of elements of
the list at the member variable called count.

There are functions to manipulate the list: add at the given position,
add to the end, remove at the given position, get data at the given position.
toString function is to show the contents of the list.

There is also a special function reverse() which reverses the list
on which it called.
