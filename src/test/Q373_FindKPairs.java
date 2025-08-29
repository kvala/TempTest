import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q373_FindKPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    record T(int i, int j, int sum) {}
    List<List<Integer>> ans = new ArrayList<>();
    Queue<T> minHeap = new PriorityQueue<>(Comparator.comparingInt(T::sum));

    for (int i = 0; i < Math.min(k, nums1.length); ++i)
      minHeap.offer(new T(i, 0, nums1[i] + nums2[0]));
    while (!minHeap.isEmpty() && ans.size() < k) {
      final int i = minHeap.peek().i;
      final int j = minHeap.poll().j;
      ans.add(Arrays.asList(nums1[i], nums2[j]));
      if (j + 1 < nums2.length)
        minHeap.offer(new T(i, j + 1, nums1[i] + nums2[j + 1]));
    }

    return ans;
  }

  public List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new int[] { nums1[i] + nums2[0], i, 0 });
        }

        List<List<Integer>> res = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            int[] arr = pq.poll();
            int i = arr[1], j = arr[2];
            //Important to note we are taking i = arr[1] and j = arr[2] and checking j+1 pair one time. 
            res.add(Arrays.asList(nums1[i], nums2[j]));
            if (j + 1 < nums2.length) {
                pq.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }
        }
        return res;
    }


    public static void main(String[] args){
        Q373_FindKPairs s = new Q373_FindKPairs();
        int[] i1 = {1,7,9,11};
        int[] i2 = {2,4,6};
        System.out.println(s.kSmallestPairs2(i1, i2, 2));
    }
     
}
