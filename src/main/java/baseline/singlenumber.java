package baseline;

/**
 *
 * function：只出现一次的数字（关于异或整理）
 * create time: 2021/3/19-9:23
 *
 * @AUTHOR : JLU
 * VERSION : 1.0
 */

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

import java.util.Scanner;

/**
 * https://blog.csdn.net/qq_19272431/article/details/78564391
 * 异或运算
 * 1.快速比较两个值 a ^ b == 0
 * 2.在汇编语言中经常用于将变量置零：xor a，a；
 * 3.我们可以使用异或来使某些特定的位翻转，因为不管是0或者是1与1做异或将得到原值的相反值；
 * 4.我们使用异或来判断一个二进制数中1的数量是奇数还是偶数
 * 5.校验和恢复
 * 6.经典题目：不使用其他空间，交换两个值
 * a = a ^ b; b = a ^ b; //a ^ b ^ b = a ^ 0 = a; a = a ^ b;
 * 7.面试题：互换二进制数的奇偶位；
 * https://blog.csdn.net/qq_36852780/article/details/89521553
 */

public class singlenumber {

    public static int exclusiveOr(int[] nums){
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        //读取int数组长度
        int number = scanner.nextInt();
        //输入的序列声明
        int[] nums = new int[number];
        //逐个把控制台的数据输入至int[]数组中
        for (int i= 0;i<number;i++){
            nums[i] = scanner.nextInt();
        }
        int result = exclusiveOr(nums);
        System.out.print(result);
    }

}
