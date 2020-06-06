package ListLianXi;

import java.util.LinkedList;

public class LinkedListDemo {
/*
    基于链表实现
    无索引
    同步
    查询慢，增删快
*/
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        //void	addFirst(E e)
        //          将指定元素插入此列表的开头。
        list.addFirst("1");
        System.out.println(list);
/*
        void	addLast(E e)
        将指定元素添加到此列表的结尾。
*/
        list.addLast("6");
        System.out.println(list);
        // 同addFirst
        list.push("0");
        System.out.println(list);

/*
        E	get(int index)
        返回此列表中指定位置处的元素。
        E	getFirst()
        返回此列表的第一个元素。
        E	getLast()
        返回此列表的最后一个元素。
*/
        String s = list.get(1);
        System.out.println(s);

        String first = list.getFirst();
        System.out.println(first);

        String last = list.getLast();
        System.out.println(last);

/*
        pop()
        从此列表所表示的堆栈处弹出一个元素。
        E	remove()
        获取并移除此列表的头（第一个元素）。
        E	remove(int index)
        移除此列表中指定位置处的元素。
        boolean	remove(Object o)
        从此列表中移除首次出现的指定元素（如果存在）。
        E	removeFirst()
        移除并返回此列表的第一个元素。
*/
        // 同removeFirst
        String pop = list.pop();
        System.out.println(pop);
        String s1 = list.removeFirst();
        System.out.println(s1);
        String remove = list.remove();
        System.out.println(remove);

        String s2 = list.removeLast();
        System.out.println(s2);
    }
}
