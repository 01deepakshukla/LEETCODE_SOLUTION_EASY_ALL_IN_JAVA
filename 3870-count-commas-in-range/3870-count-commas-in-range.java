class Solution {
    public int countCommas(int n) 
    {
        int comma = 1;
        if(n < 999) return 0;
        if(n >= 1000 && n <= 100000)
        {
        int range = (n - 1000)+1;
        comma = comma * range;
        }
      return comma;
    }
}