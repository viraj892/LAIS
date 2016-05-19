# LAIS
Java implementation to find the longest almost increasing subsequence
Based on the paper :

A. Elmasry, “The longest almost-increasing subsequence,” Information Processing Letters, vol. 110, no. 16, pp. 655–658, Jul. 2010.


Steps to run (required- java set to environment variable):
1) Open terminal in the folder
2) run the command:
javac *.java
3) run command:
java RunLAS

To change run configuration
1) To change the constant value, change the value of the variable ‘c’ on line 16 of file
RunLAS.java

2) To change the size of the input, modify the value in the condition of the while loop on
line 11 of file RunLAS.java

3) To change the range of the input values, change the value of the arguments if the
function randomWithRange on line 12 of file RunLAS.java

Files generated:
Results.txt – contains the lengths and runtime count. (Every run appends an entry)
LongestAlmostIncreasingSS.txt – the longest subsequence
