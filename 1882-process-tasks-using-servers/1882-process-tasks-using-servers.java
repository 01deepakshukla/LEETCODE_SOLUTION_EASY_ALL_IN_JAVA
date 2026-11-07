import java.util.*;
class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a,b) -> a[0] != b[0] ? Integer.compare(a[0],b[0]) : Integer.compare(a[1],b[1]));
        PriorityQueue<long[]> busy = new PriorityQueue<>((a,b) -> a[0] != b[0] ? Long.compare(a[0],b[0]) : a[1] != b[1] ? Long.compare(a[1],b[1]) : Long.compare(a[2],b[2]));
        int n = servers.length;
        int[] ans = new int[tasks.length];
        for(int i = 0; i < n; i++) free.offer(new int[]{servers[i],i});
        long currentTime = 0;
        for(int i = 0; i < tasks.length; i++) {
            currentTime = Math.max(currentTime,i);
            while(!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                long[] s = busy.poll();
                free.offer(new int[]{(int)s[1],(int)s[2]});
            }
            if(free.isEmpty()) {
                currentTime = busy.peek()[0];
                while(!busy.isEmpty() && busy.peek()[0] <= currentTime) {
                    long[] s = busy.poll();
                    free.offer(new int[]{(int)s[1],(int)s[2]});
                }
            }
            int[] server = free.poll();
            ans[i] = server[1];
            busy.offer(new long[]{currentTime + tasks[i],server[0],server[1]});
        }
        return ans;
    }
}