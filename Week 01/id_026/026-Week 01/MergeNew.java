//�ϲ����鲢����
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = m + n - 1;                                   //��ʼ��ָ��λ��Ϊ�ϲ���ĵ�����ĩβλ��
        while (n > 0) {                                            //��nums2����û�����꣬ѭ������
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {            //�����nums1����û�����������£�nums1[m-1]����nums2[n-1]����1��ʵ���±꣩
                nums1[pointer--] = nums1[--m];                     //�Ƚ�nums1[--m]�����Լ�m�õ�ʵ���±꣩����ֵ��nums[pointer]��Ȼ��ָ����ǰ�ƶ�
            } else {
                nums1[pointer--] = nums2[--n];                     //���nums1������������nums1[m-1]С��nums2[n-1]����ֵnums2[--n]��nums[pointer]
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,0,0,0};
        int[] b = {2,5,6};
        int m = 3;
        int n = 3;
        Solution s = new Solution();
        s.merge(a,m,b, n);
    }

}
