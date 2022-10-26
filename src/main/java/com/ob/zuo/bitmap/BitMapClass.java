package com.ob.zuo.bitmap;

/**
 * BitMap
 *
 * @Description: 位运算：如果使用long数组，一共8个字节，每个字节8个bit，用每个bit上的0或者1来表示要查找的数是否存在
 * 一个long，64个bit，可以判断64个值是否存在
 * @CreateDate: 2022/9/4 10:15
 * @Version: 1.0
 * @Author: oubin
 */
public class BitMapClass {

    public static class BitMap {
        private final long[] bits;

        /**
         * (max + 64) >> 6 : 决定需要多大的数组，>> 6 表示64取模
         * max = 63，value = 1
         * max = 120，value = 2
         * @param max
         */
        public BitMap(int max) {
            bits = new long[(max + 64) >> 6];
        }

        /**
         * 注意点：
         * 1.这里要使用1L，如果使用1，默认是int，int只有32位，如果左移超过32位会报错
         * 2. num >> 6 : 判断这个数落在的数组下标，如果num = 124，则落在下标1的数组上
         * 3.num & 63 : 相当于num对64取余
         * 4. 1L << num & 63 : 定位到具体的bit下标
         * 63 11111111
         * 如果num = 100，高位抹去，低位做或运算
         * 5. 1L << (num & 63) : 结果 0000010000000000，就是1右移这么多位，其他位全是0
         * 6.再和 bits[num >> 6] 做个或运算，相当于bits[num >> 6] 在该位上的值被设置为1
         * @param num
         */
        public void add(int num) {
            bits[num >> 6] |= (1L << (num & 63));
        }

        /**
         * ~(1L << (num & 63)) : 取反，相当于111101111111
         * &= 再做与运算，相当于这个下标被设置为0，其他保持不变
         * @param num
         */
        public void delete(int num) {
            bits[num >> 6] &= ~(1L << (num & 63));
        }

        /**
         * bits[num >> 6] 定位到数组下标
         * (1L << (num & 63))) 定位到在long中具体的某个bit上
         * 同时满足不为0
         * @param num
         * @return
         */
        public boolean contains(int num) {
            return (bits[num >> 6] & (1L << (num & 63))) != 0;
        }
    }

    public static void main(String[] args) {
        BitMap bitMap = new BitMap(300);
        bitMap.add(12);
        bitMap.add(2);
        bitMap.delete(2);
        for (int i = 0; i < bitMap.bits.length; i++) {
            System.out.println(bitMap.bits[i]);

        }
    }
}
