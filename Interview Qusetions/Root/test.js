const assert = require( 'assert' );
const expect = require( 'chai' ).expect;
const utils = require( './utils' );
const fs = require ( 'fs' );

describe( 'Calculate Time Function ', () => {
    it( 'should return the time difference in hours between given the start time and end time strings ', () => {
        assert.equal( utils.calculateTime( "06:00", "07:00" ), 1 );
    });
});

describe( 'Calculate Speed Function ', () => {
    it( ' should return the speed given the start-time, end-time and miles travelled ', () => {
        assert.equal( utils.calculateSpeed( "06:00", "07:00", "1" ), 1 );
    });
});

describe( 'Sorting Array Of Objects Function ', () => {

    let input = {
        "Fourth": [ 5, 32 ],
        "Third": [ 20, 34 ],
        "First": [ 50, 68 ],
        "Second": [ 40, 50 ] 
    };

    it( 'should take in an object as an input and return an array as an output ', () => {
        expect( utils.sortingArrayOfObjects( input )).to.be.instanceof( Array );
    });

    it( ' should take in an object as an input and return an array of same length as that of the object ', () => {
        let sizeOfObject = Object.keys( input ).length;
        assert.equal( utils.sortingArrayOfObjects( input ).length, sizeOfObject );
    });

    it( ' should sort an object based on the first index of the array inside an array, stored as a value to a key, and return an array ', () => {

        let result = [
            [ 'First', [ 50, 68 ] ],
            [ 'Second', [ 40, 50 ] ],
            [ 'Third', [ 20, 34 ] ],
            [ 'Fourth', [ 5, 32 ]]
        ];

        assert.deepEqual( utils.sortingArrayOfObjects( input ), result );
    });
});

describe( 'Get All Trips Data Function ', () => {

    let data = fs.readFileSync( 'input.txt', 'utf-8' );
    let allLines = data.split('\n');
    let result = utils.getAllTripsData( allLines );
    
    it( ' should read the string form the file and return an object ', () => {
        
        expect( result ).to.be.instanceOf( Object );
    
    }); 

    it( ' should contain an array as a value to every key in the returned object ', () => {

        expect( result[ Object.keys( result )[ 0 ]]).to.be.instanceOf( Array );

    });

    it( ' Length of array stored in the array as value should be 2 ', () => {
        for( key in result ){
            let value = result[key];
            if( value.length > 0 ){
                for( let i=0; i<value.length; i++ ){
                    assert.equal( value[i].length, 2 );
                }
            }
        }
    });

    it( ' should not contain any trip where the average speed is less than 5 or greater than 100 ', () => {
        for( key in result ){
            let value = result[ key ];

            if( value.length > 0 ){
                for( let i=0; i<value.length; i++ ){
                    expect( value[i][1] / value[i][0] ).to.be.at.least( 5 );
                    expect( value[i][1] / value[i][0] ).to.be.at.most( 100 );
                }
            }
        }
    });
});

describe( ' Sorting An Array Of Object Function ', () => {
    
    let obj = {
        'Sam': [ 24, 42 ],
        'Rick': [54, 30 ],
        'Martin': [ 42, 35 ]
    }
    let result = utils.sortingArrayOfObjects( obj );
    it( 'should make sure that the array is sorted according to the miles travelled ', () => {
        for( let i=0; i<result.length - 1 ; i++ ){
            expect( result[i][1][0] ).to.be.greaterThan( result[i+1][1][0] );
        }
    })
});
