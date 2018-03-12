const utils = require( './utils' );
const fs = require( "fs" );

let data;

// Reading the input file based on the the command
if( process.argv.slice( 2 ).length === 0 ){

    // If the input is given in the input.txt file.
    data = fs.readFileSync( 'input.txt', 'utf-8' );
}else{

    // If the input file is being passed from the command line.
    data = fs.readFileSync( process.argv[2], 'utf-8' );
};

// Spliting the input file data and storing it into an array.
let allLines = data.split('\n');

// Consolidating the data, usign the getAllTripsData() method.
let consolidatedDriverData = utils.getAllTripsData( allLines );

// Traversing the consolidated object
for( key in consolidatedDriverData ){

    let finalStats = [];

    // Storing the value ( which is an array ) of the key in a variable 
    let array = consolidatedDriverData[key];
    
    // Checking if there was trip with that driver or not
    if( array.length === 0 ){

        // There was no trip, added 0 miles and 0 mph
        consolidatedDriverData[key] = [ 0, 0 ];
    }else{

        // There were trips
        let totalTime = 0;
        let totalMiles = 0;

        // Looping over all the trip and calculating total time and total miles
        for( let i=0; i<array.length; i++ ){
            totalTime += array[i][0];
            totalMiles += parseFloat( array[i][1] );
        }

        // Calculating average speed of the trip
        let avgSpeed = totalMiles / totalTime;
        finalStats.push( Math.round( totalMiles ));
        finalStats.push( Math.round( avgSpeed ));
        consolidatedDriverData[key] = finalStats;
    }
}

// Sorting the object we received
var sortedArray = utils.sortingArrayOfObjects( consolidatedDriverData );

// Printing the results in the desired format.
utils.printResults( sortedArray );
console.log();
