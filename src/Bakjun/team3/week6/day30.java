package  Bakjun.team3.week6;

import java.io.*;

public class day30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        long answer = 1;

        for(int i = 0; i < input.length(); i++){
            char current = input.charAt(i);
            int count = 0;
            if(current == 'c'){
                count = 26;
            }else if(current == 'd') {
                count = 10;
            }else {
                System.out.println("c와 d만 입력해주세요");
            }
            if(i > 0 && current == input.charAt(i - 1)){
                count--;
            }

            answer = answer * count;    //누적 곱하기
        }

        // BufferedWriter는 String만 출력 가능해서 숫자를 문자열로 바꿔줘야 함 (String.valueOf)
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();


    }
}



//package Bakjun.team3.week6;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//// 2025-12-14
//public class day30 {
//    public static void main(String[] args) throws IOException {
//        // 경우의 수
//        // 1. 숫자 : 0~9 ( 10가지)
//        // 2. 문자 : a  ~ z  ( 26가지 )
//        // 번호판 4자리   c : 문자 // d 숫자 , 연속 불가
//        // 먼소리여.... 음 글쿤
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
////        String c = br.readLine();
//
//        String input = br.readLine();   // 변수 변경
//
//        long answer = 1;
//
//        /*
//            int d = Integer.parseInt(br.readLine());
//         @@ 이 문제는 c라는 변수와 d라는 변수를 따로 입력받는 게 아닙니다. ddcc 혹은
//         dcdd 처럼 알파벳으로 된 문자열 한 줄이 입력으로 들어옵니다. 그 문자열 안에 적힌
//         글자가 c인지 d인지를 판단하는거에요  -> 판단여부가 중요한가보네
//         그래서 int d = ... 이 줄은 지우시고, 문자열 하나만 받으면 됩니다
//         */
//
//        //d를 제한해야하지 않나 0~ 9 로 , c 는 a~z로
//
//
//        /*
//        그렇다면
//        먼저 if문으로 c일 때, d 일때를 구분한 후
//        c, d,는 input이니까
//        if문을 거쳐서 숫자인지 문자인지 구분한 후에 그 다음 for문으로 다음을 채워가는 방식을 쓰면 되나? 그런데 그렇게
//        하더라도 만약 4자리 중 두 번째 자리에 온다면 다시 두 번째 자리가 문자인지 숫자인지, 연속된 자리인지도 확인해야하잖아..
//
//
//        아. 알겠네 for문 안에 if를 넣어야겠네
//         */
////        for (int i = 0; i < 3; i++) {  //4자리니까 4개까지
//
//            /*
//            for (int i = 0; i < input.length(); i++) { 너가 input.length로 받았는데 나는 여기를 int i= 0; i < 3; i++
//            이렇게 했엇거든? 왜냐하면 번호판은 무조건 4자리로 고정이라고 생각했으니까
//            그런데 너가 하라는데로 input.length를 하게 된다면, 문제가 생기는 거아니야?
//            왜냐하면 c를 입력했다고 a~c라는 걸 컴퓨터가 어떻게 인식해?
//            cd라고 했다고 길이가 몇인지 어떻게 인지해?
//
//Gemini))
//        아하! Jay님이 왜 i < 3 (또는 4)로 고정하려고 하셨는지 정확히 이해했습니다! 문제의 **"최대 4글자"**라는 문구 때문에 "아, 무조건 4칸이겠구나"라고 생각하신 거죠?
//        하지만 결론부터 말씀드리면 input.length()를 써야만 정답입니다. 그 이유를 3가지 포인트로 딱 짚어 드릴게요.
//            1. "무조건 4글자"가 아닙니다! (함정 조심 🚨)
//            문제 설명을 다시 한번 자세히 보시면 이렇게 적혀 있습니다.
//            "차량 번호판의 형식은 최대 4글자이고..."
//            그리고 아래 예제 입력을 보세요.
//            예제 1: dd (2글자)
//            예제 2: cc (2글자)
//            만약 Jay님이 코드를 i < 4로 고정해버리면, dd처럼 2글자짜리 입력이 들어왔을 때 컴퓨터는 3번째, 4번째 글자를 찾으려다 "어? 없는데?" 하고 에러(IndexOutOfBounds)를 뿜고 뻗어버립니다.
//            그래서 **"입력된 길이만큼만 돌아라"**는 뜻으로 input.length()를 써야 가장 안전합니다.
//            2. 컴퓨터가 길이를 어떻게 알까요? (.length()의 마법)
//
//            Jay님 질문:
//            "cd라고 했다고 길이가 몇인지 어떻게 인지해?"
//            자바의 String(문자열)은 생각보다 똑똑한 녀석입니다. BufferedReader가 readLine()으로 "cd"라는 글자를 받아와서
//            input이라는 변수에 담는 순간, 자바는 내부적으로 글자 수를 세서 가지고 있습니다.
//            사용자가 cd 입력 → input.length()는 자동으로 2가 됩니다.
//            사용자가 ddcc 입력 → input.length()는 자동으로 4가 됩니다.
//            우리가 일일이 세지 않아도, .length()만 호출하면 "방금 들어온 글자는 2칸이야!"라고 알려주는 거죠.
//
//            3. 'c'가 'a~z'인 걸 어떻게 아냐고요?
//            Jay님 질문: "c를 입력했다고 a~c(a~z)라는 걸 컴퓨터가 어떻게 인식해?"
//            맞아요. 컴퓨터는 c가 뭔지, d가 뭔지 모릅니다. 그냥 문자 껍데기일 뿐이죠. 그래서 우리가 아까 작성한 if문이 통역사 역할을 하는 겁니다.
//            Java
//            // 컴퓨터야 잘 들어,
//            char current = input.charAt(i); // 글자 하나 꺼내봐.
//            if (current == 'c') {
//                // 그 껍데기가 'c'라고 적혀있으면,
//                // 그건 사실 수학적으로 '26가지 경우의 수'라는 뜻이야!
//                count = 26;
//            }
//            즉, 컴퓨터가 알아서 인식하는 게 아니라, Jay님이 작성하신 저 if문 덕분에 컴퓨터가 "아하! c는 26을 곱하라는 뜻이구나!"라고 알아듣게 되는 원리입니다.
//            결론 정리
//            길이: 번호판은 1글자일 수도, 4글자일 수도 있습니다. 그래서 고정된 숫자(3이나 4)를 쓰면 에러가 나니, 들어온 만큼만 도는 input.length()가 정답입니다.
//            인식: 컴퓨터는 멍청합니다. Jay님이 if(current == 'c') count = 26이라고 코드를 쳐주셨기 때문에 비로소 인식하는 겁니다.
//            이 설명이 이해가 되셨나요? 이제 input.length()를 믿고 실행해 보셔도 됩니다! 👍
//             */
//
//            for(int i = 0; i < input.length(); i++){
//                char current = input.charAt(i);
//
//                int count = 0;
//
//                // (1) 일단 형식에 따른 기본 경우의 수 설정
//                if(current == 'c'){
//                    count = 26; // 문자면 26가지
//                }else {
//                    count = 10;  // 숫자면 10가지
//                }
//                // (2) "연속된 자리"인지 확인하는 핵심 로직
//                // i > 0 : 첫 번째 글자는 앞이 없으니 비교하지 않음
//                // input.charAt(i) == input.charAt(i-1) : 현재 글자가 앞 글자와 형식이 같은지 확인
//                if(i > 0 && current == input.charAt(i - 1)){
//                     count--;
//                }
//                answer *= count;
//        }
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
