const fs = require('fs');

//Reading the data from the file containing the 10, 000 numbers
const file = fs.readFileSync('../../data/quickSort.txt', 'utf-8');

//Checking if it has read all the numbers correctly
//console.log(file); // Displays the 10,000 numbers as strings in an array


//Convert them from string to integer
var finalFile = file.split('\n').map(e => {
    return parseInt(e, 10);
})

// Checking if it has converted each element of the array to an integer
//console.log(finalFile) displays the array, with the 10,000 elements converted to integers


// Initialize a counter for the comparaisons made by the quickSort algorithm
let comparisons = 0;

var x = []

// Sort them using quick sort
function quick_Sort(origArray) {

    if (origArray.length <= 1) {
        return origArray;
    } else {
        // Checking if the array has been correctly passed as an argument 
        //console.log(origArray.length); //Displays 3742 instead of 10,000
        x.push(origArray.length)
        var left = [];
        var right = [];
        var newArray = [];
        var pivot = origArray.pop();
        var length = origArray.length;
        // I have tried comparisons += length - 1; too, but i doesn't work
        comparisons += length;
        for (var i = 0; i < length; i++) {
            if (origArray[i] <= pivot) {
                left.push(origArray[i]);

            } else {
                right.push(origArray[i]);
            }
        }

        for (var i = 0; i < right.length; i++) {
            comparisons++;
            if (right[i] < pivot) {
                return right.splice(i, 0, pivot);
            }
        }



        return newArray.concat(quick_Sort(left), pivot, quick_Sort(right));
    }
}

// Display the result
finalFile = [3, 5, 7, 1, 4]
//console.log(finalFile);
const result = quick_Sort(finalFile);
// expected output: 25
console.log(x)

console.log(result);