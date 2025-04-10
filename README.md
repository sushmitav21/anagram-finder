## Anagram Finder
This is a simple Java program that reads words from a text file and prints out all groups of words that are anagrams of each other.

Features -
- Identifies all sets of words that are anagrams of each other.
- Ignores blank lines and trims spaces.
- Supports special Norwegian characters.

  ## Config
 - Java 17 or higher
- Any IDE (like IntelliJ) or command line tools

## Run from IntelliJ
- Open the project in IntelliJ.
- Set AnagramFinder as the main class in a run configuration.
- Run the project.
  
## Run from Terminal 
Execute commands from Project Root
-  javac -d out src/main/AnagramFinder.java
-  java -cp out:src/main/resources main.AnagramFinder 

Sample output:
Words with at least one anagram :
[bar, bra]
[hellestein, steinhelle]
....
