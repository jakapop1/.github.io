#include <stdio.h>
#include <ctype.h>
#include <string.h>

// Define the size of the Morse Code array
#define SIZE 36

// Define the Morse Code array
const char *morse[SIZE] = {
    "0 ----- ",
    "1 .---- ",
    "2 ..--- ",
    "3 ...-- ",
    "4 ....- ",
    "5 ..... ",
    "6 -.... ",
    "7 --... ",
    "8 ---.. ",
    "9 ----. ",
    "a .- ",
    "b -... ",
    "c -.-. ",
    "d -.. ",
    "e . ",
    "f ..-. ",
    "g --. ",
    "h .... ",
    "i .. ",
    "j .--- ",
    "k -.- ",
    "l .-.. ",
    "m -- ",
    "n -. ",
    "o --- ",
    "p .--. ",
    "q --.- ",
    "r .-. ",
    "s ... ",
    "t - ",
    "u ..- ",
    "v ...- ",
    "w .-- ",
    "x -..- ",
    "y -.-- ",
    "z --.. ",
};

int main(int argc, char *argv[]) {
    
    // Check if the user entered at least 1 Morse Code character code
    if (argc < 2) {
        printf("ERROR: Enter at least 1 Morse Code character code on the commandline.\n");
        return 1;
    }

    // Convert Morse Code character codes to letters or digits
    for (int i = 1; i < argc; i++) { // Start from the second commandline argument
        int j = 0;
        while (j < SIZE && strcmp(argv[i], morse[j]+1) != 0) { // Search for a matching Morse Code character code
            j++;
        }
        if (j < SIZE) { // If a matching Morse Code character code is found, print the corresponding letter or digit
            printf("%c", j < 10 ? j + '0' : j - 11 + 'a');
        }
    }
    printf("\n");
    
    return 0;
}
