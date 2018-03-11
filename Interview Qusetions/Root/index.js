const utils = require( './utils' );
const fs = require( "fs" );
const assert = require( 'assert' );

let data;
if( process.argv.slice( 2 ).length === 0 ){
    data = fs.readFileSync( 'input.txt', 'utf-8' );
}else{
    data = fs.readFileSync( process.argv[2], 'utf-8' );
};

let allLines = data.split('\n');
let consolidatedDriverData = utils.getAllTripsData( allLines );

for( key in consolidatedDriverData ){

    let finalStats = [];
    let array = consolidatedDriverData[key];
    
    if( array.length === 0 ){
        consolidatedDriverData[key] = [ 0, 0 ];
    }else{
        let totalTime = 0;
        let totalMiles = 0;
        for( let i=0; i<array.length; i++ ){
            totalTime += array[i][0];
            totalMiles += parseFloat( array[i][1] );
        }

        let avgSpeed = totalMiles / totalTime;
        finalStats.push( Math.round( totalMiles ));
        finalStats.push( Math.round( avgSpeed ));
        consolidatedDriverData[key] = finalStats;
    }
}
    
var sortedArray = utils.sortingArrayOfObjects( consolidatedDriverData );
utils.printResults( sortedArray );
console.log();
