package automata;

import java.util.*;

public class NFA_String_Acceptance_Checkter {
    static String[] states = {"q0", "q1", "q2"};
    static char[] alphabet = {'a', 'b'};
    static int[][][] transitions = {
        { {0, 1}, {0} },
        { {1}, {2} },    
        { {2}, {2} }     
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input: ");
        String input = sc.nextLine();

        Set<Integer> currentStates = new HashSet<>();
        currentStates.add(0); // start at q0

        for (char symbol : input.toCharArray()) {
            Set<Integer> nextStates = new HashSet<>();
            int symbolIndex = (symbol == 'a') ? 0 : 1;
            for (int state : currentStates) {
                for (int next : transitions[state][symbolIndex]) {
                    nextStates.add(next);
                }
            }
            currentStates = nextStates;
        }

        if (currentStates.contains(2))
            System.out.println("Output: Accepted");
        else
            System.out.println("Output: Rejected");

        sc.close();
    }
}


