
# algo_learning

## Sorting
```aidl
List<Integer> intervals = new List()
List<Integer> sorted = new ArrayList<Integer>(intervals);
sorted.sort((a,b) -> a - b);
```

##### Ascending  
`(a,b) -> a - b`
-1: a goes before b
1: a goes after b
##### Descending
`(a,b) -> b - a`
### Bubble Sort

Time Complexity O(n^2)
Space Complexity O(n)

```aidl
 void bubbleSort(int arr[]){
    for (int i = 0; i < arr.length - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (arr[j] > arr[j + 1]) {
                // swap arr[j+1] and arr[j]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```
### Bubble Sort

Time Complexity O(nlog(n))
Space Complexity O(n)

* Insert into heap
* Delete all from heap (store value at end)

| Algo           | Time Complexity | Space Complexity  |     |     |
|----------------|-----------------|-------------------|-----|-----|
| Quick Sort     |                 |                   |     |     |
| Merge Sort     |                 |                   |     |     |
| Heap Sort      |                 |                   |     |     |
| Insertion Sort |                 |                   |     |     | 

## Data Structures

### Array

`int[] arr = new int[10]`
`int[] arr = new int[]{1,2,3}`

* Unsorted Search: O(n^2)
* Sorted Search: O(nlogn) -> Binary Search
* Insert: O(1)
* Remove: O(n) //shift array back

### HashMap

`HashMap<Integer> map = new HashMap<>()`

* Search: O(1)
* Insert: O(1)
* Remove: O(1)

### HashSet

`HashMap<Integer,String> map = new HashMap<>()`

* Search: O(1)
* Insert: O(1)
* Remove: O(1)

### Single Linked List

```aidl
public class ListNode {
  int val;
  ListNode next;
}
```

* Search: O(n)
* Insert: O(1) //with pointer

```aidl
temp = current.next;
current.next = newNode;
newNode.next = temp
```

* Remove: O(1) //with pointer

```aidl
remove = current.next;
current.next = remove.next;
```

* Invert list: O(n) //with pointer

```aidl
temp = current;
current = current.next;
temp.next = prev;
prev = temp;
```

* Advantage: can grow

### Heap
`PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a , b) -> b - a);`
`PriorityQueue<Integer> minHeap = new PriorityQueue<>((a , b) -> a - b);`
```aidl
         1
        / \
       /   \
      2     \
     / \     3
    4   5
    [1,2,3,4,5]
    
         1
        / \
       /   \
      2     3
     / \   / \
    4   -  -  7
    [1,2,3,4,5,-,-,7]
```

#### Array rep of binary tree

* left child = 2*i + 1
* right child = 2*i + 2
* parent child = floor(i/2)

#### Insert one element
* Time complexity O(log(n))
* Insert at next open spot
* Check parent (floor(i/2)) if bigger/smaller switch
* Repeat until in correct spot

#### Delete ROOT element
* Time complexity O(log(n))
* Must remove the top/root 
* Move last element to root
* Swap biggest/min children (2 * i +1, 2 * i + 2) with parent 
* Repeat until in correct spot


#### Heapify 
* Time complexity o(n)
* Start at index arr.length 
  * Is arr[i] greater that left and right childe? continue
  * otherwise swap
    * Does the swapped down element need to be futher swapped?
* 


| Structure          |     |     |     |
|--------------------|-----|-----|-----|
| Matrix             |     |     |     |
| Stack              |     |     |     |   
| Queue              |     |     |     |
| Binary Tree        |     |     |     |
| Binary Search Tree |     |     |     |
| Heap               |     |     |     |
| Graph              |     |     |     |

## Searching

### Linear Search

* Time Complex O(n)

```aidl
for(int i=0; i < arr.length; i++){
   if(arr[i] == target) return
}
```

| Algo          | Complexity |     |     |
|---------------|------------|-----|-----|
| Linear Search |            |     |     |
| Binary Search |            |     |     |

