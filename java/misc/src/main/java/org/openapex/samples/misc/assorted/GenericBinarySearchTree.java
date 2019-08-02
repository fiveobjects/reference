package org.openapex.samples.misc.assorted;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GenericBinarySearchTree {
    public static abstract class BString<Alphabet extends Comparable<Alphabet>> implements Iterable<Alphabet>, Comparable<BString<Alphabet>> {
        protected List<Alphabet> str;


        public BString(Alphabet[] str) {
            this.str = new ArrayList<Alphabet>(str.length);
            for (int i = 0; i < str.length; i++) {
                this.str.add(str[i]);
            }
        }
    }

    public static abstract class NGram extends BString<String>{
        public NGram(String[] str) {
            super(str);
        }
    }

    public static class BinarySearchTree<K extends Comparable<? super K>, V>
             {
        // The root of the BST. Root is null if and only if the tree is empty.
        //protected BSTNode root;

        /**
         * Create an empty binary search tree.
         */
        public BinarySearchTree() {
            super();
            //this.root = null;
        }
    }

    public static void main(String[] args) {
        new BinarySearchTree<NGram, Set>();
    }


}
