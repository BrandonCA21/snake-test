package com.example.snake;


import java.awt.Point;
import java.util.LinkedList;


public class Snake {
private final LinkedList<Point> body = new LinkedList<>();
private GamePanel.Direction direction = GamePanel.Direction.RIGHT;
private boolean growOnNext = false;


public Snake(int startX, int startY) {
// initial length 3
body.add(new Point(startX, startY));
body.add(new Point(startX - 1, startY));
body.add(new Point(startX - 2, startY));
}


public void reset(int startX, int startY) {
body.clear();
body.add(new Point(startX, startY));
body.add(new Point(startX - 1, startY));
body.add(new Point(startX - 2, startY));
direction = GamePanel.Direction.RIGHT;
growOnNext = false;
}


public void setDirection(GamePanel.Direction dir) {
this.direction = dir;
}


public GamePanel.Direction getDirection() { return direction; }


public void move() {
Point head = getHead();
Point newHead = new Point(head.x, head.y);
switch (direction) {
case UP -> newHead.y--;
case DOWN -> newHead.y++;
case LEFT -> newHead.x--;
case RIGHT -> newHead.x++;
}


body.addFirst(newHead);
if (!growOnNext) {
body.removeLast();
} else {
growOnNext = false;
}
}


public void grow() {
growOnNext = true;
}

