import minimist from "minimist";

export const argv = minimist(process.argv.slice(2));

console.log("Gulp arguments:");
console.dir(argv);
