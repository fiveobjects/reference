// With RegExp, case insensitive
function matchString1(str, match) {
    let result = str.match(new RegExp(match, 'ig'));
    console.log('Output: ' + result);
}
// With RegExp, case insensitive
function matchString2(str, match, para) {
    let result = str.match(new RegExp(match, para));
    console.log('Output: ' + result);
}
// Without RegExp, case sensitive
function matchString3(str, match) {
    let result = str.match(match);
    console.log('Output: ' + result);
}

matchString1('Hello Stack Overflow', 'over');
matchString2('Hello Stack Overflow', 'over', 'ig');
matchString3('Hello Stack Overflow', 'Over');