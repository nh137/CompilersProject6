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
	MipsFrame type;
	MipsFrame currFrame;
	ArrayList<Frag> frags;
	ClassDecl currClass;
	MethodDecl currMeth;
	Table tb;

	public Translator(MipsFrame f){
		type = f;
		frags = new ArrayList<Frag>();
		tb = new Table();
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
	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex( new BINOP(BINOP.AND, left, right)); 
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
	Translate.Tree.Exp left = e.lhs.accept(this).unEx();
	Translate.Tree.Exp right = e.rhs.accept(this).unEx();
	//Symbol table lookup? TODO
 	return new Nx(new MOVE(left,right)); 
  }
  public Translate.Translate.Exp visit(BinOpExpr e){
 return null; 
  }
  public Translate.Translate.Exp visit(BlockStmt e){
		//if (e.stmts.size() > 1)
		//return new Nx(new SEQ(e.stmts.get(0).accept(this).unEx(),sequenceSubTree(e.stmts,1))); 
		//else if (e.stmts.size() == 0)
		return null;
	}  
//public Translate.Tree.Exp sequenceSubTree(java.util.LinkedList<Stmt> list, int index)
	//{
	//	if (index < list.size()-1)
	//		return new SEQ(e.stmts.get(index).accept(this).unEx(),sequenceSubTree(list,index++));
	//	else
	//		return e.stmts.get(index).accept(this).unEx();
	//}
  public Translate.Translate.Exp visit(BooleanType e){
  	return new Ex(new CONST(0));
  }


public Translate.Translate.Exp visit(CallExpr e){
		Translate.Tree.Exp func = e.target.accept(this).unEx();
		java.util.ArrayList<Translate.Tree.Exp> argsList = new java.util.ArrayList<Translate.Tree.Exp>();
		for (int i=0;i<e.args.size();i++)
		{ argsList.add(e.args.get(i).accept(this).unEx()); }
		return new Ex(new CALL(func,argsList)); 
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
	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex(new BINOP(BINOP.AND, left, right)); 
  }
  public Translate.Translate.Exp visit(Expr e){
 return null; 
  }
  public Translate.Translate.Exp visit(FalseExpr e){
 return new CONST(0); 
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
//TODO
	currFrame.formals = new ArrayList<Access>();
 return null; 
  }
  public Translate.Translate.Exp visit(GreaterExpr e){
	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex(new CJUMP(CJUMP.GT, left, right, new Label(), new Label()));
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
		//Label tr = new Label();
		//Label fl = new Label();
		//Label join = new Label();

		//return new Nx(new SEQ(new CJUMP(CJUMP.EQ,e.test1.accept(this).unEx(),new CONST(1),tr,fl), 
		//	new SEQ(new LABEL(fl), new SEQ(e.elseStmt.accept(this).unNx(), new SEQ(new JUMP(join)))
		//		))); 
		//return new IfThenElse();
		return null;
	}
	public Translate.Translate.Exp visit(IntegerLiteral e){
		return new Ex(new CONST(e.value));

	}
	public Translate.Translate.Exp visit(IntegerType e){
		return null;
	}
	public Translate.Translate.Exp visit(LesserExpr e){
		return null; 
	}
	public Translate.Translate.Exp visit(MethodDecl e){
		currMeth = e;
		Translate.Tree.Stm varStms = null;
		Translate.Tree.Stm bodyStms = null;
		if(e.name.equals("main")){
			currFrame = (MipsFrame)type.newFrame(new Label(e.name), e.params.size());
		}else{
			currFrame = (MipsFrame)type.newFrame(new Label(currClass.name + "." + e.name), e.params.size());
		}
		
		for(int i = 0; i < e.params.size(); i++){
			tb.put(e.params.get(i).name, currFrame.allocFormal(false));
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
		if(e.name.equals("main")){
			bodyStms = new SEQ(bodyStms, new MOVE(new TEMP(currFrame.regs.get(2).temp), new CONST(0)));
		}else{
			//uhhh
		}
		

		frags.add(new ProcFrag(bodyStms, currFrame));

		return null;


	}
	public Translate.Translate.Exp visit(MulExpr e){
		Translate.Tree.Exp left = e.e1.accept(this).unEx();
		Translate.Tree.Exp right = e.e2.accept(this).unEx();
		return new Ex( new BINOP(BINOP.MUL, left, right));

	}
	public Translate.Translate.Exp visit(NegExpr e){
 		return new Ex(e.e1.accept(this)); 
  	}
	public Translate.Translate.Exp visit(NewArrayExpr e){
		return null; 
	}
	public Translate.Translate.Exp visit(NewObjectExpr e){
		return null; 
	}
	public Translate.Translate.Exp visit(NotEqExpr e){
  	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex( new CJUMP(CJUMP.NE, left, right));
  }

	public Translate.Translate.Exp visit(NullExpr e){
		return null; 
	}
	public Translate.Translate.Exp visit(OrExpr e){
  	Translate.Tree.Exp left = e.e1.accept(this).unEx();
	Translate.Tree.Exp right = e.e2.accept(this).unEx();
	return new Ex( new BINOP(BINOP.OR, left, right)); 
  }
  

<<<<<<< HEAD
 
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
	Label l = new Label();
	String s = e.value;
	Translate.Translate.DataFrag dfrag = new Translate.Translate.DataFrag(s,l);
	frags.add(dfrag);
 	return new LABEL(l); 
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
 return new CONST(1); 
  }
 
 public Translate.Translate.Exp visit(VarDecl e){
		InReg r = (InReg)currFrame.allocLocal(false);
		tb.put(e.name, r);
		if(e.init == null){
			return new Nx(new MOVE(new TEMP(r.temp), new CONST(0)));
		}
		
		return new Nx(new MOVE(new TEMP(r.temp), e.init.accept(this).unEx()));
		 
	}
  public Translate.Translate.Exp visit(VoidDecl e){
 return null; 
  }
  public Translate.Translate.Exp visit(WhileStmt e){
	Translate.Tree.Exp tstStm = e.test.accept(this);
	Translate.Tree.Exp bodyStm = e.body.accept(this);
 	//return new Nx(); 
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
		//Label cname = new Label(a.name);
		String s = a.name;
		Translate.Translate.DataFrag dfrag = new Translate.Translate.DataFrag(s);
		for(FIELD f: a.methods.fields){
			dfrag.flist.add(((FUNCTION)f.type));
		}
		frags.add(dfrag);
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
