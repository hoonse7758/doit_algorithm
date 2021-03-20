package chap04;

import java.util.Scanner;

public class IntStackTester {

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        IntStack s = new IntStack(64);

        while (true) {
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());

            int menu = 0;
            do {
                System.out.print("(1) 푸시 (2) 팝 (3) 피크 (4) 덤프 (0) 종료 : "); menu = stdIn.nextInt();
            } while (!(0<= menu && menu <= 5));

            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : "); x = stdIn.nextInt();
                    try {
                        s.push(x);
                    } catch (IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 꽉 찼습니다.");
                    }

                    break;
                case 2:
                    try {
                        x = s.pop();
                        System.out.println("s.pop() == " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }

                    break;
                case 3:
                    try {
                        x = s.peek();
                        System.out.println("s.peek() == " + x);
                    } catch (IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }

                    break;
                case 4:
                    s.dump();
                    break;
            }


        }
    }

}
