# Mini Project #1 - Searching Shakespeare’s complete works

Algorithms and Data Structures



## Status
We used a lot of time converting the Kotlin demo code [here]() to get a somewhat working Java solution. 

Our implementation used an arrayTrie implementation, and not a linkTrie implementation. 

## How to Run

Execute the **TextExample.java** file to start the JavaFX GUI to search Shakespeare. 



## Bugs
Currently, when searching for a string in the text, we get somewhat correct search results back. With some search queries, we only get partial results, for others all results. 
We suspect that our conversion from Kotlin to Java is to blame, but we are unsure exactly where, after hours of debugging. 

As an example, when searching for the string "to be or no", we get the correct results (2 strings), but when searching for "hamlet", we only get 1 results back - here we should get multiple entries (117). We know (by debugging) that the needed information is in the suffixtrie, but were unable to code a workable, recursive method to traverse the suffixtrie.  

## Author Details
 Group: Team Wing It

Alexander Winther Hørsted-Andersen (cph-ah353@cphbusiness.dk)

Mathias Bigler (cph-mb493@cphbusiness.dk)

Stanislav Novitski (cph-sn183@cphbusiness.dk)