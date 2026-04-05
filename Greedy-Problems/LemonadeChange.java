class Solution {
    public boolean lemonadeChange(int[] bills) {
        int ten = 0;
        int twenty = 0;
        int five = 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five>=1){
                    ten++;
                    five--;
                }
                else return false;
            }
            else{
                if(ten>=1&&five>=1){
                    twenty++;
                    ten--;
                    five--;
                }
                else if(five>=3){
                    five=five-3;
                    twenty++;
                }
                else return false;
            }

        }
        return true;
    }
}
