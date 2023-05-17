Sprite frog;
Group lilypads;

PSound bigJumpSound;
PSound smallJumpSound;
PSound waterSound;
void preload() {
	frog = new Sprite();
	frog.addAni("frog_jump0.png", 6);
	frog.ani.stop();
	lilypads = new Group();
	lilypads.addAni("lilypads0.png", 11);

	bigJumpSound = loadSound("sounds/retro_jump_bounce_08.wav");
	bigJumpSound.setVolume(0.3);
	smallJumpSound = loadSound("sounds/retro_jump_bounce_01.wav");
	smallJumpSound.setVolume(0.3);
	waterSound = loadSound("sounds/retro_jump_bounce_09.wav");
	waterSound.setVolume(0.3);
}

void setup() {
	world.gravity.y = 10;
	noStroke();

	frog.x = 0;
	frog.y = 80;
	frog.w = 10;
	frog.h = 8;
	frog.rotationLock = true;
	frog.layer = 1;

	lilypads.y = 90;
	lilypads.w = 10;
	lilypads.h = 2;
	lilypads.collider = "static";
	lilypads.layer = 0;

	makeLilyPads();
}

void makeLilyPads() {
	// TODO: use a loop to make more lily pads
	Func ls = lilypads.Sprite;

	for(int i = 0; i < 100; i++)
	{
		Sprite lily = new ls();
		lily.x = i * 16;

		lily.ani.frame = (int) (Math.random()*12);
		lily.ani.frameDelay = (int) (60 + Math.random()*60);

		if (Math.random() < 0.5) {
			i++;
		}
	}	
}

void draw() {
	background("0");
	fill("3");
	rect(0, 0, canvas.w, 90);

	if (frog.collides(lilypads)) {

		frog.ani.stop();
		frog.ani.frame = 0;
	}

	if (frog.colliding(lilypads)) {
		frog.x = round(frog.x / 16) * 16;

		if (kb.presses("up")) {
			// little jump
			frog.ani.frameDelay = 2;
			frog.ani.play();
			smallJumpSound.play();
			frog.velocity.y = -1.4;
			frog.velocity.x = 0.96;
		} else if (kb.presses("right")) {
			// BIG jump!
			frog.ani.frameDelay = 4;
			frog.ani.play();
			bigJumpSound.play();
			frog.velocity.y = -2;
			frog.velocity.x = 1.36;
		}
	}

	if(frog.y > 90)
	{
		frog.ani.frame = 4;
		waterSound.play();
	}

	if(frog.y > 150)
	{
		frog.x = 0;
		frog.y = 80;
	}
	

	camera.x = frog.x + 64;
}
