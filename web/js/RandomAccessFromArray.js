function randomWeapon() {
    let weaponArray = ["rock", "stick", "bat", "shoe"];
    let randomValue = Math.random();
    let value = randomValue * (weaponArray.length);
    let index = Math.floor(value);
    console.log(randomValue);
    console.log(weaponArray.length);
    console.log(value);
    console.log(index);
    return (rand = weaponArray[index]);
}
console.log(randomWeapon());