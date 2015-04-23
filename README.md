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

> No test is completely useless.

> How about we have a method to start the game which also prints the current board to the console?

... The first thing I thought of was to display the board, but I was thinking about what you said in the old thread and ended up complicating things.

You said:
> > What method could we add and to what class to show we are making progress to our goal of a chess game?

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

> > Would it be better to have a method `game.squareChosen(square)`, and our particular `Game` implementation is trusted to respond by delivering the available moves for that square?
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

I just can't stop myself from analyzing the design. I hope you don't mind that I'm spending so much time evaluating the same code. This has been a real problem for me when designing classes. I can't tell if the messages (methods) make sense. One minute I convince myself it makes sense, and a minute later I'm convinced it's wrong. I try to remove context, keep things abstract and general, delay decisions, and not get caught up in implementation details. I find that when I do this, classes end up doing very little and the tests become sort of vague. I start to wonder that I've removed so much that the class isn't actually doing anything.

I pushed a new branch to the repo called alternateDesign so you can see what I'm thinking. The changes are in GameTest, Game, and Board. I added an ExampleBoardImpl class to show how the board might be implemented.

It seemed like the Game class was taking on dependencies and work related more to the Board's job, so I tried to remove some of the dependencies and some of the context in the method calls. The tests were starting to collect a lot of mocks and I thought the Game didn't really require them as dependencies to do its job of coordinating the game. I can provide a more detailed explanation on the reasons behind these changes if needed.

Do you think I made anything better, or am I just rearranging the deck chairs on the Titanic. What do you think about this design?

> I looked at the alternative branch for Chess and it is good.
> I'd be inclined to rename `ExampleBoardImpl` to Simply `ChessBoard`. The suffix of 'Impl' should be avoided if possible.
> Sometimes its hard to think of a concrete name that doesn't clash with the Interface name.
>
> Both branches are good but you should choose one.
>
> In the master branch `Game` class when you start the game you ask the `StartingPieceConfiguration` to setup the board.
> It might seem like splitting hairs but you should probably ask the board to setup according to the starting piece configuration rather than the other way around:

> ```java
> public void start() {
>    setupBoard();
>    printBoard();
> }

> private void setupBoard() { board.setupAs(chessConfiguration); }
> private void printBoard() { board.printToConsole(); }
> ```

> Note that I have split out the methods too - as it is likely they will be reused later - and renamed the configuration.

> What is worth thinking about here is the 'board configuration'. How likely is it that the 
> board will be independent enough to the game played on it that a configuration can be 
> used? Don't change this as it will evolve.

> How can we move forward with this project?

<!-- -->
 
> > I'd be inclined to rename ExampleBoardImpl to Simply ChessBoard. The suffix of 'Impl' should be avoided if possible.

The ExampleBoardImpl class was just a quick example of what an implementation might look like. I agree, 'Impl' classes are bad news.

> > Both branches are good but you should choose one.

I was worried about how the changes in the alternate design force the Game tests to change. Changing board.sendMovesForTo to board.chooseSquare causes the Game tests lose all evidence of the feature we were testing. The Game test changes from shouldSendMovesForSquareWhenSquareIsChosen to shouldChooseSquareOnTheBoardWhenSquareIsChosen. If we want to guarantee in a test that the moves are sent to the receiver we would have to write and test an implementation of Board. Is it okay at this point to deviate from Game and start testing and implementing a ChessBoard class?

I will choose one of the branches and continue.

> > It might seem like splitting hairs but you should probably ask the board to setup according to the starting piece configuration rather than the other way around...

I couldn't decide which way made sense, telling the StartingPieceConfiguration to setup the board or telling the board to set itself up with the StartingPieceConfiguration. Can you explain why board.setupAs(chessConfiguration) is better?

> > How can we move forward with this project?

I will think of a next step to move forward. Right now I can think of three options to continue:
- We can start keeping track of player turns.
- We can implement submitting moves.
- We can write tests for bad inputs, null objects, etc.

> I wouldnt say that 'Impl' are bad news just that ChessBoard is a better name than anything with Impl at the end :)

> board.setupAs(configuration) is better because in real life we ask someone to follow instructions/map we don't as
> the instructions/map to apply to the person. However, when you implement setupAs you will almost always have
a point where board asks the configuration to apply to itself. 

