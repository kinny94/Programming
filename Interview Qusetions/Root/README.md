# Root Coding Challenge

### Overview
Question - Process the input file with the given data and generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.

I have complete the assignment using JavaScript and Nodejs. My implementation also uses some npm modules like Mocha and Chai for testing the file. The program uses the input.txt file in the root directory. However the program is quite flexible, if you wanna try the program with some other test cases. Just add the other test file of '.txt' format to the root directory and run the command **node index.js filename**. ( Replace "filename" with name of the test file ). 

### File Structure
* node_modules ( Once the **npm install** command is executed )
* .gitignore	
* index.js	( main solution file )
* input.txt 	( Input file with provided input from the gist )
* package.json	
* package-lock.json
* README.md ( Documentation about the program )
* test.js ( A file containing all the test cases )
* utils.js ( File containing all the necessary methods )

### Excecution
Inorder to run the program, you need to make sure that Node is installed in your System. You can  install node from [here]( https://nodejs.org/en/ ). Once Node is installed on your system, you need to run the following commands.

1. npm install
2. npm test
2. npm start

* npm start will run both the test cases and the entire program.

### Though Process

To keep the program as simple as possible, I have OOPS concepts and added modularity to the program. This makes testing of the modules much easier also allows to modify the functioning of the program easily. All the important functions that I have used are in the **utils.js** file. In order to explain my thought process, I would first explain the functioning of all the functions that I have created and then how I have used those functions in the programs.

###### getAllTripData( linesInInputFile ): 
 This function takes an array of all lines in the input file and retrun an object which contains driver's name stored as *key* and an array of array of trip details as *value*. If the line is an information about a driver, it creates a new *key* with that drivers name, and if it's an information about a trip, then it add's that trip to the value array with necessary information. This function makes sure that there are no trips added to the *value* array, which has speed less than *5mph* and more than *100mph*.

* Firstly, I am checking if the user is using the provided test case in the input.txt file or if he is using his own test file using the **node index.js filename** command. Then, I am reading the entire input file and storing it in a variable data. 

* I split the data by a line break and check if each line is an information about a driver or is it a trip. I created an empty object 

