const printNumbers = ( n ) => {
    if( n > 0 ){
        if( n % 3 === 0){
            printNumbers( n - 1 ); 
            console.log( "On" );
        }else if( n % 7 == 0 ){
            printNumbers( n - 1 ); 
            console.log( "Base" );
        }else{
            printNumbers( n - 1 ); 
            console.log( n );
        }
    }
}

const printPrimeNumbers = () => {
    for (var counter = 2; counter <= 100; counter++) {
        var notPrime = false;
        for (var i = 2; i <= counter; i++) {
            if (counter%i===0 && i!==counter) {
                notPrime = true;
            }
        }
        if (notPrime === false) {
            console.log(counter);
        }
    }
}

//printNumbers( 100 );
printPrimeNumbers();