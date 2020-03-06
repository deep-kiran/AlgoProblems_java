/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean overlap(Interval a, Interval b){
        return (a.start<b.start && a.end <b.end)||(a.start>b.start && a.end >b.end);
    }
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval ni) {
        int k=0;
        int n =intervals.size();
        ArrayList<Interval> ans =new ArrayList<>();

        if(ni.end>intervals.get(n-1).end && ni.start <intervals.get(0).start ){
            ans.add(ni);
            return ans;
        }
        // ArrayList<Interval> ans =new ArrayList<>();
        if(ni.end <intervals.get(0).start){
            intervals.add(0,ni);
            return intervals;
        }
        if(ni.start> intervals.get(n-1).end){
            intervals.add(n,ni);
            return intervals;
        }
        for(Interval it: intervals){
            if(it.end < ni.start){
                ans.add(it);
            }else if(it.start > ni.end){
                ans.add(ni);
                ni = it;    
            }
            if(it.end <=ni.start || it.start<=ni.end){
                ni.start =Math.min(ni.start,it.start);
                ni.end =Math.max(ni.end,it.end);
            }
        }
        ans.add(ni);
        return ans;
    }
}
