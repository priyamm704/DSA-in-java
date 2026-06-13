class StockSpanner {

     Deque<int[]> stack = new ArrayDeque<>();
     int index = -1;

    public int next(int price) {

        index++;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }

        int span = stack.isEmpty()
                ? index + 1
                : index - stack.peek()[1];

        stack.push(new int[]{price, index});

        return span;
    }
}