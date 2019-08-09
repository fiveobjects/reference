resultsArray = [{ 0: { parkName: "Central Park", owner: "NYC" } }, { 1: { parkName: "Patterson Park", owner: "Baltimore" } }];
amenities = { "0": "X Park, Y Park, Z Park", "1": "A Park, B park, C Park" };
[...resultsArray].forEach(token => {
    Object.keys(token).forEach(key => token[key]['amenities'] = amenities[key]);
})
console.log(resultsArray);