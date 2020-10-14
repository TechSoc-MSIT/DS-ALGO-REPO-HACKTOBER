// program to check the number of occurrence of a character

function countString(str, letter) {
    let count = 0;

    // looping through the items
    for (let i = 0; i < str.length; i++) {

        // check if the character is at that position
        if (str.charAt(i) == letter) {
            count += 1;
        }
    }
    return count;
}

// take input from the user
let string = prompt('Enter a string: ');
let letterToCheck = prompt('Enter a letter to check: ');

//passing parameters and calling the function
let result = countString(string, letterToCheck);

// displaying the result
console.log(result);
