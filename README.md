Easterly Chess
==============

Introduction
------------

What follows is a conversation between Peter and James regarding Object Oriented and East Oriented
Design. Along with the discussion is a Chess program developed with OO and East in mind. We hope
this project and discussion is of use to you.

More information on the East Oriented approach can be found [here](http://jamesladdcode.com/?p=12)
as well as various other places on the [internet](https://www.google.com.au/search?q=save+google+search&oq=save+google+search#q=East+Oriented+code). 

**note:** some of the discource that follows not directly related to the program and programming
tehniques has been elided.

The Discourse
-------------

Hello Mr. Ladd,

...

I found your "East Oriented Code" technique while researching the concept of "Tell, Don't Ask". It's a brilliant clarification of "Tell, Don't Ask" and I'm glad to have found it. However, I'm still having trouble applying the concepts.

I've been working on a personal project to enhance my OO coding skills. The ultimate goal is to build a chess program, but I aimed to experiment with object-oriented programming along the way in hopes of attaining a new level of understanding. "Tell, Don't Ask", or "East" is the style of code that I've been aiming for, but can't seem to make it work.

After months of experimentation, and reading many books and blogs, I've managed to work my way into a worse state. Everything I write ends up an untestable disaster. I've started from scratch countless times. I can't seem to find a way to focus my designs. I can't tell which messages objects should be sending and to which objects. I'm at the point where I can't even get a hundred lines of code out without creating a mess and throwing it away.

I was hoping maybe we could talk a bit about my issue. Maybe you could point me in the right direction. I would greatly appreciate any time you could spare.

...,

> ...
>
> Thank you for your email.
> 
> I'd be happy to correspond with you on OO and East as long as you are ok with me responding when I can - pretty busy right now.

> My first rule of Object Oriented Design is to concentrate on behaviour and not on the state (fields/variables) inside Objects.
> These fields and state fall out from defining the behaviour.

> What is your starting point - the Chess Board?

All of my research has brought me to that same conclusion. The thing that separates OO from procedural programming is the focus on behavior between modules rather than state. I've adopted this mentality, but I can't seem to correctly use it.

My starting point is actually piece movement. The goal is when a user selects a square on the board the available moves from that square are shown to the user. I started with pawn movement.

> So the behaviour you want from the Game is for the Board to reveal the available moves for an Occupied Square to the Player. 
>
> The thing with the information is the Game, and Player can't be shown directly but indirectly via an Output mechanism which could be the command line or GUI.
> This disconnect between the input and output mechanism will influence the design which should be independent of it. For example:
>
>
> `game showMovesForSquare: square On: output`
>
>
> Notice how the names of the domain (Chess Game) are coming through, this helps focus and separates the what from the how.
>
>
> Thoughts?

I'm most comfortable with Java or C#. I've been writing this project with Java.

Your analysis is spot on. Your `showMovesForSquare:On:` message makes perfect sense to me. I know just enough Smalltalk syntax to understand it!

I agree that the output (the place where the game should send the moves) should be passed into the game, but how do you tell when it should be an argument to the message as opposed to the constructor?

I'm curious to see how we would implement this.

> I try to construct my objects w valid state and then not change it, so in this case you can pass the board and the output to the constructor, then 
> `Game` has the `showMovesFor(Square selectedSquare)` method (changed to Java code examples).
>
> I would have this delegate to a private method `showMovesForOn(square, output)`
> because I like to have dependencies for methods be obvious. This approach doesn't take much longer and it helps later w testing and expanding abilities.


I wanted to ask another question about the constructor vs method parameter concept we discussed earlier. I realize there isn't actually a need to consider this right now, because there is nothing in code pressuring us to evaluate it, but it's something I stumble over often when designing classes. It could just be because I have a tendency to over analyze things.

You had said:
> I try to construct my objects w valid state and then not change it, so in this case you can pass the board and the output to the constructor, then 
> `Game` has the `showMovesFor(Square selectedSquare)` method.
> I would have this delegate to a private method `showMovesForOn(square, output)`
> because I like to have dependencies for methods be obvious. This approach doesn't take much longer and it helps later w testing and expanding abilities.

I was thinking a bit more deeply on this and considering what I might do if faced with this design decision. Here's how I would think about it that often gets me stuck.

Choosing to move the parameter to the constructor is a trade off. Moving the output to a constructor parameter would prevent changing the output during runtime without recreating the `Game` object or introducing a setter on the `Game` object.

If it was expected that the output would change often then I can think of a few design choices that I would stumble over:

Create the method like you originally had it: `showMovesForOn(square, output)`. This is most flexible, but also commits the public interface of the `Game` class to depend on the output. How do you tell if that dependency is okay?

Keep the constructor parameter and add a method like `game.outputMovesTo(output)` to change the output when needed. Same issue as above, and personally I don't like the setter-like nature of it.

Keep the constructor parameter and create different output implementations that either output conditionally to different places, or if multiple simultaneous outputs are needed, use some type of composite output. 

I would lean toward this because the `Game` object doesn't really care if the moves are output to one or multiple places.
Any thoughts?

> Consider the constructor output a default, if you call `showMovesFor(square)` then output is used and `showMovesForOn(square, output)` method is called passing the default. When needed for something other than the default the full method can be used.
>
> However, you don't have a need for it now - I'd still have the `showMovesFor(...)` and `showMovesForOn(...)` methods but the later would not be public.
>
> Btw - square, and output are interfaces yes?

That makes sense.

`Output` is an interface. 
`Square` I thought would be an immutable value type, so I didn't think to make an interface for it. I supposed there could be a `Square` Interface that still supports/maintains immutability.

> Yes - square could be an enum :)

You're thinking just make an enum with 64 squares?

> Yes, an enum with 64 values.
>
> You might want to provide a constructor that takes a row and column but converts to single value.
> This should be ok for now.

I changed `Square` to an enum.

I thought for row and column we could use File and Rank, since they are chess domain terms. I also created enums for them. Any thoughts on these decisions?

Is it okay that we stopped testing `Game` to create the `Square` enum? Will this affect the design at all?
 
In the reading I've done on testing, I've seen that it's typical to stop working on the class under test and implement simple value classes like `Square` when doing state-based testing, but in interaction-based testing should we have instead mocked an interface and implemented `Square` at a later point?

> Using the names in the Domain is always the right thing to do.
>
> Since you are working remotely to me it will be necessary to stop working on one class and focus on another. As long as the class you stop working on is at a good pause point, with passing tests.
> In a paring situation and by yourself if you keep a good dicipline the `Square` used for testing the `Game` class would be a mock until you are ready to implement it, this way the behaviour of `Square` relied upon by `Game` is what drives the implementation of `Square`. When you do classes in isolation then even with the best intentions they tend to have more behaviour and complexity than is actually needed.
> 
>
> I would move the inner enums out of the `Square` enum into their own file. Having one class per file is 'usually' the thing to do.
>
> You may notice I enabled the tests to run in parrallel - you want the feedback loop to be as quick as possible. Write a test, run it, add code, refactor, repeat. etc
>
>
> I changed the name of some methods in a hope they are more meaningful. I also added a private test method to make the test more clear, removing the repeated `toString()`.
>

Should we create an interface for `Square` instead and mock it? I would like to drive the implementation through emerging behavior as much as possible. I want to experience first hand finding the correct behaviors through testing with mocks.

We can keep the `Square` and related enums on the side, but wait until later to continue implementing them (maybe rename `Square` to be `FileRankSquare`, or something to distinguish it from the `Square` interface). What do you think? Would it make sense to do this?

> I wouldn't change `Square` to an interface just yet.
>
> You have other interfaces to see how behaviour is driven out.
>
> Besides if the class under test interacts w existing classes and they are not expensive to Instantiate then you can just use them. You would mock out a database for example but not an enum. Either way we can refactor it when needed.
>
>
> We have a method on `Game` but is it the best method to teach us something? Adding a method should teach us something and show us progress.
>
> For example running the app right now wouldn't do much. What method could we add and to what class to show we are making progress to our goal of a chess game? Let's add a test for that method next.
>
>How about you think of a method we can add to game that is usable right now such that we could show the game to another and they can see it is working?

I've been thinking about this ... and I don't really know what to do.

When you say "see it is working", do you mean see that the method is working or the `Game` class as a whole is working?

The only thing I thought of is making a `start()` method, such that starting the `Game` should tell the players the game has started, select one player to take their turn, and tell the players whose turn it currently is. I'm still not sure if this meets the criteria.

Is that first test I wrote for `showMovesFor` completely useless? I feel like it is.

>No test is completely useless.

>How about we have a method to start the game which also prints the current board to the console?

... The first thing I thought of was to display the board, but I was thinking about what you said in the old thread and ended up complicating things.

You said:
>What method could we add and to what class to show we are making progress to our goal of a chess game?

Thinking about this, I convinced myself that displaying the board seems too simple. It must be a more intricate detail of gameplay.

Do we actually want to print the board to the console, or do we send a message to the `Board` to print itself passing some interface that facilitates displaying the board?

Should it be abstract to facilitate showing the board on anything, for example, console or GUI? Or should it specifically print to a console?

I guess what I'm asking is should it look like this...

```java
@Test
public void shouldShowTheBoardWhenGameStarts() {
	game.start();
	verify(board).showTo(boardOutput);
}
```

or this...

```java
@Test
public void shouldPrintTheBoardToTheConsoleWhenGameStarts() {
	game.start();
	verify(board).printTo(console); // or verify(console).print(board);
}
```

> How about you make the chess game work on the console for now?
>

I hope you don't mind if I digress to ask a design question.

I happened to be watching a presentation today by Steve Freeman and Nat Pryce (found here: http://www.infoq.com/presentations/Mock-Objects-Nat-Pryce-Steve-Freeman). Their code example got me thinking.

It serves as a good example of the kind of design options that I wrestle with.

They give an example at around 8 minutes of a system for a location-aware media player. In short, the system receives GPS location updates, and plays music specific for the location you're in.

In their design they have a `LocationTracker` that sends `locationChanged` messages to a `LocationAware` interface. The `LocationAware` interface is realized by a `DJ` object, which decides which track to play, and tells a `MediaControl` interface to play the track. The `MediaControl` is realized by a `MediaPlayer` object, which plays the track. The `DJ` also implements a `MediaTracker` interface which is told when the media is finished.

The shell of the code looks like this:

```java
public interface LocationAware {

	void locationChangedTo(String newLocationName);
}

public interface MediaTracker {

	void mediaFinished();
}

public class DJ implements LocationAware, MediaTracker {
	
	// ...
	
	public DJ(MediaControl mediaControl) {
	    this.mediaControl = mediaControl;
	}
	
	@Override
	public void locationChangedTo(String newLocationName) {
		// ...
	}
	
	@Override
	public void mediaFinished() {
		// ...
	}
	
	public void addTrackForLocation(String location, String track) {
		// ...
	}
}
```

One of the tests looks like (edited - changed JMock to Mockito style):

```java
@Mock
private MediaControl mediaControl;
private DJ dj = new DJ(mediaControl);

@Before
public void setUp() {
    dj.addTrackForLocation(someLocation, someTrack);
    dj.addTrackForLocation(otherLocation, otherTrak);
}

@Test
public void startsPlayingTrackForCurrentLocationWhenLocationFirstDetected() {
    dj.locationChanged(someLocation);
    verify(mediaControl).play(someTrack);
}
```

This design got me thinking about some things Sandi Metz says in her POODR book.

"...blind trust is a keystone of object-oriented design. It allows objects to collaborate without binding themselves to context and is necessary in any application that expects to grow and change."

"When messages are trusting and ask for what the sender wants instead of telling the receiver how to behave, objects naturally evolve public interfaces that are flexible and reusable in novel and unexpected ways."

She also mentions three types of interactions from the calling object's perspective:

“I know what I want and I know how you do it.”

“I know what I want and I know what you do.”

“I know what I want and I trust you to do your part.” (this is the goal)

If I'm understanding this all correctly, an object calling a method should avoid assuming too much about what the object does. To do this, the message sender should bind to a name that is within the domain of the sender.

For example, they easily could have said the `LocationTracker` should tell the `DJ` to play a track for the current location.

`LocationTracker`---->`LocationAware.playTrackFor(location)`.

This seems reasonable because it's technically "tell, don't ask". It's telling it what to do, not how to do it, but it also has a lot of context that the `LocationTracker` shouldn't assume.

Even though the behavior they want is for something to play a track for the location, it doesn't make sense for the `LocationTracker` to assume this. It's more context than the `LocationTracker` is qualified to have. In other words, _playing a track is a concrete example of something that happens "when the location changes"_. The `locationChanged(location)` message is something the `LocationTracker` does know about. The `DJ` is trusted to do the right thing in response to the change in location.

So how does all this relate to our chess app? It got me thinking, is `game.showMovesFor(square)` assuming too much? While it is "tell, don't ask", I feel that it might be saying, “I know what I want and I know what you do.”, instead of “I know what I want and I trust you to do your part.”

Would it be better to take the perspective of: _Showing the moves for a square is a concrete example of something that could happen "when a square is chosen"_. It is only incidentally part of our `Game`'s implementation that we show the moves when this happens. Would it be better to have a method `game.squareChosen(square)`, and our particular `Game` implementation is trusted to respond by delivering the available moves for that square?

Yikes! That was long. I owe you a beer for this one.

>>Would it be better to have a method `game.squareChosen(square)`, and our particular `Game` implementation is trusted to respond by delivering the available moves for that square?
>
> You are right on the money. I didn't want to straight out say what you should do because that would be like spoiling a movie by telling you the ending.
> Better you explore and come to your own conclusion.
>
> Now you have to write a test for `game.squareChosen(square)`
>
> However, your method is past-tense and your request is not, so maybe `game.chooseSquare(s)`, `game.activeSquare(s)` or `game.activate(s)`.
>

Okay, cool. I think I'm starting to understand the concept of messaging a little better.

I'll setup the test for it.

As far as the name of the method goes, I think they all come with their own interesting semantic implications. It's a close call between `game.chooseSquare(s)` and `game.activate(s)`.

I decided to go with `game.chooseSquare(s)` for now only because it seems closest to the domain. Can you think of any reason one of the other names might be better?

For the same reason we changed `game.showMovesFor(s)` to `game.chooseSquare(s)`, I changed `board.showMovesForOn(s, movesOutput)` to `board.sendMovesForTo(s, movesReceiver)`; and changed `MovesOutput` to `MovesReceiver`. What do you think about this?

You had said earlier:
> How about you think of a method we can add to game that is usable right now such that we could show the game to another and they can see it is working?

I'm not sure I understand this. If we show the game to another, what should they see? Are the tests passing proof enough that it's working?

> When you start a game you have a board with white and black pieces in their designated spots.
> This could be a good starting test. That a new game has a board with pieces in the right spots.

It seems like I did too little compared to what you suggested I test. I thought testing that each piece of each color is in the right place is too much low level detail for the `Game`. My solution doesn't actually guarantee that all the white and black pieces are in their designated spots, but it assumes an implementation of a `StartingPieceConfiguration` will ensure that. A side effect of this design is it allows different starting configurations (apparently chess has many). What do you think?
