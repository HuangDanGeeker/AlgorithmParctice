/**
 * Created by HuangDanGeeker on 2018/10/10.
 */
public class RemoveElement27 {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int current = 0;
        for(int i = 0; i < len; i++){
            if(nums[i] == val){
                continue;
            }
            nums[current] = nums[i];
            current++;

        }
        return current;
    }

    public static void main(String[] args){
        RemoveElement27 s = new RemoveElement27();
        int result  = s.removeElement(new int[]{0,1,2,2,3,0,4,2}, 2);
    }
}
