---
layout: project
type: project
image: /img/FISHBOX.jpg
title: "FishBox Binary Search Trees"
date: 2015
published: true
labels:
  - Robotics
  - Arduino
  - C++
summary: "Developed a user-friendly menu-driven interface and improved skills in tree structures, exception handling, and class design."
---


<div style="text-align: center;">
  <h1 style="font-size: 28px;">FishBox Binary Search Trees</h1>
  <img src="/img/FISHBOX.jpg" alt="FishBox Binary Search Trees" style="max-width: 400px; margin: 20px auto;" />
</div>


Developed a user-friendly menu-driven interface and improved skills in tree structures, exception handling, and class design.

## Project Overview

Incorporating Binary Search Trees (BST) while creating a specialized data structure for managing fish data. The goal is to design and implement a modified BST known as the "FishBox," which keeps track of different types of I'a (fish) and their respective counts. This project not only provides a practical understanding of binary trees but also emphasizes exception handling, class design, and user interaction.

## My Role and Contributions

As a solo project, I assumed the responsibilities of designing, coding, and testing the entire FishBox Binary Search Tree. My primary tasks and contributions included:

### FishBox Driver (FishBox.java)

- Implemented a user-friendly menu-driven interface for interacting with the FishBox.
- Created options for adding new fish types to the tree and increasing the count of existing fish types.
- Implemented the ability to release fish, decrementing their counts and removing nodes if fishCount becomes zero.
- Designed the "Print FishBox" feature to display the fish types in sorted order with their respective counts.

### IaNode Class (IaNode.java)

- Developed the IaNode class to represent nodes within the FishBox BST.
- Implemented constructors and accessors (get methods) for retrieving I'a data, fishCount, and child nodes.
- Designed mutator (set methods) to increment and decrement fishCount and set child nodes.
- Ensured proper exception handling within the class, preventing fishCount from becoming negative.

### IaTree Class (IaTree.java)

- Created the IaTree class to manage the binary search tree functionality.
- Implemented constructors for initializing the tree.
- Designed the add method to add new I'a types and increment counts for existing types.
- Developed the get method to retrieve I'a data by name, throwing exceptions if not found.

**GitHub Repository**: [FishBox Binary Search Trees Repository](https://github.com/ICSatKCC/a7-fishbox-binary-search-tree-f22-jakapop1/tree/A7Sumission)

