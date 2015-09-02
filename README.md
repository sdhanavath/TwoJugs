# TwoJugs Problem

Problem Statement:

The two jugs problem is a classic problem problem solving (computer science, mathematics and Artificial Intelligence(AI)) space.
Write a algorithmic solution which takes three parameters. The first and second parameters are water jug sizes 
and the third parameter is to a size to be measured, which is the purpose of this program.

For example: You are given a 3 liter jug and a 5 liter jug. The jugs do not have markings
to measure smaller quantities. How can you measure 4 liter of water by the
jugs?

This solution is figure out how to pour the water between two jugs to reach exactly the size of solution.
So, for example if you have
	getSolution(3,5,4);

Step0:  Initially both the jugs are empty (0,0)							
Step1:	Fill 5 Liter Jug (0,5)
Step2:	Pour 5 Liter Jug into 3 Liter Jug (3,2)
Step3:	Empty 3 Liter Jug (0,2)
Step4:  Pour 5 Liter Jug into 3 Liter Jug (2,0)
Step5:  Fill 5 Liter Jug (2,5)
Step6:  Pour 5 Liter Jug into 3 Liter Jug (3,4)

program should be able say if the problem is not resolvable.

Solution:

There are a number of ways to solve this problem, including the working
backward approach [1], the billiard approach [2, 3], the digraph approach [6],
the search approach (Breadth First Search or Depth First Search) [5, 7, 14]
and the methods of heuristics [4, 8, 10, 11, 12, 13, 15, 16], etc.

I have chosen to use Breadth First Search(BFS) to figure out the possible solution for the water jug problem, 
reason being given with a given start state, goal state and having an understanding on how to generate 
the transition states, and also the prior experience with Graph search algorithms.
The BFS is guaranteed to find any existing solution. Generally search routines like 
BFS begin with a graph and traverse until goal is discovered. In this scenario, 
where transition rules are well known and transition states dependent on initial size conditions, 
a 'blind search' is used- only a root node is given, and edge connected nodes are 'discovered' 
using prior knowledge from the problem statement (filling, unfilling, pouring water into jugs, etc).

Because all the problems are not solvable and it may lead to a not solvable state. it is very much required to determine
solvability of the problem first before proceeding with the search algorithm, and this can be quickly determined by the famous
linear Diophantine equation mx+ny=c, where m, n are sizes of water jugs and c is solution size. 
The equation mx+ny=d is only solvable if and only if GCD(m,n) is divides d, Otherwise no solution for the given input.

Technical/Development Environment:

Java 7, Junit 4, SLF4J for logging, Eclipse IDE.

How To Run:

Pre-requisites to run the program
- Make sure that you have Java 7+ on your machine
how to check for java
go to command console and t
		C:/java -version
If you do not have Java, no problem it is very simple just go here
	http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html 
Step 1:
Download twojug.zip and extract at any folder you wish

Step 2: Go to the directory where you have extracted the zip in a command prompt console

Step 3: Execute the java command
       for example if you have extracted your zip file at C:\
       
       Go to C:\twojug\java -jer twojug.jar
       
       that's it.
       
       
 










