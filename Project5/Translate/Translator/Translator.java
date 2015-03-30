package Translate.Translator;
import Translate.Absyn.*;
import Translate.Types.*;
import Translate.Translate.*;
import Translate.Frame.*;
import Translate.Mips.*;
import Translate.Symbol.*;
import Translate.Tree.*;
import Translate.Temp.*;
import Translate.Symbol.*;
import Translate.*;
import java.util.*;
public class Translator
{
	Frame type;
	MipsFrame currFrame;
	ArrayList<Frag> frags;
	ClassDecl currClass;
	MethodDecl currMeth;
	Table tb;
	
	public Translator(Frame f){
		type = f;
	}
	
	public ArrayList<Frag> results(){
		return frags;
	}
 
  
  
  public Translate.Translate.Exp visit(Absyn a){
 return null; 
  }
  public Translate.Translate.Exp visit(AddExpr e){
  	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex(new BINOP(BINOP.PLUS, left, right));
	
  }
  public Translate.Translate.Exp visit(AndExpr e){
  	//if else stuff
	  return null;
  }
  public Translate.Translate.Exp visit(ArrayExpr e){
  	Translate.Tree.Exp left = e.target.accept(this).unEx();
	Translate.Tree.Exp right = e.index.accept(this).unEx();
	return new Ex(new BINOP(BINOP.PLUS, left, right));

  }
  public Translate.Translate.Exp  visit(ArrayType e){
  	return new Ex(new CONST(0));
  }
  public Translate.Translate.Exp visit(AssignableExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(AssignStmt e){
 return null; 
  }
  public Translate.Translate.Exp visit(BinOpExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(BlockStmt e){
 return null; 
  }
  public Translate.Translate.Exp visit(BooleanType e){
  	return new Ex(new CONST(0));
  }
  public Translate.Translate.Exp visit(CallExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(ClassDecl e){
	//checktype, should make datafrag from instance
	currClass = e;
	e.checktype.accept(this);

	for(MethodDecl m : e.methods){
		m.accept(this);
	}
	return null;
	
  }
  public Translate.Translate.Exp visit(DivExpr e){
  	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex(new BINOP(BINOP.DIV, left, right));

  }
  public Translate.Translate.Exp visit(EqualExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(Expr e){
 return null; 
  }
  public Translate.Translate.Exp visit(FalseExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(FieldExpr e){
	int index = e.typeIndex;
	Translate.Tree.Exp exp = e.target.accept(this).unEx();
	Label bad = currFrame.badPtr();
	Label ok = new Label();
	Temp result = new Temp();
	return new Ex(new ESEQ(new SEQ( new MOVE(new TEMP(result), exp), new CJUMP(0, new TEMP(result), new CONST(0),
	bad, ok))
	, new ESEQ(new LABEL(ok), new MEM(new BINOP(0,new TEMP(result), new CONST(index*currFrame.wordsize()))))));
  }
  public Translate.Translate.Exp visit(Formal e){
 return null; 
  }
  public Translate.Translate.Exp visit(GreaterExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(IdentifierExpr e){
		Access a = (Access)tb.get(e.id);
		if(a instanceof InReg){
			return new Ex( new TEMP(((InReg)a).temp));
		}else{
		
			return new Ex(new MEM (new BINOP(0, new TEMP(currFrame.FP), new CONST(((InFrame)a).offset))));
		}
  }
  public Translate.Translate.Exp visit(IdentifierType e){
  	return new Ex(new CONST(0));
  }
  public Translate.Translate.Exp visit(IfStmt e){
 return null; 
  }
  public Translate.Translate.Exp visit(IntegerLiteral e){
 return null; 
  }
  public Translate.Translate.Exp visit(IntegerType e){
  	return new Ex(new CONST(e.value));
  }
  public Translate.Translate.Exp visit(LesserExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(MethodDecl e){
  	currMeth = e;
	Translate.Tree.Stm varStms = null;
	Translate.Tree.Stm bodyStms = null;
	if(e.name.equals("main")){
		currFrame = new MipsFrame(new Label(e.name), e.params.size());
	}else{
		currFrame = new MipsFrame(new Label(currClass.name + "." + e.name), e.params.size());
	}
	//This should add the list of formals and actuals
	e.checktype.accept(this);
	if(e.locals.size() != 0){
		varStms = e.locals.get(0).accept(this).unNx();
		for(int i = 1; i < e.locals.size(); i++){
			varStms = new SEQ(varStms, e.locals.get(i).accept(this).unNx());
		}

	}

	if(e.stmts.size() != 0){
		if(varStms == null){
			bodyStms = e.stmts.get(0).accept(this).unNx();
		}else{
			bodyStms = new SEQ(varStms, e.stmts.get(0).accept(this).unNx());
		}
		
		for(int i = 1; i < e.stmts.size(); i++){
			bodyStms = new SEQ(bodyStms , e.stmts.get(i).accept(this).unNx());
		}

	}

	if(varStms == null && bodyStms == null){
		//dont know what to do here
	}

	frags.add(new ProcFrag(varStms, currFrame));

	return null;
	
	
  }
  public Translate.Translate.Exp visit(MulExpr e){
  	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex( new BINOP(BINOP.MUL, left, right));

  }
  public Translate.Translate.Exp visit(NegExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(NewArrayExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(NewObjectExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(NotEqExpr e){
 return null; 
  }
  
  public Translate.Translate.Exp visit(NullExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(OrExpr e){
 return null; 
  }
  
  
  public Translate.Translate.Exp visit(Program e){
		for(ClassDecl c : e.classes){
			c.accept(this);
		}
		return null;
	
  }
  public Translate.Translate.Exp visit(Stmt e){
 return null; 
  }
  public Translate.Translate.Exp visit(StringLiteral e){
 return null; 
  }
  public Translate.Translate.Exp visit(SubExpr e){
  	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex(new BINOP(BINOP.MINUS, left, right));

  }
  public Translate.Translate.Exp visit(ThisExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(ThreadDecl e){
 return null; 
  }
  public Translate.Translate.Exp visit(TrueExpr e){
 return null; 
  }
 
  public Translate.Translate.Exp visit(VarDecl e){
 return null; 
  }
  public Translate.Translate.Exp visit(VoidDecl e){
 return null; 
  }
  public Translate.Translate.Exp visit(WhileStmt e){
 return null; 
  }
  public Translate.Translate.Exp visit(XinuCallStmt e){
 return null; 
  }
  public Translate.Translate.Exp visit(XinuCallExpr e){
 return null; 
  }
  
  public Translate.Translate.Exp visit(ARRAY a){
 return null; 
  }

	public Translate.Translate.Exp visit(BOOLEAN a){
 return null; 
  }

	public Translate.Translate.Exp visit(CLASS a){
 return null; 
  }

	public Translate.Translate.Exp visit(FIELD a){
 return null; 
  }

	public Translate.Translate.Exp visit(FUNCTION a){
 return null; 
  }

	public Translate.Translate.Exp visit(INT a){
 return null; 
  }

	public Translate.Translate.Exp visit(NIL a){
 return null; 
  }

	public Translate.Translate.Exp  visit(OBJECT a){
 return null; 
  }

	public Translate.Translate.Exp visit(RECORD a){
 return null; 
  }

	public Translate.Translate.Exp visit(STRING a){
 return null; 
  }

	public Translate.Translate.Exp visit(VOID a){
 return null; 
  }

 

}// Visitor