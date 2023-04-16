Sprite frog;
Group lilypads;

void preload() {
	frog = new Sprite();
	lilypads = new Group();
}

void setup() {
	world.gravity.y = 10;
	noStroke();

	frog.x = 0;
	frog.y = 80;
	frog.w = 10;
	frog.h = 8;

	lilypads.y = 90;
	lilypads.w = 10;
	lilypads.h = 2;
	lilypads.collider = "static";

	makeLilyPads();
}

void makeLilyPads() {
	// TODO: use a loop to make more lily pads
	Func ls = lilypads.Sprite;

	int i = 0;
	while(i < 25)
	{
		Sprite lily = new ls();
		lily.x = i * 16;
		i++;
	}	
}

void draw() {
	background("0");
	fill("3");
	rect(0, 0, canvas.w, 90);

	if (frog.colliding(lilypads)) {
		frog.x = round(frog.x / 16) * 16;
		if (kb.presses("up")) {
			// little jump
			frog.velocity.y = -1.4;
			frog.velocity.x = 0.96;
		} else if (kb.presses("right")) {
			// BIG jump!
			frog.velocity.y = -2;
			frog.velocity.x = 1.36;
		}
	}

	camera.x = frog.x + 64;
}
