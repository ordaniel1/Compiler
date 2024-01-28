package AST;

import TYPES.*;

public class AST_EXP_LIST extends AST_Node {
	
	/****************/
	/* DATA MEMBERS */
	/****************/
	public AST_EXP head;
	public AST_EXP_LIST tail;

	/******************/
	/* CONSTRUCTOR(S) */
	/******************/
	public AST_EXP_LIST(AST_EXP head,AST_EXP_LIST tail, int lineNum)
	{
		/******************************/
		/* SET A UNIQUE SERIAL NUMBER */
		/******************************/
		SerialNumber = AST_Node_Serial_Number.getFresh();

		/***************************************/
		/* PRINT CORRESPONDING DERIVATION RULE */
		/***************************************/
		if (tail != null) System.out.print("====================== expList -> exp COMMA expList\n");
		if (tail == null) System.out.print("====================== expList -> exp\n");

		/*******************************/
		/* COPY INPUT DATA NENBERS ... */
		/*******************************/
		this.head = head;
		this.tail = tail;
		this.lineNum=lineNum;
	}

	/******************************************************/
	/* The printing message for a expression list AST node */
	/******************************************************/
	public void PrintMe()
	{
		/**************************************/
		/* AST NODE TYPE = AST EXPRESSION LIST */
		/**************************************/
		System.out.print("AST NODE EXP LIST\n");

		/*************************************/
		/* RECURSIVELY PRINT HEAD + TAIL ... */
		/*************************************/
		if (head != null) head.PrintMe();
		if (tail != null) tail.PrintMe();

		/**********************************/
		/* PRINT to AST GRAPHVIZ DOT file */
		/**********************************/
		AST_GRAPHVIZ.getInstance().logNode(
			SerialNumber,
			"EXP\nLIST\n");
		
		/****************************************/
		/* PRINT Edges to AST GRAPHVIZ DOT file */
		/****************************************/
		if (head != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,head.SerialNumber);
		if (tail != null) AST_GRAPHVIZ.getInstance().logEdge(SerialNumber,tail.SerialNumber);
	}
	
	public TYPE_LIST SemantMe() throws SemantErrorException {
		
		if (tail==null) {
			return new TYPE_LIST(head.SemantMe(),null);
		}
		
		else {
			return  new TYPE_LIST(head.SemantMe(),tail.SemantMe());
		
		}
	}
}