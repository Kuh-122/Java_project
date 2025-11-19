import javax.swing.JFrame;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static Random random = new Random();
    static int rand;
    static int point = 10000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        JFrame frame = new JFrame("ㄹㅈㄷ 모의사설합법 도박");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        String tempStr = in.next();
        Player player = new Player(tempStr);
        int temp = 1;

        System.out.println("이름: " + player.name + " 초기값: " + point);

        out : while(temp != 0){
            temp = in.nextInt();

            if (temp == -1){
                System.out.println("쫄?");
                break out;
            }
            else if (temp > point) {
                System.out.println("배보다 배꼽이 더 크다");
                continue;
            }

            else {
                RR(temp);
                if(point <= 0){
                    System.out.println("파산");
                    break out;
                }
                System.out.println("현재 포인트: " + point);
            }
        }
    }

    static int RR(int temp) {
        rand = random.nextInt(101); // 0~100

        if(rand%2 == 0){
            System.out.printf("이게되네 +%d\n", temp);
            return point+=temp;
        }
        else {
            System.out.printf("허접ㅋ -%d\n", temp);
            return point-=temp;
        }
    }
}