package Section2_Daily.Day09;

public class Main {

    public static void main(String[] args) {
        System.out.println(compressString("aaabc"));
        System.out.println(compressString2("aaabc"));
        System.out.println(compressString("wwwggoppopppp"));
        System.out.println(compressString2("wwwggoppopppp"));
    }

    static public String compressString(String str) {
        // TODO:
        //cnt 변수, 스트링빌더,
        if(str.length() == 0) return "";
        str = str + ' ';

        StringBuilder sb = new StringBuilder();
        char[] ch = new char[str.length()];

        for (int i = 0; i < str.length(); i++) {
            ch[i] = str.charAt(i);
        }

        int cnt = 1;
        char fst = ch[0];

        for (int i = 1; i < ch.length; i++) {

            if(fst == ch[i]){
                cnt++;
            }else{
                if(cnt >= 3){
                    sb.append(cnt).append(fst);
                }
                else{
                    for (int j = 0; j < cnt; j++) {
                        sb.append(fst);
                    }

                }
                fst = ch[i];
                cnt = 1;
            }
        }

        return sb.toString();

    }

    public static String compressString2(String str) {
        if(str.length() == 0) return "";
        // 연속되는 문자를 기록하기 위한 변수를 선언하고
        // 첫 번째 문자로 초기화합니다.
        char before = str.charAt(0);
        // 동일한 문자의 반복 횟수를 저장할 변수를 선언, 초기값은 1로 할당합니다.
        int count = 1;
        // 정답으로 리턴할 문자열을 선언합니다. 초기값은 공백으로 할당합니다.
        String result = "";

        // 마지막 부분이 연속된 문자일 경우를 위해 dummy 문자 추가합니다.
        str = str + ' ';
        for (int i = 1; i < str.length(); i++) {
            // 동일한 문자가 반복될 경우
            if (before == str.charAt(i)) {
                //count를 1씩 더해줍니다.
                count++;
            } else {
                // 이전과 다른 문자일 경우,
                // 반복된 횟수가 3 이상일 경우에만 문자열을 압축합니다.
                if (count >= 3) {
                    result = result + count + before;
                } else {
                    //count의 수만큼 결과에 문자열을 저장합니다.
                    for(int j = 0; j < count; j++) {
                        result = result + before;
                    }
                    //자바 11에서 지원하는 String.repeat메소드를 활용하면 조금 더 간단하게 작성이 가능합니다.
                    //result = result + Character.toString(before).repeat(count);
                }
                before = str.charAt(i);
                count = 1;
            }
        }
        return result;
    }
}
