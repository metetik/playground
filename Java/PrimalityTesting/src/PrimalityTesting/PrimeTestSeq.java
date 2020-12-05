package PrimalityTesting;

public class PrimeTestSeq {
	/**
	 * only test odd divisors. even numbers can not be primes start with 3 and test
	 * with every odd number: 3, 5, 7, 9, go up to the square root of the tested
	 * number the numbers larger than the square root can not divide be sole
	 * divisors
	 */
	private static boolean isPrime(long x) {
		if (x % 2 == 0) {
			return false;
		}
		long p = 3;
		long xsqrt = (long) Math.ceil(Math.sqrt(x));
		while (p <= xsqrt) {
			if (x % p == 0) {
				return false;
			}
			p += 2;
		}
		return true;
	}

	public static void main(String[] args) {
// testOneNumber();
		testManyNumbers();
	}

	public static void testOneNumber() {
		long m = 1289237867378231L;
		System.out.println("started testing: " + m);
		long t1 = System.currentTimeMillis();
		boolean positive = isPrime(m);
		long t2 = System.currentTimeMillis();
		long duration = t2 - t1;
		if (positive) {
			System.out.println(m + " is prime");
		} else {
			System.out.println(m + " is not prime");
		}
		System.out.println("the time it takes: " + duration + " ms");
	}

	public static void testManyNumbers() {
		long m[] = { 1000000000000037L, 1000000000000091L, 1000000000000159L, 1000000000000187L };
		System.out.println("started testing: ");
		boolean positives[] = new boolean[m.length];
		long startTimes[] = new long[m.length];
		long endTimes[] = new long[m.length];
		long start = System.currentTimeMillis();
		for (int i = 0; i < m.length; i++) {
			startTimes[i] = System.currentTimeMillis();
			positives[i] = isPrime(m[i]);
			endTimes[i] = System.currentTimeMillis();
		}
		for (int i = 0; i < m.length; i++) {
			if (positives[i]) {
				System.out.println(m[i] + " is prime");
			} else {
				System.out.println(m[i] + " is not prime");
			}
			System.out.println(i + " start: " + (startTimes[i] - start));
			System.out.println(i + " start: " + (endTimes[i] - start));
		}
	}
}
/*
==OUTPUT==
started testing: 
1000000000000037 is prime
0 start: 0
0 start: 342
1000000000000091 is prime
1 start: 342
1 start: 633
1000000000000159 is prime
2 start: 633
2 start: 920
1000000000000187 is prime
3 start: 920
3 start: 1267
*/