---
layout: project
type: project
image: img/micromouse/micromouse-square.jpg
title: "FishBox Binary Search Trees"
date: 2015
published: true
labels:
  - Robotics
  - Arduino
  - C++
summary: "Developed a user-friendly menu-driven interface and improved skills in tree structures, exception handling, and class design."
---



## Project Overview:
Incorporating Binary Search Trees (BST) while creating a specialized data structure for managing fish data. The goal is to design and implement a modified BST known as the "FishBox," which keeps track of different types of I'a (fish) and their respective counts. This project not only provides a practical understanding of binary trees but also emphasizes exception handling, class design, and user interaction.

## My Role and Contributions:
As a solo project, I assumed the responsibilities of designing, coding, and testing the entire FishBox Binary Search Tree. My primary tasks and contributions included:

FishBox Driver (FishBox.java):

Implemented a user-friendly menu-driven interface for interacting with the FishBox.
Created options for adding new fish types to the tree and increasing the count of existing fish types.
Implemented the ability to release fish, decrementing their counts and removing nodes if fishCount becomes zero.
Designed the "Print FishBox" feature to display the fish types in sorted order with their respective counts.

IaNode Class (IaNode.java):

Developed the IaNode class to represent nodes within the FishBox BST.
Implemented constructors and accessors (get methods) for retrieving I'a data, fishCount, and child nodes.
Designed mutator (set methods) to increment and decrement fishCount and set child nodes.
Ensured proper exception handling within the class, preventing fishCount from becoming negative.

IaTree Class (IaTree.java):

Created the IaTree class to manage the binary search tree functionality.
Implemented constructors for initializing the tree.
Designed the add method to add new I'a types and increment counts for existing types.
Developed the get method to retrieve I'a data by name, throwing exceptions if not found.
Implemented a preliminary structure for the remove method (to be completed last, as it's more complex).
Constructed the print method to display the FishBox in sorted order by name and their respective counts.

Exception Handling:

Incorporated exception handling within the IaNode and IaTree classes, ensuring robust error management for edge cases.
This project challenged my skills in tree data structures, object-oriented design, and Java programming. It required meticulous attention to detail and thorough testing to ensure the proper functioning of the FishBox and adherence to BST principles.

## Lessons Learned:
Through this project, I gained practical experience in several critical areas of software development:

Binary Search Trees: I deepened my understanding of BSTs, including their structure, insertion, retrieval, and traversal methods.

Exception Handling: I honed my ability to implement exception handling effectively, ensuring the reliability of the program in various scenarios.

Class Design: The project emphasized the importance of designing well-structured classes and methods for maintainable and extensible code.

User Interaction: I learned to create a user-friendly interface with menu-driven options, enhancing the user experience.

Additionally, this solo project reinforced my problem-solving skills and the importance of thorough testing and debugging. It provided valuable insights into the intricacies of tree data structures and their

practical applications.



[ICS 211: FishBox Github](https://github.com/ICSatKCC/a7-fishbox-binary-search-tree-f22-jakapop1/tree/A7Sumission).
