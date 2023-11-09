class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0) return new int[][]{newInterval};  // is Empty return new Interval
        int first  = newInterval[0];
        int second = newInterval[1];
        boolean isFind = false;     //If we find interval that is rigth, this will be true
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        for(int a = 0; a < n; a++){
            if(isFind){ list.add(intervals[a]); continue;}  // if we find that we don't need search
            int subF = intervals[a][0];
            int subS = intervals[a][1];

            // if first val is in array
            if(first >= subF && first <= subS){ 
                int[] priory = new int[2];
                priory[0] = subF;   //setting interval's first val is Array's first val

                for(int b = a; b < n; b++){// we looking for setting interval's last value
                    if(second >= intervals[b][0]){
                        if(intervals[b][1] >= second){// if second val is in
                            priory[1] = intervals[b][1]; list.add(priory);
                            a = b; isFind = true; break;
                        }
                    }else{// if second val isn't in
                        priory[1] = second; list.add(priory); 
                        a = b-1; isFind = true; break;
                    }
                    if(b == n-1){// if second val is most biggest value
                        priory[1] = second; list.add(priory);
                        a = b; isFind = true; break;
                    }
                }
            }
            // ----------------------------------
            // if first val smaller than first array
            else if(first < subF){
                int[] priory = new int[2];
                priory[0] = first; //setting interval's first val is our first val
                
                if(second < subF){// if whole interval isn't in first array
                    priory[1] = second; list.add(priory);
                    a --; isFind = true; continue;
                }
                else{
                    for(int b = a; b < n; b++){// we looking for setting interval's last value
                        if(second >= intervals[b][0]){
                            if(second <= intervals[b][1]){// if second val is in
                                priory[1] = intervals[b][1];
                                list.add(priory); isFind = true; a = b; break; 
                            }
                        }
                        else{
                            a = b-1; priory[1] = second;
                            list.add(priory); isFind = true; break;
                        }
                        if(b == n-1 && !isFind){
                            priory[1] = second; list.add(priory);
                            a = b; isFind = true; break;
                        }
                    }
                }
            }
            // ----------------------------------
            else{
                list.add(intervals[a]);
            }
            if(a == n-1 && !isFind) list.add(newInterval);
        }
        int l = list.size();
        int[][] ret = new int[l][2];
        for(int a = 0; a < l; a++){
            ret[a] = list.get(a);
        }
        return ret;
    }
}