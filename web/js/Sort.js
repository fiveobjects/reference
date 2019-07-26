var data = '[{ "category": "American", "order": 1, "vehicles": [{ "instock": "yes", "model": [{ "lang": "en-US", "title": "mustang" }] }, { "instock": "no", "model": [{ "lang": "en-US", "title": "viper" }] }, { "instock": "yes", "model": [{ "lang": "en-US", "title": "camaro" }] } ] }]';
const invenntory = JSON.parse(data);
const sortedInventory = data.sort((a, b) => {
    if (a.order < b.order) return -1;
    if (a.order > b.order) return 1;
    return 0;
});

const sortedInventory = sortedInventory.sort((a, b) => {
    if (a.order < b.order) return -1;
    if (a.order > b.order) return 1;
    return 0;
});

console.log(JSON.stringify(sortedInventory));