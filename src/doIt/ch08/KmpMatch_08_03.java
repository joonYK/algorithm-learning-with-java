package doIt.ch08;

/**
 * KMP법에 의한 문자열 검색
 */
public class KmpMatch_08_03 {

    static int kmpMatch(String txt, String pat) {
        //txt 커서
        int pt = 1;
        //pat 커서
        int pp = 0;
        int[] skip = new int[pat.length() + 1];

        // 건너뛰기 표를 만든다.
        skip[pt] = 0;
        while (pt != pat.length()) {
            if (pat.charAt(pt) == pat.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }

        //검색
        pt = pp = 0;
        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }

        //pt - pp를 반환
        if (pp == pat.length())
            return pt - pp;

        //검색 실패
        return -1;
    }

    public static void main(String[] args) {
        String txt = "ZABCABXABCABDF";
        String pat = "ABCABD";

        System.out.println(kmpMatch(txt, pat));
    }
}
