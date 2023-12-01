---
layout: essay
type: essay
title: "Design Patterns"
# All dates must be YYYY-MM-DD format!
date: 2023-11-30
published: true
labels:
  - Programming  
  - Structure
  - Learning
  - Software Development
  - Data Types
---

## Introduction

In the world of programming, design patterns refer to the blueprints of our code that we utilize in various programs. Like architects who need to choose the right plan for their building, programmers must select the appropriate design patterns for their projects to ensure that standards are being met while at the same time providing a solid structure for programmers to work from. To be more specific, design patterns refer to the blueprint for solving common problems in software design (ie providing standard vocabulary and efficient time-test solutions) while at the same time not referring to any specific programming language or platform. In essence, it is a conceptual toolkit that can be used in various programming situations.

## About Design Patterns

Design patterns in software engineering generally is divided into three main categories: Creational, Structural, and Behavioral. Each of the category serves a different purpose and helps to solve various problems in software design. 


- **Creational Patterns**: These patterns deal with object creation mechanisms, trying to create objects suitable to the situation. In example, in some situations, the basic form of object creation could result in design problems thus these design patterns solve this problem by controlling the object creation. An example of a creational pattern is the Singleton. This design pattern ensures a class has only one instance while providing a global point of access to it. The abstract factory, another design pattern, provides an interface for creating families of related objects without specifying a concrete class.  

- **Structural Patterns**: This type of design pattern refers to the usage of inheritance to compose interfaces to define ways to add functionalities to objects. An example of this pattern is Adapter, where the interface of an existing class is allowed to be used as another interface.
  
- **Behavioral Patterns**: This type of design pattern involves the usage of algorithms and the assignment of responsibilities between objects. An example of this type of pattern is called Observer, the creation of one or more dependency between objects so that when a state is changed, all dependents are notified and updated automatically.  

## Personal Experiences:   
In my journey as a software developer, even though concepts on types of design patterns are still new to me, I have used various design patterns in most if not all of my projects. In reflection, these design patterns have allowed me to create programs with a lot greater ease versus if I had to think of it on my own and design my own blueprint for how to structure my program for different situations.   

In one of my earlier projects, I was given the task of creating various data types and objects to represent the common types of Hawaiian fishes. The fishes were to be separated in categories while at the same time having common and uncommon values. As a result, my job was to encapsulate their data so that they work with my program to manipulate and utilize each data according to how they were specified. As a result, I utilized the Creational pattern Abstract Factory. Using this design pattern, I was able to use abstract data to create families of related fishes under subcategories without specifying a concrete class. In using this design pattern, I was able to work with various fishes while at the same time structuring them so that they would work as intended together without any conflicts.  

Another example of my usage with design pattern is the structural pattern Adapter. For this design pattern, in the same project as mentioned prior, I used the adapter pattern to allow the interface of existing fishes to work with other types of fishes through an adapter function that brings them in together and allow their data to be compared. I find this design pattern very useful because instead of having to create new data structures that are compatible, I can instead utilze an adapter created to incorporate different interfaces to have them work together.   

The way I like to visualize design patterns is to vision the building of the great pyramids. Even though in that era technology and resources were limited, due to the excellent designs of the Egyptians, the pyramids today remain one of the greatest structure to have been created by man. To me, design patterns are like that as they provide a strong fundamental idea that if followed can create a powerful structure in which to build upon until the final product is created as a result of various design patterns implemented for different issues. 

<div style="display: flex; justify-content: center;">
    <div style="text-align: center; margin-left: 15px;">
        <h1 style="font-size: 28px;"></h1>
        <img src="/img/pyramid.png" style="max-width: 100%; height: auto;" />
    </div>
      <div style="text-align: center; margin-left: 15px;">
        <h1 style="font-size: 28px;"></h1>
        <img src="/img/balance.png" style="max-width: 100%; height: auto;" />
    </div>
</div>


## Conclusion:   
The usage of various design patterns have allowed me to replicate already existing solutions to various programming problems. That is because these design patterns can apply to any programming language as it is essentially the blueprints utilized to create working structures that have been used and proven to work. Conversely, I think that if I were to tackle a problem without already having a design pattern in mind, the issues to be tackled would be significantly harder as you would have to think of various cases in which your own design would fail and have to continuously work through it to then result in a complete and working design. Overall, design patterns are in every parts of programming and as a result, it is pretty much impossible to learn programming without picking some up. As new and more difficult problems in software engineering arises, new design patterns are sure to arise with a way to tackle the solution. 

[Resources](https://sourcemaking.com/design_patterns)

