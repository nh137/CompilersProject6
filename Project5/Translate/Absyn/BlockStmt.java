package Translate.Absyn;

import java.util.LinkedList;

public class BlockStmt extends Stmt{

	public LinkedList<Stmt> stmts;
	public BlockStmt(LinkedList<Stmt> stmts){
		this.stmts = stmts;
		
		
	}
	
	public String toString()
	  {   return "";   }
	public Translate.Tree.Exp accept(Translate.Translate v) { return v.visit(this); }
	 public void accept(Semant.Visit.Visitor v)      {          v.visit(this);   }
	 public Semant.Types.Type accept(Semant.Visit.Visitor2 v) { return v.visit(this); }

	
}
