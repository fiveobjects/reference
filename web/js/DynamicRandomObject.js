class Slime {
    constructor() {
        console.log('Creating Slime');
    }
    printName() {
        console.log('Slime');
    }
}
class Abc {
    constructor() {
        console.log('Creating Abc');
    }
    printName() {
        console.log('Abc');
    }
}
class Xyz {
    constructor() {
        console.log('Creating Xyz');
    }
    printName() {
        console.log('Xyz');
    }
}
possibleEnemies = [Slime, Abc, Xyz];
let enemy = new possibleEnemies[Math.floor(Math.random() * possibleEnemies.length)]();
console.log("enemy: " + enemy);
enemy.printName();