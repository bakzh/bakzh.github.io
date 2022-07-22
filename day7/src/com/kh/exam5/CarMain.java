package com.kh.exam5;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class CarMain {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        Scanner scanner = new Scanner(System.in);

        boolean stop = false;
        do {
            System.out.println("메뉴] 1. 차량구매  후 입고 2.차고지 출고 3 .차고지 현황 4.종료");
            System.out.println("선택>>");
            String menu = scanner.nextLine();

            System.out.print("원하는 차량색상은 : ");
            String inputColor = scanner.nextLine();

            switch (menu) {
                case "1":
                    boolean flag = false;
                    int i = 0;
                    for (i = 0; i < cars.length; i++) {
                        if (cars[i] == null) {
                            cars[i] = new Car(inputColor);
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("여유 공간이 부족합니다");
                        stop = true;
                    } else {
                        System.out.println("cars[" + i + "] 번 차고지에 입고 완료!");
                        System.out.println(Arrays.toString(cars));
                    }
                    break;
                case "2": //출고
                    System.out.println("출고할 차량 색상");
                    String clorOfCar = scanner.nextLine();
                    boolean fined = false;
                    for (int j = 0; j < cars.length; j++) {
                        if (cars[j].getColor().equals(clorOfCar)) {
                            cars[j] = null;
                            fined = true;
                            break;
                        }
                    }
                    if (!fined) {
                        System.out.println("출고하고자 하는 차량이 없습니다!");
                        continue;
                    }
                    break;
                case "3": //차고지 현황
                    for (Car car : cars) {
                        if (car == null) continue;
                        System.out.println(car.getColor());
                    }
                    break;
                case "4": //종료
                    stop = true;
                    continue;
                default:
            }


        } while (!stop);
    }
}
