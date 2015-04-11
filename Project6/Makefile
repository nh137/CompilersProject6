PARSER   = ReadFrags

JAVAC    = javac
JAVA     = java
JAVACC   = javacc
JJDOC    = jjdoc


JAVAC_FLAGS = -Xdepend

JAVACCGEN = Assem/SimpleCharStream.java Assem/ParseException.java \
        Assem/$(PARSER).java Assem/$(PARSER)Constants.java \
        Assem/$(PARSER)TokenManager.java Assem/Token.java \
        Assem/TokenMgrError.java

ABSYN    = Assem/Translate/Absyn/Absyn.java Assem/Translate/Absyn/Expr.java \
	Assem/Translate/Absyn/AddExpr.java Assem/Translate/Asyn/ArrayExpr.java \
	Assem/Translate/Absyn/ArrayType.java Assem/Translate/Absyn/AssignableExpr.java \
	Assem/Translate/Absyn/AssignStmt.java Assem/Translate/Absyn/BinOpExpr.java \
	Assem/Translate/Absyn/BlockStmt.java Assem/Translate/Absyn/BooleanType.java \
	Assem/Translate/Absyn/CallExpr.java Assem/Translate/Absyn/ClassDecl.java \
	Assem/Translate/Absyn/DivExpr.java Assem/Translate/Absyn/EqualExpr.java \
	Assem/Translate/Absyn/FalseExpr.java Assem/Translate/Absyn/FieldExpr.java \
	Assem/Translate/Absyn/Formal.java Assem/Translate/Absyn/GreaterExpr.java \
	Assem/Translate/Absyn/IdentifierExpr.java Assem/Translate/Absyn/IdentifierType.java \
	Assem/Translate/Absyn/IfStmt.java Assem/Translate/Absyn/IntegerLiteral.java \
	Assem/Translate/Absyn/IntegerType.java Assem/Translate/Absyn/LesserExpr.java \
	Assem/Translate/Absyn/MainClassDecl.java Assem/Translate/Absyn/MethodDecl.java \
	Assem/Translate/Absyn/MulExpr.java Assem/Translate/Absyn/NegExpr.java \
	Assem/Translate/Absyn/NewArrayExpr.java Assem/Translate/Absyn/NewObjectExpr.java \
	Assem/Translate/Absyn/NotEqExpr.java Assem/Translate/Absyn/NotExpr.java \
	Assem/Translate/Absyn/NullExpr.java Assem/Translate/Absyn/OrExpr.java \
	Assem/Translate/Absyn/PrintVisitor.java Assem/Translate/Absyn/Program.java \
	Assem/Translate/Absyn/Stmt.java Assem/Translate/Absyn/StringLiteral.java \
	Assem/Translate/Absyn/SubExpr.java Assem/Translate/Absyn/ThisExpr.java \
	Assem/Translate/Absyn/ThreadDecl.java Assem/Translate/Absyn/TrueExpr.java \
	Assem/Translate/Absyn/Type.java Assem/Translate/Absyn/VarDecl.java \
	Assem/Translate/Absyn/VoidDecl.java Assem/Translate/Absyn/WhileStmt.java \
	Assem/Translate/Absyn/XinuCallExpr.java Assem/Translate/Absyn/XinuCallStmt.java

VISIT    = Assem/Translate/Visit/Visitable.java Assem/Translate/Visit/Visitor.java \
	
TYPES	 = Assem/Translate/Types/ARRAY.java Assem/Translate/Types/BOOLEAN.java \
	Assem/Translate/Types/CLASS.java Assem/Translate/Types/FIELD.java \
	Assem/Translate/Types/FUNCTION.java Assem/Translate/Types/INT.java \
	Assem/Translate/Types/NIL.java Assem/Translate/Types/OBJECT.java \
	Assem/Translate/Types/RECORD.java Assem/Translate/Types/STRING.java \
	Assem/Translate/Types/Type.java Assem/Translate/Types/VOID.java
	
FRAME	= Assem/Translate/Frame/Access.java Assem/Translate/Frame/Frame.java

MIPS	= Assem/Translate/Mips/InFrame.java Assem/Translate/Mips/InReg.java \
	Assem/Translate/Mips/MipsFrame.java
	
TRANSLATE	=	Assem/Translate/Translate/Cx.java Assem/Translate/Translate/DataFrag.java \
	Assem/Translate/Translate/Ex.java Assem/Translate/Translate/Exp.java \
	Assem/Translate/Translate/Frag.java Assem/Translate/Translate/IfThenElseExp.java \
	Assem/Translate/Translate/Nx.java Assem/Translate/Translate/ProcFrag.java \
	Assem/Translate/Translate/RelCx.java
	
TREE	=	Assem/Translate/Tree/BINOP.java Assem/Translate/Tree/CALL.java \
	Assem/Translate/Tree/CJUMP.java Assem/Translate/Tree/CONST.java \
	Assem/Translate/Tree/ESEQ.java Assem/Translate/Tree/Exp.java \
	Assem/Translate/Tree/EXP.java Assem/Translate/Tree/Hospitable.java \
	Assem/Translate/Tree/IntVisitor.java Assem/Translate/Tree/JUMP.java \
	Assem/Translate/Tree/LABEL.java Assem/Translate/Tree/MEM.java \
	Assem/Translate/Tree/MOVE.java Assem/Translate/Tree/NAME.java \
	Assem/Translate/Tree/Print.java Assem/Translate/Tree/SEQ.java \
	Assem/Translate/Tree/Stm.java Assem/Translate/Tree/TEMP.java

SYMBOL	= Assem/Translate/Symbol/Symbol.java Assem/Translate/Symbol/Table.java

SRCS     =   $(ABSYN) $(SYMBOL) $(VISIT) $(TYPES) Assem/$(PARSER).java Assem/Main.java Assem/Translate/Translator/Translator.java Assem/Translate/Util/BoolList.java

all:  $(SRCS:.java=.class)

%.class : %.java
	$(JAVAC) $<



Assem/$(PARSER).java: Assem/$(PARSER).jj
	$(JAVACC)  $<

parser: $(PARSER).class $(PARSER)Constants.class \
	$(PARSER)TokenManager.class ParseException.class

main: $(PARSER).class Main.class

clean:
	rm -f $(SRCS:.java=.class) ${JAVACCGEN} $(JAVACCGEN:.java=.class)
