#include <stdio.h>
#include <stdlib.h>

void gameOfLife(int** board, int boardSize, int* boardColSize) {
    int rows = boardSize;
    int cols = *boardColSize;
    int** tempBoard = (int**)malloc(rows * sizeof(int*));
    for (int i = 0; i < rows; i++) {
        tempBoard[i] = (int*)malloc(cols * sizeof(int));
    }

    // Directions array to check all 8 neighbors (horizontal, vertical, diagonal)
    int directions[8][2] = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    // Copy the original board to the temporary board
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            tempBoard[i][j] = board[i][j];
        }
    }

    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            int liveNeighbors = 0;

            // Count live neighbors
            for (int k = 0; k < 8; k++) {
                int ni = i + directions[k][0];
                int nj = j + directions[k][1];

                if (ni >= 0 && ni < rows && nj >= 0 && nj < cols) {
                    if (tempBoard[ni][nj] == 1) {
                        liveNeighbors++;
                    }
                }
            }

            // Apply the Game of Life rules
            if (tempBoard[i][j] == 1) {
                if (liveNeighbors < 2 || liveNeighbors > 3) {
                    board[i][j] = 0; // Dies
                }
            } else {
                if (liveNeighbors == 3) {
                    board[i][j] = 1; // Becomes live
                }
            }
        }
    }

    // Free the temporary board
    for (int i = 0; i < rows; i++) {
        free(tempBoard[i]);
    }
    free(tempBoard);
}

void printBoard(int** board, int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d ", board[i][j]);
        }
        printf("\n");
    }
}

