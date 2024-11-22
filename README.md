# Here, the following tasks are implemented:
Let's say there is a file with document numbers.
A document number is a string consisting of letters and numbers (without service characters).
Let this file contain each document number on a new line and no other information in the line, only the document number.
A valid document number must be 15 characters long and begin with the sequence docnum (then any sequence of letters/numbers) or contract (then any sequence of letters/numbers).
Write a program to read information from the input file - the path to the input file must be specified through the console.
The program must check the document numbers for validity.
Valid document numbers docnum should be written to one report file.
Valid contract numbers contract should be written to another report file.
Invalid document numbers should be written to another report file, but after the document numbers, information should be added about why this document is invalid (incorrect sequence of characters at the beginning / there are service characters in the document name, etc.).
