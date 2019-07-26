function pseudoRandom(seed) {
    let value = seed;
  
    return function() {
      value = value * 16807;
      return value;
    }
  }
  
  let generator = pseudoRandom(1);
  console.log(generator()); // 16807
  console.log(generator()); // 282475249
  console.log(generator()); // 1622650073