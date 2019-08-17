package org.openapex.samples.misc.assorted;

import java.util.ArrayList;
import java.util.List;

public class DuplicateItemInList {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("rose"); // 0
        list.add("love"); // 1
        list.add("lyre"); // 2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        List<String> addList = new ArrayList<>();
        List<String> removeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).contains("r") && list.get(i).contains("l"))
            {
                continue;
            } else if (list.get(i).contains("r"))
            {
                removeList.add(list.get(i));
            } else if (list.get(i).contains("l"))
            {
                addList.add(list.get(i));
            }
        }
        list.removeAll(removeList);
        list.addAll(addList);
        return list;
    }
}
