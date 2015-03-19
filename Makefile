PARSER   = ReadAbsyn

JAVAC    = javac
JAVA     = java
JAVACC   = javacc
JJDOC    = jjdoc

JAVACC_FLAGS = -NOSTATIC
JAVAC_FLAGS = -Xdepend

JAVACCGEN = Semant/SimpleCharStream.java Semant/ParseException.java \
        Semant/$(PARSER).java Semant/$(PARSER)Constants.java \
        Semant/$(PARSER)TokenManager.java Semant/Token.java \
        Semant/TokenMgrError.java

ABSYN    = Semant/Absyn/Absyn.java Semant/Absyn/Expr.java \
	Semant/Absyn/AddExpr.java Semant/Absyn/ArrayExpr.java \
	Semant/Absyn/ArrayType.java Semant/Absyn/AssignableExpr.java \
	Semant/Absyn/AssignStmt.java Semant/Absyn/BinOpExpr.java \
	Semant/Absyn/BlockStmt.java Semant/Absyn/BooleanType.java \
	Semant/Absyn/CallExpr.java Semant/Absyn/ClassDecl.java \
	Semant/Absyn/DivExpr.java Semant/Absyn/EqualExpr.java \
	Semant/Absyn/FalseExpr.java Semant/Absyn/FieldExpr.java \
	Semant/Absyn/Formal.java Semant/Absyn/GreaterExpr.java \
	Semant/Absyn/IdentifierExpr.java Semant/Absyn/IdentifierType.java \
	Semant/Absyn/IfStmt.java Semant/Absyn/IntegerLiteral.java \
	Semant/Absyn/IntegerType.java Semant/Absyn/LesserExpr.java \
	Semant/Absyn/MainClassDecl.java Semant/Absyn/MethodDecl.java \
	Semant/Absyn/MulExpr.java Semant/Absyn/NegExpr.java \
	Semant/Absyn/NewArrayExpr.java Semant/Absyn/NewObjectExpr.java \
	Semant/Absyn/NotEqExpr.java Semant/Absyn/NotExpr.java \
	Semant/Absyn/NullExpr.java Semant/Absyn/OrExpr.java \
	Semant/Absyn/PrintVisitor.java Semant/Absyn/Program.java \
	Semant/Absyn/Stmt.java Semant/Absyn/StringLiteral.java \
	Semant/Absyn/SubExpr.java Semant/Absyn/ThisExpr.java \
	Semant/Absyn/ThreadDecl.java Semant/Absyn/TrueExpr.java \
	Semant/Absyn/Type.java Semant/Absyn/VarDecl.java \
	Semant/Absyn/VoidDecl.java Semant/Absyn/WhileStmt.java \
	Semant/Absyn/XinuCallExpr.java Semant/Absyn/XinuCallStmt.java

VISIT    = Semant/Visit/Visitable.java Semant/Visit/Visitor.java \
	Semant/Visit/AbsynPrintVisitor.java 
	
TYPES	 = Semant/Types/ARRAY.java Semant/Types/BOOLEAN.java \
	Semant/Types/CLASS.java Semant/Types/FIELD.java \
	Semant/Types/FUNCTION.java Semant/Types/INT.java \
	Semant/Types/NIL.java Semant/Types/OBJECT.java \
	Semant/Types/RECORD.java Semant/Types/STRING.java \
	Semant/Types/Type.java Semant/Types/VOID.java

SYMBOL	= Semant/Symbol/Symbol.java Semant/Symbol/Table.java

SRCS     =  $(ABSYN) $(SYMBOL) $(TYPES) $(VISIT) $(PARSER).java Semant/Main.java

all:  $(SRCS:.java=.class)

%.class : %.java
	$(JAVAC) $<



$(PARSER).java: Semant/$(PARSER).jj
	$(JAVACC) $(JAVACC_FLAGS) $<

parser: Semant/$(PARSER).class Semant/$(PARSER)Constants.class \
	Semant/$(PARSER)TokenManager.class Semant/ParseException.class

main: $(PARSER).class Main.class

clean:
	rm -f $(SRCS:.java=.class) ${JAVACCGEN} $(JAVACCGEN:.java=.class)
