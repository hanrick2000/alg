public class SnakeGame {
    /* Initialize your data structure here.
       @param width - screen width
       @param height - screen height 
       @param food - A list of food positions
       E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private class Position {
        public int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private boolean gameOver; //结束游戏
    private int[][] food; //豆的位置
    private int foodGet; //吃了多少豆
    private int width, height; //屏幕长宽
    private HashSet<Integer> set;
    private Deque<Position> queue; //dq的头放蛇尾, dq的尾放的是蛇头

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        gameOver = false;
        foodGet = 0; //表示吃到第几个豆, 吃掉一个下一个才会出现
        set= new HashSet<Integer>(); //把二维上的位置变成1维, 存到set中表示当前蛇所在的位置
        this.food = food;
        queue = new LinkedList<Position>();
        set.add(0);
        queue.offer(new Position(0, 0)); //开始的时候蛇长1, 从(0,0)开始, deque.offer()和dqeue.offerLast()是一样的, 都是放到队列尾
        if (food.length > 0 && food[foodGet][0] == 0 && food[foodGet][1] == 0) {
            foodGet++;
        }
    }
    
    /* Moves the snake.
       @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
       @return The game's score after the move. Return -1 if game over. 
       Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (gameOver) {
            return -1;
        }
        int incx = 0, incy = 0;
        switch (direction) {
            case "U": incx = -1; incy = 0; break;
            case "L": incx = 0; incy = -1; break;
            case "R": incx = 0; incy = 1; break;
            case "D": incx = 1; incy = 0; break;
            default: break;
        }
        int x = queue.peekLast().x + incx; 
        int y = queue.peekLast().y + incy; //取出队尾
        if (x >= 0 && x < height && y >= 0 && y < width) { //判断是否碰到墙
            queue.offerLast(new Position(x, y)); //把新的位置放入dq
            //判断是否迟到豆子
            if (foodGet < food.length && x == food[foodGet][0] && y == food[foodGet][1]) { //如果新的位置吃到豆
                foodGet++; //吃到了新的豆, queue长度就不会变短
            } else {
                set.remove(queue.peekFirst().x * width + queue.peekFirst().y); //蛇尾从set中出去
                queue.pollFirst(); //把蛇尾出dq
            }
            //判断是否蛇头碰到自己
            if (set.contains(x * width + y)) { //如果在移动后(x,y)的位置已经在set中了, 则蛇头碰到了自己的身体, 游戏结束
                return -1;
            } else {
                set.add(x * width + y); //如果蛇头所在额位置没有在set中, 那么就加到set中
            }
            return foodGet;
        } else {
            gameOver = true;
            return -1;
        }
    }
}
