/*
 * (C) Copyright 2016 Alejandro Sanchez Acosta.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *     Alejandro Sanchez Acosta <asanchez@neurowork.net>
 */

/* 
 * Bag definition
 */
public class LinkedBag<T> implements GenericBag<T> {
  public Node<T> head;

	private int elementCount = 0;

	private class Node<T> {
		public T data;
		public Node<T> next;
	}
	/**
   *
   * Add element to the bag
   *
   */
	public void add(T value) {
		Node<T> node = new Node<T>();
		node.data = value;
		node.next = head;

		head = node;
		elementCount++;
	}

	/**
   *
   * Remove element from bag
   *
   */
	public void remove(T value) {
		Node<T> currentNode = head;

		while (currentNode != null) {
			if (currentNode.data.equals(value)) {
				currentNode.next = currentNode.next.next;
				return;
			}

			currentNode = currentNode.next;
		}
	}

	/**
   *
   * Contains element in the List
   *
   * @return true or false if the element is in the List
   */
	public boolean contains(T value) {
		Node<T> currentNode = head;

		while (currentNode != null) {
			if (currentNode.data.equals(value)) {
				return true;
			}

			currentNode = currentNode.next;
		}

		return false;
	}

	/* 
	 * Compares two lists
	 * TODO: Be improved with head. Not efficient with count.
	 */
	public boolean isEqual(GenericBag<T> other) {
		System.out.println(this.getElementCount());
		System.out.println(other.getElementCount());

		if (this.getElementCount() != other.getElementCount())
			return false;

		Node<T> currentNode = head;

		while (currentNode != null) {
			if (this.count(currentNode.data) != other.count(currentNode.data)) {
				return false;
			}

			currentNode = currentNode.next;
		}

		return true;
	}

	/* 
	 * Check if List has Duplicated Entries
	 *
	 * return @boolean
	 */
	public boolean hasDuplicatedEntries(T value) {
		int count = count(value);

		if (count > 1)
			return true;

		return false;
	}

	/**
   *
   * Count elements in the List
   *
   * @return the number of elements in the List
   */
	public int count(T value) {
		Node<T> currentNode = head;
		int count = 0;

		while (currentNode != null) {
			if (currentNode.data.equals(value)) {
				count++;	
			}

			currentNode = currentNode.next;
		}

		return count;
	}
 
	public int getElementCount() {
		return elementCount;
	}
}