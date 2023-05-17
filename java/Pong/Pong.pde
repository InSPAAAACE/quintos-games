// screen resolution is 256x192

PImage imgBall = spriteArt("""
..wwww
.ww..ww
ww....ww
w......w
w......w
ww....ww
.ww..ww
..wwww""");

PImage imgPaddle = spriteArt(".wwwwww.\nwwwwwwww\n" + "www..www\nww.ww.ww\n".repeat(21) + "wwwwwwww\n.wwwwww.");

Sprite ball;
Sprite paddles_left;
Sprite paddles_right;

Sprite wallTop;
Sprite wallBottom;

int score_left = 0;
int score_right = 0;

void setup() {
  ball = new Sprite();
  ball.image = imgBall;
	ball.x = width / 2;
	ball.y = height / 2;
	ball.diameter = 8;
	ball.bounciness = 1; // full bounciness
	ball.friction = 0; // no friction40
	ball.direction = 40;
	ball.speed = 3;

  /* Part A: add the paddles */
  // your code here!
	paddles_left = new Sprite();
	paddles_left.collider = "kinematic";
	paddles_left.image = imgPaddle;
	paddles_left.x = 10;
	paddles_left.y = height / 2;

	paddles_right = new Sprite();
	paddles_right.collider = "kinematic";
	paddles_right.image = imgPaddle;
	paddles_right.x = width -10;
	paddles_right.y = height / 2;

	wallTop = new Sprite();
	wallTop.color = "white";
	wallTop.collider = "static";
	wallTop.width = width;
	wallTop.height = 10;
	wallTop.x = width/2;
	wallTop.y = -2;

	wallBottom = new Sprite();
	wallBottom.color = "white";
	wallBottom.collider = "static";
	wallBottom.width = width;
	wallBottom.height = 10;
	wallBottom.x = width/2;
	wallBottom.y = height+2;


}

void draw() {
	background("b");
	
	if (ball.x < -100 || ball.x > width + 100)
	{
		// if the ball goes off the left side
		if (ball.x < -100) {
			ball.direction = 30 + Math.random()*30;
			if (Math.random() > 0.5)
			{
				ball.direction = -ball.direction;
			}
			score_right ++;
		}
		// if the ball goes off the right side
		if (ball.x > width + 100) {
			ball.direction = 150 - Math.random()*30;
			if (Math.random() > 0.5)
			{
				ball.direction = -ball.direction;
			}
			score_left ++;
		}
		ball.x = width/2;
		ball.y = height/ 2;
		ball.speed = 3;
	}

	if (ball.collided(paddles_left))
	{
		ball.speed = ball.speed + 0.5;
	}
	else if (ball.collided(paddles_right))
	{
		ball.speed = ball.speed + 0.5;
	}
	else if (ball.collided(wallTop))
	{
		ball.speed = ball.speed + 0.5;
	}
	else if (ball.collided(wallBottom))
	{
		ball.speed = ball.speed + 0.5;
	}


	txt(score_right, 2, 25);
	txt(score_left, 2, 5);

	if (kb.pressing("w") && paddles_left.y > 0) {
		paddles_left.vel.y = -2; // move the player up by 2 pixels each frame
	} else if (kb.pressing("s") && paddles_left.y < height) {
		paddles_left.vel.y = 2; // move the player down by 2 pixels each frame
	} else {
		paddles_left.vel.y = 0;
	}

	if (kb.pressing("ArrowUp") && paddles_right.y > 0) {
		paddles_right.vel.y = -2; // move the player up by 2 pixels each frame
	}
	else if (kb.pressing("ArrowDown") && paddles_right.y < height) {
		paddles_right.vel.y = 2; // move the player down by 2 pixels each frame
	}
	else
	{
		paddles_right.vel.y = 0;
	}
}
