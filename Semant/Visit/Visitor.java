package Semant.Visit;

/**
 * Visitor.java
 *
 *
 * Created: Thu Sep 23 14:18:50 2004
 *
 * @author <a href="mailto:brylow@elsinore.cs.purdue.edu">Dennis Brylow</a>
 * @version 1.0
 */

public interface Visitor
{
 
  
  
  public void visit(Semant.Absyn.Absyn a);
  public void visit(Semant.Absyn.AddExpr e);
  public void visit(Semant.Absyn.AndExpr e);
  public void visit(Semant.Absyn.ArrayExpr e);
  public void visit(Semant.Absyn.ArrayType e);
  public void visit(Semant.Absyn.AssignableExpr e);
  public void visit(Semant.Absyn.AssignStmt e);
  public void visit(Semant.Absyn.BinOpExpr e);
  public void visit(Semant.Absyn.BlockStmt e);
  public void visit(Semant.Absyn.BooleanType e);
  public void visit(Semant.Absyn.CallExpr e);
  public void visit(Semant.Absyn.ClassDecl e);
  public void visit(Semant.Absyn.DivExpr e);
  public void visit(Semant.Absyn.EqualExpr e);
  public void visit(Semant.Absyn.Expr e);
  public void visit(Semant.Absyn.FalseExpr e);
  public void visit(Semant.Absyn.FieldExpr e);
  public void visit(Semant.Absyn.Formal e);
  public void visit(Semant.Absyn.GreaterExpr e);
  public void visit(Semant.Absyn.IdentifierExpr e);
  public void visit(Semant.Absyn.IdentifierType e);
  public void visit(Semant.Absyn.IfStmt e);
  public void visit(Semant.Absyn.IntegerLiteral e);
  public void visit(Semant.Absyn.IntegerType e);
  public void visit(Semant.Absyn.LesserExpr e);
  public void visit(Semant.Absyn.MethodDecl e);
  public void visit(Semant.Absyn.MulExpr e);
  public void visit(Semant.Absyn.NegExpr e);
  public void visit(Semant.Absyn.NewArrayExpr e);
  public void visit(Semant.Absyn.NewObjectExpr e);
  public void visit(Semant.Absyn.NotEqExpr e);
  
  public void visit(Semant.Absyn.NullExpr e);
  public void visit(Semant.Absyn.OrExpr e);
  //public void visit(Semant.Absyn.PrintVisitor e);
  
  public void visit(Semant.Absyn.Program e);
  public void visit(Semant.Absyn.Stmt e);
  public void visit(Semant.Absyn.StringLiteral e);
  public void visit(Semant.Absyn.SubExpr e);
  public void visit(Semant.Absyn.ThisExpr e);
  public void visit(Semant.Absyn.ThreadDecl e);
  public void visit(Semant.Absyn.TrueExpr e);
  public void visit(Semant.Absyn.Type e);
  public void visit(Semant.Absyn.VarDecl e);
  public void visit(Semant.Absyn.VoidDecl e);
  public void visit(Semant.Absyn.WhileStmt e);
  public void visit(Semant.Absyn.XinuCallStmt e);
  public void visit(Semant.Absyn.XinuCallExpr e);
  
  public void visit(Semant.Types.ARRAY a);
	public void visit(Semant.Types.BOOLEAN a);
	public void visit(Semant.Types.CLASS a);
	public void visit(Semant.Types.FIELD a);
	public void visit(Semant.Types.FUNCTION a);
	public void visit(Semant.Types.INT a);
	public void visit(Semant.Types.NIL a);
	public void visit(Semant.Types.OBJECT a);
	public void visit(Semant.Types.RECORD a);
	public void visit(Semant.Types.STRING a);
	public void visit(Semant.Types.VOID a);
 

}// Visitor
