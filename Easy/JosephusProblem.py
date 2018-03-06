'''
line up in circle, person zero gets a sword and kills the person next to him, and hand the sword. Until only one person is left.
You don't know how many people are gonna be there.

- - - x -
-       - <-
-       -
- - - - -


odds

evens  14

node.next
node.val => which node value I want to be


class Node:
	__init__(self, val):
  	self.val = val
    self.next = None

'''
class Node(object):
    def __init__(self, val):
        self.val = val
        self.next = None

head_node = Node(0)




def survive_this(head_node):  # 0
    last_survivor = execute_turn(head_node)  # 0
    return last_survivor.val


def execute_turn(node):  # 4 => 2 => 4
    if node.next and node.next.next is not node:
        node.next = node.next.next  # disconnects the node after head node from ll, killing the person
        execute_turn(node.next)  # this hadnds off the sword to the next 'live' guy
    return node


#  2 => 4 => 2
#            *

# 2 => None

# 0 => 2 => 3 => 0
#      *
def execute_turn_alt(node):
    while node.next.next is not node:
        node.next = node.next.next
        node = node.next
    node.next = None
    return node


def implementation(number_of_combatents):  # 5
    head_node = None
    prev_combatant = None
    for i in range(number_of_combatents):  # 5
        current_combatant = Node(i)  # 4  # node.val = 4 node.next = None
        if not head_node:
            head_node = current_combatant  # head node is node.val = 0
        if prev_combatant:
            prev_combatant.next = current_combatant  # head_node.next = node.val(4)
        prev_combatant = current_combatant  # prev comb is node.val = 4

    prev_combatant.next = head_node  # node.val(4).next = node.val(0)

    return survive_this(head_node)

print(implementation(5))


# post moretem:

'''
How big is the circle in terms of people?  Get more info about the problem.
 * discuss memory limitations
 	* 
 * possible data structure alternatives
 * recursion vs iteration
 * Put data in to prove that it works, pick various test cases
 * start testing from the top and really go through every variable and operation to catch your own bugs
 * discuss the data struture choice, compared to alternatives.  Tell about its good and bad sides (like memory or performance).
'''


