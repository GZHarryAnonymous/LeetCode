package q_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MySolution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int index = m + n;
		if (index % 2 == 1) {
			index = (int) Math.ceil(index / 2) + 1;
			int i = 0, j = 0, tmp = 0;
			while (i < m && j < n) {
				if (nums1[i] < nums2[j]) {
					tmp++;
					if (tmp == index)
						return nums1[i];
					i++;
				} else {
					tmp++;
					if (tmp == index)
						return nums2[j];

					j++;
				}
			}
			while (i < m) {
				tmp++;
				if (tmp == index)
					return nums1[i];
				i++;
			}
			while (j < n) {
				tmp++;
				if (tmp == index)
					return nums2[j];
				j++;
			}
		} else {
			index = index / 2;

			int i = 0, j = 0, tmp = 0, tag = 0;
			double number1 = 0, number2 = 0;
			while (i < m && j < n) {
				if (nums1[i] < nums2[j]) {

					tmp++;
					if (tmp == index) {
						number1 = nums1[i];
						tag++;
					}
					if (tmp == index + 1) {
						number2 = nums1[i];
						tag++;
					}
					i++;

				} else {

					tmp++;
					if (tmp == index) {
						number1 = nums2[j];
						tag++;
					}
					if (tmp == index + 1) {
						number2 = nums2[j];
						tag++;
					}
					j++;

				}
				if (tag == 2) {
					return (number1 + number2) / 2;
				}
			}
			while (i < m) {

				tmp++;
				if (tmp == index) {
					number1 = nums1[i];
					tag++;
				}
				if (tmp == index + 1) {
					number2 = nums1[i];
					tag++;
				}
				if (tag == 2) {
					return (number1 + number2) / 2;
				}
				i++;
			}
			while (j < n) {

				tmp++;
				if (tmp == index) {
					number1 = nums2[j];
					tag++;
				}
				if (tmp == index + 1) {
					number2 = nums2[j];
					tag++;
				}
				if (tag == 2) {
					return (number1 + number2) / 2;
				}
				j++;
			}
		}
		return 0;
	}
}
/*
 * 相关说明： 基于LeetCode平台算法的一个刷题记录！ 已经共享至public repository，链接如下：
 * https://github.com/GZHarryAnonymous/LeetCode 欢迎题友们fork、push纠正相关错误、交流相关问题！
 * 个人博客：https://gzharryanonymous.github.io/ 欢迎来访！当然，如果来访还打赏就更好啦！！！ 能力有限，希望有帮到你！
 **/
