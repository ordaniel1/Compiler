/***********/
/* PACKAGE */
/***********/
package IR;

/*******************/
/* GENERAL IMPORTS */
/*******************/

/*******************/
/* PROJECT IMPORTS */
/*******************/
import TEMP.*;
import MIPS.*;

public class IRcommand_blt extends IRcommand {
	
	TEMP t1;
	TEMP t2;
	String label_name;
	
	public IRcommand_blt(TEMP t1, TEMP t2, String label_name)
	{
		this.t1=t1;
		this.t2=t2;
		this.label_name = label_name;
	}
	
	/***************/
	/* MIPS me !!! */
	/***************/
	public void MIPSme()
	{
		MIPSGenerator.getInstance().blt(t1,t2,label_name);
	}

}