> To move forward how about you have a main in the game class that constructs a chess game and tells the game
to start resulting in a board being printed to the console? Driven out by tests.

I'll start working on that. What is the reasoning behind this as a next step? I wouldn't have thought to go in that direction.

> Well this approach will make a running piece of software, and this is the only real measure of success. :)

I finally got this thing printing a chess board with a standard chess piece configuration. I added quite a bit of code which makes me a little nervous. I had a lot of trouble figuring out how to test certain aspects because I needed to test that constructors were called with the correct arguments. I couldn't figure out a good way to test constructors, so I feel like some of the interfaces and code exist to make those parts testable (specifically in relation to adding pieces to the board)... Let me know if you have any questions. I can explain my decisions in detail.

I was anxious to see how piece targeting would work out so I started working on pawn targeting.

I'm not sure about the interface I created for piece targeting. I thought of a few different designs, and don't know if one is better than the others.

My first attempt is what I ended up staying with (for now), which you can see on github. I'm not sold on it. It only contains the methods needed for pawn right now, but I imagine when the other pieces are implemented it will look more like this:
```java
public interface ChessPieceTargeting {

	// Target paths with a limit
	void pathForward(final TargetingCount maxTargetingCount);
	void pathBackward(final TargetingCount maxTargetingCount);
	void pathLeft(final TargetingCount maxTargetingCount);
	void pathRight(final TargetingCount maxTargetingCount);
	void pathForwardLeft(final TargetingCount maxTargetingCount);
	void pathForwardRight(final TargetingCount maxTargetingCount);
	void pathBackwardLeft(final TargetingCount maxTargetingCount);
	void pathBackwardRight(final TargetingCount maxTargetingCount);
	// Target paths with no limit (go to edge of board)
	void pathForward();
	void pathBackward);
	void pathLeft();
	void pathRight();
	void pathForwardLeft();
	void pathForwardRight();
	void pathBackwardLeft();
	void pathBackwardRight();
	// Attacks
	void attackForwardRight();
	void attackForwardLeft();
	// etc.
}
```
As you can see this interface gives the pieces very granular control over their targeting choice, but the interface gets huge. Is this as bad as I think? Most of them are overloads, and so similar than many could be implemented in terms of each other. I also don't like that the pieces have to make multiple calls on the object in order to achieve their goal.

Then I had the idea to trim it down using some enum types:
```java
public enum RankDirection {

	FORWARD,
	BACKWARD;
}

public enum FileDirection {

	LEFT,
	RIGHT;
}

public interface ChessPieceTargeting {

	// Allows diagonal paths with limit
	void path(final RankDirection rankDirection, final FileDirection fileDirection,
		final TargetingCount maxTargetingCount);
	
	// Allows path through ranks with limit
	void path(final RankDirection rankDirection, final TargetingCount maxTargetingCount);
	
	// Allows path through files with limit
	void path(final FileDirection fileDirection, final TargetingCount maxTargetingCount);
	
	// The same with no limits (go to edge of board)
	void path(final RankDirection rankDirection, final FileDirection fileDirection);
	void path(final RankDirection rankDirection);
	void path(final FileDirection fileDirection);
	
	// Attacks
	void attack(final RankDirection rankDirection, final FileDirection fileDirection);
	// etc.
}
```
This removes some of the bulk of the interface, but now has these enums passed in that are obviously going to be used with conditional logic, and to me feels like it's assuming implementation details.

One question that's on my mind is: Does the number of methods in an interface matter if the methods are closely related, or should interfaces with lots of methods be viewed with suspicion?

Again, with this interface the objects have to make multiple calls to create their targeting pattern.

So now I'm wondering if these options are too granular and should be more direct in intent. They are chess pieces after all and this targeting interface is specifically for chess pieces.

Maybe something like this would be better? It only contains the targeting patterns that are used by chess pieces?
```java
public interface ChessPieceTargeting {

	// For use by the pawn
	void pathForward(final TargetingCount maxTargetingCount);
	
	void attackForwardLeft();
	
	void attackForwardRight();
	
	// For use by bishop
	void pathAttackDiagonals()
	
	// For use by Queen
	void pathAttackAll()
	
	// etc. for the various chess specific targeting styles
}
```
Or maybe something even more specific to chess pieces?
```java
public interface ChessPieceTargeting {

	// For use by the pawn
	void targetAsPawn(final boolean hasMoved);
	
	void targetAsQueen();
	
	void targetAsBishop();
	
	// etc. for the various chess specific targeting styles
}
```
This last one seems like it offers the greatest abstraction, but it seems a little strange. Then again, it's far less likely to change than the others I presented. When I look at this I start to see how the others force the pieces to describe "how to perform targeting", where this is more "what the piece wants to do" (how vs what). The more I think about it, I'm starting to think this last one might be best.

