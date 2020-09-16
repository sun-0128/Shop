package _0716;

/**
 * @author sunyong
 * @date 2020/07/16
 * @description
 */
public class Su {
    public static void main(String[] args) {
        int count =0;
        for (int i = 101; i <201 ; i++) {
            for (int j = 2; j <i ; j++) {
                if(i%j==0){
                    break;
                }else {
                    if (j==i-1){
                    count+=1;
                    System.out.println(i);
                    }
                }
            }
        }
        System.out.println(count+"个");
    }
}
