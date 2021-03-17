package chap02;

public class PrimeNumber3 {

    public static void main(String[] args) {
        int counter = 0;
        int ptr = 0;
        int[] primes = new int[500];

        primes[ptr++] = 2;
        primes[ptr++] = 3;

        for(int n = 5 ; n <= 1000 ; n += 2) {
            boolean flag = false;

            for (int i = 1 ; primes[i] * primes[i] <= n ; i++) {
                counter += 2;

                if (n % primes[i] == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                primes[ptr++] = n;
                counter++;
            }
        }

        for (int j = 0 ; j < ptr ; j++) {
            System.out.println(primes[j]);
        }

        System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
    }

}
