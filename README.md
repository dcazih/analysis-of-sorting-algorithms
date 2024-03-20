## Experimental Evaluation of Sorting Algorithms
### By Dmitri Azih

  <br/>

#### Overview of Sorting class:
+ 3 sorting algorithms
  + Insertion sort
  + Merge sort
  + QuickSort
+ Two helper methods for Merge Sort and Quicksort
  + merge()
  + partition()
+ A method to calculate the time costs of each sorting algorithm
  + Returns calculated times in milliseconds
  
  <br/> 

#### To Compile Experiment:
+ To compile the analysis you must have JRE installed.
To ensure you have java installed, follow these steps:
  + Open Command Prompt.
  + Next, type "java -version" in the Command Line window and hit Enter. It will show you the further details of Java version on your computer.
  + If there is no Java on your computer, install at: https://www.java.com/en/download/
+ Once installed, in Command Prompt, Type the command “java -jar 'pathtofile.jar' maxInputSize". 
With "pathtofile" being the exact file path of the file in question.
And "maxInputSize" being an integer representing the number of arrays you want the algorithms to sort. 
+ Hit Enter and the if the analysis will run.

Example compilation: java -jar 'Sorting Algorithms Analysis.jar' 100000
