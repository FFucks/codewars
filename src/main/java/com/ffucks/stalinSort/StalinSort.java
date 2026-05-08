package com.ffucks.stalinSort;

/*Stalin Sort
"If there is no person, there is no problem"

Unlike conventional sorting algorithms that rearrange elements, Stalin Sort solves the problem of disorder radically: any element that violates the ascending order is shot and removed from the list.

Task
Implement the function stalin_sort / stalinSort, which accepts an array of integers and modifies it in-place, removing all elements that violate the ascending order relative to the previous surviving element.

All other elements are considered enemies of order and must be eliminated.

Rules
The first element always survives.
Each next element survives only if it is ≥ the previous survivor.
The order of the survivors is preserved.
An empty array remains unchanged.
        Optionally, print "Расстрелять!" to stdout for each eliminated element.
        Examples
[1, 2, 3, 4, 5]        →  [1, 2, 3, 4, 5]   (all loyal, no executions)
[5, 3, 1, 2, 4]        →  [5]                (4 executions)
[1, 2, 2, 3, 1, 4]     →  [1, 2, 2, 3, 4]   (1 execution)
[3, 1, 4, 1, 5, 9, 2]  →  [3, 4, 5, 9]      (3 executions)
[]                      →  []                (no one to purge)
⚠ The function does not return anything — it modifies the array directly (except for in Solidity).

► Complexity: O(n) time, O(1) space — in theory.
The real-world implementation may vary depending on
how efficiently your government handles paperwork.*/

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class StalinSort {

    public static void stalinSort(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return;
        }

        int maxSurvivor = numbers.get(0);
        Iterator<Integer> iterator = numbers.listIterator(1);

        while (iterator.hasNext()) {
            int current = iterator.next();
            if (current >= maxSurvivor) {
                maxSurvivor = current;
            } else {
                System.out.println("Расстрелять!");
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> example1 = new ArrayList<>(
                List.of(1, 2, 3, 4, 5)
        );
        List<Integer> example2 = new ArrayList<>(
                List.of(5, 3, 1, 2, 4)
        );
        List<Integer> example3 = new ArrayList<>(
                List.of(1, 2, 2, 3, 1, 4)
        );
        List<Integer> example4 = new ArrayList<>(
                List.of(3, 1, 4, 1, 5, 9, 2)
        );

        stalinSort(example1);
        stalinSort(example2);
        stalinSort(example3);
        stalinSort(example4);

        System.out.println(example1); // [1, 2, 3, 4, 5]
        System.out.println(example2); // [5]
        System.out.println(example3); // [1, 2, 2, 3, 4]
        System.out.println(example4); // [3, 4, 5, 9]
    }
}
