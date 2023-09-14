/* Preprocessing of Secure Hash Algorithm (SHA-1)
 * @author Jakapop Khongnawang
 * @since 04/13/2023
 * ICS 212: Lisa Miller
 */
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdint.h>

#define MAX_SIZE 1048576  // Maximum size of input data in bytes
#define BLOCK_SIZE 64     // Block size in 32-bit words (64 bytes)
#define DEBUG 1           // Global debug boolean (1 for on, 0 for off)

// Function prototypes
unsigned int readFile(unsigned char buffer[]);
unsigned int calculateBlocks(unsigned int sizeOfFileInBytes);
void convertCharArrayToIntArray(unsigned char buffer[], unsigned int message[], unsigned int sizeOfFileInBytes);
void addBitCountToLastBlock(unsigned int message[], unsigned int sizeOfFileInBytes, unsigned int blockCount);
unsigned int f(unsigned int t, unsigned int B, unsigned int C, unsigned int D);
unsigned int K(unsigned int t);
void computeMessageDigest(unsigned int message[], unsigned int blockCount);

int main(int argc, char *argv[]) {
    unsigned char buffer[MAX_SIZE] = {0};  // Buffer to store the input data
    unsigned int message[MAX_SIZE / 4] = {0};  // Array to store the padded message in 32-bit words

    // Read input data and store it in buffer
    unsigned int sizeOfFileInBytes = readFile(buffer);
    // Calculate the number of 512-bit blocks needed for padding
    unsigned int blockCount = calculateBlocks(sizeOfFileInBytes);

    // Convert the input data to 32-bit words and store in the message array
    convertCharArrayToIntArray(buffer, message, sizeOfFileInBytes);
    // Add the original message length to the last block of the message array
    addBitCountToLastBlock(message, sizeOfFileInBytes, blockCount);

    // Compute the message digest using SHA-1 algorithm
    computeMessageDigest(message, blockCount);

    return 0;
}

// Reads input data from stdin and stores it in the buffer
unsigned int readFile(unsigned char buffer[]) {
    unsigned int sizeOfFileInBytes = 0;
    int c;

    // Read characters from stdin until EOF is reached
    while ((c = getchar()) != EOF) {
        // Check if the input data size exceeds the maximum size
        if (sizeOfFileInBytes >= MAX_SIZE - 1) {
            fprintf(stderr, "Error: Input file is too big.\n");
            exit(EXIT_FAILURE);
        }
        buffer[sizeOfFileInBytes++] = (unsigned char)c;
    }
    // Append the "1" bit to the end of the message
    buffer[sizeOfFileInBytes] = 0x80;

    // Debug: Print the size of the read file in bytes
    //printf("Size of Read File: %u bytes\n", sizeOfFileInBytes);

    return sizeOfFileInBytes;
}

// Calculates the number of 512-bit blocks needed for padding the message
unsigned int calculateBlocks(unsigned int sizeOfFileInBytes) {
    unsigned int blockCount = (((8 * sizeOfFileInBytes) + 1) / 512) + 1;

    // Check if an additional block is needed for the message length
    if ((((8 * sizeOfFileInBytes) + 1) % 512) > (512 - 64)) {
        blockCount += 1;
    }

    // Debug: Print the size of the file in bytes and the calculated block count
    //printf("File Size: %u bytes\n", sizeOfFileInBytes);
    //printf("Block Count: %u\n", blockCount);

    return blockCount;
}

void convertCharArrayToIntArray(unsigned char buffer[], unsigned int message[], unsigned int sizeOfFileInBytes) {
    // Loop through the buffer and convert every 4 bytes to a 32-bit word
    unsigned int i;
    for (i = 0; i <= sizeOfFileInBytes; i += 4) {
        message[i / 4] = (unsigned int)buffer[i] << 24 |
                         (unsigned int)buffer[i + 1] << 16 |
                         (unsigned int)buffer[i + 2] << 8 |
                         (unsigned int)buffer[i + 3];
    }

    // Debug print: Print the converted message array
    if (DEBUG) {
        printf("Converted Message (32-bit words):\n");
        for (i = 0; i < (sizeOfFileInBytes + 3) / 4; i++) {
            printf("%08x ", message[i]);
            if ((i + 1) % 8 == 0) {
                printf("\n");
            }
        }
        printf("\n");
    }
}

// Adds the original message length to the last block of the message array
void addBitCountToLastBlock(unsigned int message[], unsigned int sizeOfFileInBytes, unsigned int blockCount) {
    // Calculate the size of the file in bits
    uint64_t sizeOfFileInBits = (uint64_t)sizeOfFileInBytes * 8;
    // Find the index of the end of the last block
    unsigned int indexOfEndOfLastBlock = (blockCount * 16) - 1;

    // Add the original message length to the last block of the message array
    message[indexOfEndOfLastBlock - 1] = (sizeOfFileInBits >> 32) & 0xFFFFFFFF;
    message[indexOfEndOfLastBlock] = sizeOfFileInBits & 0xFFFFFFFF;

    // Debug print: Print the message array after adding the bit count
    if (DEBUG) {
        printf("Message Array after Adding Bit Count:\n");
        for (unsigned int i = 0; i < blockCount * 16; i++) {
            printf("%08x ", message[i]);
            if ((i + 1) % 8 == 0) {
                printf("\n");
            }
        }
        printf("\n");
    }
}

