package com.example.snake;
g2.drawString("Score: " + (snake.getLength() - 3), 8, 16);


if (!running) {
g2.setColor(new Color(255, 255, 255, 200));
g2.setFont(new Font("Arial", Font.BOLD, 36));
String msg = "Game Over";
FontMetrics fm = g2.getFontMetrics();
int tx = (PANEL_WIDTH - fm.stringWidth(msg)) / 2;
int ty = PANEL_HEIGHT / 2;
g2.drawString(msg, tx, ty);


g2.setFont(new Font("Arial", Font.PLAIN, 18));
String r = "Press ENTER to restart";
fm = g2.getFontMetrics();
tx = (PANEL_WIDTH - fm.stringWidth(r)) / 2;
g2.drawString(r, tx, ty + 30);
}
}


@Override
public void actionPerformed(ActionEvent e) {
if (!running) {
timer.stop();
return;
}


snake.setDirection(nextDirection);
snake.move();


// check collision with walls
Point head = snake.getHead();
if (head.x < 0 || head.x >= GRID_WIDTH || head.y < 0 || head.y >= GRID_HEIGHT) {
running = false;
}


// check collision with self
if (snake.hitSelf()) {
running = false;
}


// check food
if (head.x == food.x && head.y == food.y) {
snake.grow();
spawnFood();
}


repaint();
}


@Override
public void keyTyped(KeyEvent e) { }


@Override
public void keyPressed(KeyEvent e) {
int key = e.getKeyCode();
switch (key) {
case KeyEvent.VK_UP -> { if (snake.getDirection() != Direction.DOWN) nextDirection = Direction.UP; }
case KeyEvent.VK_DOWN -> { if (snake.getDirection() != Direction.UP) nextDirection = Direction.DOWN; }
case KeyEvent.VK_LEFT -> { if (snake.getDirection() != Direction.RIGHT) nextDirection = Direction.LEFT; }
case KeyEvent.VK_RIGHT -> { if (snake.getDirection() != Direction.LEFT) nextDirection = Direction.RIGHT; }
case KeyEvent.VK_ENTER -> { if (!running) restart(); }
}
}


@Override
public void keyReleased(KeyEvent e) { }


private void restart() {
snake.reset(GRID_WIDTH / 2, GRID_HEIGHT / 2);
nextDirection = Direction.RIGHT;
spawnFood();
running = true;
timer.start();
}


// simple direction enum
public enum Direction { UP, DOWN, LEFT, RIGHT }
