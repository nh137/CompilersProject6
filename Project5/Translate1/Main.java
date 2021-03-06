package Semant;
import Semant.Types.*;
import Semant.Symbol.*;
public class Main {
	
	public static Table tb;
	
	public static void main(String[] args)
 {
    Semant.Absyn.Program pm = null;
    java.util.LinkedList c = null;
	
    try
      {
        java.io.FileReader reader = new java.io.FileReader(args[0]);
        pm = new ReadAbsyn(reader).Program();
      }
    catch (java.io.IOException e)
      {
        System.err.println(e.toString());
      }
    catch (ParseException p)
      {
        System.out.println(p.toString());
        System.exit(-1);
      }
    
    tb = new Table();
    
    
    java.util.LinkedList<FIELD> f = new java.util.LinkedList<FIELD>();
    FIELD print = new FIELD( new FUNCTION(Symbol.symbol("print"),null, null, null), 0, Symbol.symbol("print"));
    FIELD println = new FIELD( new FUNCTION(Symbol.symbol("println"),null, null, null), 0, Symbol.symbol("println"));
    FIELD printint = new FIELD( new FUNCTION(Symbol.symbol("printint"),null, null, null), 0, Symbol.symbol("printint"));
    FIELD readint = new FIELD( new FUNCTION(Symbol.symbol("readint"),null, null, null), 0, Symbol.symbol("readint"));
    FIELD threadCreate = new FIELD( new FUNCTION(Symbol.symbol("threadCreate"),null, null, null), 0, Symbol.symbol("threadCreate"));
    FIELD yield = new FIELD( new FUNCTION(Symbol.symbol("yield"),null, null, null), 0, Symbol.symbol("yield"));
    FIELD sleep = new FIELD( new FUNCTION(Symbol.symbol("sleep"),null, null, null), 0, Symbol.symbol("sleep"));
    f.add(print);
    f.add(println);
    f.add(printint);
    f.add(readint);
    f.add(threadCreate);
    f.add(yield);
    f.add(sleep);
    RECORD xinuMethods = new RECORD();
	//xinuMethods.fields = f;
    for(FIELD field : f){
    	xinuMethods.put(field, field.name);
    }
    CLASS xinu = new CLASS(Symbol.symbol("Xinu"));
    xinu.methods = xinuMethods;
    xinu.parent = null;
    xinu.fields = null;
    xinu.instance = null;
    
    CLASS thread = new CLASS(Symbol.symbol("Thread"));
    xinu.methods = null;
    xinu.parent = null;
    xinu.fields = null;
    xinu.instance = null;
    tb.put(xinu.name, xinu);
    tb.put(thread.name, thread);
    boolean error = false;
    java.util.LinkedList<String> classNames = new java.util.LinkedList<String>();
    //CLASSES, DUPLICATES
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	//CLASS c1 = convertClassDecl(cd);
    	CLASS c1 = new CLASS(Symbol.symbol(cd.name));
    	for(String s : classNames){
    		if(s.equals(cd.name)){
    			//Error print
    			System.out.println("ERROR duplicate class: " + cd.name + ": line not available");
    			error = true;
    			//return;
    		}
    	}
    	classNames.add(cd.name);
    	//CLASS c1 = new CLASS(Symbol.symbol(cd.name));
   
    	c1.methods = null;
    	
    	c1.fields = null;
    	c1.parent = null;
    	c1.instance = null;
    	tb.put(c1.name, c1);
    }
    
