class MyStack {
    private Deque<Integer> primary = null, secondary = null;
    public MyStack() {
        primary = new ArrayDeque<>();
        secondary = new ArrayDeque<>();
    }
    
    public void push(int x) {
        primary.offerLast(x);
    }
    
    public int pop() {
        while(primary.size() != 1){
            secondary.offerLast(primary.pollFirst());
        }
        int res = primary.pollFirst();
        while(!secondary.isEmpty()){
            primary.offerLast(secondary.pollFirst());
        }
        return res;
    }
    
    public int top() {
        while(primary.size() != 1){
            secondary.offerLast(primary.pollFirst());
        }
        int res = primary.pollFirst();
        secondary.offerLast(res);
        while(!secondary.isEmpty()){
            primary.offerLast(secondary.pollFirst());
        }
        return res;
    }
    
    public boolean empty() {
        return primary.isEmpty();
    }
}
/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */