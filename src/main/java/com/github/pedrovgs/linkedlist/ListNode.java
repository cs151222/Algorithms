/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.linkedlist;

/**
 * Main class for linked list data structure. A linked list is a data structure consisting of a
 * group of nodes which together represent a sequence. Under the simplest form, each node is
 * composed of a data and a reference (in other words, a link) to the next node in the sequence;
 * more complex variants add additional links. This structure allows for efficient insertion or
 * removal of elements from any position in the sequence.
 *
 * 链表数据结构的主类。 链表是由一组节点组成的数据结构，这些节点共同表示一个序列。
 * 在最简单的形式下，每个节点由一个数据和一个指向序列中下一个节点的引用（换句话说，一个链接）组成；
 * 更复杂的变体会添加额外的链接。 这种结构允许从序列中的任何位置有效地插入或移除元素。
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class ListNode<T> {

  private T data;
  private ListNode<T> next;

  public ListNode(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public ListNode<T> getNext() {
    return next;
  }

  public void setNext(ListNode<T> next) {
    this.next = next;
  }

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ListNode)) return false;

    ListNode listNode = (ListNode) o;

    if (!data.equals(listNode.data)) return false;

    return true;
  }

  @Override public int hashCode() {
    return data.hashCode();
  }

  @Override public String toString() {
    return "ListNode{" + "data=" + data + ", next=" + next + '}';
  }
}