    if(error == true){
    	return;
    }
    //BUILD PARENTS
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
    	if(cd.parent == null){
    		
    	}else{
    		CLASS p1 = (CLASS)tb.get(Symbol.symbol(cd.parent));
        	
        	if(p1 == null){
        		//print error cannot resolve parent class
        		System.out.println("ERROR cannot resolve parent class: "+cd.parent + ": line not available");
        		error = true;
        	}else{
        		c1.parent = p1;
        	    		
        	}    	
        	//OBJECT instance = new OBJECT(c1, );
        	RECORD methods = new RECORD();
        	for(Semant.Absyn.MethodDecl md : cd.methods){
        		RECORD formals = new RECORD();
        		for(int i = 0; i < md.params.size(); i++){
        			Semant.Absyn.Formal form = md.params.get(i);
        			tb.put(Semant.Symbol.Symbol.symbol(form.name), form.type);
				//formals.fields.add(new FIELD(form.type,i,Semant.Symbol.Symbol.symbol(form.name)));
        		}
        		methods.put(new FUNCTION(Symbol.symbol(md.name),null, new RECORD(), null), Symbol.symbol(md.name));
        		
        	}
      
        	RECORD fields = new RECORD();
        	for(Semant.Absyn.VarDecl vd : cd.fields){
        		fields.put(null, Symbol.symbol(vd.name));
        	}
        	c1.methods = methods;
        	
        	c1.fields = fields;
    	}
    	
    	
    }
    
    if(error == true){
    	return;
    }
    
    
    
    //CHECK FOR CYCLE
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
    //String ogClassName = cd.name;
    java.util.ArrayList<String> names = new java.util.ArrayList<String>();
    names.add(cd.name);
    if(cd.parent == null){
     
    }else{
    java.util.Stack<CLASS> stack= new java.util.Stack<CLASS>();
    CLASS p1 = (CLASS)tb.get(Symbol.symbol(cd.parent));
    boolean nocycle = true;
        while(p1.parent != null && nocycle){
        stack.push(p1);
        //System.out.println(p1.name.toString() + " ==?" + ogClassName);
       
        for(String s : names){
        if(p1.name.toString().equals(s)){
        System.out.println("ERROR cyclic inheritence involving "+ cd.name + ": line not available");
            error = true;
            nocycle = false;
            break;
        }
        }
        names.add(p1.name.toString());
       
       
        p1 = (CLASS)tb.get(p1.parent.name);
        }
        OBJECT o = new OBJECT(c1);
        while(!stack.empty()){
        	p1 = stack.pop();
        	for(FIELD fe: p1.fields){
        		o.fields.put(fe, fe.name);
        	}
        	for(FIELD fe: p1.methods){
        		o.methods.put(fe, fe.name);
        	}
        }
       
        c1.instance = o;
       
    }
   
    }
    
    for(Semant.Absyn.ClassDecl cd : pm.classes){
    	CLASS c1 = (CLASS)tb.get(Symbol.symbol(cd.name));
    }
    
    
	


    // Print Visitor
    //     System.out.println("Input String:");
    //         Visit.PrintVisitor pv = new Visit.PrintVisitor();
    //             pv.visit(g);
    //                 System.out.println();
    //                    System.out.println();
    
    //                         System.out.println("Abstract Syntax Tree:");
           //Semant.Visit.AbsynPrintVisitor apv = new Semant.Visit.AbsynPrintVisitor();
            //apv.visit(pm);
	//Semant.Visit.TypeVisitor cv = new Semant.Visit.TypeVisitor();
	//cv.setTable(tb);
	//cv.visit(pm);
     //       System.out.println();
     //       System.out.println();
    //        System.out.println("Interpreter:");
    //        Visit.Interpreter interp = new Visit.Interpreter();
           // System.out.println(interp.visit(g));
    }
	
	//public static parent merge
 //Main

