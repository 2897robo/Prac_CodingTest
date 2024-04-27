class Solution {
    public int solution(int n) {
        if (n < 1) return 0;  // Handle case where n is less than 1 (though per problem constraints this shouldn't happen)

        int i = 1;
        long factorial = 1;

        while (true) {
            if (factorial > n) break; // If the factorial exceeds n, stop the loop.
            i++;
            factorial *= i;
        }

        return i - 1; // Return the largest integer i such that i! <= n
    }
}
