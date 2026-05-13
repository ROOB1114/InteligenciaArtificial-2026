package puzzle8.start;

import java.util.ArrayList;
import java.util.List;

// Utility class to perform some operations on a node.
public class NodeUtil {

    /**
     * Generates all valid successor states for the 8-puzzle game.
     * 
     * The empty position (0) can swap with adjacent positions based on grid layout.
     * Uses an adjacency map to determine valid moves for each position.
     * 
     * @param state a 9-character string representing puzzle positions (0-8 left-to-right, top-to-bottom).
     *              Character '0' represents the empty space.
     * @return a list of all possible successor states reachable in one move
     * 
     * Example with state "023814765":
     *   Grid layout:      |0|2|3|
     *                     |8|1|4|
     *                     |7|6|5|
     *   
     *   Valid moves (swapping 0 with adjacent positions):
     *                     |2|0|3|    |8|2|3|
     *                     |8|1|4|    |0|1|4|
     *                     |7|6|5|    |7|6|5|
     *   
     *   Return: ["203814765", "823014765"]
     */
    public static List<String> getSuccessors(String state) {
        List<String> successors = new ArrayList<>();
        int zeroPos = state.indexOf("0");
        
        // Adjacency map: for each position, which positions can it swap with
        int[][] adjacentPositions = {
            {1, 3},           // pos 0: can swap with right(1), down(3)
            {0, 2, 4},        // pos 1: can swap with left(0), right(2), down(4)
            {1, 5},           // pos 2: can swap with left(1), down(5)
            {0, 4, 6},        // pos 3: can swap with up(0), right(4), down(6)
            {1, 3, 5, 7},     // pos 4: can swap with up(1), left(3), right(5), down(7)
            {2, 4, 8},        // pos 5: can swap with up(2), left(4), down(8)
            {3, 7},           // pos 6: can swap with up(3), right(7)
            {4, 6, 8},        // pos 7: can swap with up(4), left(6), right(8)
            {5, 7}            // pos 8: can swap with up(5), left(7)
        };
        
        for (int adjPos : adjacentPositions[zeroPos]) {
            successors.add(swapPositions(state, zeroPos, adjPos));
        }
        
        return successors;
    }
    
    /**
     * Swaps characters at two positions in a string.
     * @param state the original string
     * @param pos1 first position
     * @param pos2 second position
     * @return new string with swapped positions
     */
    private static String swapPositions(String state, int pos1, int pos2) {
        char[] arr = state.toCharArray();
        char temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
        return new String(arr);
    }
}