/*
static CLASS convertClassDecl(Semant.Absyn.ClassDecl cd)
{
	tb.beginScope();
	CLASS c = new CLASS(Symbol.symbol(cd.name));
	c.fields = new RECORD();
	c.fields = createFieldRECORD(cd.fields);
	c.methods = new RECORD();
	c.methods = createMethodRECORD(cd.methods, c);
	if (cd.parent != null)
		c.parent = new CLASS(Symbol.symbol(cd.parent));
	else
		c.parent = null;
	c.instance = createOBJECT(c);
	tb.endScope();
	return c;
}

static OBJECT createOBJECT(CLASS c)
{
	OBJECT o = new OBJECT(c);
	return o;
}

static RECORD createFieldRECORD(java.util.LinkedList<Semant.Absyn.VarDecl> fields)
{
	RECORD f = new RECORD();
	for (int i = 0; i < fields.size(); i++){
		if (typecheck(fields.get(i))){
			tb.put(Symbol.symbol(fields.get(i).name),fields.get(i));
			f.fields.add(createFieldsFIELD(fields.get(i),i));
		}
		else
			System.exit(0);
	}
	return f;
}

static boolean typecheck(Semant.Absyn.VarDecl field)
{
	if(returnVarDeclTYPE(field).coerceTo(returnExprType(field.init)))
		return true;
	else
		return false;
}

static Type returnVarDeclTYPE(Semant.Absyn.VarDecl field)
{
	if (field.type instanceof Semant.Absyn.ArrayType)
		return returnARRAYTYPE(field.type);
	else if (field.type instance of Semant.Absyn.IdentifierType)
		return OBJECT;
	else if (field.type instanceof Semant.Absyn.BooleanType)
		return BOOLEAN;
	else
		return INT;	
}

static Type returnARRAYTYPE(Semant.Absyn.ArrayType array)
{
	if (array.type instanceof Semant.Absyn.IdentifierType)
		return new OBJECT;
	else if (array.type instanceof Semant.Absyn.BooleanType)
		return BOOLEAN;
	else
		return INT;
}

static Type returnExprType(Semant.Absyn.Expr varexpr)
{
	if (varexpr instanceof Semant.Abysn.NullExpr)
		return new NIL();
	else if (varexpr instanceof Semant.Absyn.AddExpr){
		if (typecheckAddExpr((Semant.Absyn.AddExpr) varexpr))
			return new INT();
		else 
			return System.exit(0);
	}
	//	return typecheckAddExpr((Semant.Absyn.AddExpr) varexpr);
	else if (varexpr instanceof Semant.Absyn.AndExpr)
		return typecheckAndExpr((Semant.Absyn.AndExpr) varexpr);
	else if (varexpr instanceof Semant.Absyn.ArrayExpr)
		return returnARRAYTYPE((Semant.Absyn.ArrayExpr) varexpr);
	else if (varexpr instanceof Semant.Absyn.AssignableExpr)
		return typecheckAssignableExpr((Semant.Absyn.AssignableExpr) varexpr);
	else if (varexpr instanceof Semant.Absyn.BinOpExpr)//shouldn't really reach this
		return returnBinOpType((Semant.Absyn.BinOpExpr) varexpr);
	else if (varexpr instanceof Semant.Abysn.CallExpr)
		return typecheckCallExpr((Semant.Absyn.CallExpr) varexpr);
	else if (varexpr instanceof Semant.Absyn.DivExpr)
		return typecheckDivExpr((Semant.Abysn.DivExpr) varexpr);
	else if (varexpr instanceof Semant.Abysn.EqualExpr)
		return typecheckEqualExpr((Semant.Absyn.EqualExpr) varexpr);
	else if (varexpr instanceof Semant.Abysn.FalseExpr)
		return new BOOLEAN();
	else if (varexpr instanceof Semant.Abysn.FieldExpr)
		return typecheckFieldExpr((Semant.Abysn.FieldExpr) varexpr);
	else if (varexpr instanceof Semant.Absyn.GreaterExpr)
		return typecheckGreaterExpr((Semant.Absyn.GreaterExpr) varexpr);
	else if (varexpr instanceof Semant.Abysn.IdentifierExpr)
		return typecheckIdentfierExpr((Semant.Abysn.IdentifierExpr) varexpr);
	else if (varexpr instanceof Semant.Abysn.IntegerLiteral)
		return new INT();
	else if (varexpr instanceof Semant.Abysn.LesserExpr)
		return typecheckLesserExpr((Semant.Abysn.LesserExpr) varexpr);
	else if 
}

static boolean typecheckAddExpr(Semant.Absyn.AddExpr add)
{
	if(returnExprType(add.e1).coerceTo(returnExprType(add.e2)) && returnExprType(add.e2).coerceTo(returnExprType(add.e1)))
		return true;
	else 
		{
		System.out.println("ERROR operator + cannot be applied to " + returnExprType(add.e1).toString() + ", " + returnExprType(add.e2).toString()
			+ "found\n" + Semant.Visit.AbsynPrintVisitor.visit(add) );
		return false;
		}
}

static boolean typecheckAndExpr(Semant.Abysn.AndExpr and)
{
	if(returnExprType(and.e1).coerceTo(returnExprType(and.e2)) && returnExprType(and.e2).coerceTo(returnExprType(and.e1)))
		return true;
	else{
		System.out.println("ERROR operator && cannot be applied to " + returnExprType(and.e1).toString() + ", " + returnExprType(and.e2).toString()
			+ "found\n" + Semant.Visit.AbsynPrintVisitor.visit(and.e2) );
		return false;
	}
}

static RECORD createMethodRECORD(java.util.LinkedList<Semant.Absyn.MethodDecl> methods, CLASS c)
{
	RECORD m = new RECORD();
	for (int i = 0; i < methods.size(); i++)
		m.fields.add(createMethodsFIELD(methods.get(i),i, c));
	return m;
}

static FIELD createFieldsFIELD(Semant.Absyn.VarDecl vd, int index)
{
	if (vd.type instanceof Semant.Absyn.ArrayType)
		return new FIELD(createARRAY(vd ,index),index,Symbol.symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.BooleanType)
		return new FIELD(new BOOLEAN(),index,Symbol.symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.IdentifierType)
		return new FIELD(new OBJECT(new CLASS(Symbol.symbol(vd.name))),index,Symbol.symbol(vd.name));
	else if (vd.type instanceof Semant.Absyn.IntegerType)
		return new FIELD(new INT(),index,Symbol.symbol(vd.name));
	else
		return null;
}

static ARRAY createARRAY(Semant.Absyn.VarDecl vd, int index)
{
	if (vd.type instanceof Semant.Absyn.BooleanType)
		return new ARRAY(new BOOLEAN());
	else if (vd.type instanceof Semant.Absyn.IdentifierType)
		return new ARRAY(new OBJECT(new CLASS(Symbol.symbol(vd.name))));
	else if (vd.type instanceof Semant.Absyn.IntegerType)
		return new ARRAY(new INT());
	else
		return null;
}

static FIELD createMethodsFIELD(Semant.Absyn.MethodDecl md, int index, CLASS c)
{
	if (md.returnType != null)
		return new FIELD(new FUNCTION(Symbol.symbol(md.name), c, createFormalRECORD(md.params), createType(md.returnType)),index,Symbol.symbol(md.name));
	else
		return null;
}


static RECORD createFormalRECORD(java.util.LinkedList<Semant.Absyn.Formal> formals)
{
	RECORD f = new RECORD();
	for (int i = 0; i < formals.size(); i++)
		f.fields.add(createFormalsFIELD(formals.get(i),i));
	return f;
}

static FIELD createFormalsFIELD(Semant.Absyn.Formal formal, int index)
{
	if (formal.type instanceof Semant.Absyn.ArrayType)
		return new FIELD(createARRAYFormal(formal ,index),index,Symbol.symbol(formal.name));
	else if (formal.type instanceof Semant.Absyn.BooleanType)
		return new FIELD(new BOOLEAN(),index,Symbol.symbol(formal.name));
	else if (formal.type instanceof Semant.Absyn.IdentifierType)
		return new FIELD(new OBJECT(new CLASS(Symbol.symbol(formal.name))),index,Symbol.symbol(formal.name));
	else if (formal.type instanceof Semant.Absyn.IntegerType)
		return new FIELD(new INT(),index,Symbol.symbol(formal.name));
	else
		return null;
}

static ARRAY createARRAYFormal(Semant.Absyn.Formal formal, int index)
{
	if (formal.type instanceof Semant.Absyn.BooleanType)
		return new ARRAY(new BOOLEAN());
	else if (formal.type instanceof Semant.Absyn.IdentifierType)
		return new ARRAY(new OBJECT(new CLASS(Symbol.symbol(formal.name))));
	else if (formal.type instanceof Semant.Absyn.IntegerType)
		return new ARRAY(new INT());
	else
		return null;
}


static Type createType(Semant.Absyn.Type type)
{
	if (type instanceof Semant.Absyn.ArrayType)
		return createTypeARRAY(type);
	else if (type instanceof Semant.Absyn.BooleanType)
		return new BOOLEAN();
	else if (type instanceof Semant.Absyn.IdentifierType)
		return new OBJECT(new CLASS(Symbol.symbol(((Semant.Absyn.IdentifierType)type).id)));
	else if (type instanceof Semant.Absyn.IntegerType)
		return new INT();
	else
		return null;
}

static Type createTypeARRAY(Semant.Absyn.Type type)
{
	if (type instanceof Semant.Absyn.BooleanType)
		return new ARRAY(new BOOLEAN());
	else if (type instanceof Semant.Absyn.IdentifierType)
		return new ARRAY(new OBJECT(new CLASS(Symbol.symbol(((Semant.Absyn.IdentifierType)type).id))));
	else if (type instanceof Semant.Absyn.IntegerType)
		return new ARRAY(new INT());
	else
		return null;
}
*/
}
