
class Solution {
    public boolean isValidSudoku(char[][] board) {

        HashSet<String> seen = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                // Ignore empty cells
                if (num == '.') {
                    continue;
                }

                // Check row
                if (!seen.add(num + " in row " + row)) {
                    return false;
                }

                // Check column
                if (!seen.add(num + " in col " + col)) {
                    return false;
                }

                // Check 3x3 box
                if (!seen.add(num + " in box " + row / 3 + "-" + col / 3)) {
                    return false;
                }
            }
        }

        return true;
    }
}