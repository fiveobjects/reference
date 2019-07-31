from queue import Queue


class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None


def fillMissingNodes(root, level):
    if (root == None):
        return
    if(root.left == None and level > 0):
        root.left = Node(-1)
    if(root.right == None and level > 0):
        root.right = Node(-1)
    fillMissingNodes(root.left, level - 1)
    fillMissingNodes(root.right, level - 1)


def traverseInOrder(root):
    if (root == None):
        return
    traverseInOrder(root.left)
    print(root.val, end=" ")
    traverseInOrder(root.right)


def traverseLevelOrder(q):
    while(q.qsize() > 1):
        current = q.get()
        if(current == None):
            q.put(None)
            print("")
        else:
            if(current.left != None):
                q.put(current.left)
            if(current.right != None):
                q.put(current.right)
            print(current.val, end=" ")


def traverseLevelOrderAndFillMissingNodes(q, level):
    while(q.qsize() > 1):
        current = q.get()
        if(current == None):
            q.put(None)
            print("\n")
            level = level - 1
        else:
            if(current.left == None and level > 0):
                current.left = Node(-1)
            if(current.right == None and level > 0):
                current.right = Node(-1)
            if(current.left != None):
                q.put(current.left)
            if(current.right != None):
                q.put(current.right)
            print(current.val, end=" ")


root = Node(1)
root.left = Node(2)
root.right = Node(3)
root.left.left = Node(4)
root.left.right = Node(5)
root.right.right = Node(6)
root.right.right.left = Node(7)
root.left.left.right = Node(8)

# Fill missing nodes
#fillMissingNodes(root, 3)
# In order traversal
traverseInOrder(root)
print("\n")
# Level order print
q = Queue()
q.put(root)
q.put(None)
# traverseLevelOrder(q)
traverseLevelOrderAndFillMissingNodes(q, 3)
