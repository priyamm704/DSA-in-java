class StockSpanner {

    private static class Pair {
        int price;
        int index;

        Pair(int price, int index) {
            this.price = price;
            this.index = index;
        }
    }

    private Deque<Pair> stack = new ArrayDeque<>();
    private int index = -1;

    public int next(int price) {

        index++;

        while (!stack.isEmpty() && stack.peek().price <= price) {
            stack.pop();
        }

        int span = stack.isEmpty()
                ? index + 1
                : index - stack.peek().index;

        stack.push(new Pair(price, index));

        return span;
    }
}