# algo_learning

## Sorting

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