> In the context of the game what role is Targeting playing?
>
> Is it the way that you can find out of a move is valid?

A player would select a square occupied by one of his/her pieces. When the choose message is sent to the piece, Targeting is supposed to allow a chess piece to specify where it can go. Valid moves would be send to the `MovesReceiver` to be presented to the player. It's really a way to find out all of the valid moves that are available.

My intent was to make Targeting an interface for chess pieces allowing them to describe their ideal movements without actually having to worry about the state of the game and board.

> What you just said doesn't come across in the interface.
>
> Why not:
>
>```java
> interface AllowableMoves {
>   void describeMoves(MovesReceiver movesReceiver);
>}
>```
> Any piece can implement this interface

Are you suggesting something like this?

```java
public interface AllowableMoves {

	void describeMoves(MovesReceiver movesReceiver);
}

public interface Piece extends AllowableMoves {
	// Other Piece methods
}

public class ChessBoard {

	private MovesReceiver movesReceiver;

	public void chooseSquare(Square square) {
		// ...
		piece.describeMoves(movesReceiver);
	}
}
```

> YES. :)

That makes sense...

What about the chess pieces then? I can't figure out what messages they should send to do this?

> The messages they should send to the MovesReceiver?

Yes

I think I need to revisit some of my previous notions about the relationship between objects and interfaces.

> Interfaces define a clear role for the object to implement and help scope the role required by a method when passing an object.

Thank you. I haven't heard it put like that. There's a surprising amount to learn from that one statement. I had a chance to reflect on what you said and about the project in general, and I think I've identified where my confusion is coming from. Before I get into that, I should tell you that I think the design we originally had (that you had originally suggested) is a better choice. I'm going to revert some of my recent changes and try again.

The mistake I made is unconsciously associating the names of the interfaces and classes with their real life counterparts. For example, I've been comparing the `Board` interface to a real board. It was preventing me from believing that `sendMovesForTo(...)` makes sense because it doesn't make sense for a real chess board. That's why I ended up changing it to `choose(...)` on the `Board` interface. It makes sense to choose a square on a real board, but it's not the best choice for this program. I'm embarrassed, because I warned against making this exact mistake in a blog post two years ago. Software objects are not meant to be generalized, idealized versions of real objects, they are just named as such to make them familiar and easy to understand. I forgot this.

There are a lot of mental hurdles to jump over with OOP.

I've been working some more on trying to figure out how to implement the communication between pieces and the `MovesReceiver`. My motivation here is to design communication so the pieces don't have to ask about the state of the board. They describe the form of their movement (path or step), the direction(s), and how to deal with other pieces in the way. The `MovesReceiver` will coordinate in some way with the board to determine which of the moves meet the criteria and then have those valid moves displayed in some way.

I came up with two new solutions, but I'm not confident in either of them. At this point I'm completely stuck. I can't tell if I'm making things better or worse, or if I'm just spinning endlessly somewhere in the middle. I don't know where to go from here. 

You can see the first solution here: https://gist.github.com/TheSecretSquad/701cf1cd4143f5ab1458

It uses a builder pattern, but I'm not sold on it because:
1. I don't think it's East Oriented.
2. It's a pain to test because I have to create mocks for all of the returned builders, and I have to be very careful about which mocks are returned in order to not get false positives. (You can see a sample of the tests at the bottom of the gist)

The second solution is here: https://gist.github.com/TheSecretSquad/c7ce1a12615b6f1dc25c

I switched the builder to use functional parameters instead. The tests are a bit better, but I'm not sold on it because:
1. The only way to test it is to use argument captors and execute the consumers against mock objects. I don't know if this is a bad thing. It works, but should I be testing the messages of the arguments like that?
The only alternative to this would be to create classes for each of the consumers that the pieces pass, but that would create an explosion of classes (instead of verifying using argument captors I would verify that the parameter is a certain type). (You can see a sample of the tests at the bottom of the gist)
