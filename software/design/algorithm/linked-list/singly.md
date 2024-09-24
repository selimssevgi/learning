# singly linked list

- head is must to know where it starts
- tail optional but useful
- count optional but useful


```shell
addFirst(e):
  newest = Node(e)
  newest.next = head
  head = newest
  size++
```

```shell
addLast(e):
  newest = Node(e)
  newest.next = null
  tail.next = newest
  tail = newest
  size++
```

```shell
removeFirst(e):
  if head not null
    toBeRemoved = head
    head = head.next
    toBeRemoved = null
    size--
```


- removing tail is not easy
- we need a reference from tail to the node before tail, but we dont have
- we need to start from head to find that node, which is not performant
- if we need to support removal from the end, we need *doubly linked list*
