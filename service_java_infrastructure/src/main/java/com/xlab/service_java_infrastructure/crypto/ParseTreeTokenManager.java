/*
 * module: fundermental
 * file: ParseTreeTokenManager.java
 * date: 3/15/19 4:48 PM
 * author: VectorJu
 */

/* ParseTreeTokenManager.java */
/* Generated By:JJTree&JavaCC: Do not edit this line. ParseTreeTokenManager.java */
package com.xlab.service_java_infrastructure.crypto;

/** Token Manager. */
@SuppressWarnings("unused")public class ParseTreeTokenManager implements ParseTreeConstants {

  /** Debug output. */
  public  java.io.PrintStream debugStream = System.out;
  /** Set debug output. */
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0){
   switch (pos)
   {
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0){
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0), pos + 1);
}
private int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private int jjMoveStringLiteralDfa0_0(){
   switch(curChar)
   {
      case 13:
         jjmatchedKind = 4;
         return jjMoveStringLiteralDfa1_0(0x20L);
      case 40:
         return jjStopAtPos(0, 23);
      case 41:
         return jjStopAtPos(0, 24);
      case 44:
         return jjStopAtPos(0, 9);
      case 59:
         return jjStopAtPos(0, 22);
      case 126:
         return jjStopAtPos(0, 25);
      default :
         return jjMoveNfa_0(2, 0);
   }
}
private int jjMoveStringLiteralDfa1_0(long active0){
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0);
      return 1;
   }
   switch(curChar)
   {
      case 10:
         if ((active0 & 0x20L) != 0L)
            return jjStopAtPos(1, 5);
         break;
      default :
         break;
   }
   return jjStartNfa_0(0, active0);
}
private int jjMoveNfa_0(int startState, int curPos)
{
   int startsAt = 0;
   jjnewStateCnt = 25;
   int i = 1;
   jjstateSet[0] = startState;
   int kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0x3ff000000000000L & l) != 0L)
                  {
                     if (kind > 17)
                        kind = 17;
                     { jjCheckNAddStates(0, 2); }
                  }
                  else if ((0x7000000000000000L & l) != 0L)
                  {
                     if (kind > 10)
                        kind = 10;
                  }
                  else if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 13;
                  if (curChar == 60)
                     { jjCheckNAdd(6); }
                  else if (curChar == 62)
                     { jjCheckNAdd(6); }
                  break;
               case 6:
                  if (curChar == 61 && kind > 10)
                     kind = 10;
                  break;
               case 7:
                  if (curChar == 62)
                     { jjCheckNAdd(6); }
                  break;
               case 8:
                  if (curChar == 60)
                     { jjCheckNAdd(6); }
                  break;
               case 9:
                  if ((0x7000000000000000L & l) != 0L && kind > 10)
                     kind = 10;
                  break;
               case 11:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  jjstateSet[jjnewStateCnt++] = 11;
                  break;
               case 12:
                  if (curChar == 45)
                     jjstateSet[jjnewStateCnt++] = 13;
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  { jjCheckNAddTwoStates(14, 16); }
                  break;
               case 14:
                  if ((0x500000000000L & l) == 0L)
                     break;
                  kind = 18;
                  { jjCheckNAdd(15); }
                  break;
               case 15:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  { jjCheckNAdd(15); }
                  break;
               case 16:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 18)
                     kind = 18;
                  { jjCheckNAddStates(3, 5); }
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  { jjCheckNAddStates(0, 2); }
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 17)
                     kind = 17;
                  { jjCheckNAdd(24); }
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((0x7fffffe07fffffeL & l) != 0L)
                  {
                     if (kind > 16)
                        kind = 16;
                     { jjCheckNAdd(11); }
                  }
                  if (curChar == 79)
                     { jjAddStates(6, 7); }
                  else if (curChar == 111)
                     { jjAddStates(8, 9); }
                  else if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 4;
                  else if (curChar == 97)
                     jjstateSet[jjnewStateCnt++] = 1;
                  break;
               case 0:
                  if (curChar == 100 && kind > 7)
                     kind = 7;
                  break;
               case 1:
                  if (curChar == 110)
                     jjstateSet[jjnewStateCnt++] = 0;
                  break;
               case 3:
                  if (curChar == 68 && kind > 7)
                     kind = 7;
                  break;
               case 4:
                  if (curChar == 78)
                     jjstateSet[jjnewStateCnt++] = 3;
                  break;
               case 5:
                  if (curChar == 65)
                     jjstateSet[jjnewStateCnt++] = 4;
                  break;
               case 10:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  { jjCheckNAdd(11); }
                  break;
               case 11:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 16)
                     kind = 16;
                  { jjCheckNAdd(11); }
                  break;
               case 17:
                  if (curChar == 111)
                     { jjAddStates(8, 9); }
                  break;
               case 18:
                  if (curChar == 114 && kind > 6)
                     kind = 6;
                  break;
               case 19:
                  if (curChar == 102 && kind > 8)
                     kind = 8;
                  break;
               case 20:
                  if (curChar == 79)
                     { jjAddStates(6, 7); }
                  break;
               case 21:
                  if (curChar == 82 && kind > 6)
                     kind = 6;
                  break;
               case 22:
                  if (curChar == 70 && kind > 8)
                     kind = 8;
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         do
         {
            switch(jjstateSet[--i])
            {
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 25 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   24, 14, 16, 14, 15, 16, 21, 22, 18, 19, 
};

/** Token literal values. */
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, "\54", null, null, null, 
null, null, null, null, null, null, null, null, null, "\73", "\50", "\51", "\176", };
protected Token jjFillToken()
{
   final Token t;
   final String curTokenImage;
   final int beginLine;
   final int endLine;
   final int beginColumn;
   final int endColumn;
   String im = jjstrLiteralImages[jjmatchedKind];
   curTokenImage = (im == null) ? input_stream.GetImage() : im;
   beginLine = input_stream.getBeginLine();
   beginColumn = input_stream.getBeginColumn();
   endLine = input_stream.getEndLine();
   endColumn = input_stream.getEndColumn();
   t = Token.newToken(jjmatchedKind, curTokenImage);

   t.beginLine = beginLine;
   t.endLine = endLine;
   t.beginColumn = beginColumn;
   t.endColumn = endColumn;

   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

/** Get the next Token. */
public Token getNextToken() 
{
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {
   try
   {
      curChar = input_stream.BeginToken();
   }
   catch(Exception e)
   {
      jjmatchedKind = 0;
      jjmatchedPos = -1;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   try { input_stream.backup(0);
      while (curChar <= 32 && (0x100000600L & (1L << curChar)) != 0L)
         curChar = input_stream.BeginToken();
   }
   catch (java.io.IOException e1) { continue EOFLoop; }
   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

private void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}

private void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}

    /** Constructor. */
    public ParseTreeTokenManager(SimpleCharStream stream){

      if (SimpleCharStream.staticFlag)
            throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");

    input_stream = stream;
  }

  /** Constructor. */
  public ParseTreeTokenManager (SimpleCharStream stream, int lexState){
    ReInit(stream);
    SwitchTo(lexState);
  }

  /** Reinitialise parser. */
  public void ReInit(SimpleCharStream stream)
  {
	
    jjmatchedPos = jjnewStateCnt = 0;
    curLexState = defaultLexState;
    input_stream = stream;
    ReInitRounds();
  }

  private void ReInitRounds()
  {
    int i;
    jjround = 0x80000001;
    for (i = 25; i-- > 0;)
      jjrounds[i] = 0x80000000;
  }

  /** Reinitialise parser. */
  public void ReInit( SimpleCharStream stream, int lexState)
  {
  
    ReInit( stream);
    SwitchTo(lexState);
  }

  /** Switch to specified lex state. */
  public void SwitchTo(int lexState)
  {
    if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
    else
      curLexState = lexState;
  }

/** Lexer state names. */
public static final String[] lexStateNames = {
   "DEFAULT",
};
static final long[] jjtoToken = {
   0x3c707c1L, 
};
static final long[] jjtoSkip = {
   0x3eL, 
};
    protected SimpleCharStream  input_stream;

    private final int[] jjrounds = new int[25];
    private final int[] jjstateSet = new int[2 * 25];

    
    protected int curChar;
}
