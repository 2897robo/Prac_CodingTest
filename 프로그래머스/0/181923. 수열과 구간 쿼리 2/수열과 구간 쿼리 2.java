class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int s = query[0];
            int e = query[1];
            int k = query[2];

            int min = 1000000;
            int count = 0;
            for(int j = s; j < e + 1; j++) {
                if(arr[j] > k) {
                    if(min > arr[j]) {
                        min = arr[j];    
                    }
                } else {
                    count++;
                }
            }

            if(count == e - s + 1) {
                answer[i] = -1;
            } else {
                answer[i] = min;    
            }
        }

        return answer;
    }
}