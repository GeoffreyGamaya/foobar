package foobar;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
You need to figure out which sets of panels in any given array you can take offline to repair while still maintaining the maximum amount of power output per array,
and to do THAT,
you'll first need to figure out what the maximum output of each array actually is.

Write a function solution(xs) that takes a list of integers representing the power output levels of each panel in an array,

and returns the maximum product of some non-empty subset of those numbers.

eg:
if an array contained panels with power output levels of
[2, -3, 1, 0, -5]
then the maximum product would be found by taking the subset:
xs[0] = 2, xs[1] = -3, xs[4] = -5
giving the product 2*(-3)*(-5) = 30.

So solution([2, -3, 1, 0, -5]) will be "30".

Input:
Solution.solution({2, 0, 2, 2, 0})
Output:
    8

Input:
Solution.solution({-2, -3, 4, -5})
Output:
    60

Each array of solar panels contains at least 1 and no more than 50 panels,
And each panel will have a power output level whose absolute value is no greater than 1000
Some panels are malfunctioning so badly that they're draining energy, but you know a trick with the panels' wave stabilizer that lets you combine two Negative-output panels to produce the positive output of the multiple of their power values.

The final products may be very large, so give the solution as a string representation of the number.
 */
public class Solution {
    public static String solution(int[] xs) {

        if (xs.length < 1 || xs.length > 50) {
            return "0";
        }

        List<Integer> xsList = Arrays.stream(xs).parallel().boxed()
                .filter(power_output_level -> power_output_level >= -1000L && power_output_level <= 1000L)
                .filter(power_output_level -> power_output_level != 0)
                .collect(Collectors.toList());

        LinkedList<Integer> negativePart = xsList.parallelStream()
                .filter(powerOutputLevel -> powerOutputLevel < 0)
                .sorted()
                .collect(Collectors.toCollection(LinkedList::new));

        if ((negativePart.size() & 1) != 0) {
            negativePart.removeLast();
        }

        negativePart.addAll(xsList.parallelStream()
                .filter(powerOutputLevel -> powerOutputLevel > 1)
                .collect(Collectors.toList()));

        return negativePart.parallelStream()
                .map(BigInteger::valueOf)
                .reduce(BigInteger.valueOf(1), BigInteger::multiply)
                .toString();
    }

}