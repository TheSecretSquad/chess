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
> The thing with the information is the Game, and Player can't be shown directly but indirectly via an Output mechanism which could be the command line or GUI.
> This disconnect between the input and output mechanism will influence the design which should be independent of it. For example:
>
> game showMovesForSquare: square On: output
>
> Notice how the names of the domain (Chess Game) are coming through, this helps focus and separates the what from the how.
>
> Thoughts?

I'm most comfortable with Java or C#. I've been writing this project with Java.

Your analysis is spot on. Your showMovesForSquare:On: message makes perfect sense to me. I know just enough Smalltalk syntax to understand it!

I agree that the output (the place where the game should send the moves) should be passed into the game, but how do you tell when it should be an argument to the message as opposed to the constructor?

I'm curious to see how we would implement this.

> I try to construct my objects w valid state and then not change it, so in this case you can pass the board and the output to the constructor, then 
> Game has the showMovesFor(Square selectedSquare) method (changed to Java code examples).
> I would have this delegate to a private method showMovesForOn(square, output)
> because I like to have dependencies for methods be obvious. This approach doesn't take much longer and it helps later w testing and expanding abilities.



