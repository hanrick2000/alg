ArrayList
int size()                                             | 返回容器尺寸
void clear()                                           | 清空
boolean add(E e)                                       | 增加在末尾
E get(int index)                                       | 返回index元素
E set(int index, E element)                            | 替换index位置的元素
E remove(int index)                                    | 删除index位置的元素
boolean remove(Object o)                               | 删除第一个object
void add(int index, E element)                         | 增加在index位置
boolean contains(Object o)                             | 是否包含
boolean isEmpty()                                      | 是否空
int indexOf(Object o)                                  | 返回第一次出现的index, 没有就是-1
boolean addAll(Collection<? extends E> c)              | 增加在末尾
boolean addAll(int index, Collection<? extends E> c)   | 从index位置开始
Object clone()                                         | 创建shallow 拷贝
void ensureCapacity(int minCapacity)                   | 增加容量
Iterator<E> iterator()                                 | 返回iterator
int lastIndexOf(Object o)                              | 返回最后一次出现的index, 没有返回-1
ListIterator<E> listIterator()                         | 返回一个list iterator
ListIterator<E> listIterator(int index)                | 返回一个从index开始的iterator
boolean removeAll(Collection<?> c)                     | 从list里面删除容器中的所有元素
protected void removeRange(int fromIndex, int toIndex) | 删除[fromIndex, toIndex)
boolean retainAll(Collection<?> c)                     | 只保留容器中存在的元素 
List<E> subList(int fromIndex, int toIndex)            | 返回一个子list [fromIndex, toIndex)
Object[] toArray()                                     | 转换成Array[]
<T> T[]  toArray(T[] a)                                | 转换成指定类型的Array[]
void trimToSize()                                      | 根据实际的size给ArrayList瘦身

Stack
boolean empty()      | 是否空
E peek()             | 查询栈顶
E pop()              | 栈顶出栈
E push(E item)       | 入栈
int search(Object o) | 返回1-based的索引

PriorityQueue
boolean add(E e)                   | 插入一个元素
void clear()                       | 删除所有
Comparator<? super E> comparator() | 把comparator返回
boolean contains(Object o)         | 查看是否存在某元素
Iterator<E> iterator()             | 返回iterator
boolean offer(E e)                 | 插入一个元素
E peek()                           | 查询堆顶元素, 没有返回null
E poll()                           | 堆顶元素出堆, 没有返回null
boolean remove(Object o)           | 删除某个元素
int size()                         | 返回大小
Object[] toArray()                 | 转成Array[]
<T> T[] toArray(T[] a)             | 按照指定类型转成Array[]

HashMap
void clear()                                 | 删除所有
Object clone()                               | shollow 拷贝
boolean containsKey(Object key)              | 是否存在key
boolean containsValue(Object value)          | 是否存在value
Set<Map.Entry<K,V>> entrySet()               | 返回KV对
V get(Object key)                            | 用key取value, 没有返回null
boolean isEmpty()                            | 是否空
Set<K> keySet()                              | 返回Key的Set view
V put(K key, V value)                        | 将k, v放入
void putAll(Map<? extends K,? extends V> m)  | 将一系列kv放入
V remove(Object key)                         | 删除指定key及对应的value
int size()                                   | 返回大小
Collection<V> values()                       | 返回values的Collection view
V getOrDefault(key, default)                 | java8: 取key的value, 没有返回default

LinkedList
int size()                                           | 队列大小
boolean add(E e)                                     | 尾端增加元素
E remove()                                           | 删除头部元素
E get(int index)                                     | 返回index处元素
void addFirst(E e)                                   | 在头部增加元素
void addLast(E e)                                    | 在尾端增加元素
E removeFirst()                                      | 删除头部元素
E removeLast()                                       | 删除尾部元素
E getFirst()                                         | 返回头部元素
E getLast()                                          | 返回尾部元素
boolean offer(E e)                                   | 向尾部插入元素
E poll()                                             | 头部元素出队
E peek()                                             | 查询头部元素
boolean offerFirst(E e)                              | 向头部插入元素
boolean offerLast(E e)                               | 向尾部插入元素
E pollFirst()                                        | 头部元素出队
E pollLast()                                         | 尾部元素出队
E peekFirst()                                        | 查询头部元素
E peekLast()                                         | 查询尾部元素
void clear()                                         | 清空
E pop()                                              | 尾部出栈
void push(E e)                                       | 尾部入栈
void add(int index, E element)                       | 在指定位置增加元素
boolean contains(Object o)                           | 是否包含某元素
boolean addAll(Collection<? extends E> c)            | 在尾端增加一批元素
boolean addAll(int index, Collection<? extends E> c) | 在指定位置增加一批元素
Object clone()                                       | 做shollow 拷贝
Iterator<E> descendingIterator()                     | 返回一个从后向前的iterator
E element()                                          | 查询头部元素
int indexOf(Object o)                                | 第一次出现的index
int lastIndexOf(Object o)                            | 最后一次出现的index
ListIterator<E>  listIterator(int index)             | 从指定位置开始的iterator
E remove(int index)                                  | 删除指定位置元素
boolean remove(Object o)                             | 删除指定元素
boolean removeFirstOccurrence(Object o)              | 删除从头部开始第一次出现的元素
boolean removeLastOccurrence(Object o)               | 删除从头部开始最后一次出现的元素
E set(int index, E element)                          | 更新指定位置元素
Object[] toArray()                                   | 从头到尾转换成array
<T> T[] toArray(T[] a)                               | 按照指定格式转换成array

