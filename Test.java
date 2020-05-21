链接：https://www.nowcoder.com/questionTerminal/571cfbe764824f03b5c0bfd2eb0a8ddf?toCommentId=388087
来源：牛客网

小青蛙有一天不小心落入了一个地下迷宫,小青蛙希望用自己仅剩的体力值P跳出这个地下迷宫。为了让问题简单,假设这是一个n*m的格子迷宫,迷宫每个位置为0或者1,
0代表这个位置有障碍物,小青蛙达到不了这个位置;1代表小青蛙可以达到的位置。小青蛙初始在(0,0)位置,地下迷宫的出口在(0,m-1)(保证这两个位置都是1,并且保证
一定有起点到终点可达的路径),小青蛙在迷宫中水平移动一个单位距离需要消耗1点体力值,向上爬一个单位距离需要消耗3个单位的体力值,向下移动不消耗体力值,当小
青蛙的体力值等于0的时候还没有到达出口,小青蛙将无法逃离迷宫。现在需要你帮助小青蛙计算出能否用仅剩的体力值跳出迷宫(即达到(0,m-1)位置)。

import java.util.*;
public class Main{
    private static int n;
    private static int m;
    private static String res;
    private static boolean isArrive;
    private static int maxEnergy;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            n=sc.nextInt();
            m=sc.nextInt();
            int p=sc.nextInt();
            int[][] grid=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            back(grid,0,0,p,new ArrayList<>());
            if(isArrive){
                System.out.println(res);
            }else{
                System.out.println("Can not escape!");
            }
        }
    }
    
    private static void back(int[][] grid,int x,int y,int energy,List<String> list){
        if(x<0||y<0||x>=n||y>=m||energy<0||grid[x][y]!=1){
            return;
        }
        list.add("["+x+","+y+"]");
        grid[x][y]=0;
        if(x==0&&y==m-1){
            isArrive=true;
            if(energy>=maxEnergy){
                maxEnergy=energy;
               update(list);
            }
            grid[x][y]=1;
            list.remove(list.size()-1);
            return;
        }
        
        back(grid,x,y+1,energy-1,list);
        back(grid,x,y-1,energy-1,list);
        back(grid,x-1,y,energy,list);
        back(grid,x+1,y,energy-3,list);
        grid[x][y]=1;
        list.remove(list.size()-1);
    }
    
    private static void update(List<String> list){
        StringBuilder sb=new StringBuilder();
         Iterator<String> iter=list.iterator();
            while(iter.hasNext()){
                sb.append(iter.next()).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
        res=sb.toString();
    }
	
	
	
众所周知，牛能和牛可乐经常收到小粉丝们送来的礼物，每个礼物有特定的价值，他俩想要尽可能按照自己所得价值来平均分配所有礼物。

那么问题来了，在最优的情况下，他俩手中得到的礼物价值和的最小差值是多少呢？
p.s 礼物都很珍贵，所以不可以拆开算哦

public class Solution {
    /**
     * 
     * @param presentVec int整型一维数组 每个礼物的价值
     * @return int整型
     */
    public int maxPresent (int[] presentVec) {
        int sum=0;
        for(int pres:presentVec){
            sum+=pres;
        }
        int cap=sum/2;
        int[] dp=new int[cap+1];
        for(int i=0;i<presentVec.length;i++){
            for(int j=cap;j>=presentVec[i];j--){
                dp[j]=Math.max(dp[j],dp[j-presentVec[i]]+presentVec[i]);
            }
        }
        return sum-2*dp[cap];
    }
}


众所周知，牛牛不喜欢6这个数字（因为牛牛和66发音相近）
所以他想知道，不超过n位十进制数中有多少个数字不含有连续的6（从1开始算的）
输入只包含一个正整数n（1<=n<20）

public class Solution {
    /**
     * 
     * @param n int整型 
     * @return string字符串
     */
    long[][] dp;
    public String calculate (int n) {
        dp=new long[n+1][2];
        long res=dfs(n,0);
        return String.valueOf(dfs(n,0));
    }
    private long dfs(int cur,int flag){
        if(cur==0) return 1;
        if(dp[cur][flag]>0) return dp[cur][flag];
        long res=0;
        for(int i=0;i<10;i++){
            if(flag==1&&i==6) continue;
            res+=dfs(cur-1,i==6?1:0);
        }
        dp[cur][flag]=res;
        return res;
    }
    
}

public class Solution {
    /**
     * 
     * @param n int整型 
     * @return string字符串
     */
    public String calculate (int n) {
        long[] dp=new long[n+1];
        dp[1]=10;
        dp[2]=99;
        for(int i=3;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2])*9;
        }
        return String.valueOf(dp[n]);
    }
}


牛妹出去旅行啦，她准备去NN个城市旅行，去每个城市的开销是A_{i}A 
i
​	
 元。但是牛妹有强迫症，她想在去y城市之前先旅游x城市，于是牛妹列出了这些限制条件List。并且牛妹很节约，她只有VV元，她想知道她最多能到多少个城市去旅游。

输入：
给定N,V，A数组，List数组
import java.util.*;

/*
 * public class Point {
 *   int x;
 *   int y;
 * }
 */

public class Solution {
    /**
     * 
     * @param N int整型 N
     * @param V int整型 V
     * @param A int整型一维数组 A
     * @param List Point类一维数组 List
     * @return int整型
     */
    private int max;
    private Point[] list;
    private Map<Integer,Integer> indexCost=new HashMap<>();
    public int Travel (int N, int V, int[] A, Point[] List) {
        list=List;
        for(int i=0;i<A.length;i++){
            indexCost.put(i+1,A[i]);
        }
        dfs(N,V,A,0,new HashSet<>(),0);
        return max;
    }
    private void dfs(int N,int V,int[] A,int begin,Set<Integer> set,int num){
        if(begin==N||V<0) return;
        
        for(int i=begin;i<N;i++){
            if(V>=A[i]&&isValid(list,i+1,set)){
                V-=A[i];
                set.add(i+1);
                num+=1;
                max=Math.max(max,num);
                dfs(N,V,A,i+1,set,num);
                V+=A[i];
                set.remove(i+1);
                num-=1;
            }
        }
    }
    private boolean isValid(Point[] list,int index,Set<Integer> set){
        for(Point p:list){
            if(p.y==index){
                if(!set.contains(p.x)) return false;
            }
        }
        return true;
    }
}


