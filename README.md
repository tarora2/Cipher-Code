This code implements a program named Cipher that uses a scheme similar to the one given below to encode and decode files. To make it possible to decode an encoded file and recover the original file, all characters on each line, including spaces, tabs, punctuation, etc., are “shuffled.” For example, the line
Hello World!
would be encoded as
HloWrdel ol!
The user provides an input file. This application provides the encoded/decoded file in an output file.
