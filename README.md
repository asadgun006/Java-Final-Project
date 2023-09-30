# Java-Final-Project

This Final Java Project deals with user input, string manipulation, and Graphical User Interfaces (GUI). The programs asks the user for a string and performs either a 
Substitution cipher or a Shuffle cipher based on the option selected by the user. The user can select the number of substitutions they want to perform or the number of shuffles
they want to perform on a given string. There is no limit on the length or the number of ciphers. The program can either encode the given string i.e perform a cipher, or decode
a string i.e perform a reverse cipher that restores the original format of the string. Additionally, the program also counts the number of encode and decode operations performed
individually and stores it until the user terminates the program.

The processing of the program is done within the SubstitutionCipher.java and ShuffleCipher.java classes in which the constructor takes one argument for the number of manipulations
to be performed on the string. Each class provides comments on the methods used in it for encoding and decoding. Each of these classes implement two interfaces with abstract methods
for encoding and decoding. 

The main program, ASG_FinalProject.java, uses the javafx library to create a GUI for user interaction and creates instances of the SubstitutionCipher and ShuffleCipher classes
to display the user intended output. The GUI also gives the user the option to clear all output results to begin again. The comments on the main class help explain the purpose
of each block of code.
