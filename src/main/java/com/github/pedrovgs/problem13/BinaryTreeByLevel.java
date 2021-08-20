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
package com.github.pedrovgs.problem13;

import com.github.pedrovgs.binarytree.BinaryNode;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, can you write a method to return a list of nodes by level?
 * And without any additional data structure?
 *
 * 给定一棵二叉树，你能写一个方法来按级别返回节点列表吗？
 * 没有任何额外的数据结构？
 *
 *
 * @author Pedro Vicente Gómez Sánchez.
 */
public class BinaryTreeByLevel {

  /**
   * Add implementation based on an additional data structure, one queue which implementation is a
   * LinkedList. What we are going to do is add elements of the tree to the queue and one by one
   * evaluate it adding more binary nodes to the queue if exist. The complexity order in time terms
   * is O(N) where N is the number of elements in the tree. The complexity order in space terms is
   * O(N) where N is the number of elements in the tree because we are going to store every node in
   * a queue.
   *
   * 添加基于附加数据结构的实现，一个队列，其实现是一个 LinkedList。 
   * 我们要做的是将树的元素添加到队列中，并一一评估它，如果存在，则向队列添加更多二元节点。
   * 时间方面的复杂度顺序是 O(N)，其中 N 是树中元素的数量。
   * 空间方面的复杂度顺序是 O(N)，其中 N 是树中元素的数量，因为我们要将每个节点存储在队列中。 
   *
   */
  public List<BinaryNode> getUsingQueue(BinaryNode root) {
    validateBinaryNode(root);

    List<BinaryNode> result = new LinkedList<BinaryNode>();
    Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
    queue.add(root);
    while (!queue.isEmpty()) {
      BinaryNode binaryNode = queue.remove();
      result.add(binaryNode);
      if (binaryNode.getLeft() != null) queue.add(binaryNode.getLeft());
      if (binaryNode.getRight() != null) queue.add(binaryNode.getRight());
    }
    return result;
  }

  /**
   * Slower implementation created to resolve one of the questions of problem 13, print the binary
   * tree by level without use any additional data structure for the main algorithm.
   * The complexity order in space terms is O(N) because we are using one structure to return the
   * result. The complexity order in time terms is O(N*M) where the N is the depth of the Binary
   * Tree and M is the number of elements below one level.
   *
   * To be able to implement this approach you need to know the depth of the tree before to start.
   * This approach is based on recursion and uses the level param as counter to go through the
   * binary tree.
   *
   *
   * 为解决问题 13 中的一个问题而创建的较慢的实现，逐级打印二叉树，而不使用主算法的任何额外数据结构。 
   * 空间方面的复杂度顺序是 O(N)，因为我们使用一种结构来返回结果。 
   * 时间方面的复杂度顺序是 O(N*M)，其中 N 是二叉树的深度，M 是低于一级的元素数量。 
   *
   * 为了能够实现这种方法，您需要在开始之前知道树的深度。 
   * 这种方法基于递归并使用级别参数作为计数器来遍历二叉树。 
   */
  public List<BinaryNode> getWithoutAdditionalDataStructures(BinaryNode root) {
    validateBinaryNode(root);

    List<BinaryNode> result = new LinkedList<BinaryNode>();
    int depth = getDepth(root);
    for (int i = 1; i <= depth; i++) {
      result.addAll(getNodesForLevel(root, i));
    }
    return result;
  }

  private void validateBinaryNode(BinaryNode root) {
    if (root == null) {
      throw new IllegalArgumentException("You can't use null BinaryNodes as argument.");
    }
  }

  /**
   * Calculate the Binary Tree depth based on recursion. The complexity order in space terms of
   * this algorithm is O(N) and in time terms is O(N) where N is the number of nodes in the tree.
   *
   * 基于递归计算二叉树深度。 该算法在空间方面的复杂度顺序是 O(N)，在时间方面是 O(N)，其中 N 是树中的节点数。 
   *
   */
  private int getDepth(BinaryNode root) {
    if (root == null) {
      return 0;
    } else {
      return 1 + Math.max(getDepth(root.getLeft()), getDepth(root.getRight()));
    }
  }

  private List<BinaryNode> getNodesForLevel(BinaryNode root, int level) {
    if (root == null) {
      return Collections.EMPTY_LIST;
    } else {
      List<BinaryNode> result = new LinkedList<BinaryNode>();
      StringBuilder stringBuilder = new StringBuilder();
      if (level == 1) {
        result.add(root);
      } else {
        result.addAll(getNodesForLevel(root.getLeft(), level - 1));
        result.addAll(getNodesForLevel(root.getRight(), level - 1));
      }
      return result;
    }
  }
}
