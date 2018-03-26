    const z = {
        A: 2,
        B: 4,
        C: 8,
        D: 16,
        E: 32,
        F: 64,
        G: 128,
        H: 256
    }

let char = "";
let x = "125D15";

for( let i=0; i<x.length; i++ ){
    if( isNaN( x[i] )){
        char = x[i];
    }
}

let arr = x.split( char );
let num = parseInt(arr[0]) * z[char] + parseInt(arr[1]);

let answer = num/ parseInt(z[char]);

console.log( answer );
