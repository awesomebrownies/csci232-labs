I'll need to create a Red-Black binary tree for processing duplicate data.

The key is the array value, and the value is the array number (that it came from)

First, I'll loop through k arrays, and target a specific index. Since the arrays are sorted it'll go from lowest to highest value.
This means, it will always target the lowest values for each array, and by doing this I'll always get the smallest value, and if they line up
then I can find duplicate values between multiple arrays.

Analysis of Efficiency

N = 1,000,000 and k = 40
    elapsed time: 0.318827979 seconds

N = 1,000,000 and k = 400
    elapsed time: 0.549960973 seconds

(log 400 base 2) over (log 40 base 2) is ~1.624
0.318827979 * 1.624 = 0.51809546587
This matches up closely with the second value, so I can confirm the efficiency in O includes the multiplication of "log(k)"

N = 1,000,000 and k = 400
    elapsed time: 0.549960973 seconds

N = 10,000,000 and k = 400
    elapsed time: 4.181773946 seconds

 0.54 * 10 = 5.4, which is close to 4.18 seconds.

 The conclusion of this algorithm is that the efficiency is O (N log K)