import org.junit.jupiter.api.Test;

class Solution {

    @Test
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya","ye","woo","ma"};


        for(String str: babbling) {
            for(String cry : word) {
                if(str.contains(cry)) {
                    answer++;
                }
            }
        }


        System.out.println(answer);
        return answer;
    }
}