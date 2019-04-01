public class Array {
 public Array(int capacity) {
  arr = new int[capacity];
 }
 public Array() {this(DEFAULT_CAPACITY);}

 int capacity() {return arr.length;}

 void add(int val) throws Exception {
  if (size >= capacity()) throw new Exception("capacity exceeded");
  arr[size++] = val;
 }

 boolean contains(int val) {
  for (int i = 0; i < size; i++)
   if (arr[i] == val) return true;
  return false;
 }

 public int get(int pos) {return arr[pos];}
 public void set(int pos, int val) {arr[pos] = val;}

 public String toString() {
  String result = "{";
  for (int i = 0; i < size; i++)
   result += arr[i] + (i < size-1 ? ", " : "");
  result += "}";
  return result;
 }

 private int [] arr;  // capacity is arr.length
 private int size = 0;

 static final int DEFAULT_CAPACITY = 100;
}