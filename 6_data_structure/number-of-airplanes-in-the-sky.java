class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }

        ArrayList<Integer> start = new ArrayList<Integer>();
        ArrayList<Integer> end = new ArrayList<Integer>();
        for(int i = 0; i < airplanes.size(); i++){
            start.add(airplanes.get(i).start);
            end.add(airplanes.get(i).end);
        }

        Collections.sort(start);
        Collections.sort(end);

        int i = 0;
        int j = 0;
        int count = 0;
        int most = Integer.MIN_VALUE;
        while(i < start.size() && j < end.size()){
            if(start.get(i) < end.get(j)){
                count++;
                i++;
                most = Math.max(most, count);
            }else{
                count--;
                j++;
            }
        }
        return most;
    }
}

1) 将start和end时间分别保存在两个list中，并对两个list排序。
2) 从两个list的第一个元素开始比较，若start小于end，则天上增加一架飞机，并将start进一位，反之则天上减少一架飞机，并将end进一位。记录每次增加飞机后天上飞机数量的最大值。
3) 当start遍历完成时，返回此时最大值。

Given an interval list which are flying and landing time of the flight. How many airplanes are on the sky at most?

 Notice

If landing and flying happens at the same time, we consider landing should happen at first.

Have you met this question in a real interview? Yes
Example
For interval list

[
  [1,10],
  [2,3],
  [5,8],
  [4,7]
]
Return 3
