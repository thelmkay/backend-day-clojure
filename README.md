# backend-day

Clojure backend day.

## Setup instructions

you will need a working java environment on your machine ideally java 11+ but 8 will probably work too. javac should be accessible from the command line with a correct java home set.

Then we will need to prepare our clojure environment as we will need [Leiningen](https://leiningen.org/) the clojure build tool equivilent of maven/gradle.

```
brew install leiningen
```

then to check it works run `lein version` from the terminal and you should see an output like

```
Leiningen 2.9.10 on Java 18.0.2.1 OpenJDK 64-Bit Server VM
```

## VS Code setup

while you can use a different IDE vs code was by far the easiest to setup and get working with clojures features.

You will need to install the `calva` [plugin](https://marketplace.visualstudio.com/items?itemName=betterthantomorrow.calva) via the plugin menu in vs code or by clicking install directly on the plugin link on the website.

Once installed you will need to `jack-in` to the interactive development environment which provides you with inline evaluation and a repl with your code loaded. Do this by opening `core.clj` and right clicking and selecting `Start or connect to clojure repl` and follow through the options.

You now have a working environment and can evaluate expressions inline by placing the cursor at the end of the line and hitting `Ctrl + Enter`

## Excersise

--- Day 1: No Time for a Taxicab ---
Part 1
Euan's car uses a very high-precision clock to guide its movements, and the clock's oscillator is regulated by stars. Unfortunately, the stars have been stolen... by the BJSS. To save xDesign, Euan needs you to retrieve all the missing stars.

Collect stars by solving puzzles. Each puzzle grants one star. Good luck!

You're airdropped near BJSS headquarters in a city somewhere. "Near", unfortunately, is as close as you can get - the instructions on the BJSS Recruiting Document that Ben Kurk intercepted start here, and nobody had time to work them out further.

The Document indicates that you should start at the given coordinates (where you just landed) and face North. Then, follow the provided sequence: either turn left (L) or right (R) 90 degrees, then walk forward the given number of blocks, ending at a new intersection.

There's no time to follow such ridiculous instructions on foot, though, so you take a moment and work out the destination. Given that you can only walk on the street grid of the city, how far is the shortest path to the destination?

For example:

Following R2, L3 leaves you 2 blocks East and 3 blocks North, or 5 blocks away. R2, R2, R2 leaves you 2 blocks due South of your starting position, which is 2 blocks away. R5, L5, R5, R3 leaves you 12 blocks away. How many blocks away is BJSS HQ?

- Part 2
Then, you notice the instructions continue on the back of the Recruiting Document. BJSS is actually at the first location you visit twice.

For example, if your instructions are R8, R4, R4, R8, the first location you visit twice is 4 blocks away, due East.

How many blocks away is the first location you visit twice?