PARSER   = ReadTypes

JAVAC    = javac
JAVA     = java
JAVACC   = javacc
JJDOC    = jjdoc

JAVACC_FLAGS = -NOSTATIC
JAVAC_FLAGS = -Xdepend

JAVACCGEN = Translate/SimpleCharStream.java Translate/ParseException.java \
        Translate/$(PARSER).java Translate/$(PARSER)Constants.java \
        Translate/$(PARSER)TokenManager.java Translate/Token.java \
        Translate/TokenMgrError.java

ABSYN    = Translate/Absyn/Absyn.java Translate/Absyn/Expr.java \
	Translate/Absyn/AddExpr.java Translate/Absyn/ArrayExpr.java \
	Translate/Absyn/ArrayType.java Translate/Absyn/AssignableExpr.java \
	Translate/Absyn/AssignStmt.java Translate/Absyn/BinOpExpr.java \
	Translate/Absyn/BlockStmt.java Translate/Absyn/BooleanType.java \
	Translate/Absyn/CallExpr.java Translate/Absyn/ClassDecl.java \
	Translate/Absyn/DivExpr.java Translate/Absyn/EqualExpr.java \
	Translate/Absyn/FalseExpr.java Translate/Absyn/FieldExpr.java \
	Translate/Absyn/Formal.java Translate/Absyn/GreaterExpr.java \
	Translate/Absyn/IdentifierExpr.java Translate/Absyn/IdentifierType.java \
	Translate/Absyn/IfStmt.java Translate/Absyn/IntegerLiteral.java \
	Translate/Absyn/IntegerType.java Translate/Absyn/LesserExpr.java \
	Translate/Absyn/MainClassDecl.java Translate/Absyn/MethodDecl.java \
	Translate/Absyn/MulExpr.java Translate/Absyn/NegExpr.java \
	Translate/Absyn/NewArrayExpr.java Translate/Absyn/NewObjectExpr.java \
	Translate/Absyn/NotEqExpr.java Translate/Absyn/NotExpr.java \
	Translate/Absyn/NullExpr.java Translate/Absyn/OrExpr.java \
	Translate/Absyn/PrintVisitor.java Translate/Absyn/Program.java \
	Translate/Absyn/Stmt.java Translate/Absyn/StringLiteral.java \
	Translate/Absyn/SubExpr.java Translate/Absyn/ThisExpr.java \
	Translate/Absyn/ThreadDecl.java Translate/Absyn/TrueExpr.java \
	Translate/Absyn/Type.java Translate/Absyn/VarDecl.java \
	Translate/Absyn/VoidDecl.java Translate/Absyn/WhileStmt.java \
	Translate/Absyn/XinuCallExpr.java Translate/Absyn/XinuCallStmt.java

VISIT    = Translate/Visit/Visitable.java Translate/Visit/Visitor.java \
	
TYPES	 = Translate/Types/ARRAY.java Translate/Types/BOOLEAN.java \
	Translate/Types/CLASS.java Translate/Types/FIELD.java \
	Translate/Types/FUNCTION.java Translate/Types/INT.java \
	Translate/Types/NIL.java Translate/Types/OBJECT.java \
	Translate/Types/RECORD.java Translate/Types/STRING.java \
	Translate/Types/Type.java Translate/Types/VOID.java
	
FRAME	= Translate/Frame/Access.java Translate/Frame/Frame.java

MIPS	= Translate/Mips/InFrame.java Translate/Mips/InReg.java \
	Translate/Mips/MipsFrame.java
	
TRANSLATE	=	Translate/Translate/Cx.java Translate/Translate/DataFrag.java \
	Translate/Translate/Ex.java Translate/Translate/Exp.java \
	Translate/Translate/Frag.java Translate/Translate/IfThenElseExp.java \
	Translate/Translate/Nx.java Translate/Translate/ProcFrag.java \
	Translate/Translate/RelCx.java
	
TREE	=	Translate/Tree/BINOP.java Translate/Tree/CALL.java \
	Translate/Tree/CJUMP.java Translate/Tree/CONST.java \
	Translate/Tree/ESEQ.java Translate/Tree/Exp.java \
	Translate/Tree/EXP.java Translate/Tree/Hospitable.java \
	Translate/Tree/IntVisitor.java Translate/Tree/JUMP.java \
	Translate/Tree/LABEL.java Translate/Tree/MEM.java \
	Translate/Tree/MOVE.java Translate/Tree/NAME.java \
	Translate/Tree/Print.java Translate/Tree/SEQ.java \
	Translate/Tree/Stm.java Translate/Tree/TEMP.java

SYMBOL	= Translate/Symbol/Symbol.java Translate/Symbol/Table.java

SRCS     =  $(ABSYN) $(SYMBOL)  $(TYPES) $(VISIT) $(PARSER).java Translate/Main.java Translate/Translator/Translator.java Translate/Util/BoolList.java

all:  $(SRCS:.java=.class)

%.class : %.java
	$(JAVAC) $<



$(PARSER).java: Translate/$(PARSER).jj
	$(JAVACC) $(JAVACC_FLAGS) $<

parser: Translate/$(PARSER).class Translate/$(PARSER)Constants.class \
	Translate/$(PARSER)TokenManager.class Translate/ParseException.class

main: $(PARSER).class Main.class

clean:
	rm -f $(SRCS:.java=.class) ${JAVACCGEN} $(JAVACCGEN:.java=.class)
