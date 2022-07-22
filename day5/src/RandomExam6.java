import java.util.Arrays;
import java.util.Scanner;

/*
    로또 프로그램 구현하기
    : 1~45번호 중 중복되지 않는 6자리 추출하기
    Math.random() : 0 <= ? < 1 사이의 랜덤한 실수발생
     중복 체크 로지은 별도의 메소드를 사용하여 구현할 것.

*/
public class RandomExam6 {
    public static void main(String[] args) {
        Util util = new Util();
//        String name = new String("홍길동");
//        Scanner scanner = new Scanner(System.in);

        int[] lotto = new int[6];

        int count = 0; // for문 반복횟수 카운트
        boolean stop = false;

        while (!stop) {
            int num = (int) (Math.floor(Math.random() * 45) + 1);

            //동일 번호가 존재하면 번호를 다시 생성
            if (util.isExist(lotto, num)) {

                continue;
            //동일 번호가 존재하면 번호를 다시 생성
            } else{
                lotto[count++] = num;
            }

            //로또 번호 6개가 모두 추출되면 무한루프를 빠져나온다
            if (count == lotto.length) {
                stop = true;
            }

        }
        for (int i = 0; i < lotto.length; i++) {
            Util.printLine('-', 3);
            System.out.println(lotto[i]);
        }
//       System.out.println("for문 반복횟수:" + count);
//        System.out.println(Arrays.toString(lotto));
    }
}

