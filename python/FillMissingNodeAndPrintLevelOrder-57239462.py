from collections import deque


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
    print(root.val),
    traverseInOrder(root.right)


def traverseLevelOrder(q):
    while(q.qsize() > 1):
        current = q.get()
        if(current == None):
            q.append(None)
            print("\n")
        else:
            if(current.left != None):
                q.append(current.left)
            if(current.right != None):
                q.append(current.right)
            print(current.val),


def traverseLevelOrderAndFillMissingNodes(q, level):
    while(len(q) > 1):
        current = q.popleft()
        if(current == None):
            q.append(None)
            print("\n")
            level = level - 1
        else:
            if(current.left == None and level > 0):
                current.left = Node(-1)
            if(current.right == None and level > 0):
                current.right = Node(-1)
            if(current.left != None):
                q.append(current.left)
            if(current.right != None):
                q.append(current.right)
            print(current.val),


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
q = deque()
q.append(root)
q.append(None)
# traverseLevelOrder(q)
traverseLevelOrderAndFillMissingNodes(q, 3)
