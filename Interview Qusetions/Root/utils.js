const calculateTime = ( startTime, endTime ) => {
    let time1 = startTime.split(":");
    let time2 = endTime.split(":");
    
    let d1 = new Date( 0, 0, 0, time1[0], time1[1] );
    let d2 = new Date( 0, 0, 0, time2[0], time2[1] );

    let diff = new Date( d2 - d1 ).getTime() / ( 60 * 1000 * 60 );
    return diff;
}

const calculateSpeed = ( startTime, endTime, miles ) => {
    let speed = miles / calculateTime( startTime, endTime );
    return speed;
}

const sortingArrayOfObjects = ( object ) => {
    
    var sortable = [];
    for(var key in object )
        if( object.hasOwnProperty(key))
            sortable.push([key, object[key]]); 

    sortable.sort(function(a, b){
        return a[1][0]-b[1][0]; // compare numbers
    });

    return sortable.reverse();
}

const getAllTripsData = ( inputFileData ) => {

    var driversData = {};
    for( let i=0; i<inputFileData.length; i++ ){
        if( inputFileData[i].split(' ')[0] === "Driver" ){
            driversData[ inputFileData[i].split(' ')[1] ] = [];
        }else{
            //let tripDetails = allLines[i].split(' ').slice( 2 ).join(" ");
            let speed = calculateSpeed( inputFileData[i].split(" ")[2], inputFileData[i].split(" ")[3], inputFileData[i].split(" ")[4]);
            if( speed > 5 && speed < 100 ){
                let data = [];
                data.push( calculateTime( inputFileData[i].split(" ")[2], inputFileData[i].split(" ")[3] ));
                data.push( inputFileData[i].split(" ")[4]);
                driversData[ inputFileData[i].split(' ')[1]].push( data );
            }
        }
    }
    return driversData;
}

const printResults = ( arrayOfData ) => {
    for( let i=0; i<arrayOfData.length; i++ ){
        if( arrayOfData[i][1][0] !== 0 ){
            console.log( arrayOfData[i][0] + " : " + arrayOfData[i][1][0] + " miles @ " + arrayOfData[i][1][1] + " mph");
        }else{
            console.log( arrayOfData[i][0] + " : " + arrayOfData[i][1][0] + " miles");
        }   
    }
} 

module.exports = {
    calculateSpeed,
    calculateTime,
    printResults,
    sortingArrayOfObjects,
    getAllTripsData
}