package bfs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class 打开转盘锁 {
    //向上转动一次
    public String uplock(String s,int j){
        char[] chars = s.toCharArray();
        if (chars[j]=='9')
            chars[j]='0';
        else
            chars[j]+=1;
        return new String(chars);
    }
    //向下转动一次
    public String downlock(String s,int j){
        char[] chars = s.toCharArray();
        if (chars[j]=='0')
            chars[j]='9';
        else
            chars[j]-=1;
        return new String(chars);
    }
    public int openLock(String[] deadends, String target) {
        Queue<String> list = new LinkedList<>();
        //判断锁是否已经转动过
        Set<String> visit = new HashSet<>();
        HashSet<String> deads = new HashSet<>();
        for (int i = 0; i < deadends.length; i++) {
            deads.add(deadends[i]);
        }
        list.offer("0000");
        visit.add("0000");
        int count=0;
        while (!list.isEmpty()){
            int size = list.size();
            for (int i = 0; i < size; i++) {
                String cur = list.poll();
                if (deads.contains(cur))
                    continue;
                if (cur.equals(target))
                    return count;
                for (int j = 0; j < 4; j++) {
                    //向上转动锁
                    String uplock = uplock(cur, j);
                    if (!visit.contains(uplock)){
                        list.offer(uplock);
                        visit.add(uplock);
                    }
                    String downlock = downlock(cur, j);
                    if (!visit.contains(downlock)){
                        list.offer(downlock);
                        visit.add(downlock);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
