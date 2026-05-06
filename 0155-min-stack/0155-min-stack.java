class Node{
    long data;
    Node next;

    Node(long data){
        this.data = data;
        this.next = null;
    }
}

class MinStack {
    Node top;
    long min;

    public MinStack() {
        top = null;
    }
    
    public void push(int val) {
        Node newNode;
        if(top == null){
            newNode = new Node(val);
            min = val;
        }else if(val < min){
            long encoded = 2L * val - min;
            newNode = new Node(encoded);
            min = val;
        }else{
            newNode = new Node(val);
        }
        newNode.next = top;
        top = newNode;
    }
    
    public void pop() {
        if(top == null) return;
        if(top.data < min){
            min = 2 * min - top.data;
        }
        top = top.next;
    }
    
    public int top() {
        if(top == null) throw new RuntimeException("Stack Is Empty");
        if(top.data < min){
            return (int)min;
        }
        return (int)top.data;
    }
    
    public int getMin() {
        if(top == null) throw new RuntimeException("Stack Is Empty");
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */