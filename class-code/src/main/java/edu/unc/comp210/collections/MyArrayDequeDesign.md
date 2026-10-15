# MyArrayDeque Design Document

## What is it?
A double-ended queue (deque, pronounced "deck") stored in a circular array. You can add and remove at both ends,
so one class works as a stack and as a queue. Both share the front: push adds there, pop and poll remove from there,
and offer adds at the back.

## Fields
E[] data - the underlying circular array
int front - array index of the first element
int size - number of elements in the deque

The deque does not store the back. You compute it from front and size.

## Invariants
1. 0 <= size <= data.length. A full array is allowed: the add methods grow the array before they write, so the array
   can stay full until the next add.
2. 0 <= front < data.length, even when the deque is empty.
3. Logical position i (0 <= i < size) maps to data[(front + i) % data.length].
4. Every slot outside those size positions holds null, so the deque keeps no references to removed elements.

## Constructor
public MyArrayDeque(){
    this.data = (E[]) new Object[INITIAL_CAPACITY]; // capacity 10
    this.front = 0;
    this.size = 0;
}

## Methods

Private deque operations:
index(i)
addFirst(e)
addLast(e)
removeFirst()
removeLast()
grow()

Public methods from the interfaces:
MyCollection: size(), add(e), remove(e), contains(e)
MyWorklist: remove(), peek()
MyStack: push(e), pop()
MyQueue: offer(e), poll()

## Running Times
Add at either end: O(1) amortized. grow() copies the array in O(n), but it runs only when the array is full.
Remove at either end: O(1)
contains(e), remove(e): O(n)

## Testing
*another time*