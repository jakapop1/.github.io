
/*This program sorts a given text file with English and Japanese translations based on English words.
*@author Jakapop Khongnawang
*@since 05/02/2023
* ICS 212: Lisa Miller
*/ 

#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <algorithm>
#include <iomanip>
#include <cctype>

using namespace std;

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

int main(int argc, char *argv[]) {
    // Check if the correct number of command line arguments are provided
    if (argc != 2) {
        cerr << "Usage: " << argv[0] << " <filename>" << endl;
        return 1;
    }

    // Open the input file
    ifstream inputFile(argv[1]);
    if (!inputFile) {
        cerr << "Error: Cannot open the file." << endl;
        return 1;
    }

    // Vector to store Entry objects
    vector<Entry> entries;
    string line;

    // Read the input file line by line
    while (getline(inputFile, line)) {
        size_t tabPos = line.find('\t');
        string english = line.substr(0, tabPos);
        string japanese = line.substr(tabPos + 1);
        string sortField = processSortField(english);

        // Create an Entry object and set its data members
        Entry entry;
        entry.setEnglish(english);
        entry.setJapanese(japanese);
        entry.setSortField(sortField);
        // Add the Entry object to the entries vector
        entries.push_back(entry);
    }

    // Close the input file
    inputFile.close();

    // Sort the vector of Entry objects
    sort(entries.begin(), entries.end());

    // Display the sorted Entry objects to the screen
    for (const Entry &entry : entries) {
        cout << setw(50) << left << entry.getEnglish() << "\t" << entry.getJapanese() << endl;
    }

    return 0;
}
