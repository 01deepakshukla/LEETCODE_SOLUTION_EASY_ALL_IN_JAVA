class Solution {
    public boolean canReach(int[] arr, int start) {

        int n = arr.length;
        boolean vis[] = new boolean[n];

        return check(arr,vis,start);   
    }

    public boolean check(int[] arr, boolean[] vis, int idx){
        if(idx<0 || idx >= arr.length)return false;

        if(vis[idx])return false;

        if(arr[idx]==0)return true;

        vis[idx] = true;
        if(check(arr,vis,idx-arr[idx]) || check(arr,vis,idx+arr[idx]))return true;
        
        return false;
    }

}