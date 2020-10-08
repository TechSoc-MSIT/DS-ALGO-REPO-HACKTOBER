package Dynamic_Programming;

import java.util.Scanner;

/**
 * we have board of length n, and a dice whose faces numbered from 1 to 6.
 * initailly we are at starting point of board. so we have to find the no of
 * ways to reach destination.
 * 
 * @author sahil
 *
 */
public class GetBoardPath {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(getBoardPathRecursive(0, n));
		System.out.println(getBoardPathMemoization(0, n, new int[n]));
		System.out.println(getBoardPathTabulation(n));
		System.out.println(getFibonacciTabulationSpaceEfficient(n));
		s.close();
	}

	// Recursive Approach Time Complexity O(2^n)
	private static int getBoardPathRecursive(int current, int end) {
		// base case
		if (current == end) {
			return 1;
		} else if (current > end) {
			return 0;
		}

		// recursion work
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += getBoardPathRecursive(current + dice, end);
		}
		return count;
	}

	// Memoization Approach Time Complexity O(n) and Space Complexity O(n)
	private static int getBoardPathMemoization(int current, int end, int[] storage) {
		// +ve base case
		if (current == end) {
			return 1;
		}
		// -ve base case
		else if (current > end) {
			return 0;
		}
		// reuse
		else if (storage[current] != 0) {
			return storage[current];
		}

		// recursion work
		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += getBoardPathRecursive(current + dice, end);
		}
		// store
		storage[current] = count;

		return count;
	}

	// Tabulation Approach Time Complexity O(n) and Space Complexity O(n)
	private static int getBoardPathTabulation(int end) {
		// allocate array
		int storage[] = new int[end + 6];
		// allocate base case initial values
		storage[end] = 1;

		// fill the array
		for (int i = end - 1; i >= 0; i--) {
			/*
			 * storage[i] = storage[i + 1] + storage[i + 2] + storage[i + 3] + storage[i +
			 * 4] + storage[i + 5] + storage[i + 6]; OR
			 */
			int count = 0;
			for (int dice = 1; dice <= 6; dice++) {
				count += storage[i + dice];
			}
			storage[i] = count;
		}
		// return the result
		return storage[0];

	}

	// Tabulation Approach Time Complexity O(n) and Space Complexity O(1)
	private static int getFibonacciTabulationSpaceEfficient(int end) {

		int[] storage = new int[6];
		storage[0] = 1;

		for (int slide = 1; slide <= end; slide++) {
			int sum = 0;
			for (int index = 0; index <= 5; index++) {
				sum += storage[index];
			}
			storage[5] = storage[4];
			storage[4] = storage[3];
			storage[3] = storage[2];
			storage[2] = storage[1];
			storage[1] = storage[0];
			storage[0] = sum;
		}
		return storage[0];
	}
}