StringBuilder VS StringBuffer
StringBuffer是线程安全的
StringBuilder更快, 大概快3倍
二者接口相同
尽量用StringBuilder
String是immutable的, 每次都会创建新的object
StringBuilder append(boolean b) Appends the string representation of the boolean argument to the sequence.
StringBuilder append(char c) Appends the string representation of the char argument to this sequence.
StringBuilder append(char[] str) Appends the string representation of the char array argument to this sequence.
StringBuilder append(char[] str, int offset, int len) Appends the string representation of a subarray of the char array argument to this sequence.
StringBuilder append(CharSequence s) Appends the specified character sequence to this Appendable.
StringBuilder append(CharSequence s, int start, int end) Appends a subsequence of the specified CharSequence to this sequence.
StringBuilder append(double d) Appends the string representation of the double argument to this sequence.
StringBuilder append(float f) Appends the string representation of the float argument to this sequence.
StringBuilder append(int i) Appends the string representation of the int argument to this sequence.
StringBuilder append(long lng) Appends the string representation of the long argument to this sequence.
StringBuilder append(Object obj) Appends the string representation of the Object argument.
StringBuilder append(String str) Appends the specified string to this character sequence.
StringBuilder append(StringBuffer sb) Appends the specified StringBuffer to this sequence.
StringBuilder appendCodePoint(int codePoint) Appends the string representation of the codePoint argument to this sequence.
int capacity() Returns the current capacity.
char charAt(int index) Returns the char value in this sequence at the specified index.
int codePointAt(int index) Returns the character (Unicode code point) at the specified index.
int codePointBefore(int index) Returns the character (Unicode code point) before the specified index.
int codePointCount(int beginIndex, int endIndex) Returns the number of Unicode code points in the specified text range of this sequence.
StringBuilder delete(int start, int end) Removes the characters in a substring of this sequence.
StringBuilder deleteCharAt(int index) Removes the char at the specified position in this sequence.
void ensureCapacity(int minimumCapacity) Ensures that the capacity is at least equal to the specified minimum.
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin) Characters are copied from this sequence into the destination character array dst.
int indexOf(String str) Returns the index within this string of the first occurrence of the specified substring.
int indexOf(String str, int fromIndex) Returns the index within this string of the first occurrence of the specified substring, starting at the specified index.
StringBuilder insert(int offset, boolean b) Inserts the string representation of the boolean argument into this sequence.
StringBuilder insert(int offset, char c) Inserts the string representation of the char argument into this sequence.
StringBuilder insert(int offset, char[] str) Inserts the string representation of the char array argument into this sequence.
StringBuilder insert(int index, char[] str, int offset, int len) Inserts the string representation of a subarray of the str array argument into this sequence.
StringBuilder insert(int dstOffset, CharSequence s) Inserts the specified CharSequence into this sequence.
StringBuilder insert(int dstOffset, CharSequence s, int start, int end) Inserts a subsequence of the specified CharSequence into this sequence.
StringBuilder insert(int offset, double d) Inserts the string representation of the double argument into this sequence.
StringBuilder insert(int offset, float f) Inserts the string representation of the float argument into this sequence.
StringBuilder insert(int offset, int i) Inserts the string representation of the second int argument into this sequence.
StringBuilder insert(int offset, long l) Inserts the string representation of the long argument into this sequence.
StringBuilder insert(int offset, Object obj) Inserts the string representation of the Object argument into this character sequence.
StringBuilder insert(int offset, String str) Inserts the string into this character sequence.
int lastIndexOf(String str) Returns the index within this string of the rightmost occurrence of the specified substring.
int lastIndexOf(String str, int fromIndex) Returns the index within this string of the last occurrence of the specified substring.
int length() Returns the length (character count).
int offsetByCodePoints(int index, int codePointOffset) Returns the index within this sequence that is offset from the given index by codePointOffset code points.
StringBuilder replace(int start, int end, String str) Replaces the characters in a substring of this sequence with characters in the specified String.
StringBuilder reverse() Causes this character sequence to be replaced by the reverse of the sequence.
void setCharAt(int index, char ch) The character at the specified index is set to ch.
void setLength(int newLength) Sets the length of the character sequence.
CharSequence subSequence(int start, int end) Returns a new character sequence that is a subsequence of this sequence.
String substring(int start) Returns a new String that contains a subsequence of characters currently contained in this character sequence.
String substring(int start, int end) Returns a new String that contains a subsequence of characters currently contained in this sequence.
String toString() Returns a string representing the data in this sequence.
void trimToSize() Attempts to reduce storage used for the character sequence.

Mics
     0123456
str="1234567"
str.substring(3,5) => "45" 是索引[3,5)之间的字符串
Character.toLowerCase(s.charAt(front)) 
Character.isLetter(c)
Character.isDigit(c);
Character.isLowerCase(c) 
Character.isUpperCase(c) 

String:
toCharArray()

