// Funciton to calculate time difference between a given start time and end time.
const calculateTime = ( startTime, endTime ) => {

    // Spliting the sting 
    let time1 = startTime.split(":");
    let time2 = endTime.split(":");
    
    // Converting into Date
    let d1 = new Date( 0, 0, 0, time1[0], time1[1] );
    let d2 = new Date( 0, 0, 0, time2[0], time2[1] );

    // Getting the difference in hours
    let diff = new Date( d2 - d1 ).getTime() / ( 60 * 1000 * 60 );
    return diff;
}

// Calculate speed given strt time, end time and  miles
const calculateSpeed = ( startTime, endTime, miles ) => {
    let speed = miles / calculateTime( startTime, endTime );
    return speed;
}

// Getting consolifate from the inputFile
const getAllTripsData = ( inputFileData ) => {

    var driversData = {};

    // Looping over the object
    for( let i=0; i<inputFileData.length; i++ ){

        // If the line starts with the word "Driver", its about a new driver 
        if( inputFileData[i].split(' ')[0] === "Driver" ){

            // Create a new key with that Driver's name and assign an empty array as its value.
            driversData[ inputFileData[i].split(' ')[1] ] = [];

        }else{
            
            // The line is about a trip. Caluculate the speed based on the start time, end time and miles provided
            let speed = calculateSpeed( inputFileData[i].split(" ")[2], inputFileData[i].split(" ")[3], inputFileData[i].split(" ")[4]);
            
            // Consider the trip, only if the speed is greate than 5 and less than 100
            if( speed > 5 && speed < 100 ){

                // Adding hours and miles in an array and adding that array to the value array of that particular driver key.
                let data = [];
                data.push( calculateTime( inputFileData[i].split(" ")[2], inputFileData[i].split(" ")[3] ));
                data.push( inputFileData[i].split(" ")[4]);
                driversData[ inputFileData[i].split(' ')[1]].push( data );
            }
        }
    }
    return driversData;
}

// Sorting an array of object
const sortingArrayOfObjects = ( object ) => {

    // Looping over all the keys in the object
    var sortable = [];
    for(var key in object )
        // If object has a key, push it to the sortable as a first index
        if( object.hasOwnProperty(key))
            sortable.push([key, object[key]]); 

    // Sorting the object, based on the miles travelled by the driver.
    sortable.sort(function(a, b){
        return a[1][0]-b[1][0]; // compare numbers
    });

    return sortable.reverse();
}

// Printing the result according to the gist.
const printResults = ( arrayOfData ) => {
    for( let i=0; i<arrayOfData.length; i++ ){
        if( arrayOfData[i][1][0] !== 0 ){
            console.log( arrayOfData[i][0] + " : " + arrayOfData[i][1][0] + " miles @ " + arrayOfData[i][1][1] + " mph");
        }else{
            console.log( arrayOfData[i][0] + " : " + arrayOfData[i][1][0] + " miles");
        }   
    }
} 

// Exporting all the modules
module.exports = {
    calculateSpeed,
    calculateTime,
    printResults,
    sortingArrayOfObjects,
    getAllTripsData
}