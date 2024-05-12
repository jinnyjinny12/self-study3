package com.ohgiraffers.phone.view;

import com.ohgiraffers.phone.dto.PhoneDTO;
import com.ohgiraffers.phone.service.PhoneService;

import java.util.Scanner;

public class PhoneView {
    private static boolean state = true;
    private static PhoneService phoneService = new PhoneService();

    public static void run(){

        while (state){
            System.out.println("실행할 번호를 입력해주세요: ");
            System.out.println("1. 연락처 등록하기");
            System.out.println("2. 연락처 전체조회하기");
            System.out.println("3. 연락처 상세조회하기");
            System.out.println("4. 연락처 수정하기");
            System.out.println("5. 연락처 삭제하기");
            Scanner sc = new Scanner(System.in);
            int index = Integer.parseInt(sc.nextLine());

            switch (index){
                case1:
                PhoneInsert();
                break;
                case 2:
                    PhoneViewAll();
                    break:
                case 3:
                    PhoneFindByName();
                    break;
            }

            System.out.println("종료하시겠습니까? (yes 또는 no를 입력)");
            String result = sc.nextLine();
            if (result.equals("yes")){
                state = false;
                sc.close();
            }

        }

    }

    public static void PhoneFindByName(){
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 연락처의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        PhoneDTO emp = null; // emp 가 뭐지?

        try {
            emp = phoneService.phoneFindbyName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


    }

}

