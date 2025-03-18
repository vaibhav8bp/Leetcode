package org.example.Weekly._438;

public class Q3_Check_If_Digits_Are_Equal_in_String_After_Operations_II {

    public static boolean hasSameDigits(String s) {

        int firstNumber = 0;
        int secondNumber = 0;

        int i = 0;
        int j = s.length() - 2;
        int n = s.length() - 2;
        int r = 0;
        long combinations = 0;

        while (i <= j) {
            if (r == 0 || r == n) {
                combinations = 1;
            } else {
                combinations = ((n - r + 1) * combinations) / (r);
            }
            // (a*b)%10 = (a%10*b%10)%10
            System.out.println(combinations);
            long leftSum = Integer.parseInt(String.valueOf(s.charAt(i))) * combinations;
            long rightSum = 0;
            if (i != j) {
                rightSum = Integer.parseInt(String.valueOf(s.charAt(j))) * combinations;
            }
            firstNumber = (int) ((firstNumber + leftSum + rightSum) % 10);
            i++;
            j--;
            r++;
        }

        i = 1;
        j = s.length() - 1;
        r = 0;
        combinations = 0;

        while (i <= j) {
            if (r == 0 || r == n) {
                combinations = 1;
            } else {
                combinations = ((n - r + 1) * combinations) / (r);
            }
            long leftSum = Integer.parseInt(String.valueOf(s.charAt(i))) * combinations;
            long rightSum = 0;
            if (i != j) {
                rightSum = Integer.parseInt(String.valueOf(s.charAt(j))) * combinations;
            }
            secondNumber = (int) ((secondNumber + leftSum + rightSum) % 10);
            i++;
            j--;
            r++;
        }

        return firstNumber == secondNumber;
    }

    public static void main(String[] args) {
        System.out.println(hasSameDigits("0592231624769094147872173684657188897200703294938005267216462411446503861829156219072319535576812420641829052393818612564808223088017457287164641658054162725630745447817069525519932332334419147620547616694770466042602896886511919584334800700035870232001051131054312689325823141037742972919770368739704025345229155767645832001757551476678146747545125049115696550374942225377564106101511912571501955574373498220093522976726315644821852625651875323852797142600443038578290214698733157803587070635567757182482016584478248152655738183479494282486193842194987199696935390379030247550759642209074377343866146165958"));
    }
}