// Helper function f as described in the NIST document
// Represents the logical functions that are used in the main loop of the SHA-1 algorithm
unsigned int f(unsigned int t, unsigned int B, unsigned int C, unsigned int D) {
    unsigned int result;
    if (t <= 19) {
        result = (B & C) | ((~B) & D);
    } else if (t >= 20 && t <= 39) {
        result = B ^ C ^ D;
    } else if (t >= 40 && t <= 59) {
        result = (B & C) | (B & D) | (C & D);
    } else {
        result = B ^ C ^ D;
    }

    // prints the input parameters t, B, C, D and the result of the function.
    // printf("f(t: %d, B: %08X, C: %08X, D: %08X) = %08X\n", t, B, C, D, result);

    return result;
}

// Helper function K as described in the NIST document
// Provides the constant words K[t] used for each round of the main loop in the SHA-1 algorithm
unsigned int K(unsigned int t) {
    unsigned int result;
    if (t <= 19) {
        result = 0x5A827999;
    } else if (t >= 20 && t <= 39) {
        result = 0x6ED9EBA1;
    } else if (t >= 40 && t <= 59) {
        result = 0x8F1BBCDC;
    } else {
        result = 0xCA62C1D6;
    }

    // prints the input parameter t and the result of the function
    // printf("K(t: %d) = %08X\n", t, result);

    return result;
}
// Compute the message digest using SHA-1 algorithm
void computeMessageDigest(unsigned int message[], unsigned int blockCount) {
    // Initialize variables as described in the NIST document on page 11
    unsigned int H0 = 0x67452301;
    unsigned int H1 = 0xEFCDAB89;
    unsigned int H2 = 0x98BADCFE;
    unsigned int H3 = 0x10325476;
    unsigned int H4 = 0xC3D2E1F0;

    //printing according to Appendix A-C of initial values
    if (DEBUG) {
        printf("The initial hex values of {H} are\n");
        printf("    H0 = %08X\n", H0);
        printf("    H1 = %08X\n", H1);
        printf("    H2 = %08X\n", H2);
        printf("    H3 = %08X\n", H3);
        printf("    H4 = %08X\n", H4);
        printf("\nStart processing block 1. The words of block 1 are\n");
    }

    // Loop through each block and complete steps a, b, c, d, and e as described in the NIST document
    unsigned int blockNumber;  // Variable to store the block number
    
    //For each block, several operations will be performed
    for (blockNumber = 0; blockNumber < blockCount; ++blockNumber) {
        unsigned int W[80] = {0};
        unsigned int A = H0;
        unsigned int B = H1;
        unsigned int C = H2;
        unsigned int D = H3;
        unsigned int E = H4;

        // Step a: Copy block into W[0] to W[15]
	    //Initializes first 16 words in array W
        for (unsigned int t = 0; t < 16; ++t) {
            W[t] = message[blockNumber * 16 + t];

            if (DEBUG) {
                printf("    W[%2u] = %08X\n", t, W[t]);
            }
        }

        // Step b: For t = 16 to 79, expand W[t]
	    //Fills rest of array W by rotating and XORing values from first 16 words
        for (unsigned int t = 16; t < 80; ++t) {
            W[t] = (W[t - 3] ^ W[t - 8] ^ W[t - 14] ^ W[t - 16]);
            W[t] = (W[t] << 1) | (W[t] >> 31);  // Circular left shift by 1 bit

            if (DEBUG && t >= 1 && t <= 15) {
                printf("    W[%2u] = %08X\n", t, W[t]);
            }
        }

        // Step c: For t = 0 to 79, compute TEMP and update A, B, C, D, and E
	    //Main SHA-1 Computation per word in current block
        for (unsigned int t = 0; t < 80; ++t) {
            unsigned int TEMP = (A << 5) | (A >> 27);  // Circular left shift by 5 bits
            TEMP += f(t, B, C, D);
            TEMP += E;
            TEMP += W[t];
            TEMP += K(t);

            E = D;
            D = C;
            C = (B << 30) | (B >> 2);  // Circular left shift by 30 bits
            B = A;
            A = TEMP;

            if (DEBUG) {
                printf("    t=%2u: A=%08X B=%08X C=%08X D=%08X E=%08X\n", t, A, B, C, D, E);
            }
        }

    // Step d: Update H0, H1, H2, H3, and H4
	//Results are added to running total
	//Becomes inputs to next block's computation
        H0 += A;
        H1 += B;
        H2 += C;
        H3 += D;
        H4 += E;

	// Debug print: Print the block number and updated H values
        if (DEBUG) {
            printf("\nBlock %u has been processed. The values of {Hi} are:\n", blockNumber+1);
            printf("H0 = %08X + %08X = %08X\n", H0 - A, A, H0);
            printf("H1 = %08X + %08X = %08X\n", H1 - B, B, H1);
            printf("H2 = %08X + %08X = %08X\n", H2 - C, C, H2);
            printf("H3 = %08X + %08X = %08X\n", H3 - D, D, H3);
            printf("H4 = %08X + %08X = %08X\n", H4 - E, E, H4);
        }
    }

    // Step e: The message digest {H0, H1, H2, H3, H4} according to Appendix A-C
    // Final hash in hexadecimal number
    
    printf("Message Digest =");
    printf(" %08X", H0);
    printf(" %08X", H1);
    printf(" %08X", H2);
    printf(" %08X", H3);
    printf(" %08X\n", H4);
}
