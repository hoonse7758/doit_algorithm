package chap02;


public class PrimeNumber2 {

    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] primes = new int[500];

        primes[ptr++] = 2;

        for (int n = 3 ; n <= 1000 ; n += 2) {
            int i;
            for (i = 1 ; i < ptr ; i++) {
                counter++;
                if (n % primes[i] == 0) {
                    break;
                }
            }
            if (ptr == i) {
                primes[ptr++] = n;
            }
        }

        for (int j = 0 ; j < ptr ; j++) {
            System.out.println(primes[j]);
        }

        System.out.println("나눗셈 수행 횟수 : " + counter);
    }

}
