class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0 || g.length==0) return 0;
        g = sortArray(g);
        s = sortArray(s);
        int count = 0,i=0,j=0;
        while(j<s.length && i<g.length){
            if(g[i]<=s[j]){
                count++;
                i++;j++;
            }
            else j++;

        } 
        return count;
    }
    public int[] sortArray(int[] nums) {
        if(nums.length<=1) return nums;
        int mid = (nums.length/2);
        int[] left = sortArray(Arrays.copyOfRange(nums, 0 , mid));
        int[] right = sortArray(Arrays.copyOfRange(nums, mid, nums.length));
        return mergeSort(left,right);
    }
    public int[] mergeSort(int[] first, int[] second){
        int[] newArr = new int[first.length+second.length];
        int i=0;
        int j =0;
        int k=0;               
        while(i<first.length && j<second.length){

            if(first[i]>second[j]){
                newArr[k] = second[j];
                j++;
            }
            else{
                newArr[k]= first[i];
                i++;
            }
            k++;
        }
        while(i<first.length){
            newArr[k] = first[i];
            i++;
            k++;
        }
        while(j<second.length){
            newArr[k] = second[j];
            j++;
            k++;
        }
        return newArr;

    }

}
