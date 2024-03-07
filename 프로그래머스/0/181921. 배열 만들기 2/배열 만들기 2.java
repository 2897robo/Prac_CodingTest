class Solution {
    public int[] solution(int l, int r) {
        int[] answer = {-1};

        ArrayList1 arrayList = new ArrayList1(1);
        int count1 = 0;
        for(int i = l; i < r + 1; i++) {
            String strNum = String.valueOf(i);
            int count2 = 0;
            for(int j = 0; j < strNum.length(); j++) {
                if(strNum.charAt(j) == '0' || strNum.charAt(j) == '5') {
                    count2++;
                }
            }
            if(count2 == strNum.length()) {
                count1++;
                arrayList.add(i);
            }
        }

        if(count1 == 0) {
            return answer;
        }

        return arrayList.getArray();
    }
}

class ArrayList1 {
    private int size;
    private int[] array;
    private int index;

    public ArrayList1(int size) {
        this.size = size;
        this.array = new int[size];
        this.index = -1;
    }

    public void add(int num) {
        if(this.index == size - 1) {
            int[] copyArray = new int[size+1];
            for(int i = 0; i < size; i++) {
                copyArray[i] = array[i];
            }
            this.size++;
            this.array = copyArray;
        }
        array[++index] = num;
    }

    public int[] getArray() {
        return this.array;
    }
}