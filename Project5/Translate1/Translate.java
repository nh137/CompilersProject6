package Translate;
import Translate.*;
import Translate.Translate.*;
import Translate.Frame.*;
import Translate.Mips.*;
import Translate.Symbol.*;
import Translate.Tree.*;
/**
 * Visitor.java
 *
 *
 * Created: Thu Sep 23 14:18:50 2004
 *
 * @author <a href="mailto:brylow@elsinore.cs.purdue.edu">Dennis Brylow</a>
 * @version 1.0
 */

public class Translate
{
	Frame type;
	MipsFrame currFrame;
	ArrayList<Frag> frags;
	
	public Translate(Frame f){
		type = f;
	}
	
	public ArrayList<Frag> results(){
		return frags;
	}
 
  
  
  public Translate.Exp visit(Absyn.Absyn a){
  
  }
  public Translate.Exp visit(Absyn.AddExpr e){
  
  }
  public Translate.Exp visit(Absyn.AndExpr e){
  
  }
  public Translate.Exp visit(Absyn.ArrayExpr e){
  
  }
  public Translate.Exp  visit(Absyn.ArrayType e){
  
  }
  public Translate.Exp visit(Absyn.AssignableExpr e){
  
  }
  public Translate.Exp visit(Absyn.AssignStmt e){
  
  }
  public Translate.Exp visit(Absyn.BinOpExpr e){
  
  }
  public Translate.Exp visit(Absyn.BlockStmt e){
  
  }
  public Translate.Exp visit(Absyn.BooleanType e){
  
  }
  public Translate.Exp visit(Absyn.CallExpr e){
  
  }
  public Translate.Exp visit(Absyn.ClassDecl e){
		
  }
  public Translate.Exp visit(Absyn.DivExpr e){
  
  }
  public Translate.Exp visit(Absyn.EqualExpr e){
  
  }
  public Translate.Exp visit(Absyn.Expr e){
  
  }
  public Translate.Exp visit(Absyn.FalseExpr e){
  
  }
  public Translate.Exp visit(Absyn.FieldExpr e){
  
  }
  public Translate.Exp visit(Absyn.Formal e){
  
  }
  public Translate.Exp visit(Absyn.GreaterExpr e){
  
  }
  public Translate.Exp visit(Absyn.IdentifierExpr e){
		Access a = t.get(symbol(e.id));
		if(a instanceof InReg){
			return new Ex( new TEMP(((InReg)a).temp));
		}else{
		
			return new Ex(new MEM (new BINOP(BINOP.PLUS, new TEMP(currFrame.FP), CONST(((InFrame)a).FP))));
		}
  }
  public Translate.Exp visit(Absyn.IdentifierType e){
  
  }
  public Translate.Exp visit(Absyn.IfStmt e){
  
  }
  public Translate.Exp visit(Absyn.IntegerLiteral e){
  
  }
  public Translate.Exp visit(Absyn.IntegerType e){
  
  }
  public Translate.Exp visit(Absyn.LesserExpr e){
  
  }
  public Translate.Exp visit(Absyn.MethodDecl e){
  
  }
  public Translate.Exp visit(Absyn.MulExpr e){
  
  }
  public Translate.Exp visit(Absyn.NegExpr e){
  
  }
  public Translate.Exp visit(Absyn.NewArrayExpr e){
  
  }
  public Translate.Exp visit(Absyn.NewObjectExpr e){
  
  }
  public Translate.Exp visit(Absyn.NotEqExpr e){
  
  }
  
  public Translate.Exp visit(Absyn.NullExpr e){
  
  }
  public Translate.Exp visit(Absyn.OrExpr e){
  
  }
  
  
  public Translate.Exp visit(Absyn.Program e){
		for(ClassDecl c : e.classes){
			c.accept(e);
		}
	
  }
  public Translate.Exp visit(Absyn.Stmt e){
  
  }
  public Translate.Exp visit(Absyn.StringLiteral e){
  
  }
  public Translate.Exp visit(Absyn.SubExpr e){
  
  }
  public Translate.Exp visit(Absyn.ThisExpr e){
  
  }
  public Translate.Exp visit(Absyn.ThreadDecl e){
  
  }
  public Translate.Exp visit(Absyn.TrueExpr e){
  
  }
  public Translate.Exp visit(Absyn.Type e){
  
  }
  public Translate.Exp visit(Absyn.VarDecl e){
  
  }
  public Translate.Exp visit(Absyn.VoidDecl e){
  
  }
  public Translate.Exp visit(Absyn.WhileStmt e){
  
  }
  public Translate.Exp visit(Absyn.XinuCallStmt e){
  
  }
  public Translate.Expv isit(Absyn.XinuCallExpr e){
  
  }
  
  public Translate.Exp visit(Types.ARRAY a);
	public Translate.Exp visit(Types.BOOLEAN a);
	public Translate.Exp visit(Types.CLASS a);
	public Translate.Exp visit(Types.FIELD a);
	public Translate.Exp visit(Types.FUNCTION a);
	public Translate.Exp visit(Types.INT a);
	public Translate.Exp visit(Types.NIL a);
	public Translate.Exp  visit(Types.OBJECT a);
	public Translate.Exp visit(Types.RECORD a);
	public Translate.Exp visit(Types.STRING a);
	public Translate.Exp visit(Types.VOID a);
 

}// Visitor
