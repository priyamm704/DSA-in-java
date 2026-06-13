class StockSpanner {
    List<Integer> ls = new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
        ls.add(price);
        int count = 0;
        for(int i = ls.size()-1;i>=0;i--){
            if(ls.get(i) <= price)count++;
            else break;
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */