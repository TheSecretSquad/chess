package com.disalvo.chess;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChessBoardTest {

	private ChessBoard chessBoard;
	@Mock
	private BoardConsolePrinter boardConsoleWriter;
	@Mock
	private Piece piece;
	@Mock
	private PieceAtSquareConsumer pieceConsumer;
	@Mock
	private ChessConfiguration chessConfiguration;
	@Mock
	private MovesReceiver movesReceiver;
	@Mock
	private PieceChoiceContextFactory pieceTargetingFactory;
	@Mock
	private PieceTargeting pieceTargeting;
	
	@Before
	public void setUp() throws Exception {
		when(pieceTargetingFactory.createContext(any(Square.class), any(TargetSource.class), any(MovesReceiver.class))).thenReturn(pieceTargeting);
		chessBoard = new ChessBoard(boardConsoleWriter, movesReceiver, pieceTargetingFactory);
	}
	
	@Test
	public void shouldProvidePiecesToConsolePrinterWhenPrintingToConsole() {
		chessBoard.printToConsole();
		verify(boardConsoleWriter).printFrom(isA(PieceAtSquareProvider.class));
	}
	
	@Test
	public void shouldGivePieceToPieceConsumerIfOccupiedWhenProvidingPieceAtSquare() {
		chessBoard.placePieceAt(piece, Square.A1);
		chessBoard.providePieceAtSquareTo(Square.A1, pieceConsumer);
		verify(pieceConsumer).givePiece(piece);
	}
	
	@Test
	public void shouldReportNoPieceToPieceConsumerIfNotOccupiedWhenProvidingPieceAtSquare() {
		chessBoard.placePieceAt(piece, Square.A1);
		chessBoard.providePieceAtSquareTo(Square.B1, pieceConsumer);
		verify(pieceConsumer, never()).givePiece(any(Piece.class));
		verify(pieceConsumer).noPiece();
	}
	
	@Test
	public void shouldSetupWithChessConfigurationWhenSettingUp() {
		chessBoard.configureAs(chessConfiguration);
		verify(chessConfiguration).setup(chessBoard);
	}
	
	@Test
	public void shouldChoosePieceAtSquareWhenSquareChosen() {
		chessBoard.placePieceAt(piece, Square.A1);
		chessBoard.chooseSquare(Square.A1);
		verify(piece).choose(isA(PieceTargeting.class));
	}
}