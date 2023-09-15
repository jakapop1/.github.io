---
layout: project
type: project
image: img/HASHING.jpg
title: SHA-1 
date: 2023
published: true
labels:
  - C++
  - Cryptology
  - Security
summary: "Developed a SHA-1 hashing tool in C++ capable of computing hash values for large files, promoting data security and ensuring cryptographic accuracy."
---

<!-- Add a professional header with centered title and image -->
<div style="text-align: center;">
  <img src="/img/door.png" alt="SHA-1 Hashing" style="max-width: 400px; margin: 0 auto;" />
  <h1 style="font-size: 28px; margin-top: 10px;">SHA-1</h1>
</div>

<!-- Brief project summary -->
Implemented the SHA-1 hash algorithm in C++, processing a million hashes, and emphasizing data security and algorithm integrity for the portfolio project for my ICS 212 class.

## Project Overview

SHA-1 (Secure Hash Algorithm 1) is a cryptographic hashing function that produces a 160-bit hash value, commonly used in various security applications and systems developed by the U.S. National Security in 1995. Despite vulnerabilities having been found over the years, many applications continue to rely on SHA-1. For this project, I implemented the SHA-1 alrogrithm to read files, preprocess the data, and produce to hash value by following the specifications of FIPS PUB 180-1 (Federal Information Processing Standards Publication 180-1).

## Key Features
 - **Preprocessing**: Prepares data being inputed for hashing function.
 - **Single block Haskhing**: Successfully computed the hash value for a small file (`abc.txt`) with a single block.
 - **Multi-block Hashing**:  Extended the algorithm to process larger files with multiple blocks, such as `alpha.txt` and `a.txt`.
 
## My Role and Contributions

I was responsible for designing, coding, and testing the SHA-1 hashing tool in C++. Key contributions included:

### SHA-1 Hashing Implementation

Implemented the complete SHA-1 hashing algorithm, adhering to standard specifications. Ensured efficient and accurate hashing of data read from a text file.

### Input Data Handling

Developed a the program to read and process data from a text file, maintaining data integrity.


### Testing and Validation

Conducted extensive testing through various debug statements in each function to ensure proper output in accordance to FIPS180-1-SecureHashStandard.

## Code Snippets

Below is a snippet from my code in which includes the main method calling various functions defined implementing the SHA-1 with a couple of the functions below as examples utilizing debug statements used for testing during the development phase of the project to ensure proper output in accordance to documentation.
```


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


```

## Lessons Learned

This project provided valuable insights into cryptography, algorithm implementation, and data security. Key takeaways include:

- Cryptographic Expertise: Gained a deeper understanding of cryptographic principles, especially in the context of hashing algorithms.

- Proficiency in C++: Improved programming skills in C++, particularly in handling file input/output and cryptographic operations.

- Data Integrity and Security: Emphasized the critical importance of data integrity and security in cryptographic applications.

The SHA-1 hashing tool in C++ represents a significant addition to my portfolio, showcasing my ability to create secure and efficient tools for data processing and cryptography.



## Resources

[FIPS180-1-SecureHashStandard](https://github.com/jakapop1/jakapop1.github.io/blob/5cda4fe837dd7a5dd4387843918af05bc7e26ca3/img/FIPS180-1-SecureHashStandard-3.pdf)

[a.txt](https://github.com/jakapop1/jakapop1.github.io/blob/02dc49b2ea3217db129809c8980585ccb45bdb16/img/a.txt)

[abc.txt](https://github.com/jakapop1/jakapop1.github.io/blob/02dc49b2ea3217db129809c8980585ccb45bdb16/img/abc.txt)

[alpha.txt](https://github.com/jakapop1/jakapop1.github.io/blob/02dc49b2ea3217db129809c8980585ccb45bdb16/img/alpha.txt)

[project.c](https://github.com/jakapop1/jakapop1.github.io/blob/3b6f6aafe8feb641f3364195b878e0902cf7167a/img/prj_jakapop.c)

[makefile](https://github.com/jakapop1/jakapop1.github.io/blob/3b6f6aafe8feb641f3364195b878e0902cf7167a/img/makefile.txt)
