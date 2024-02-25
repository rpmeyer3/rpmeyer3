
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ContextualLinkedList<E> {
    /**
     * A reference to the Head of the list
     */
    private Node<E> head = null;
    /**
     * A reference to the end of the list.
     */
    private Node<E> tail = null;
    /**
     * the size of the list
     */
    private int size = 0;

    /**
     * Doubly linked list node structure
     * this class is declared as a static inner class
     */
    private static class Node<E> {
        private E data;
        private Node<E> next;
        private Node<E> prev;

        /**
         * Creates a new node with the null prev and next fields.
         *
         * @param dataItem the data stored
         */
        private Node(E dataItem) {
            data = dataItem;
            next = null;
            prev = null;
        }

        /**
         * Creates a new node with the prev and next fields set
         *
         * @param prev
         * @param dataItem
         * @param next
         */
        private Node(Node<E> prev, E dataItem, Node<E> next) {
            this.data = dataItem;
            this.next = next;
            this.prev = prev;
        }
    }

    /**
     * List iterator class for MyLinkedList that implements the
     * standard <code>ListIterator</code> interface.
     */
    private class MyListItr implements ListIterator<E> {
        //A reference to the next item
        private Node<E> nextNode;
        // a reference to the last item returned.
        private Node<E> lastNodeReturned;
        //this list iterator puts cursor position 0 for size;
        private int nextIndex = 0;

        private boolean isNextCalledLast;
        public MyListItr(boolean atHead) {
            lastNodeReturned = null;
            if (atHead) {
                nextNode = head;
                nextIndex = 0;
            } else {
                nextNode = null;
                nextIndex = size; // Corrected initialization for an empty list
            }
            // Also works when the list is empty
        }
        @Override
        public boolean hasNext() {
            return head != null && nextNode != null;
        }
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                lastNodeReturned = nextNode;
                nextNode = nextNode.next;
                nextIndex++;
                return lastNodeReturned.data;
            }
        }
        @Override
        public boolean hasPrevious() {
            return (nextNode == null && size != 0) || nextNode.prev != null;
        }
        @Override
        public E previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            // Decrement nextIndex when moving backwards
            nextIndex--;
            if (nextNode == null) {
                nextNode = tail;
            } else {
                nextNode = nextNode.prev;
            }
            lastNodeReturned = nextNode;
            return lastNodeReturned.data;
        }
        @Override
        public int nextIndex() {
            return (nextIndex == -1) ? -1 : nextIndex;
        }
        @Override
        public int previousIndex() {
            return (nextIndex == 0) ? -1 : nextIndex - 1;
        }
        @Override
        public void remove() {
            // Check if a next or previous operation has been called before this remove operation
            if (lastNodeReturned == null) {
                throw new IllegalStateException();
            }

            // If the node to be removed is the head of the list
            if (lastNodeReturned == head) {
                // Move the head pointer to the next node
                head = head.next;
                // If the list is not empty after removal, update the prev pointer of the new head
                if (head != null) {
                    head.prev = null;
                }
            }
            // If the node to be removed is the tail of the list
            else if (lastNodeReturned == tail) {
                // Move the tail pointer to the previous node
                tail = tail.prev;
                // If the list is not empty after removal, update the next pointer of the new tail
                if (tail != null) {
                    tail.next = null;
                }
            }
            // If the node to be removed is in the middle of the list
            else {
                // Update the next pointer of the node before the one to be removed
                lastNodeReturned.prev.next = lastNodeReturned.next;
                // Update the prev pointer of the node after the one to be removed
                lastNodeReturned.next.prev = lastNodeReturned.prev;
            }

            // Decrease the size of the list by 1 as a node has been removed
            size--;

            // If nextNode points to lastNodeReturned, move it along with lastNodeReturned
            if (nextNode == lastNodeReturned) {
                nextNode = lastNodeReturned.next;
            } else if (nextIndex > 0) {
                // Decrement nextIndex as a node has been removed before it
                nextIndex--;
            }

            // Reset lastNodeReturned as it has been removed from the list
            lastNodeReturned = null;
        }

        @Override
        public void set(E e) {
            // Check if the new element is null
            if (e == null) {
                throw new IllegalArgumentException();
            }
            // Check if the list is empty
            if (head == null) {
                throw new IllegalStateException();
            }
            // Check if the iterator has been moved
            if (lastNodeReturned == null) {
                throw new IllegalStateException();
            }

            lastNodeReturned.data = e;
        }
        @Override
        public void add(E e) {
            if (e == null) {
                throw new IllegalArgumentException();
            }
            if (isEmpty()) {
                // If the list is empty, create the first node
                head = new Node<>(e);
                tail = head;
            } else if (nextNode == head) {
                // If adding at the beginning
                Node<E> newNode = new Node<>(e);
                newNode.next = nextNode;
                nextNode.prev = newNode;
                head = newNode;
                nextIndex++;
            } else if (nextNode == null) {
                // If adding at the end
                Node<E> newNode = new Node<>(e);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
                nextIndex++;
            } else {
                // If adding in the middle
                Node<E> newNode = new Node<>(e);
                newNode.prev = nextNode.prev;
                nextNode.prev.next = newNode;
                newNode.next = nextNode;
                nextNode.prev = newNode;
            }
            size++;
            nextIndex++;
            lastNodeReturned = null;
        }
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (head == null) {
            return false; // Return false immediately if the list is empty
        }
        if (o == null) {
            for (Node<E> currentNode = head; currentNode != null; currentNode = currentNode.next) {
                if (currentNode.data == null) {
                    return true;
                }
            }
        } else {
            for (Node<E> currentNode = head; currentNode != null; currentNode = currentNode.next) {
                if (o.equals(currentNode.data)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ListIterator<E> listIterator(boolean atHead) {
        return new MyListItr(atHead);
    }
}