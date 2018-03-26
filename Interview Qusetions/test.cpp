#include<iostream>

bool findCh( const char* s, char ch ){
    bool found;
    while( s ){
        if( *s == ch ){
            found = true;
        }

        ++s;
    }

    return( found );
}

int main(){

    
}