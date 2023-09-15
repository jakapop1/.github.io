 ---
layout: project
type: project
image: Japanese_File_Sort/Fuji.JPEG
title: "Japanese Text File Sorting"
date: 2023/09/14
published: true
labels:
  - C++
  - Sorting
summary: "Developed a C++ program to sort text files containing English-Japanese word pairs separated by tabs. The sorting prioritizes English words, with considerations for specific character exclusions and case insensitivity."
---


<div style="text-align: center;">
  <h1 style="font-size: 28px;"></h1>
  <img src="/Japanese_File_Sort/tree.jpg" alt="Japan" style="max-width: 400px; margin: 20px auto;" />
</div>



## Project Overview

In Software Development, there often comes time to sort and process large sets of data efficiently. For this little project, I created a program in which process and sorts a given textfile with specific formatting containing English words with it's Japanese counterpart separted by a tab. The instructions given provided the challenge of ignoring certain characters or patterns while sorting, like brackets or parentheses at the beginning of a line, spaces at the start, or the case of the English words. Additionally, the program should be user-friendly, allowing users to specify the filename through the command line.



## My Role and Contributions

I was solely responsible for this project. Starting with parsing the text files, I separated the English and Japanese words based on the tab character and stored them in respective variables. After processing the English word (to create the 'sort field'), I created a custom Entry class to store these pairs, which then got sorted using the overloaded < operator.
To ensure the data gets displayed correctly, I incorporated field width adjustments and left justification for the output to be in aligned columns.

## Code Snippet with comments
```
// Entry class to store three strings: the English, the Japanese, and the sort field
class Entry {
public:
    // Default constructor
    Entry() = default;

    // Setters for the class members
    void setEnglish(const string &eng) {
        english = eng;
    }

    void setJapanese(const string &jap) {
        japanese = jap;
    }

    void setSortField(const string &sort) {
        sortField = sort;
    }

    // Getters for the class members
    string getEnglish() const {
        return english;
    }

    string getJapanese() const {
        return japanese;
    }

    string getSortField() const {
        return sortField;
    }

    // Overloaded less than operator for Entry objects
    bool operator< (const Entry &e) const {
        return sortField < e.getSortField();
    }

private:
    // Class members
    string english;
    string japanese;
    string sortField;
};

// Function to process the sort field 
string processSortField(string english) {
    string sortField;
    bool skip = false;

    // Iterate through each character in the English string
    for (char c : english) {
        if (c == '(' || c == '[') skip = true;
        if (!skip && !isspace(c)) sortField += tolower(c);
        if (c == ')' || c == ']') skip = false;
    }

    return sortField;
}
```
## What I learned:

This project reinforced my understanding of file processing in C++, especially using ifstream. Creating a custom class and overloading operators provided insights into object-oriented programming. I also gained a deeper understanding of data manipulation, as specific characters needed to be disregarded during the sorting process. Additionally, aligning output so that it satisfies the instruction's requirements.

## Resources:

[MakeFile]()

[Code]()
