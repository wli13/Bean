# Bean
#### Wenting Li, Selina Zou, Stefan Tan

### Rationality for Choice of V2
We looked for robust, clear, efficient code, prioritizing robustness over the two other characteristics. We decided to use Wenting's code with slight modifications because her code exemplifies the characteristics we were looking for and uses the methods of ArrayList to write the methods of APQ proficiently and clearly. 

### Time Complexity of Each Method
* add() O(1) - amortized constant time
* isEmpty() O(1) - constant time
* peekMin() O(n) - linear time
* removeMin() O(n) - linear time

### Heap Todo
1. toString() - comes in handy for testing purposes
2. peekMin(), isEmpty() - seems pretty straightforward and likely useful for later methods
3. minOf() - should be done fairly early since it is a helper function of later, more complicated code
4. add() - figured actually being able to add elements should come before removing them
5. minChildPos() - useful in removeMin method
6. removeMin() - what else is left?
